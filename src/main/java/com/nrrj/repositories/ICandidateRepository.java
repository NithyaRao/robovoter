package com.nrrj.repositories;


import com.nrrj.entities.Candidate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Integer> {


}
