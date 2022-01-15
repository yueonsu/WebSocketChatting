package chat.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomEntity {
    private int iroom;
    private String rnm;
    private int room_master;
}
