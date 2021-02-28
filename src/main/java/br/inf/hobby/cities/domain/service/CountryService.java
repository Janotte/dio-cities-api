package br.inf.hobby.cities.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.hobby.cities.domain.entity.Country;
import br.inf.hobby.cities.domain.exception.EntityNotFoundException;
import br.inf.hobby.cities.domain.repository.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public Country verifyIfExists(Long countryId) throws EntityNotFoundException {

		return countryRepository.findById(countryId)
				.orElseThrow(() -> new EntityNotFoundException(String.format("No Country with id %s was found.", countryId)));

	}

}