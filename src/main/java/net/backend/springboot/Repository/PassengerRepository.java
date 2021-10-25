package net.backend.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.backend.springboot.model.Passenger;



@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
