package com.devi.review;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hzchendawei on 2018/8/17.
 */
public class ProxyTest {
    public static void main(String[] args) {
        TestImpl r = new TestImpl();
        TestInterface instance = (TestInterface) Proxy.newProxyInstance(TestInterface.class.getClassLoader(), new Class[]{TestInterface.class}, new ProxyObject(r));
        instance.say();
    }

    interface TestInterface {
        void say();
    }

    static class TestImpl implements TestInterface {

        @Override
        public void say() {
            System.out.println("RRRRRRRRRRRRRRRRRRRRRR");
        }
    }

    static class ProxyObject implements InvocationHandler {
        private Object o;

        public ProxyObject(Object o) {
            this.o = o;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("PPPPPPPPPPPPPPP");
            return method.invoke(o, args);
        }
    }

}
