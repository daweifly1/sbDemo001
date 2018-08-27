package com.devi.review;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolProperties;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by hzchendawei on 2018/8/21.
 */
public class CommandHelloWorld extends HystrixCommand<String> {
    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("CircuitBreakerTestGroup"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("CircuitBreakerTestKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("CircuitBreakerTest"))
                .andThreadPoolPropertiesDefaults( // 配置线程池
                        HystrixThreadPoolProperties.Setter().withCoreSize(200) // 配置线程池里的线程数，设置足够多线程，以防未熔断却打满threadpool
                ).andCommandPropertiesDefaults( // 配置熔断器
                        HystrixCommandProperties.Setter().withCircuitBreakerEnabled(true)
                                .withCircuitBreakerRequestVolumeThreshold(3)
                                .withCircuitBreakerErrorThresholdPercentage(80).withRequestCacheEnabled(false)
                                .withExecutionTimeoutEnabled(true)
// .withCircuitBreakerForceOpen(true) // 置为true时，所有请求都将被拒绝，直接到fallback
// .withCircuitBreakerForceClosed(true) // 置为true时，将忽略错误
// .withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE) //
// 信号量隔离
// .withExecutionTimeoutInMilliseconds(5000)
                ));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        Thread.sleep(50);
        System.out.println("running run():" + name + ",thread : " + Thread.currentThread().getName());
        return name;
    }

    @Override
    protected String getFallback() {
        System.out.println("running getFallback");
        return "CircuitBreaker fallback: " + name;
    }

    public static void main(String args[]) throws InterruptedException, ExecutionException, IOException {
        Future<String> test = new CommandHelloWorld("Hello").queue();
        System.out.println("done!");
        System.out.println(test.get());
        System.in.read();
    }

}
