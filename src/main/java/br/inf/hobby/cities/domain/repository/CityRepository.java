package br.inf.hobby.cities.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.inf.hobby.cities.domain.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	@Query(value = "SELECT ((SELECT lat_lon FROM city WHERE id=?1) <@> (SELECT lat_lon FROM city WHERE id=?2)) as distance", nativeQuery = true)
	Double distanceByPoints(final Long cityId1, final Long cityId2);

	@Query(value = "SELECT earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance", nativeQuery = true)
	Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

}
