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
    public List<Building> getBuildingsByPrice(Float price) {
        return buildingRepository.findBuildingByPrice(price);
    }


    @Override
    public List<Building> getBuildingsByYear(Integer year) {
        return buildingRepository.findBuildingByYear(year);
    }

    @Override
    public List<Building> getBuildingsBySquareMeters(Integer sqMeters) {
        return buildingRepository.findBuildingBySquareMeters(sqMeters);
    }

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    // query WHERE PRICE OR YEAR OR SQUARE_METERS
    @Override
    public List<Building> getQueryWherePriceOrYearOrSquaremeters(Float price, Integer year, Integer squareMeters) {
        if (price != null || year != null || squareMeters != null) {
            return buildingRepository.findAllByPriceOrYearOrSquareMeters(price, year, squareMeters);
        } else {
            return buildingRepository.findAllByPriceOrYearOrSquareMeters(0f, 0, 0);
        }
    }

    // query WHERE PRICE AND YEAR AND SQUARE_METERS
    @Override
    public List<Building> getQueryWherePriceAndYearAndSquaremeters(Float price, Integer year, Integer squareMeters) {
        if (price != null || year != null || squareMeters != null) {
            return buildingRepository.findAllByPriceAndYearAndSquareMeters(price, year, squareMeters);
        } else {
            return buildingRepository.findAllByPriceAndYearAndSquareMeters(0f, 0, 0);
        }
    }

    // PRICE BETWEEN
    @Override
    public List<Building> getPriceRangeBetween(Float priceMin, Float priceMax) {
        return buildingRepository.findBuildingsByPriceBetweenMinAndMax(priceMin, priceMax);
    }

    // YEAR BETWEEN
    @Override
    public List<Building> getYearRangeBetween(Integer yearMin, Integer yearMax) {
        return buildingRepository.findBuildingsByYearBetweenMinAndMax(yearMin, yearMax);
    }

    @Override
    public List<Building> getQueryWhereRegionAndBuildingTypeAndTransactionTypeAndYearBetween(String region, String buildingType,
                                                                                             String transactionType, Integer priceMin,
                                                                                             Integer priceMax) {
        return buildingRepository.findBuildingsByPriceBetweenAndRegionAndTransactionTypeAndType(region, buildingType, transactionType,
                priceMin, priceMax);
    }

    @Override
    public List<Building> getQueryWherePriceRangeOrYearOrSquearmeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters) {
        return buildingRepository.findAllByPriceRangeOrYearOrSquareMeters(priceMin, priceMax, year, squareMeters);
    }

    @Override
    public List<Building> getQueryWherePriceRangeAndYearAndSquearmeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters) {
        return buildingRepository.findAllByPriceRangeAndYearAndSquareMeters(priceMin, priceMax, year, squareMeters);
    }
}