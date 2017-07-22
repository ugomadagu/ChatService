package hello;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;

@Controller
public class GreetingController {


//    @MessageMapping("/hello/{chatId}")
//    @SendTo("/topic/greetings/{chatId}")
//    public Greeting greeting(@DestinationVariable String chatId, HelloMessage message) throws Exception {
//        Thread.sleep(1000); // simulated delay
//        return new Greeting("Hello, " + message.getName() + "!");
//    }


    @MessageMapping("/chatroomapi/{chatId}")
    @SendTo("/topic/chatroom/{chatId}")
    public ChatMessageResponse greeting(@DestinationVariable String chatId, ChatMessage message) throws Exception {
        return new ChatMessageResponse(message.getMessage() + ": with ID " + chatId);
    }

}