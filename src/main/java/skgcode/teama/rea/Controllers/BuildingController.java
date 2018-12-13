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

    // Retrieve results as query: Where Price Between Or Year Or Squaremeters
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
        return buildingService.getQueryWhereRegionAndBuildingTypeAndTransactionTypeAndPriceBetween(region, buildingType,
                transactionType, priceMin, priceMax);
    }

    @RequestMapping(value = "/building/query/regionOrRegionAndBuildingTypeAndTransactionTypeAndPriceRange",
            params = {"region1", "region2", "buildingType", "transactionType", "priceMin", "priceMax"},
            method = RequestMethod.GET)
    public List<Building> getQueryWhereRegionOrRegionAndBuildingTypeAndTransactionTypeAndPriceRange(@RequestParam("region1") String region1,
                                                                                                    @RequestParam("region2") String region2,
                                                                                                    @RequestParam("buildingType") String buildingType,
                                                                                                    @RequestParam("transactionType") String transactionType,
                                                                                                    @RequestParam("priceMin") Integer priceMin,
                                                                                                    @RequestParam("priceMax") Integer priceMax) {
        return buildingService.getQueryWhereRegionOrRegionAndBuildingTypeAndTransactionTypeAndPriceBetween(region1, region2, buildingType,
                transactionType, priceMin, priceMax);
    }

    @RequestMapping(value = "/building/query/regionAndTransactionTypeAndPriceRange",
            params = {"region", "transactionType", "priceMin", "priceMax"},
            method = RequestMethod.GET)
    public List<Building> getQueryWhereRegionAndTransactionTypeAndPriceRange(@RequestParam("region") String region,
                                                                                     @RequestParam("transactionType") String transactionType,
                                                                                     @RequestParam("priceMin") Integer priceMin,
                                                                                     @RequestParam("priceMax") Integer priceMax) {
        return buildingService.getQueryWhereRegionAndTransactionTypeAndPriceBetween(region, transactionType, priceMin, priceMax);
    }

    @RequestMapping(value = "/building/query/regionOrRegionAndTransactionTypeAndPriceRange",
            params = {"region1", "region2", "transactionType", "priceMin", "priceMax"},
            method = RequestMethod.GET)
    public List<Building> getQueryWhereRegionOrRegionAndTransactionTypeAndPriceRange(@RequestParam("region1") String region1,
                                                                                     @RequestParam("region2") String region2,
                                                                                     @RequestParam("transactionType") String transactionType,
                                                                                     @RequestParam("priceMin") Integer priceMin,
                                                                                     @RequestParam("priceMax") Integer priceMax) {
        return buildingService.getQueryWhereRegionOrRegionAndTransactionTypeAndPriceBetween(region1, region2, transactionType, priceMin, priceMax);
    }
}