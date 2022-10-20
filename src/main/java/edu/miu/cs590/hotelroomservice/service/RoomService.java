package edu.miu.cs590.hotelroomservice.service;

import edu.miu.cs590.hotelroomservice.dto.RoomSaveDto;

import java.util.List;

public interface RoomService {
    RoomSaveDto saveRoom(RoomSaveDto roomDto);

    List<RoomSaveDto> fetchAllRooms();

    RoomSaveDto findByRoomIdForHotel(String hotelId, String id);

    List<RoomSaveDto> findByHotelId(String hotelId);

    RoomSaveDto updateRoom(String hotelId, String roomId, RoomSaveDto roomDto);


    void deleteRoom(String id);

}
