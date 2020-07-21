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
        if(url.contains("=")) {
            //url web page
            String[] link = url.split("=");
            if (!url.contains("&")) {
                return link[1];
            } else {

                String[] lastSplit = link[1].split("&");
                return lastSplit[0];
            }
        } else{
            //url of mobile
            String[] link = url.split("/");
            return link[3];
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

    @Override
    public void deleteVideo(String roomName) {
        videoRoomRepository.deleteById(roomName);
    }

}
