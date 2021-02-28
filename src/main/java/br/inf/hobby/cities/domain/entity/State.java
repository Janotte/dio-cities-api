package br.inf.hobby.cities.domain.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@TypeDefs({ @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
@NoArgsConstructor
@AllArgsConstructor
public class State {

	@Id
	@GeneratedValue(generator = "state_id_seq")
	@SequenceGenerator(name = "state_id_seq", sequenceName = "state_sequence", initialValue = 1)
	private Long id;

	@Column(length = 60)
	private String name;

	@Column(length = 2)
	private String uf;

	private Long ibge;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	@Type(type = "jsonb")
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "ddd", columnDefinition = "jsonb")
	private List<Integer> ddd;

}
