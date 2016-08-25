package com.nrrj.repositories;


import com.nrrj.entities.Candidate;
import com.nrrj.entities.Voter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVoterRepository extends PagingAndSortingRepository<Voter, Integer> {

     @Query("select c from Candidate c join c.voters v where v.id = :id")
    public Page<Candidate> findAllCandidatesByVoterId(@Param("id") int id, Pageable pageable);

}
