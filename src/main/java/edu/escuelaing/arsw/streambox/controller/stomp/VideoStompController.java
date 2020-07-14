package edu.escuelaing.arsw.streambox.controller.stomp;

import edu.escuelaing.arsw.streambox.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    VideoService videoService;

    @MessageMapping("/video")
    public void handleStateVideo(List<String> state){
        String newState = state.get(0);
        String roomName = state.get(1);
        String newId = videoService.convertUrlToVideoId(newState);
        System.out.println(newId);
        msgt.convertAndSend("/topic/video." + roomName, newId);
    }

}
