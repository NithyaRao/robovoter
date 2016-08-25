package com.nrrj.services;

import com.nrrj.entities.Election;
import com.nrrj.entities.Voter;
import com.nrrj.repositories.IElectionRepository;
import com.nrrj.repositories.IVoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ElectionService {
    private IElectionRepository repository;

    @Autowired
    public void setRepository(IElectionRepository repository) {this.repository = repository;}

    public Page<Election> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Election findOne(int id) {
        return this.repository.findOne(id);
    }

    public Election create(Election c) {
        return this.repository.save(c);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Election update(int id, Election c) {
        Election election = this.repository.findOne(id);
        election.setName(c.getName());
         return this.repository.save(election);
    }

}
