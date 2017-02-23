package com.pvkr.hibernate.training;

import com.pvkr.hibernate.training.model.Author;
import com.pvkr.hibernate.training.model.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class SampleBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void createMessages() {
        Author author = new Author("Me");
        author.addMessage(new Message("Hello World!"));
        author.addMessage(new Message("Hello World, again!"));
        author.addMessage(new Message("Hello World, and again!"));
        entityManager.persist(author);
    }

    @Transactional
    public void searchMessages() {
        List<Author> authors = entityManager.createQuery("from Author", Author.class).getResultList();
        System.out.println("Found authors: " + authors.size());
        authors.forEach(author -> {
            System.out.println("Messages: ");
            author.getMessages().forEach(message -> System.out.println(message.getText()));
        });
    }
}
