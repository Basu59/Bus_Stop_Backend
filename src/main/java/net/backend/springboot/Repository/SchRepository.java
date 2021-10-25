package net.backend.springboot.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.backend.springboot.model.Sche;

@Repository
public interface SchRepository extends JpaRepository<Sche, Long> {

}
