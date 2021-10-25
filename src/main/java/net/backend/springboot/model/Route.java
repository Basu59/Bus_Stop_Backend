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
@Table(name ="RouteDet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="routeno")
	private long routeno;
	
	@Column(name="busno")
	private String busno;
		
	@Column(name="origin")
	private String origin;
	
	@Column(name="destination")
	private String destination;

}