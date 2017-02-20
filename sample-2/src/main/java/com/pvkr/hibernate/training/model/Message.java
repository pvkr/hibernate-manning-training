package com.pvkr.hibernate.training.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private Long id;
    private String text;
    private Message nextMessage;
}
