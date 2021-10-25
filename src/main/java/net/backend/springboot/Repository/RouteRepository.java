package net.backend.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.backend.springboot.model.Route;

@Repository

public interface RouteRepository extends JpaRepository<Route, Long>{

}