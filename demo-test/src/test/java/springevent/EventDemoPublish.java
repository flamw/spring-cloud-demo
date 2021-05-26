package springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventDemoPublish {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(String message){
        EventDemo demo = new EventDemo(this, message);
        applicationEventPublisher.publishEvent(demo);
    }

}