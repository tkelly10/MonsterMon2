package notFinal.service;

import hibernate.entity.Card;

import java.util.List;

public interface CardService {
    List<Card> getCards();

    void saveCard(Card aCard);

    Card getCard(int theId);

    void deleteCard(int theId);

    List<Card> getCardByName(String theSearchTerm);
}
