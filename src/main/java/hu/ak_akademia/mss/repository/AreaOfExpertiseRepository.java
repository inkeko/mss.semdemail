package hu.ak_akademia.mss.repository;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
    public interface  AreaOfExpertiseRepository extends JpaRepository<AreaOfExpertise, Integer> {
    @Override
    List<AreaOfExpertise> findAll(Sort sort);
}

