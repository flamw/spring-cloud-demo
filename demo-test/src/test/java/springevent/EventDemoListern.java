package springevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventDemoListern implements ApplicationListener<EventDemo> {

    @Override
    public void onApplicationEvent(EventDemo event) {
        System.out.println("receiver " + event.getMessage());
    }
}