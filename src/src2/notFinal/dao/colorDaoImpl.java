package notFinal.dao;

import hibernate.entity.CardColor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class colorDaoImpl implements colorDao {
    @Autowired
    private SessionFactory factory;

    @Override
    public List<CardColor> getCardColors() {
        Session session = factory.getCurrentSession();
        List<CardColor> list = session.createQuery("from CardColor", CardColor.class).getResultList();
        return list;
    }

    @Override
    public CardColor getCardColors(int id) {
        Session session = factory.getCurrentSession();
        return session.get(CardColor.class, id);
    }
}
