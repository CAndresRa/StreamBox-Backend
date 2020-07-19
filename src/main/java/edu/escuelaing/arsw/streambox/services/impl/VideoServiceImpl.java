package edu.escuelaing.arsw.streambox.services.impl;

import edu.escuelaing.arsw.streambox.entity.Video;
import edu.escuelaing.arsw.streambox.repository.VideoRoomRepository;
import edu.escuelaing.arsw.streambox.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRoomRepository videoRoomRepository;

    @Override
    public String convertUrlToVideoId(String url) {
        String[] link = url.split("=");
        if(link[1].contains("&")){
            String[] temp = url.split("&");
            return temp[0];
        }
        else {
            return link[1];
        }
    }

    @Override
    public List<Video> findVideo(String roomName) {
        List<Video> videos = videoRoomRepository.findByRoom(roomName);
        return videos;
    }

    @Override
    public Video create(Video video) {
        return videoRoomRepository.save(video);
    }

    @Override
    public Boolean existVideo(String roomName) {
        return videoRoomRepository.existsById(roomName);
    }

}
