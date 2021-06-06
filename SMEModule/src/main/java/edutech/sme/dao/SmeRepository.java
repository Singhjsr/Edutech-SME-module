package edutech.sme.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edutech.sme.entities.Sme;


@Repository("smeRepo")
public interface SmeRepository extends JpaRepository<Sme, Integer> {

}
