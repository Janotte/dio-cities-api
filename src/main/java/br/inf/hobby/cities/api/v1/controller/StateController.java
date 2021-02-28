package br.inf.hobby.cities.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inf.hobby.cities.domain.entity.State;
import br.inf.hobby.cities.domain.repository.StateRepository;
import br.inf.hobby.cities.domain.service.StateService;

@RestController
@RequestMapping("api/v1/states")
public class StateController {

	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private StateService stateService;

	@GetMapping
	public Page<State> states(Pageable pageable) {
		
		return stateRepository.findAll(pageable);
	}

	@GetMapping("/{stateId}")
	public State getState(@PathVariable Long stateId) {

		return stateService.verifyIfExists(stateId);
	}

}
