package com.nrrj.entities;

import com.nrrj.enums.Position;
import com.nrrj.enums.State;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="elections")
public class Election {
    private int id;
    private String name;
    /*
    private Position position;
    private State state;
    */
    private Date createdAt;
    private Date updatedAt;

    public Election() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "ENUM('PRESIDENT', 'GOVERNOR', 'SENATOR')")
//    public Position getPosition() {
//        return position;
//    }
//    public void setPosition(Position position) {
//        this.position = position;
//    }
//
//    @Enumerated(EnumType.STRING)
//    @Column(columnDefinition = "ENUM('IL', 'IA', 'IND', 'SD', 'ND')")
//    public State getState() {
//        return state;
//    }
//    public void setState(State state) {
//        this.state = state;
//    }

    @Column(name = "created_at", nullable = false, updatable = false)
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Column(name="updated_at", nullable = false)
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
