package am.profclub.notificationservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.w3c.dom.events.Event;

import java.io.Serializable;

/**
 * Created by ARTHUR on 11/5/2017.
 */
@Document(collection = "d_test_event")
public class MongoTestModel implements Serializable{

    @Id
    private String id;

    private String text;

    public MongoTestModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
