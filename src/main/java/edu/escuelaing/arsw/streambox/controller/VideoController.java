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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/changeurl")
    public String convertUrlToVideoId (@RequestParam(value="url") String url){
        System.out.println(url);
        System.out.println(videoService.convertUrlToVideoId(url));
        return videoService.convertUrlToVideoId(url);
    }

}
