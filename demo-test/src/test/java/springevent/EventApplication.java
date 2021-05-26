package springevent;

import com.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class EventApplication {

    @Autowired
    EventDemoPublish eventDemoPublish;

    @Test
    public void test(){

        System.out.println("------------");
        eventDemoPublish.publish("gogogogogogo");
        System.out.println("------------");
    }
}
