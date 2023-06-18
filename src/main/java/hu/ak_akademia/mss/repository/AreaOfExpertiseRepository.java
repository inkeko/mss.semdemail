package hu.ak_akademia.mss.repository;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface AreaOfExpertiseRepository extends JpaRepository<AreaOfExpertise, Integer> {
    }

