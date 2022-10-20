//package edu.miu.cs590.hotelroomservice.serviceimpl;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import edu.miu.cs590.hotelroomservice.dto.RoomDto;
//import edu.miu.cs590.hotelroomservice.dto.RoomSaveDto;
//import edu.miu.cs590.hotelroomservice.entity.Room;
//import edu.miu.cs590.hotelroomservice.mapper.RoomMapper;
//import edu.miu.cs590.hotelroomservice.repository.RoomRepository;
//import edu.miu.cs590.hotelroomservice.service.RoomService;
//import org.junit.jupiter.api.*;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
//class RoomServiceImplTest {
//    @Mock
//    RoomRepository roomRepository;
//
//    @Mock
//    RoomMapper roomMapper;
//
//    @Mock
//    MongoTemplate mongoTemplate;
//
//    @InjectMocks
//    RoomServiceImpl roomService;
//
//
////    @Autowired
////    private RoomMapper roomMapper;
//
//    public List<RoomSaveDto> roomSaveDtos;
//
//    List<Room> rooms = new ArrayList<>();
//
//
//    @Test
//    @Order(1)
//    public void test_FetchAllRooms() {
//        rooms.add(Room.builder().hotelId("11aa").capacity(2).bedType("Single").defaultRoomPrice(10.0).roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build());
//        rooms.add(Room.builder().hotelId("11ab").capacity(1).bedType("Single").defaultRoomPrice(10.0)
//                .roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build());
//
//        when(roomRepository.findAll()).thenReturn(rooms);
//        List<RoomSaveDto> _rooms = roomService.fetchAllRooms();
//        assertEquals(2, _rooms.size());
//    }
//
//
//    @Test
//    @Order(2)
//    void findByRoomIdForHotel() {
//        rooms.add(Room.builder().hotelId("11aa").id("632fb8dce6d3d2085d22e8b5").capacity(2).bedType("Single").defaultRoomPrice(10.0).roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build());
//        rooms.add(Room.builder().hotelId("11ab").capacity(1).bedType("Single").defaultRoomPrice(10.0)
//                .roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build());
//
//        String id = "11aa";
//        when(roomRepository.findAll()).thenReturn(rooms);
//        assertEquals(1,roomService.findByRoomIdForHotel("11aa","632fb8dce6d3d2085d22e8b5"));
//    }
//
//    @Test
//    @Order(3)
//    void findByHotelId() {
//        rooms.add(Room.builder().hotelId("11aa").id("632fb8dce6d3d2085d22e8b5").capacity(2).bedType("Single").defaultRoomPrice(10.0).roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build());
//        rooms.add(Room.builder().hotelId("11ab").capacity(1).bedType("Single").defaultRoomPrice(10.0)
//                .roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build());
//
//        String id = "11aa";
//        when(roomRepository.findAll()).thenReturn(rooms);
//        assertEquals(1,roomService.findByHotelId("11aa"));
//    }
//
//    @Test
//    @Order(4)
//    void saveRoom() {
//        RoomSaveDto room=RoomSaveDto.builder().hotelId("11ab").capacity(1).bedType("Single").defaultRoomPrice(10.0)
//                .roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build();
//        when(roomRepository.save(roomMapper.toEntity(room))).thenReturn(roomMapper.toEntity(room));
//
//        assertEquals(room,roomService.saveRoom(room));
//    }
//
//    @Test
//    @Order(5)
//    void updateRoom() {
//        RoomSaveDto room=RoomSaveDto.builder().hotelId("11ab").capacity(1).bedType("Single").defaultRoomPrice(10.0)
//                .roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build();
//        when(roomRepository.save(roomMapper.toEntity(room))).thenReturn(roomMapper.toEntity(room));
//
//        assertEquals(room,roomService.updateRoom("11ab","632fb8dce6d3d2085d22e8b5",room));
//    }
//
//    @Test
//    @Order(6)
//    void deleteOrder() {
//        Room room = Room.builder().hotelId("11aa").id("632fb8dce6d3d2085d22e8b5").capacity(2).bedType("Single").defaultRoomPrice(10.0).roomPrice(11.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build();
//        roomService.deleteRoom("632fb8dce6d3d2085d22e8b5");
////        verify(roomRepository,times(1)).delete(room);
//    }
//}