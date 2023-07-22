package hu.ak_akademia.mss.repository;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
    public interface  AreaOfExpertiseRepository extends JpaRepository<AreaOfExpertise, Integer> {
    Optional<AreaOfExpertise> findByQualification(String qualification);
    @Override
    Optional<AreaOfExpertise> findById(Integer integer);


    @Override
    List<AreaOfExpertise> findAll(Sort sort);
}

