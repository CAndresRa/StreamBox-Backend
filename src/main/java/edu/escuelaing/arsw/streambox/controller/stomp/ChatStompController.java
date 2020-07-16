package edu.escuelaing.arsw.streambox.controller.stomp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class ChatStompController {

    @Autowired
    SimpMessagingTemplate msgt;

    @MessageMapping("/chat")
    public void handleStateVideo(List<String> state){
        String sendMessage = state.get(0);
        String roomName = state.get(1);
        System.out.println(sendMessage + " " + roomName);
        msgt.convertAndSend("/topic/chat." + roomName, sendMessage);
    }

}

