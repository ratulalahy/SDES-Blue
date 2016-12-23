package test.ratul.com.signinpractice;

/**
 * Created by Ratul on 12/20/2016.
 */

public class ChatMessage {
    private long id;
    private boolean isMe;
    private String message;
    private Long userId;
    private String dateTime;
    private boolean isMedia;

    public boolean isMedia() {
        return isMedia;
    }

    public void setMedia(boolean media) {
        isMedia = media;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIsme() {
        return isMe;
    }

    public void setMe(boolean isMe) {
        this.isMe = isMe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDate() {
        return dateTime;
    }

    public void setDate(String dateTime) {
        this.dateTime = dateTime;
    }
}
