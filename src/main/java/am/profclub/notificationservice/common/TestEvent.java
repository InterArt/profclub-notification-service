package am.profclub.notificationservice.common;


public class TestEvent implements Event {

    private String title;

    public TestEvent() {
    }

    public TestEvent(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
