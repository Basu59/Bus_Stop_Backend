package net.backend.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.backend.springboot.model.BusDetails;



@Repository
public interface BusDetailsRepository extends JpaRepository<BusDetails, Long> {

}