package skgcode.teama.rea.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import skgcode.teama.rea.Model.Building;
import skgcode.teama.rea.Service.BuildingService;

import java.util.List;

@RestController
public class BuildingController extends ApiController {

    @Autowired
    private BuildingService buildingService;

    // Retrieve all
    @RequestMapping(value = "/getAllHouses")
    public List<Building> getAllHouses() {
        return buildingService.getAllBuildings();
    }

    // Retrieve by ID
    @RequestMapping("/building/id/{id}")
    public Building getById(@PathVariable Integer id) {
        return buildingService.getBuildingById(id);
    }

    // Retrieve by price
    @RequestMapping("/building/price/{price}")
    public List<Building> getByPrice(@PathVariable float price) {
        return buildingService.getBuildingByPrice(price);
    }

    // Retrieve by year
    @RequestMapping("/building/year/{year}")
    public List<Building> getByYear(@PathVariable Integer year) {
        return buildingService.getBuildingByYear(year);
    }

    // Retrieve by square meters
    @RequestMapping("/building/squareMeters/{squareMeters}")
    public List<Building> getBySquareMeters(@PathVariable Integer squareMeters) {
        return buildingService.getBuildingBySquareMeters(squareMeters);
    }

    @RequestMapping("/building/query/{price}-{year}-{squareMeters}")
    public List<Building> getFilteredResults(@PathVariable Float price, @PathVariable Integer year,
                                             @PathVariable Integer squareMeters) {

        return buildingService.getFilteredBuildings(price, year, squareMeters);
    }
}