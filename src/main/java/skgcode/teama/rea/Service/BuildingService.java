package skgcode.teama.rea.Service;

import skgcode.teama.rea.Model.Building;

import java.util.List;

public interface BuildingService {

    Building getBuildingById(Integer id);

    List<Building> getBuildingsByPrice(Float price);

    List<Building> getBuildingsByYear(Integer year);

    List<Building> getBuildingsBySquareMeters(Integer sqMeters);

    List<Building> getAllBuildings();

    List<Building> getFilteredBuildings(Float price, Integer year, Integer squareMeters);

    List<Building> getPriceRangeBetween(Float priceMin, Float priceMax);

    List<Building> getYearRangeBetween(Integer yearMin, Integer yearMax);
}