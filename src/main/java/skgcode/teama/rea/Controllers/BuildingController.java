package skgcode.teama.rea.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import skgcode.teama.rea.Model.Building;
import skgcode.teama.rea.Service.BuildingService;

import java.util.List;

@RestController
public class BuildingController implements ApiController {

    @Autowired
    private BuildingService buildingService;

    // Retrieve all
    @RequestMapping(value = "/building/getAllBuildings", method = RequestMethod.GET)
    public List<Building> getAllBuildings() {
        return buildingService.getAllBuildings();
    }

    // Retrieve by ID
    @RequestMapping(value = "/building/id/{id}", method = RequestMethod.GET)
    public Building getById(@PathVariable Integer id) {
        return buildingService.getBuildingById(id);
    }

    // Retrieve by price
    @RequestMapping(value = "/building/price/{price}", method = RequestMethod.GET)
    public List<Building> getByPrice(@PathVariable float price) {
        return buildingService.getBuildingsByPrice(price);
    }

    // Retrieve by year
    @RequestMapping(value = "/building/year/{year}", method = RequestMethod.GET)
    public List<Building> getByYear(@PathVariable Integer year) {
        return buildingService.getBuildingsByYear(year);
    }

    // Retrieve by square meters
    @RequestMapping(value = "/building/squareMeters/{squareMeters}", method = RequestMethod.GET)
    public List<Building> getBySquareMeters(@PathVariable Integer squareMeters) {
        return buildingService.getBuildingsBySquareMeters(squareMeters);
    }

    // Retrieve results WHERE PRICE OR YEAR OR SQUARE_METERS
    @RequestMapping(value = "/building/query/priceOrYearOrSquaremeters",
            params = {"price", "year", "squareMeters"},
            method = RequestMethod.GET)
    public List<Building> getQueryWherePriceOrYearOrSquareMeters(@RequestParam("price") Float price, @RequestParam("year") Integer year,
                                                                 @RequestParam("squareMeters") Integer squareMeters) {

        return buildingService.getQueryWherePriceOrYearOrSquaremeters(price, year, squareMeters);
    }

    // Retrieve results WHERE PRICE AND YEAR AND SQUARE_METERS
    @RequestMapping(value = "/building/query/priceAndYearAndSquaremeters",
            params = {"price", "year", "squareMeters"},
            method = RequestMethod.GET)
    public List<Building> getQueryWherePriceAndYearAndSquareMeters(@RequestParam("price") Float price, @RequestParam("year") Integer year,
                                                                   @RequestParam("squareMeters") Integer squareMeters) {

        return buildingService.getQueryWherePriceAndYearAndSquaremeters(price, year, squareMeters);
    }

    // Retrieve results between a certain price range
    @RequestMapping(value = "/building/query/pricerange",
            params = {"min", "max"},
            method = RequestMethod.GET)
    @ResponseBody
    public List<Building> getPriceRangeBetween(@RequestParam("min") Float min,
                                               @RequestParam("max") Float max) {

        return buildingService.getPriceRangeBetween(min, max);
    }

    // Retrieve results between a certain year range
    @RequestMapping(value = "/building/query/yearrange",
            params = {"min", "max"},
            method = RequestMethod.GET)
    public List<Building> getYearRangeBetween(@RequestParam("min") Integer min,
                                              @RequestParam("max") Integer max) {
        return buildingService.getYearRangeBetween(min, max);
    }

    @RequestMapping(value = "/building/query/priceRangeOrYearOrsquareMeters",
            params = {"priceMin", "priceMax", "year", "squareMeters"},
            method = RequestMethod.GET)
    public List<Building> getQueryWherePriceRangeOrYearOrSquaremeters(@RequestParam("priceMin") Float priceMin,
                                                                      @RequestParam("priceMax") Float priceMax, @RequestParam("year") Integer year, @RequestParam("squareMeters") Integer squareMeters) {
        return buildingService.getQueryWherePriceRangeOrYearOrSquearmeters(priceMin, priceMax, year, squareMeters);
    }

    @RequestMapping(value = "/building/query/priceRangeAndYearAndsquareMeters",
            params = {"priceMin", "priceMax", "year", "squareMeters"},
            method = RequestMethod.GET)
    public List<Building> getQueryWherePriceRangeAndYearAndSquaremeters(@RequestParam("priceMin") Float priceMin,
                                                                        @RequestParam("priceMax") Float priceMax,
                                                                        @RequestParam("year") Integer year,
                                                                        @RequestParam("squareMeters") Integer squareMeters) {
        return buildingService.getQueryWherePriceRangeAndYearAndSquearmeters(priceMin, priceMax, year, squareMeters);
    }

    @RequestMapping(value = "/building/query/regionAndBuildingTypeAndTransactionTypeAndPriceRange",
            params = {"region", "buildingType", "transactionType", "priceMin", "priceMax"},
            method = RequestMethod.GET)
    public List<Building> getQueryWhereRegionAndBuildingTypeAndTransactionTypeAndPriceRange(@RequestParam("region") String region,
                                                                                            @RequestParam("buildingType") String buildingType,
                                                                                            @RequestParam("transactionType") String transactionType,
                                                                                            @RequestParam("priceMin") Integer priceMin,
                                                                                            @RequestParam("priceMax") Integer priceMax) {
        return buildingService.getQueryWhereRegionAndBuildingTypeAndTransactionTypeAndYearBetween(region, buildingType,
                transactionType, priceMin, priceMax);
    }
}