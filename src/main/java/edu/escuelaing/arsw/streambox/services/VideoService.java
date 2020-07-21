package edu.escuelaing.arsw.streambox.services;

import edu.escuelaing.arsw.streambox.entity.Video;

import java.util.List;

public interface VideoService {

    /**
     * Get id of url video
     * @param url url video
     * @return id of url video
     */
    String convertUrlToVideoId(String url);

    /**
     * Get video of room
     * @param roomName name of room
     * @return video of room
     */
    List<Video> findVideo(String roomName);

    /**
     * Create video
     * @param video video
     * @return video save in database mongodb
     */
    Video create(Video video);

    /**
     * allow know if room exist
     * @param roomName name of room
     * @return boolean true or false
     */
    Boolean existVideo(String roomName);

    /**
     * Delete video of database
     * @param roomName name of room
     */
    void deleteVideo(String roomName);



}
