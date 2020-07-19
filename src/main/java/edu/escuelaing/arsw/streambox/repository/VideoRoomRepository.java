package edu.escuelaing.arsw.streambox.repository;

import edu.escuelaing.arsw.streambox.entity.Video;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRoomRepository extends MongoRepository<Video, String> {

    boolean existsById(String roomName);

    List<Video> findByRoom(String roomName);

}
