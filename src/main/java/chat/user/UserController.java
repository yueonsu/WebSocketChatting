package chat.user;

import chat.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private HttpSession hs;

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public void login() {}

    @PostMapping("/login")
    public String loginProc(UserEntity entity, RedirectAttributes ra) {
        int result = service.selUser(entity);
        switch (result) {
            case 1:
                return "redirect:/chat/find";
            case 2:
                ra.addFlashAttribute("err", "등록되지 않은 아이디입니다.");
                break;
            case 3:
                ra.addFlashAttribute("err", "비밀번호를 확인해 주세요.");
                break;
        }
        return "redirect:/user/login";
    }

    @GetMapping("/join")
    public void join() {}

    @PostMapping("/join")
    public String joinProc(UserEntity entity) {
        int result = service.insUser(entity);
        return "redirect:/user/login";
    }
}
