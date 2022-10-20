package edu.miu.cs590.hotelroomservice.repository;

import edu.miu.cs590.hotelroomservice.entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoomRepository extends MongoRepository<Room, String> {
    Optional<Room> findById(String id);
}
