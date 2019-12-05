package notFinal.service;

import notFinal.dao.cardDao;
import hibernate.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private cardDao cardDao;

    @Override
    @Transactional
    public List<Card> getCards() {

        return cardDao.getCards();
    }

    @Override
    @Transactional
    public void saveCard(Card aCard) {

        cardDao.saveCard(aCard);
    }

    @Override
    @Transactional
    public Card getCard(int theId) {

        return cardDao.getCard(theId);
    }

    @Override
    @Transactional
    public void deleteCard(int theId) {
         cardDao.deleteCard(theId);
    }

    @Override
    @Transactional
    public List<Card> getCardByName(String theSearchTerm) {
        return cardDao.getCardsByName(theSearchTerm);
    }
}
