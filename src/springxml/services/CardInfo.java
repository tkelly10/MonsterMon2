package springxml.services;


import org.springframework.stereotype.Component;

@Component
public class CardInfo implements Logging{
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String changeLog() {
        return "oh look at that";
    }
}
