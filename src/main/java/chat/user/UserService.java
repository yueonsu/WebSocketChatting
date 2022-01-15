package chat.user;

import chat.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private HttpSession hs;

    @Autowired
    private UserMapper mapper;

    public int insUser(UserEntity entity) {
        return mapper.insUser(entity);
    }

    // 아이디없음 2, 비번틀림 3, 로그인성공 1
    public int selUser(UserEntity entity) {
        UserEntity dbData = mapper.selUser(entity);
        if(dbData == null) {
            return 2;
        }

        if(!entity.getUpw().equals(dbData.getUpw())) {
            return 3;
        }

        entity.setUpw(null);
        hs.setAttribute("loginUser", dbData);
        return 1;
    }
}
