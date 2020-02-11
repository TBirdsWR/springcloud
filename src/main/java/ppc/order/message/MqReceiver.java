package ppc.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

//    @RabbitListener(queues = "myQueue")
//    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    @RabbitListener(bindings = @QueueBinding(value = @Queue("computerOrder"),
            exchange = @Exchange("myOrder"),key = "computer"))
    public void processComputer(String message){
//        log.info("MqReceiver:{}",message);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue("phoneOrder"),
            exchange = @Exchange("myOrder"),key = "phone"))
    public void processPhone(String message){
//        log.info("MqReceiver:{}",message);

    }

}
