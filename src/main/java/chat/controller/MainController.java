package chat.controller;

import chat.model.RoomEntity;
import chat.room.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    @Autowired
    private HttpSession hs;

    @Autowired private RoomService service;

    @RequestMapping("/chat")
    public String chat(@RequestParam("room") int room, RedirectAttributes ra) {
        RoomEntity entity = new RoomEntity();
        entity.setIroom(room);
        int result = service.selRoom(entity);
        System.out.println("selRoomResult : " + result);
        switch (result) {
            case 0:
                ra.addFlashAttribute("err", "방이 없습니다.");
                return "redirect:/chat/find";
            case 1:
                break;
        }
        return "/chat/chat";
    }
}
