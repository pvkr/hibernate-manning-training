package com.pvkr.hibernate.training;

import com.pvkr.hibernate.training.model.Author;
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

        Author author = new Author("Me");
        author.addMessage(new Message("Hello World!"));
        author.addMessage(new Message("Hello World, again!"));
        author.addMessage(new Message("Hello World, and again!"));
        entityManager.persist(author);

        transaction.commit();
        entityManager.close();
    }

    private static void findAllMessages(EntityManagerFactory emf) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List<Author> authors = entityManager.createQuery("from Author", Author.class).getResultList();
        System.out.println("Found authors: " + authors.size());
        authors.forEach(author -> {
            System.out.println("Messages: ");
            author.getMessages().forEach(message -> System.out.println(message.getText()));
        });

        transaction.commit();
        entityManager.close();
    }
}
