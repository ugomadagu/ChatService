package userservice;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(path="/api/users", method=RequestMethod.POST)
    public @ResponseBody GeneralResponse createNewUser(@RequestBody User newUser) {
        try {
            userRepository.save(newUser);
        } catch(Exception e) {
            return new GeneralResponse(e.getMessage());
        }
        return new GeneralResponse("User has been added.");
    }
}
