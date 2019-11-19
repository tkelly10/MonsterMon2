package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cardscolor")
public class CardColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colorid")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cardColor",
    cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Card> cardList;


    public CardColor(String name) {
        this.name = name;
    }

    public CardColor(){

    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CardColor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void add(Card tempDonut) {
        if ( cardList == null)
            cardList = new ArrayList<>();
        cardList.add(tempDonut);

    }


}
