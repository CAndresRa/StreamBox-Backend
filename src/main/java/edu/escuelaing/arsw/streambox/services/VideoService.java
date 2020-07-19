package edu.escuelaing.arsw.streambox.services;

import edu.escuelaing.arsw.streambox.entity.Video;

import java.util.List;

public interface VideoService {

    String convertUrlToVideoId(String url);

    List<Video> findVideo(String roomName);

    Video create(Video video);

    Boolean existVideo(String roomName);

}
