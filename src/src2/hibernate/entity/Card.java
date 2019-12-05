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
    @Column(name = "attackManaCost")
    private int attackManaCost;
    @Column(name = "defense")
    private String defense;
    @Column(name = "defenseManaCost")
    private int defenseManaCost;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "colorId")
    private CardColor cardColor;

    public Card(String name, String description, String attack, int attackManaCost, String defense, int defenseManaCost) {
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.attackManaCost = attackManaCost;
        this.defense = defense;
        this.defenseManaCost = defenseManaCost;
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

    public int getAttackManaCost() {
        return attackManaCost;
    }

    public void setAttackManaCost(int attackManaCost) {
        this.attackManaCost = attackManaCost;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public int getDefenseManaCost() {
        return defenseManaCost;
    }

    public void setDefenseManaCost(int defenseManaCost) {
        this.defenseManaCost = defenseManaCost;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", attack='" + attack + '\'' +
                ", aManaCost=" + attackManaCost +
                ", defense='" + defense + '\'' +
                ", dManaCost=" + defenseManaCost +
                ", cardColor=" + cardColor +
                '}';
    }
}
