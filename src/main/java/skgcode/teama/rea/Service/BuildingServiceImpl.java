package skgcode.teama.rea.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import skgcode.teama.rea.Model.Building;
import skgcode.teama.rea.Repository.BuildingRepository;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

}