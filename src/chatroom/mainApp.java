package chatroom;

import chatroom.chat.ChatCoordinator;
import chatroom.test.SimpleTupleSpaceTest;
import chatroom.tuple.SimpleTuple;
import chatroom.tuple.Tuple;
import chatroom.tuplespace.SimpleTupleSpace;
import chatroom.tuplespace.TupleSpace;
import javafx.animation.AnimationTimer;
import sun.java2d.pipe.SpanShapeRenderer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class mainApp {

    public static void main(String[] args) {

        //SimpleTupleSpaceTest simpleTest = new SimpleTupleSpaceTest();
        ChatCoordinator coordinator = new ChatCoordinator();

        AnimationTimer a = new AnimationTimer() {
            private long nextTime = 0;

            @Override
            public void handle(long now) {

                if(now > nextTime) {
                    coordinator.update();
                    nextTime = now + Duration.ofMillis(1).toNanos();
                }
            }
        };
        a.start();


    }
}

