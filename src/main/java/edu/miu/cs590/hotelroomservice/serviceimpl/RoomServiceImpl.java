package edu.miu.cs590.hotelroomservice.serviceimpl;

import edu.miu.cs590.hotelroomservice.dto.RoomSaveDto;
import edu.miu.cs590.hotelroomservice.entity.Room;
import edu.miu.cs590.hotelroomservice.mapper.RoomMapper;
import edu.miu.cs590.hotelroomservice.repository.RoomRepository;
import edu.miu.cs590.hotelroomservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomServiceImpl implements RoomService {
    private static final String ROOM_NOT_FOUND_MSG = "Room with id %d not found";
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomRepository repository;

    private RedisTemplate redisTemplate;


    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<RoomSaveDto> fetchAllRooms() {
        return roomMapper.toListDto(repository.findAll());
    }

    @Override
    @Cacheable(value = "hotelRooms", key = "{#hotelId, #id}")
    public RoomSaveDto findByRoomIdForHotel(String hotelId, String id) {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("id").is(id));
//        Room account = mongoTemplate.getMongoOpertion().findOne(query, Room.class);

        Query query = new Query();
        query.addCriteria(Criteria.where("hotelId").is(hotelId));
        query.addCriteria(Criteria.where("id").is(id));
        Room rooms = mongoTemplate.findOne(query, Room.class);

        return roomMapper.toDto(rooms);
    }

    @Override
    @Cacheable(value = "rooms", key = "#hotelId")
    public List<RoomSaveDto> findByHotelId(String hotelId) {

        Query query = new Query();
        query.addCriteria(Criteria.where("hotelId").is(hotelId));
        List<Room> rooms = mongoTemplate.find(query, Room.class);

        return roomMapper.toListDto(rooms);
    }

    @CacheEvict(value = "room", allEntries = true)
    public RoomSaveDto saveRoom(RoomSaveDto roomDto) {
        try {

            return roomMapper.toDto(repository.save(roomMapper.toEntity(roomDto)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnsupportedOperationException();
        }
    }

    @Override
    @CachePut(value = "rooms", key = "{#hotelId, #id}", unless = "")
    public RoomSaveDto updateRoom(String hotelId, String roomId, RoomSaveDto roomDto) {
        try {
            Query query = new Query();
            query.addCriteria(Criteria.where("hotelId").is(hotelId));
            query.addCriteria(Criteria.where("id").is(roomId));

            Room room = mongoTemplate.findOne(query, Room.class);

            if (room != null) {
                room.setCapacity(roomDto.getCapacity());
                room.setRoomType(roomDto.getRoomType());
                room.setRoomPrice(roomDto.getRoomPrice());
                room.setDefaultRoomPrice(roomDto.getDefaultRoomPrice());
                room.setDescription(roomDto.getDescription());
                room.setNumberOfBeds(roomDto.getNumberOfBeds());
                room.setBedType(roomDto.getBedType());

                repository.save(room);

                return roomMapper.toDto(room);
            }

            return null;

        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    @CacheEvict(value = "room", key = "#id")
    public void deleteRoom(String id) {
//        if (!repository.findById(id).isPresent()) {
//            throw new NoSuchElementException("Room with id: " + id + " not present!!");
//        }
        repository.deleteById(id.toString());
    }

}
