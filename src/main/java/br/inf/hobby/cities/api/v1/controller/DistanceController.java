package br.inf.hobby.cities.api.v1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.inf.hobby.cities.domain.service.CityService;
import br.inf.hobby.cities.domain.service.DistanceService;
import br.inf.hobby.cities.domain.service.EarthRadius;

@RestController
@RequestMapping("api/v1/distances")
public class DistanceController {

	@Autowired
	private final CityService cityService;
	
	@Autowired
	private final DistanceService service;
	Logger log = LoggerFactory.getLogger(DistanceController.class);

	public DistanceController(DistanceService service) {
		this.cityService = new CityService();
		this.service = service;
	}

	@GetMapping("/by-points")
	public Double byPoints(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
		log.info("byPoints");
		
		cityService.verifyIfExists(city1);
		cityService.verifyIfExists(city2);
		
		return service.distanceByPointsInMiles(city1, city2);
	}

	@GetMapping("/by-cube")
	public Double byCube(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2) {
		log.info("byCube");
		
		cityService.verifyIfExists(city1);
		cityService.verifyIfExists(city2);
		
		return service.distanceByCubeInMeters(city1, city2);
	}

	@GetMapping("/by-math")
	public Double byMath(@RequestParam(name = "from") final Long city1, @RequestParam(name = "to") final Long city2,
			@RequestParam final EarthRadius unit) {
		log.info("byMath");
		
		cityService.verifyIfExists(city1);
		cityService.verifyIfExists(city2);
		
		return service.distanceUsingMath(city1, city2, unit);
	}
}
