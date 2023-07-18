package hu.ak_akademia.mss.service;

import hu.ak_akademia.mss.model.AreaOfExpertise;
import hu.ak_akademia.mss.repository.AreaOfExpertiseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AreaOfExpertiseService {
    private AreaOfExpertiseRepository areaOfExpertiseRepository;

    public AreaOfExpertiseService(AreaOfExpertiseRepository areaOfExpertiseRepository) {
        this.areaOfExpertiseRepository = areaOfExpertiseRepository;
    }

    public List<AreaOfExpertise> getAllAreaOfexpertise(){
    return areaOfExpertiseRepository.findAll();
    }

}
