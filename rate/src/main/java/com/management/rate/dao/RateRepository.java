package com.management.rate.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.rate.model.RatePersistenceDTO;

public interface RateRepository extends JpaRepository<RatePersistenceDTO, Long> {

	
}