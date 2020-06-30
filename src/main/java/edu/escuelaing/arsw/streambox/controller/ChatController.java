package edu.escuelaing.arsw.streambox.controller;
import edu.escuelaing.arsw.streambox.entity.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/message") // toServer
    @SendTo("/chat/message")    // to other clients subscribes
    public Message ReceivesMessage( Message message){
        System.out.println(message);
        return message;
    }
}