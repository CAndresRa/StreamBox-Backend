package edu.escuelaing.arsw.streambox.entity;

public class Video {
    private String url;
    private String VideoId;
    private StateType state;
    private String sender;



    public enum StateType {
        PAUSED,
        PLAYING
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVideoId() {
        return VideoId;
    }

    public void setVideoId(String videoId) {
        VideoId = videoId;
    }

    public StateType getState() {
        return state;
    }

    public void setState(StateType state) {
        this.state = state;
    }


    public String getSender() {
        return sender;
    }
}
