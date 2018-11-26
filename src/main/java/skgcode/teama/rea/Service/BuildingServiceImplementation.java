package skgcode.teama.rea.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skgcode.teama.rea.Model.Building;
import skgcode.teama.rea.Repository.BuildingRepository;

import java.util.List;

@Service
public class BuildingServiceImplementation implements BuildingService {

    @Autowired
    BuildingRepository buildingRepository;

    @Override
    public Building getBuildingById(Integer id) {
        return buildingRepository.findBuildingById(id);
    }

    @Override
    public List<Building> getBuildingByPrice(Float price) {
        return buildingRepository.findBuildingByPrice(price);
    }


    @Override
    public List<Building> getBuildingByYear(Integer year) {
        return buildingRepository.findBuildingByYear(year);
    }

    @Override
    public List<Building> getBuildingBySquareMeters(Integer sqMeters) {
        return buildingRepository.findBuildingBySquareMeters(sqMeters);
    }

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public List<Building> getFilteredBuildings(Float price, Integer year, Integer squareMeters) {
        if(price != null || year != null || squareMeters != null) {
            return buildingRepository.findAllByPriceOrYearOrSquareMeters(price, year, squareMeters);
        } else {
            return buildingRepository.findAllByPriceOrYearOrSquareMeters(0f, 0, 0);
        }
    }
}