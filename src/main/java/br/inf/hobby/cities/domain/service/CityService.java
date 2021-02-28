package br.inf.hobby.cities.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.hobby.cities.domain.entity.City;
import br.inf.hobby.cities.domain.exception.EntityNotFoundException;
import br.inf.hobby.cities.domain.repository.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;

	public City verifyIfExists(Long cityId) throws EntityNotFoundException {

		return cityRepository.findById(cityId)
				.orElseThrow(() -> new EntityNotFoundException(String.format("No City with id %s was found.", cityId)));
	}

}