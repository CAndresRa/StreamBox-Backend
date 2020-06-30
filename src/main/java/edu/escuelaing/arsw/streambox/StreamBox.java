package edu.escuelaing.arsw.streambox;

import edu.escuelaing.arsw.streambox.entity.Video;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
public class StreamBox {
    private Video video;

    private StreamBox() {

    }
}
