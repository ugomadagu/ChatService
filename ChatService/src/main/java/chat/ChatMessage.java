package chat;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "ChatMessages") // Spceifies name for the table
public class ChatMessage {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String userNameOfSender;

    private String timestamp;

    private Integer chatRoomId;

    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserNameOfSender() {
        return userNameOfSender;
    }

    public void setUserNameOfSender(String userNameOfSender) {
        this.userNameOfSender = userNameOfSender;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(Integer chatRoomId) {
        this.chatRoomId = chatRoomId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
