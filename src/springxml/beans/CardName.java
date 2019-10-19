package springxml.beans;


import springxml.services.CardInfo;
import springxml.services.CardLog;

public class CardName  {
    private String cardName;
    private CardLog cl = new CardLog();
    private CardInfo ci = new CardInfo();

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public CardName() {
    }

    public void setCl(CardLog cl) {
        this.cl = cl;
    }

    public void setCi(CardInfo ci) {
        this.ci = ci;
    }
}
