package ppc.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {
    @Input("myMessage")
    SubscribableChannel input();

    @Output("myMessage")
    MessageChannel output();
}
