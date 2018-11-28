package skgcode.teama.rea.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skgcode.teama.rea.Model.Building;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer> {

    Building findBuildingById(Integer id);

    List<Building> findBuildingByPrice(Float price);

    List<Building> findBuildingByYear(Integer year);

    List<Building> findBuildingBySquareMeters(Integer squareMeters);

    List<Building> findAll();

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

    // TODO: Implement searches for all entities [BuildingType, TransactionType, Region]
    // TODO: Add all fields in one query
    // TODO: Implement more complicated queries exmpl:
    // TODO: "SELECT BUILDING.PRICE, REGION.NAME FROM BUILDING, REGION
    // TODO: WHERE REGION.ID=2 AND BUILDING.REGION_ID=REGION.ID"
}
