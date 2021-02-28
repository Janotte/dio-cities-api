package br.inf.hobby.cities.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inf.hobby.cities.domain.entity.City;
import br.inf.hobby.cities.domain.repository.CityRepository;
import br.inf.hobby.cities.domain.service.CityService;

@RestController
@RequestMapping("api/v1/cities")
public class CityController {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private CityService cityService;

	@GetMapping
	public Page<City> cities(Pageable pageable) {

		return cityRepository.findAll(pageable);
	}

	@GetMapping("/{cityId}")
	public City getCity(@PathVariable Long cityId) {

		return cityService.verifyIfExists(cityId);
	}

}
