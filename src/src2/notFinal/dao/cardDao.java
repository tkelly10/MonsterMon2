package notFinal.dao;

import hibernate.entity.Card;

import java.util.List;

public interface cardDao {
    List<Card> getCards();
    void saveCard(Card aCard);
    Card getCard(int theId);
    void deleteCard(int theId);
    List<Card> getCardsByName(String theSearchTerm);

}
