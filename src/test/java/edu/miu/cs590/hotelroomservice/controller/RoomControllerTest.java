//package edu.miu.cs590.hotelroomservice.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import edu.miu.cs590.hotelroomservice.dto.RoomSaveDto;
//import edu.miu.cs590.hotelroomservice.service.RoomService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//import static org.hamcrest.Matchers.*;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//class RoomControllerTest {
//
//    @InjectMocks
//    private RoomController roomController;
//
//    ObjectMapper objectMapper = new ObjectMapper();
//    ObjectWriter objectWriter = objectMapper.writer();
//
//    private MockMvc mockMvc;
//
//
//    @Mock
//    private RoomService roomService;
//
//    public RoomControllerTest() {
//        MockitoAnnotations.initMocks(this);
//        this.mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
//    }
//
////    @Before
////    public void setup() {
////        MockitoAnnotations.initMocks(this);
////        roomController = new RoomController();
////        this.mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
////    }
//
//    RoomSaveDto room1 = RoomSaveDto.builder().id("632fb8dce6d3d2085d22e8b5").hotelId("11aa").capacity(2).roomPrice(11.0)
//            .bedType("Single").defaultRoomPrice(10.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build();
//
//
//    RoomSaveDto room3 = RoomSaveDto.builder().id("632fb8dce6d3d2085d22e8b6").hotelId("99aa").capacity(2).roomPrice(11.0)
//            .bedType("Single").defaultRoomPrice(10.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build();
//
//    @Test
//    void getAllRooms_success() throws Exception {
//        List<RoomSaveDto> rooms = new ArrayList<>(Arrays.asList(room1));
//
//        Mockito.when(roomService.fetchAllRooms()).thenReturn(rooms);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/hotel-room")
//                        .contentType(MediaType.APPLICATION_JSON))
//                        .andExpect(status().isOk())
//                        .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
//                        .andExpect(jsonPath("$[0].hotelId", is("11aa")));
//
//    }
//
//    @Test
//    void getRoomsByHotelId_success() throws Exception {
//        List<RoomSaveDto> rooms = new ArrayList<>(Arrays.asList(room1));
//
//        Mockito.when(roomService.findByHotelId(room1.getHotelId())).thenReturn(rooms);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/hotel-room/hotel/11aa")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()))
//                .andExpect(jsonPath("$[0].hotelId", is("11aa")));
//    }
//
//    @Test
//    void getRoomById() throws Exception{
////        List<RoomSaveDto> rooms = new ArrayList<>(Arrays.asList(room1));
//        Mockito.when(roomService.findByRoomIdForHotel(room1.getHotelId(), room1.getId())).thenReturn(room1);
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/hotel-room/hotel/11aa/632fb8dce6d3d2085d22e8b5")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", notNullValue()));
////                .andExpect(jsonPath("$[0].hotelId", is("11aa")))
////                .andExpect(jsonPath("$[0].id", is("632fb8dce6d3d2085d22e8b5")));
//    }
//
//    @Test
//    void save() throws Exception{
//        RoomSaveDto room = RoomSaveDto.builder().id("632fb8dce6d3d2085d22e8b5").hotelId("12aa").capacity(1).roomPrice(10.0)
//                .bedType("Single").defaultRoomPrice(10.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build();
//
//        Mockito.when(roomService.saveRoom(room)).thenReturn(room);
//
//        String content = objectWriter.writeValueAsString(room);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/hotel-room")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(content);
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$",notNullValue()))
//                .andExpect(jsonPath("$.hotelId",is("12aa")));
//
//    }
//
//    @Test
//    void updateRoom() throws Exception{
//        RoomSaveDto room = RoomSaveDto.builder().id("632fb8dce6d3d2085d22e8b5").hotelId("12abc").capacity(1).roomPrice(10.0)
//                .bedType("Singleton").defaultRoomPrice(10.0).roomType("Multi").description("Prime").numberOfBeds(2).images(null).build();
//
////        List<RoomSaveDto> rooms = new ArrayList<>(Arrays.asList(room1));
//
//        Mockito.when(roomService.findByRoomIdForHotel(room1.getHotelId(), room1.getId())).thenReturn(room1);
//        Mockito.when(roomService.saveRoom(room)).thenReturn(room);
//
//        String updatedContent = objectWriter.writeValueAsString(room);
//
//        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/hotel-room/hotel/11aa/632fb8dce6d3d2085d22e8b5")
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(updatedContent);
//
//        mockMvc.perform(mockRequest)
//                .andExpect(status().isOk());
////                .andExpect(jsonPath("$",notNullValue()))
////                .andExpect(jsonPath("$[0].hotelId",is("12abc")));
//
//    }
//
//    @Test
//    void deleteOrder() throws Exception{
//        Mockito.when(roomService.findByRoomIdForHotel(room3.getHotelId(),room3.getId())).thenReturn(room3);
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/hotel-room/632fb8dce6d3d2085d22e8b6")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//}