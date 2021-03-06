package skgcode.teama.rea.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skgcode.teama.rea.Model.Building;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer> {

    List<Building> findAll();

    @Query(value = "SELECT * FROM BUILDING WHERE (PRICE BETWEEN ?1 AND ?2) OR YEAR=?3 OR SQUARE_METERS=?4", nativeQuery = true)
    List<Building> findAllByPriceRangeOrYearOrSquareMeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters);

    @Query(value = "SELECT * FROM BUILDING WHERE (PRICE BETWEEN ?1 AND ?2) AND YEAR=?3 AND SQUARE_METERS=?4", nativeQuery = true)
    List<Building> findAllByPriceRangeAndYearAndSquareMeters(Float priceMin, Float priceMax, Integer year, Integer squareMeters);

    // query WHERE PRICE OR YEAR OR SQUARE_METERS
    @Query(value = "SELECT * FROM BUILDING WHERE PRICE=?1 OR YEAR=?2 OR SQUARE_METERS=?3", nativeQuery = true)
    List<Building> findAllByPriceOrYearOrSquareMeters(Float price, Integer year, Integer squareMeters);

    // query WHERE PRICE AND YEAR AND SQUARE_METERS
    @Query(value = "SELECT * FROM BUILDING WHERE PRICE=?1 AND YEAR=?2 AND SQUARE_METERS=?3", nativeQuery = true)
    List<Building> findAllByPriceAndYearAndSquareMeters(Float price, Integer year, Integer squareMeters);

    // PRICE BETWEEN
    @Query(value = "SELECT * FROM BUILDING WHERE PRICE BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Building> findBuildingsByPriceBetweenMinAndMax(Float min, Float max);

    // YEAR BETWEEN
    @Query(value = "SELECT * FROM BUILDING WHERE YEAR BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Building> findBuildingsByYearBetweenMinAndMax(Integer min, Integer max);

    // FORM BASED QUERY WITH AND
    @Query(value = "SELECT * FROM BUILDING, REGION, TRANSACTION_TYPE, BUILDING_TYPE\n" +
            "WHERE REGION.NAME=?1 AND BUILDING_TYPE.NAME=?2 AND TRANSACTION_TYPE.NAME=?3 AND (BUILDING.PRICE BETWEEN ?4 AND ?5)\n" +
            "AND REGION.ID=BUILDING.REGION_ID AND BUILDING_TYPE.ID=BUILDING.TYPE_ID AND TRANSACTION_TYPE.ID=BUILDING.TRANSACTION_TYPE_ID", nativeQuery = true)
    List<Building> findBuildingsByPriceBetweenAndRegionAndTransactionTypeAndType(String region, String buildingType,
                                                                                 String transactionType, Integer priceMin,
                                                                                 Integer priceMax);

    // FORM BASED QUERY WITH AND - REGION1 OR REGION2
    @Query(value = "SELECT * FROM BUILDING, REGION, TRANSACTION_TYPE, BUILDING_TYPE\n" +
            "WHERE ((REGION.NAME=?1 OR REGION.NAME=?2) AND BUILDING_TYPE.NAME=?3) AND TRANSACTION_TYPE.NAME=?4 AND (BUILDING.PRICE BETWEEN ?5 AND ?6)\n" +
            "AND REGION.ID=BUILDING.REGION_ID AND BUILDING_TYPE.ID=BUILDING.TYPE_ID AND TRANSACTION_TYPE.ID=BUILDING.TRANSACTION_TYPE_ID", nativeQuery = true)
    List<Building> findBuildingsByPriceBetweenAndRegionOrRegionAndTransactionTypeAndType(String region1, String region2, String buildingType,
                                                                                         String transactionType, Integer priceMin,
                                                                                         Integer priceMax);

    // FORM BASED QUERY WITH AND - REGION1 OR REGION2 without BUILDING_TYPE
    @Query(value = "SELECT * FROM BUILDING, REGION, TRANSACTION_TYPE\n" +
            "WHERE (REGION.NAME=?1 OR REGION.NAME=?2) AND TRANSACTION_TYPE.NAME=?3 AND (BUILDING.PRICE BETWEEN ?4 AND ?5)\n" +
            "AND REGION.ID=BUILDING.REGION_ID AND TRANSACTION_TYPE.ID=BUILDING.TRANSACTION_TYPE_ID", nativeQuery = true)
    List<Building> findBuildingsByPriceBetweenAndRegionOrRegionAndTransactionType(String region1, String region2,
                                                                                  String transactionType, Integer priceMin,
                                                                                  Integer priceMax);

    // FORM BASED QUERY WITH AND - REGION without BUILDING_TYPE
    @Query(value = "SELECT * FROM BUILDING, REGION, TRANSACTION_TYPE WHERE REGION.NAME=?1 AND TRANSACTION_TYPE.NAME=?2 AND REGION.ID=BUILDING.REGION_ID AND TRANSACTION_TYPE.ID=BUILDING.TRANSACTION_TYPE_ID\n" +
            "AND BUILDING.PRICE BETWEEN ?3 AND ?4", nativeQuery = true)
    List<Building> findBuildingsByPriceBetweenAndRegionAndTransactionType(String region, String transactionType,
                                                                          Integer priceMin, Integer priceMax);
}