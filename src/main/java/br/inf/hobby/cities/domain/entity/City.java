package br.inf.hobby.cities.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@TypeDefs(value = { @TypeDef(name = "point", typeClass = PointType.class) })
public class City {

	@Id
	@GeneratedValue(generator = ".city_id_seq")
	@SequenceGenerator(name = ".city_id_seq", sequenceName = "city_sequence", initialValue = 1)
	private Long id;

	@Column(length = 120)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "state_id", nullable = false)
	private State state;

	private Long ibge;

	// 1st
	@Column(name = "lat_lon")
	private String geolocation;

	// 2nd
	@Type(type = "point")
	@Column(name = "lat_lon", updatable = false, insertable = false)
	private Point location;

}
