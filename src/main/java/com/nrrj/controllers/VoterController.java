package com.nrrj.controllers;

import com.nrrj.entities.Candidate;
import com.nrrj.entities.Voter;
import com.nrrj.services.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/voters")
public class VoterController {
    private VoterService service;

    @Autowired
    public void setService(VoterService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Voter> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page ) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Voter show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Voter create(@RequestBody Voter voter) {
        return this.service.create(voter);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Voter update(@PathVariable int id, @RequestBody Voter voter) {
        return this.service.update(id, voter);
    }

    @RequestMapping(path = {"/{id}/candidate"}, method = RequestMethod.GET)
    public Page<Candidate> candidates(@PathVariable int id, @RequestParam(name = "page", required = false, defaultValue = "0") int page ) {
        return this.service.findAllCandidatesByVoterId(id, page);
    }

}
