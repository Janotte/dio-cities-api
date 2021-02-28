package br.inf.hobby.cities.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Country {

	@Id
	@GeneratedValue(generator = "country_id_seq")
	@SequenceGenerator(name = "country_id_seq", sequenceName = "country_sequence", initialValue = 1 )
	private Long id;

	@Column(length = 60)
	private String name;

	@Column(length = 60)
	private String namePt;

	@Column(length = 2)
	private String code;

	private Integer bacen;
}
