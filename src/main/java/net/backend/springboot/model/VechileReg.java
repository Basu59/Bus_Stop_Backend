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
@Table(name ="vechile")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VechileReg {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="vechileno")
	private String vechileno;
		
	@Column(name="busno")
	private String busno;
	
	@Column(name="modelno")
	private String modelno;
	
	@Column(name="brand")
	private String brand;

}
