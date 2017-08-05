package chat;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface MessageRepository extends CrudRepository<ChatMessage, Long> {
    List<ChatMessage> findByChatRoomId(Integer chatRoomId);
}

