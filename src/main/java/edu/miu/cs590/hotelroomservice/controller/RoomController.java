package edu.miu.cs590.hotelroomservice.controller;

import edu.miu.cs590.hotelroomservice.dto.RoomSaveDto;
import edu.miu.cs590.hotelroomservice.service.RoomService;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hotel-room")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomService roomService;
    private int attempts = 1;

    @GetMapping
    public ResponseEntity<List<RoomSaveDto>> getAllRooms() {
        List<RoomSaveDto> rooms = roomService.fetchAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<RoomSaveDto>> getRoomsByHotelId(@PathVariable String hotelId) {
        List<RoomSaveDto> room = roomService.findByHotelId(hotelId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("hotel/{hotelId}/{id}")
//    @GetMapping(value = "/hotel/{id}/rooms")
    public ResponseEntity<RoomSaveDto> getRoomById(@PathVariable String hotelId, @PathVariable String id) {
        RoomSaveDto room = roomService.findByRoomIdForHotel(hotelId, id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Retry(name = "hotelRoomService", fallbackMethod = "fallback_retry")
    public ResponseEntity<RoomSaveDto> save(@Valid @RequestBody RoomSaveDto roomDto) {
        System.out.println("room service call attempted::" + attempts++);
        return new ResponseEntity<>(roomService.saveRoom(roomDto), HttpStatus.OK);
    }

    @PutMapping("hotel/{hotelId}/{id}")
    public ResponseEntity<RoomSaveDto> updateRoom(@PathVariable String hotelId, @PathVariable String id, @RequestBody RoomSaveDto roomDto) {
        return new ResponseEntity<>(roomService.updateRoom(hotelId, id, roomDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable String id) {
        roomService.deleteRoom(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    private ResponseEntity<String> fallback_retry(Exception e) {
        attempts = 1;
        return new ResponseEntity<String>("Room service is down", HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
