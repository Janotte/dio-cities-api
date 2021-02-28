package br.inf.hobby.cities.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inf.hobby.cities.domain.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}