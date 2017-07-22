package chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;

@Controller
public class ChatRoomController {

    @MessageMapping("/chatroomapi/{chatId}")
    @SendTo("/topic/chatroom/{chatId}")
    public ChatMessageResponse sendMessage(@DestinationVariable String chatId, ChatMessage message) throws Exception {
        return new ChatMessageResponse("Matt234: " + message.getMessage());
    }

}