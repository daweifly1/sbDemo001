import com.devi.Application;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StarterServiceApplicationTests {

    @Test
    public void deployementAndStartProcess() {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //不加斜杠代表从当前类读取资源，加"/"代表从classpath路径下读取文件
        InputStream inputStreamBpmn = this.getClass().getResourceAsStream("bpm/VacationRequest.bpmn");
        InputStream inputStreampng = this.getClass().getResourceAsStream("bpm/VacationRequest.bpmn.png");
        //部署流程定义
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()//创建部署对象
                .addInputStream("bpm/VacationRequest.bpmn", inputStreamBpmn)//部署加载资源文件
                .addInputStream("bpm/VacationRequest.bpmn.png", inputStreampng)//
                .addInputStream("bpm/VacationRequest.bpmn.png", inputStreampng)//
                .deploy();
        System.out.println("部署ID：" + deployment.getId());

        Long count = processEngine.getRepositoryService().createProcessDefinitionQuery().count();
        System.out.println("===================="+count);


        Map<String, Object> vars3 = new HashMap<String, Object>();
        vars3.put("msg", "y");

        RuntimeService runtimeService = processEngine.getRuntimeService();
        TaskService taskService=processEngine.getTaskService();

        // 开始流流程
        ProcessInstance pi1 =runtimeService.startProcessInstanceByKey("myProcess_1", "businessKey1", vars3);

        //启动流程实例
        ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey("myProcess_1");//使用流程定义的key的最新版本启动流程
        System.out.println("流程实例ID：" + pi.getId());
        System.out.println("流程定义的ID：" + pi.getProcessDefinitionId());


        List<Task> tasks = taskService.createTaskQuery().processInstanceId(pi.getId()).list();
        for (Task task : tasks) {
            System.out.println("当前流程节点：" + task.getName());
            Execution exe = runtimeService.createExecutionQuery()
                    .executionId(task.getExecutionId()).singleResult();
            System.out.println("msg：" + runtimeService.getVariable(exe.getId(), "msg"));
        }


        //完成任务
        for (Task task : tasks) {
            Execution exe = runtimeService.createExecutionQuery().executionId(task.getExecutionId()).singleResult();
            runtimeService.setVariableLocal(exe.getId(), "msg", "y");
            taskService.complete(task.getId());
        }

        for (Task task : tasks) {
            System.out.println("当前流程节点：" + task.getName());
            Execution exe = runtimeService.createExecutionQuery()
                    .executionId(task.getExecutionId()).singleResult();
            System.out.println("msg：" + runtimeService.getVariable(exe.getId(), "msg"));
        }

    }
}
