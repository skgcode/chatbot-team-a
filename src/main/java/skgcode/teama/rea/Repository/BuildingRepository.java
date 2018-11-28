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

    @Query(value = "SELECT * FROM BUILDING WHERE PRICE=?1 OR YEAR=?2 OR SQUARE_METERS=?3", nativeQuery = true)
    List<Building> findAllByPriceOrYearOrSquareMeters(Float price, Integer year, Integer squareMeters);

    // TODO: Implement searches for all entities [BuildingType, TransactionType, Region]
}
