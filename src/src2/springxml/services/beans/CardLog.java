package springxml.services.beans;


import org.springframework.stereotype.Component;

@Component
public class CardLog implements Logging {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String changeLog() {
        return "something Changed";
    }
}
