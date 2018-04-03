package com.devi.akka;

import akka.actor.UntypedActor;

/**
 * Created by hzchendawei on 2018/3/2.
 */
public class Greeter extends UntypedActor {

    public enum Msg {
        GREET, DONE
    }

    @Override
    public void onReceive(Object msg) throws InterruptedException {
        if (msg == Msg.GREET) {
            System.out.println("Hello World!");
            Thread.sleep(1000);
            getSender().tell(Msg.DONE, getSelf());
        } else
            unhandled(msg);
    }

}