package org.addresses.controllers;

import org.addresses.models.House;
import org.addresses.models.Street;
import org.addresses.services.HouseService;
import org.addresses.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {
    @Autowired
    private HouseService houseService;
    @Autowired
    private StreetService streetService;

    @GetMapping("/findHousesJson")
    public List<House> findHouses(Model model) {
        return houseService.findAll();
    }

    @GetMapping(path ="/findHousesXml", produces = MediaType.APPLICATION_XML_VALUE)
    public List<House> findHousesXml(Model model) {
        return houseService.findAll();
    }

    @GetMapping("/findStreetByIdJson")
    public Street findStreetById(@RequestParam(value = "id", defaultValue = "100314") int street_id) {
        return streetService.getStreetById(street_id);
    }

}
