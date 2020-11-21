package com.management.rate.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.management.rate.dao.RateRepository;
import com.management.rate.exception.RateNotFoundException;
import com.management.rate.model.RatePersistenceDTO;
import com.management.rate.model.RateRestDTO;

@Service
public class RateService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RateService.class);

	@Autowired
	RateRepository repo;

	@Autowired
	RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public Optional<RatePersistenceDTO> getRate(Long id) {
		Optional<RatePersistenceDTO> rate = repo.findById(id);
		if (!rate.isPresent()) {
			throw new RateNotFoundException("id : " + id);
		}
		return rate;

	}

	public RatePersistenceDTO addRate(RatePersistenceDTO rate) {
		return repo.save(rate);

	}

	public RatePersistenceDTO updateRate(Long id, RatePersistenceDTO rate) {

		return repo.save(rate);
	}

	public void deleteRate(Long id) {
		repo.deleteById(id);
	}

	public RateRestDTO searchRate(Long id) {
		Optional<RatePersistenceDTO> dbRate = repo.findById(id);
		RateRestDTO rateRestData = restTemplate.getForObject("https://surcharge.free.beeceptor.com/surcharge",
				RateRestDTO.class);
		if (!dbRate.isPresent()) {
			throw new RateNotFoundException("id : " + id);
		}
		if (null != dbRate) {
			rateRestData.setRateDetails(dbRate);
		}
		return rateRestData;

	}

}