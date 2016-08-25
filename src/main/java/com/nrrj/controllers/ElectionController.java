package com.nrrj.controllers;

import com.nrrj.entities.Election;
import com.nrrj.services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/elections")
public class ElectionController {
    private ElectionService service;

    @Autowired
    public void setService(ElectionService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Election> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page ) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Election show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Election create(@RequestBody Election election) {
        return this.service.create(election);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Election update(@PathVariable int id, @RequestBody Election election) {
        return this.service.update(id, election);
    }

}
