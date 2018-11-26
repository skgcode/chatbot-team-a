package skgcode.teama.rea.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skgcode.teama.rea.Model.Building;
import skgcode.teama.rea.Repository.BuildingRepository;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    @Override
    public Building getBuilding(Integer id) {
        return buildingRepository.findBuildingById(id);
    }

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

}