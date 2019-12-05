package notFinal.dao;

import hibernate.entity.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class cardDaoImpl implements cardDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<Card> getCards() {
        Session session = factory.getCurrentSession();
        List<Card> list = session.createQuery("from Card", Card.class).getResultList();
        return list;
    }

    @Override
    public void saveCard(Card aCard) {
    Session session = factory.getCurrentSession();
    session.saveOrUpdate(aCard);
    }

    @Override
    public Card getCard(int theId) {
        Session session = factory.getCurrentSession();
        return session.get(Card.class, theId);
    }

    @Override
    public void deleteCard(int theId) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("delete from Card where id = :doomedCardId");
        query.setParameter("doomedCardId", theId);
        query.executeUpdate();
    }

    @Override
    public List<Card> getCardsByName(String theSearchTerm) {
        Session session = factory.getCurrentSession();

        Query<Card> query = session.createQuery("from Card where lower(name) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }
}

