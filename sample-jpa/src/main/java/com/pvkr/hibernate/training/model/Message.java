package com.pvkr.hibernate.training.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String text;

    @ManyToOne
    private Author author;
}
