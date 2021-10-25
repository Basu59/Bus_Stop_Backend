package net.backend.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name ="stop_det")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="routeno")
	private String routeno;
		
	@Column(name="busstops")
	private String busstops;
	
	
}
