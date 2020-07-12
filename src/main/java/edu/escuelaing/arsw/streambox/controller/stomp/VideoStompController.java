package edu.escuelaing.arsw.streambox.controller.stomp;

import edu.escuelaing.arsw.streambox.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class VideoStompController {

    @Autowired
    SimpMessagingTemplate msgt;

    @MessageMapping("/video")
    public void handleStateVideo(List<String> state){
        String roomName = state.get(1);
        msgt.convertAndSend("/topic/video." + roomName, "penelope");
    }
}
