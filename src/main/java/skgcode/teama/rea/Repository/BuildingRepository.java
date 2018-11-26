package skgcode.teama.rea.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import skgcode.teama.rea.Model.Building;

import java.util.List;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer> {

    Building findBuildingById(Integer id);

    List<Building> findAll();

    // TODO: Implement searches for all entities [BuildingType, TransactionType, Region]
}
