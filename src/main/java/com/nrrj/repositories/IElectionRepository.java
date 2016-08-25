package com.nrrj.repositories;


import com.nrrj.entities.Election;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IElectionRepository extends PagingAndSortingRepository<Election, Integer> {


}
