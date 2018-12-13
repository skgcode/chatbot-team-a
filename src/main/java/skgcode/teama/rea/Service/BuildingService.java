package skgcode.teama.rea.Service;

import skgcode.teama.rea.Model.Building;

import java.util.List;

public interface BuildingService {

    List<Building> getAllBuildings();

    List<Building> getQueryWherePriceRangeOrYearOrSquearmeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters);

    List<Building> getQueryWherePriceRangeAndYearAndSquearmeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters);

    List<Building> getQueryWherePriceOrYearOrSquaremeters(Float price, Integer year, Integer squareMeters);

    List<Building> getQueryWherePriceAndYearAndSquaremeters(Float price, Integer year, Integer squareMeters);

    List<Building> getPriceRangeBetween(Float priceMin, Float priceMax);

    List<Building> getYearRangeBetween(Integer yearMin, Integer yearMax);

    List<Building> getQueryWhereRegionAndBuildingTypeAndTransactionTypeAndPriceBetween(String region, String buildingType,
                                                                                       String transactionType, Integer priceMin,
                                                                                       Integer priceMax);

    List<Building> getQueryWhereRegionOrRegionAndBuildingTypeAndTransactionTypeAndPriceBetween(String region1, String region2, String buildingType,
                                                                                               String transactionType, Integer priceMin,
                                                                                               Integer priceMax);

    List<Building> getQueryWhereRegionOrRegionAndTransactionTypeAndPriceBetween(String region1, String region2,
                                                                                String transactionType, Integer priceMin,
                                                                                Integer priceMax);

    List<Building> getQueryWhereRegionAndTransactionTypeAndPriceBetween(String region, String transactionType,
                                                                        Integer priceMin, Integer priceMax);
}