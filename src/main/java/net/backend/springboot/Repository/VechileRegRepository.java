package net.backend.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.backend.springboot.model.VechileReg;


@Repository
public interface VechileRegRepository extends JpaRepository<VechileReg, Long> {

}
