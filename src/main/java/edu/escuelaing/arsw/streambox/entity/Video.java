package edu.escuelaing.arsw.streambox.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Video {
    @Id
    private String room;

    private String url;
    private String videoId;

    /**
     * constructor
     * @param room name of room
     * @param url url of video
     * @param videoId id of url video
     */
    public Video(String room, String url, String videoId){
        this.room = room;
        this.url = url;
        this.videoId = videoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
