package net.backend.springboot.model;
import java.time.LocalTime;

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
@Table(name ="Timing")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sche {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Busno")
	private String busno;
	
	@Column (name ="Aritime")
	private LocalTime aritime;
	
	@Column(name="Deptime")
	private LocalTime deptime;
	
		

}