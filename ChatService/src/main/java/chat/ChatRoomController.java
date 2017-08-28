package chat;

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
public class ChatRoomController {

    @Autowired
    private MessageRepository chatMessageRepository;
    private DateFormat dateFormat = new SimpleDateFormat(" yyyy/MM/dd HH:mm:ss");

    @MessageMapping("/chatroomapi/{chatId}")
    @SendTo("/topic/chatroom/{chatId}")
    public ChatMessageResponse sendMessage(@DestinationVariable String chatId, ChatMessage message) throws Exception {

        Date date = new Date();
        message.setTimestamp(dateFormat.format(date));
        message.setChatRoomId(Integer.parseInt(chatId));
        chatMessageRepository.save(message);
        return new ChatMessageResponse( message.getUserNameOfSender() + ": " + message.getMessage());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(path="/api/chatrooms/{chatRoomId}/messages", method=RequestMethod.GET)
    public @ResponseBody Iterable<ChatMessage> getAllMessagesForChatroom(@PathVariable String chatRoomId) {
        return chatMessageRepository.findByChatRoomId(Integer.parseInt(chatRoomId));
    }

}
