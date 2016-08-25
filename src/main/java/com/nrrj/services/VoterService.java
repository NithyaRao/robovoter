package com.nrrj.services;

import com.nrrj.entities.Candidate;
import com.nrrj.entities.Voter;
import com.nrrj.repositories.IVoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VoterService {
    private IVoterRepository repository;

    @Autowired
    public void setRepository(IVoterRepository repository) {this.repository = repository;}

    public Page<Voter> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Voter findOne(int id) {
        return this.repository.findOne(id);
    }

    public Voter create(Voter v) {
        return this.repository.save(v);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Voter update(int id, Voter v) {
        Voter voter = this.repository.findOne(id);
        voter.setName(v.getName());
        voter.setParty(v.getParty());
        return this.repository.save(voter);
    }


    public Page<Candidate> findAllCandidatesByVoterId(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAllCandidatesByVoterId(id, pr);
    }
}
