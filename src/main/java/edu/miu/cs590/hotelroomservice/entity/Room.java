package edu.miu.cs590.hotelroomservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.*;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Document("room")
@Builder
@AllArgsConstructor
public class Room {

    @MongoId
    @Field(value = "_id", targetType = FieldType.STRING)
    private String id;

    private String hotelId;
    private Integer capacity;
    private String roomType;
    private Double roomPrice;
    private Double defaultRoomPrice;
    private String description;
    private Integer numberOfBeds;
    private String bedType;
    private byte[] images;

    @CreatedDate
    private LocalDateTime createdDate;

    @Version
    private Integer version;
//
//    public Room() {
////        if (this.id == null) this.id = UUID.randomUUID();
//    }



}
