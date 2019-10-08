package springxml.services.beans;




public class CardColor {
    private String cardColor;
    private CardInfo ci = new CardInfo();
    private CardLog cl = new CardLog();

    public CardColor() {
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }

    public void setCi(CardInfo ci) {
        this.ci = ci;
    }

    public void setCl(CardLog cl) {
        this.cl = cl;
    }
}
