package chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatRoomController {
    @Autowired
    private MessageRepository userRepository;
    private DateFormat dateFormat = new SimpleDateFormat(" yyyy/MM/dd HH:mm");

    @MessageMapping("/chatroomapi/{chatId}")
    @SendTo("/topic/chatroom/{chatId}")
    public ChatMessageResponse sendMessage(@DestinationVariable String chatId, ChatMessage message) throws Exception {

        Date date = new Date();
        message.setTimestamp(dateFormat.format(date));
        message.setChatRoomId(Integer.parseInt(chatId));
        userRepository.save(message);
        return new ChatMessageResponse( message.getUserNameOfSender() + ": " + message.getMessage());
    }

}