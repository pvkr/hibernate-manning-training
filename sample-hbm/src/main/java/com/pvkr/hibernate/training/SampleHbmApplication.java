package com.pvkr.hibernate.training;

import com.pvkr.hibernate.training.model.Message;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static com.pvkr.hibernate.training.util.HibernateUtil.getSessionFactory;
import static com.pvkr.hibernate.training.util.HibernateUtil.shutdown;

public class SampleHbmApplication {

    public static void main(String[] args) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Message message = new Message();
            message.setText("Hello World!");
            session.persist(message);

            transaction.commit();
        }

        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            List<Message> messages = session.createQuery("from Message m order by m.text asc", Message.class).list();
            for (Message message : messages) {
                System.out.println("Found message: [" + message.getText() + "]");
            }

            transaction.commit();
        }

        shutdown();
    }
}
