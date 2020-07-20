package edu.escuelaing.arsw.streambox.controller.stomp;

import edu.escuelaing.arsw.streambox.entity.Video;
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

    /**
     * Depend of actions in video broadcast to others players
     * state = [changeOfVideo, roomName] or [changeOfVideo, roomName, currentTime]
     * return, 1 play - ,# pause - # synchronization
     * @param state change in player of youtube
     */
    @MessageMapping("/video")
    public void handleStateVideo(List<String> state){
        String newState = state.get(0);
        String roomName = state.get(1);

        if(newState.length() > 1) {
            String newId = videoService.convertUrlToVideoId(newState);
            if(!videoService.existVideo(roomName)){
                // Create new room video in MongoDB
                Video video = new Video(roomName, newState, newId);
                videoService.create(video);
            } else {
                // Update room video in MongoDB
                Video video = videoService.findVideo(roomName).get(0);
                video.setVideoId(newId);
                videoService.create(video);
                System.out.println(video.getVideoId());
            }
            // Send id video to youtube player
            msgt.convertAndSend("/topic/video." + roomName, newId);

        } else {
            // Pause and synchronization
            if(state.size() == 3 && newState.equals("2")){
                String time = "," + state.get(2);
                msgt.convertAndSend("/topic/video." + roomName, time);
            }
            //only synchronization
            else if(state.size() == 3 && newState.equals("9")){
                String time = state.get(2);
                msgt.convertAndSend("/topic/video." + roomName, time);
            }
            // playVideo
            else {
                msgt.convertAndSend("/topic/video." + roomName, newState);
            }
        }
    }

}
