package skgcode.teama.rea.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController{
    
    @RequestMapping("/getAllHouses") 
    public String getAllHouses() {
        return "";
    }
}