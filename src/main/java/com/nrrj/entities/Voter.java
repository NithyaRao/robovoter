package com.nrrj.entities;


import com.nrrj.enums.Ethnicity;
import com.nrrj.enums.Gender;
import com.nrrj.enums.Party;
import com.nrrj.enums.State;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="voters")
public class Voter {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    private Ethnicity ethnicity;
    private State state;
    private Party party;
    private Date createdAt;
    private Date updatedAt;

    public Voter( ) {
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

    @Column(name="age", nullable = false)
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('M','F')")
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('CAUCASIAN', 'ASIAN', 'AFRICANAMERICAN', 'AMERICANINDIAN')")
    public Ethnicity getEthnicity() {
        return ethnicity;
    }
    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('IL', 'IA', 'IND', 'SD', 'ND')")
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('DEMOCRATIC', 'REPUBLICAN')")
    public Party getParty() {
        return party;
    }
    public void setParty(Party party) {
        this.party = party;
    }

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
