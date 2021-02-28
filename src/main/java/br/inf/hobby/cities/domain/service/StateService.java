package br.inf.hobby.cities.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.inf.hobby.cities.domain.entity.State;
import br.inf.hobby.cities.domain.exception.EntityNotFoundException;
import br.inf.hobby.cities.domain.repository.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;

	public State verifyIfExists(Long stateId) throws EntityNotFoundException {

		return stateRepository.findById(stateId).orElseThrow(
				() -> new EntityNotFoundException(String.format("No State with id %s was found.", stateId)));

	}
}
