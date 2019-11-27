package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cardId")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Column(name = "attack")
    private String attack;
    @Column(name = "attackmanacost")
    private int aManaCost;
    @Column(name = "defense")
    private String defense;
    @Column(name = "defensemanacost")
    private int dManaCost;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "colorId")
    private CardColor cardColor;

    public Card(String name, String description, String attack, int aManaCost, String defense, int dManaCost) {
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.aManaCost = aManaCost;
        this.defense = defense;
        this.dManaCost = dManaCost;
    }

    public Card() {
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public void setCardColor(CardColor cardColor) {
        this.cardColor = cardColor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public int getaManaCost() {
        return aManaCost;
    }

    public void setaManaCost(int aManaCost) {
        this.aManaCost = aManaCost;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public int getdManaCost() {
        return dManaCost;
    }

    public void setdManaCost(int dManaCost) {
        this.dManaCost = dManaCost;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", attack='" + attack + '\'' +
                ", aManaCost=" + aManaCost +
                ", defense='" + defense + '\'' +
                ", dManaCost=" + dManaCost +
                ", cardColor=" + cardColor +
                '}';
    }
}
