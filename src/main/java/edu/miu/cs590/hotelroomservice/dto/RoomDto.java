package edu.miu.cs590.hotelroomservice.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@NoArgsConstructor
public class RoomDto {

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
