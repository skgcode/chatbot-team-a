package skgcode.teama.rea.Service;

import skgcode.teama.rea.Model.Building;

import java.util.List;

public interface BuildingService {

    Building getBuildingById(Integer id);

    List<Building> getBuildingByPrice(Float price);

    List<Building> getBuildingByYear(Integer year);

    List<Building> getBuildingBySquareMeters(Integer sqMeters);

    List<Building> getAllBuildings();

    List<Building> getFilteredBuildings(Float price, Integer year, Integer squareMeters);
}