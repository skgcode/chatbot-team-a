package skgcode.teama.rea.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import skgcode.teama.rea.Model.Building;
import skgcode.teama.rea.Service.BuildingService;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping("/getAllHouses")
    public List<Building> getAllHouses() {
        return buildingService.getAllBuildings();
    }
}