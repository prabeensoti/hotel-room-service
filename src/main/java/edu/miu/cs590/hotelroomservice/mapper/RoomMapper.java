package edu.miu.cs590.hotelroomservice.mapper;

import edu.miu.cs590.hotelroomservice.dto.RoomSaveDto;
import edu.miu.cs590.hotelroomservice.entity.Room;
import org.bson.types.ObjectId;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoomMapper {
//    @Mappings(
//            @Mapping(source = "id",target = "id",qualifiedByName = "objectIdConvert")
//    )
    RoomSaveDto toDto(Room room);
    Room toEntity(RoomSaveDto room);

    List<RoomSaveDto> toListDto(List<Room> roomList);

    @Named("objectIdConvert")
    static String objectToString(ObjectId id){
        return id.toString();
    }

}
