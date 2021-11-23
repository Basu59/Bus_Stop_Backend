package net.backend.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.backend.springboot.model.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop,Long>{

}
