package edu.escuelaing.arsw.streambox.controller.stomp;

import edu.escuelaing.arsw.streambox.entity.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VideoStompController {

    @Autowired
    SimpMessagingTemplate msgt;

    @MessageMapping("/video.{id}")
    public void handleStateVideo(Video video, @DestinationVariable("id") String roomId){
        System.out.println("Conectando al video de la sala" + roomId);
        msgt.convertAndSend("/topic/video.conectTo." + roomId, video);
    }
}
