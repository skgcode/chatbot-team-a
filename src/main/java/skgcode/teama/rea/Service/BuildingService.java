package skgcode.teama.rea.Service;

import skgcode.teama.rea.Model.Building;

import java.util.List;

public interface BuildingService {

    Building getBuilding(Integer id);

    List<Building> getAllBuildings();
}