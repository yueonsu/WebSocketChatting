package chat.room;

import chat.Const;
import chat.model.RoomEntity;
import chat.model.RoomVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class RoomController {

    @Autowired private RoomService service;

    @GetMapping("/find")
    public void find(Model model) {
        model.addAttribute(Const.ROOM_LIST, service.selRoomList());
    }

    @GetMapping("/finde")
    public String finde() {
        return "/redirect:/chat/find";
    }

    @GetMapping("/createroom")
    public void create() {
    }

    @PostMapping("/createroom")
    public String createProc(RoomEntity entity) {
        int vo = service.insRoom(entity);
        if(vo == 0) {
            return "redirect:/chat/createroom";
        }
        return "redirect:/chat?room="+entity.getIroom();
    }


    //TODO socket종료시 fetch로 통신


}
