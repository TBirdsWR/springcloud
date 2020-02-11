package ppc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@EnableBinding(StreamClient.class)
@Component
@Slf4j
public class StreamReceiver {

    @StreamListener("myMessage")
//    @SendTo("myMessage2")
    public void process(Object message){
        log.info("StreamReceiver:{}",message);
//        return message;
    }
}
