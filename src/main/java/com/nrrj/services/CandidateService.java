package com.nrrj.services;

import com.nrrj.entities.Candidate;
import com.nrrj.entities.Voter;
import com.nrrj.repositories.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Service
public class CandidateService {
    private ICandidateRepository repository;

    @Autowired
    public void setRepository(ICandidateRepository repository) {
        this.repository = repository;
    }

    public Page<Candidate> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Candidate findOne(int id) {
        return this.repository.findOne(id);
    }

    public Candidate create(Candidate c) {
        return this.repository.save(c);
    }

    public void destroy(int id) {
        this.repository.delete(id);
    }

    public Candidate update(int id, Candidate c) {
        Candidate candidate = this.repository.findOne(id);
        candidate.setName(c.getName());
        candidate.setParty(c.getParty());
        return this.repository.save(candidate);
    }

    public Candidate addVote( int id, Voter voter) {
        Candidate candidate = this.repository.findOne(id);
        candidate.addVote(voter);
        return this.repository.save(candidate);
    }

    public List<Voter> GetVoters(int id) {
        Candidate c = this.repository.findOne(id);
        return c.getVoters();
    }
}