package chat.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String rdt;
}
