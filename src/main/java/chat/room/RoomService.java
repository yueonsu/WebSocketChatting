package chat.room;

import chat.model.RoomEntity;
import chat.model.RoomVO;
import chat.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired private RoomMapper mapper;

    int insRoom(RoomEntity entity) {
        return mapper.insRoom(entity);
    }

    List<RoomVO> selRoomList() {
        return mapper.selRoomList();
    }

    public int closeRoom(RoomEntity entity) {
        return mapper.closeRoom(entity);
    }

    public int selRoom(RoomEntity entity) {
        RoomEntity result = mapper.selRoom(entity);
        if(result == null) {
            return 0;
        }
        return 1;
    }
}
