package edu.escuelaing.arsw.streambox;

import edu.escuelaing.arsw.streambox.entity.Video;
import edu.escuelaing.arsw.streambox.services.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
class StreamboxApplicationTests {

    @Autowired
    VideoService videoService;

    @Test
    void urlOfPhoneAppYoutubeToId() {
        String url = "https://youtu.be/OzOruOeEZ4I";
        String idOfUrl = videoService.convertUrlToVideoId(url);
        assertEquals("OzOruOeEZ4I", idOfUrl);
    }

    @Test
    void urlOfWebPageYoutubeToId() {
        String url = "https://www.youtube.com/watch?v=S_roMeig-YQ";
        String idOfUrl = videoService.convertUrlToVideoId(url);
        assertEquals("S_roMeig-YQ", idOfUrl);
    }

    @Test
    void urlOfWebPageWithListYoutubeToId() {
        String url = "https://www.youtube.com/watch?v=ph6fmk27grc&list=RDph6fmk27grc&start_radio=1";
        String idOfUrl = videoService.convertUrlToVideoId(url);
        assertEquals("ph6fmk27grc", idOfUrl);
    }

    @Test
    void urlOfWebPageWithListYoutubeToId1() {
        String url = "https://www.youtube.com/watch?v=r00ikilDxW4&list=RDMMr00ikilDxW4&start_radio=1";
        String idOfUrl = videoService.convertUrlToVideoId(url);
        assertEquals("r00ikilDxW4", idOfUrl);
    }

    @Test
    void SimpleUrlOfWebPageWithListYoutubeToId() {
        String url = "https://www.youtube.com/watch?v=r00ikilDxW4";
        String idOfUrl = videoService.convertUrlToVideoId(url);
        assertEquals("r00ikilDxW4", idOfUrl);
    }

    @Test
    void SimpleUrlOfPhoneAppYoutubeToId() {
        String url = "https://youtu.be/5sE4s3YNmqQ";
        String idOfUrl = videoService.convertUrlToVideoId(url);
        assertEquals("5sE4s3YNmqQ", idOfUrl);
    }

    @Test
    void videoExistsOnMongoDB(){
        Boolean videoExists = videoService.existVideo("test");
        assertTrue(videoExists);
    }

    @Test
    void createNewVideoRoomOnMongoDB(){
        if(videoService.existVideo("test1")){
            videoService.deleteVideo("test1");
        }
        String room = "test1";
        String url = "https://www.youtube.com/watch?v=r00ikilDxW4&list=RDMMr00ikilDxW4&start_radio=1";
        String videoId = "r00ikilDxW4";
        Video video = new Video(room, url, videoId);
        videoService.create(video);
        Boolean videoExists = videoService.existVideo("test1");
        assertTrue(videoExists);
    }

    @Test
    void updateVideoRoomOnMongoDB(){
        if(videoService.existVideo("test2")){
            videoService.deleteVideo("test2");
        }
        String room = "test2";
        String url = "https://www.youtube.com/watch?v=r00ikilDxW4&list=RDMMr00ikilDxW4&start_radio=1";
        String videoId = "r00ikilDxW4";
        Video video = new Video(room, url, videoId);
        videoService.create(video);
        String updateRoom = "test2";
        String updateUrl = "https://www.youtube.com/watch?v=fvDQy53eldY&list=RDMMr00ikilDxW4&index=2";
        String updateVideoId = "fvDQy53eldY";
        Video updateVideo = new Video(updateRoom, updateUrl, updateVideoId);
        videoService.create(updateVideo);
        String lastVideoId = videoService.findVideo("test2").get(0).getVideoId();
        assertEquals("fvDQy53eldY", lastVideoId);
    }


}
