package p.tomaszewski.FastRace.controller;


import org.springframework.web.bind.annotation.*;
import p.tomaszewski.FastRace.model.User;


import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return user.getUserName().equals("user") && user.getPassword().equals("password") ||
                user.getUserName().equals("admin") && user.getPassword().equals("password");

    }

//    @RequestMapping("/user")
//    public Principal user(HttpServletRequest request) {
//        String authToken = request.getHeader("Authorization").substring("'Basic'".length()).trim();
//        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
//    }
}
