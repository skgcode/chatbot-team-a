package skgcode.teama.rea.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import skgcode.teama.rea.Model.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

    Building findAllById(Integer id);

    List<Building> findAll();

    // TODO: Another search
}
