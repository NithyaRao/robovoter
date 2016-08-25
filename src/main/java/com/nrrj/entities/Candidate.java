package com.nrrj.entities;

import com.nrrj.enums.Position;
import com.nrrj.enums.Party;
import com.nrrj.enums.State;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="candidates")
public class Candidate {
    private int id;
    private String name;
    private Position position;
    private State state;
    private Party party;
    private Election election;
    private Date createdAt;
    private Date updatedAt;

    private List<Voter> voters;

    public Candidate( ) {
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

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('PRESIDENT', 'GOVERNOR', 'SENATOR')")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "election_id")
    public Election getElection() {
        return election;
    }
    public void setElection(Election election) {
        this.election = election;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidates_voters",
            joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"))
    public List<Voter> getVoters() {
        return voters;
    }
    public void setVoters(List<Voter> voters) {
        this.voters = voters;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "candidates_voters",
            joinColumns = @JoinColumn(name = "candidate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "voter_id", referencedColumnName = "id"))
    public void addVote(Voter v) {
        this.voters.add((v));
    }

}
