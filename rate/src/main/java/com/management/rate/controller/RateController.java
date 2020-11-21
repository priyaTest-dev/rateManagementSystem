package com.management.rate.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import com.management.rate.model.RatePersistenceDTO;
import com.management.rate.model.RateRestDTO;
import com.management.rate.service.RateService;

@RestController
@RequestMapping("/rate")
public class RateController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RateController.class);

	@RequestMapping("/")
	@ResponseBody
	public String home(@AuthenticationPrincipal OidcUser oidcUser) {
		return "Welcome, " + oidcUser.getFullName();
	}

	@Autowired
	RateService service;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public RatePersistenceDTO addRate(@RequestBody RatePersistenceDTO a) {
		return service.addRate(a);

	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public RatePersistenceDTO updateRate(@RequestBody RatePersistenceDTO rate, @PathVariable Long id) {
		return service.updateRate(id, rate);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteRate(@PathVariable Long id) {
		service.deleteRate(id);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Optional<RatePersistenceDTO> getRate(@PathVariable Long id) {
		return service.getRate(id);
	}

	@RequestMapping(value = "/search/{id}", method = RequestMethod.GET)
	public RateRestDTO searchRate(@PathVariable Long id) {
		return service.searchRate(id);
	}

}
