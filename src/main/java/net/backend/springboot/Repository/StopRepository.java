package net.backend.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.backend.springboot.model.Stop;

public interface StopRepository extends JpaRepository<Stop,Long>{

}
