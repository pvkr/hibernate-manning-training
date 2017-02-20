package com.pvkr.hibernate.training;

import com.pvkr.hibernate.training.model.Message;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myDS");

        createHelloWorldMessage(emf);
        findAllMessages(emf);

        emf.close();
    }

    private static void createHelloWorldMessage(EntityManagerFactory emf) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Message message = new Message();
        message.setText("Hello World!");
        entityManager.persist(message);

        transaction.commit();
        entityManager.close();
    }

    private static void findAllMessages(EntityManagerFactory emf) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Message> messages = entityManager.createQuery("from Message m order by m.text asc", Message.class).getResultList();
        System.out.println("Found messages: " + messages.size());
        for (Message message : messages) {
            System.out.println(message.getText());
        }

        transaction.commit();
        entityManager.close();
    }
}
