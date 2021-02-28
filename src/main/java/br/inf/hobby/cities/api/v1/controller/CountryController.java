package br.inf.hobby.cities.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inf.hobby.cities.domain.entity.Country;
import br.inf.hobby.cities.domain.repository.CountryRepository;
import br.inf.hobby.cities.domain.service.CountryService;

@RestController
@RequestMapping("api/v1/countries")
public class CountryController {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryService countryService;

	@GetMapping
	public Page<Country> countries(Pageable pageable) {

		return countryRepository.findAll(pageable);
	}

	@GetMapping("/{countryId}")
	public Country getCountry(@PathVariable Long countryId) {

		return countryService.verifyIfExists(countryId);
	}
	
}
