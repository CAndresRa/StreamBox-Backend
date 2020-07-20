package edu.escuelaing.arsw.streambox.controller;
import edu.escuelaing.arsw.streambox.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/video")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VideoController {
    @Autowired
    VideoService videoService;

    /**
     * Allow callback in browsers connected
     * @param url url of youtube video
     * @return url of youtube video selected
     */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/changeurl")
    public String convertUrlToVideoId (@RequestParam(value="url") String url){
        return url;
    }

    /**
     * Allow save the last video in room
     * @param roomName name of room to endpoint
     * @return if room exist charge video else not video ""
     */
    @GetMapping("videoid")
    public String getVideoRoom(@RequestParam(value="room") String roomName){
        if(videoService.existVideo(roomName)){
            return videoService.findVideo(roomName).get(0).getVideoId();
        } else {
            return "";
        }
    }

}
