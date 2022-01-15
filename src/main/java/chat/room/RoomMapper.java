package chat.room;

import chat.model.RoomEntity;
import chat.model.RoomVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    int insRoom(RoomEntity entity);
    List<RoomVO> selRoomList();
    int closeRoom(RoomEntity entity);
    RoomEntity selRoom(RoomEntity entity);
}
