package skgcode.teama.rea.Service;

import skgcode.teama.rea.Model.Building;

import java.util.List;

public interface BuildingService {

    Building getBuildingById(Integer id);

    List<Building> getBuildingsByPrice(Float price);

    List<Building> getBuildingsByYear(Integer year);

    List<Building> getBuildingsBySquareMeters(Integer sqMeters);

    List<Building> getAllBuildings();

    List<Building> getQueryWherePriceRangeOrYearOrSquearmeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters);

    List<Building> getQueryWherePriceRangeAndYearAndSquearmeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters);

    List<Building> getQueryWherePriceOrYearOrSquaremeters(Float price, Integer year, Integer squareMeters);

    List<Building> getQueryWherePriceAndYearAndSquaremeters(Float price, Integer year, Integer squareMeters);

    List<Building> getPriceRangeBetween(Float priceMin, Float priceMax);

    List<Building> getYearRangeBetween(Integer yearMin, Integer yearMax);

    List<Building> getQueryWhereRegionAndBuildingTypeAndTransactionTypeAndYearBetween(String region, String buildingType,
                                                                                      String transactionType, Integer priceMin,
                                                                                      Integer priceMax);
}