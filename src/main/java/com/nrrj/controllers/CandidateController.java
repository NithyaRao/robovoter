package com.nrrj.controllers;

import com.nrrj.entities.Candidate;
import com.nrrj.entities.Voter;
import com.nrrj.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidateController {
   private CandidateService service;

    @Autowired
    public void setService(CandidateService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Candidate> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page ) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Candidate show(@PathVariable int id) {
        return this.service.findOne(id);
    }


    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Candidate create(@RequestBody Candidate candidate) {
        return this.service.create(candidate);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Candidate update(@PathVariable int id, @RequestBody Candidate candidate) {
        return this.service.update(id, candidate);
    }

    @RequestMapping(path = {"/{id}/addVote"}, method = RequestMethod.PUT)
    public Candidate addVote(@PathVariable int id, @RequestBody Voter voter) {
        return this.service.addVote(id, voter);
    }

    @RequestMapping(path = {"/{id}/voters"}, method = RequestMethod.GET)
    public List<Voter> voters(@PathVariable int id) {
        return this.service.GetVoters(id);
    }

}
