package edu.miu.cs590.hotelroomservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Room")
public class RoomSaveDto implements Serializable {


    private String hotelId;
    private String id;
    private Integer capacity;
    private String roomType;
    private Double roomPrice;
    private Double defaultRoomPrice;
    private String description;
    private Integer numberOfBeds;
    private String bedType;
    private byte[] images;
    private Date createdDate;
}
