package com.example.spring152.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "request")
public class RequestModel {


    @Column(name = "item_id")
    private Long itemId;

    @Column (name = "person_name")
    private String name;

    @Column (name = "contact")
    private String contact;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
