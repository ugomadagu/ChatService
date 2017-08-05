package chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ChatRoomController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

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

    @RequestMapping(path="/api/chatrooms/{chatRoomId}/messages", method=RequestMethod.GET)
    public @ResponseBody Iterable<ChatMessage> getAllMessagesForChatroom(@PathVariable String chatRoomId) {
        return chatMessageRepository.findByChatRoomId(Integer.parseInt(chatRoomId));
    }

}