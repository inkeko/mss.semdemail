package hu.ak_akademia.mss.service;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import hu.ak_akademia.mss.repository.AreaOfExpertiseRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class AreaOfExpertiseService {
    private AreaOfExpertiseRepository areaOfExpertiseRepository;

    public AreaOfExpertiseService(AreaOfExpertiseRepository areaOfExpertiseRepository) {
        this.areaOfExpertiseRepository = areaOfExpertiseRepository;
    }

    public List<AreaOfExpertise> getAllAreaOfexpertise(){

        return areaOfExpertiseRepository.findAll();
    }

    public AreaOfExpertise getAreaOfExpertiseByQualification(String qualification) {
        return areaOfExpertiseRepository.findByQualification(qualification)
                .orElseThrow(() -> new NoSuchElementException("Nem található szakirány ezzel a kvalifikációval: " + qualification));
    }


}
