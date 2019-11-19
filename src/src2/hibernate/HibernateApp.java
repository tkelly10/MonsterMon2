package hibernate;

import hibernate.entity.Card;
import hibernate.entity.CardColor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.util.List;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Card.class)
                .addAnnotatedClass(CardColor.class)
                .buildSessionFactory();
    }

    public void close(){
        factory.close();
    }

    public static void main(String[] args) {
        HibernateApp app = new HibernateApp();

        try{

          app.makeCard();
//          app.updateCard(101);
//          app.readCard(101);
//          app.deleteCard(201);
//            app.createColor();
//            app.updateColor(2);
           // app.readColor(1);
//            app.deleteColor(2);



        }finally {
            app.close();
        }

    }

    private void deleteColor(int colorId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        CardColor aColor = session.get(CardColor.class, colorId);
        if(aColor != null){
            session.delete(aColor);
        } else {
            System.out.println("Item not found");
        }

        session.getTransaction().commit();
    }

    private CardColor readColor(int colorId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        CardColor aColor = session.get(CardColor.class, colorId);
        System.out.println(aColor);

        session.getTransaction().commit();
        return aColor;
    }

    private void updateColor(int colorId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        CardColor aColor = session.get(CardColor.class, colorId);
        if(aColor != null){
           aColor.setName(aColor.getName().toUpperCase());
        }
        System.out.println(aColor);
        session.getTransaction().commit();
    }

    private int createColor() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        CardColor color = new CardColor("Red");

        session.save(color);

        System.out.println(color);
        session.getTransaction().commit();

        return color.getId();
    }


    private void deleteCard(int cardId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        Card aCard = session.get(Card.class, cardId);
        if(aCard != null){
            session.delete(aCard);
        } else {
            System.out.println("Item not found");
        }

        session.getTransaction().commit();
    }


    private void readCard(int cardId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        Card aCard = session.get(Card.class, cardId);
        System.out.println(aCard);

        session.getTransaction().commit();
    }


    private void updateCard(int cardId) {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        Card aCard = session.get(Card.class, cardId);
        if(aCard != null){
            aCard.setDescription(aCard.getDescription().toUpperCase());
        }
        System.out.println(aCard);

        session.getTransaction().commit();
    }


    private int makeCard() {
        CardColor aColor = readColor(1);
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        Card card = new Card("HardBooger","It's a hard booger","Deal 4 damage",2,"Reduce any Monsermon's damage by 1",1);


        card.setCardColor(aColor);
        session.save(card);

        System.out.println(card);


        session.getTransaction().commit();

        return card.getId();
    }

    private void crudTemplate() {
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        /** DO CRUD **/

        session.getTransaction().commit();
    }

}
