
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
@Table(name = "BusDet")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "dname")
	private String drivername;
	
	@Column(name = "busno")
	private String busno;
	
	@Column(name = "mobileno")
	private String mobileno;


}
