package skgcode.teama.rea.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import skgcode.teama.rea.Model.Building;
import skgcode.teama.rea.Service.BuildingService;

@RestController
@RequestMapping("/rea")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/getAllHouses")
    public List<Building> getAllHouses() {
        return buildingService.getAllBuildings();
    }

    // Retrieve a building
    @RequestMapping(value = "/building/{id}", method = RequestMethod.GET)
    public Building getById(@PathVariable Integer id) {
        return buildingService.getBuilding(id);
    }
}