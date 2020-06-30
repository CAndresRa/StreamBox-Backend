package edu.escuelaing.arsw.streambox.services.impl;

import edu.escuelaing.arsw.streambox.services.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {

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
}
