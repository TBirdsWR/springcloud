package ppc.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ppc.order.message.StreamClient;

import java.util.Date;

@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @RequestMapping("/sendMessage")
    public void process(){
        streamClient.output().send(MessageBuilder.withPayload("now:"+new Date()).build());
    }
}
