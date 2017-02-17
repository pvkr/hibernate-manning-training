package com.pvkr.hibernate.training.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Event {
    private Long id;
    private String title;
    private Date date;

    public Event() {
        // this form used by Hibernate
    }

    public Event(String title, Date date) {
        // for application use, to create new events
        this.title = title;
        this.date = date;
    }
}
