package com.at.controllers;

import com.at.models.Claim;
import com.at.models.Person;
import com.at.repositories.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Created by localadmin on 8/18/16.
 */

@RestController
@CrossOrigin
@RequestMapping({"/claims"})
public class ClaimsController {

    private ClaimRepository repo;

    @Autowired
    public void setRepo(ClaimRepository repo){
        this.repo = repo;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Iterable<Claim> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page){
        PageRequest pr = new PageRequest(page, 3);
        return repo.findAll(pr);
    }


    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Claim create(@RequestBody Claim claim){

        return repo.save(claim);
    }
}
