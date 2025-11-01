package id.co.focusrealm.backend.PageModules.LoginPage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping(path = "/login_page")
public class LoginPageController {

    @Autowired
    private LoginPageService loginPageService;

    @PostMapping("/insert_user")
    public @ResponseBody LoginPageResponse insertUserResponse(@RequestBody LoginPageModel user) {
        try {
            log.info("Inserting User!");
            return loginPageService.insertUser(user);
        } catch (Exception e) {
            log.error("Error At LoginPageController InsertUserResponse");
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/fetch_user")
    public @ResponseBody LoginPageResponse fetchUserResponse(@RequestBody LoginPageModel user) {
        try {
            log.info("Fetching User Data!");
            return loginPageService.fetchUser(user);
        } catch (Exception e) {
            log.error("Error At LoginPageController FetchUserResponse");
            throw new RuntimeException(e);
        }
    }

}
