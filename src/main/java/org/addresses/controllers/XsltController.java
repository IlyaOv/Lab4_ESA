package org.addresses.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.addresses.models.House;
import org.addresses.services.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.util.List;

@Controller
public class XsltController {
    @Autowired
    private HouseService houseService;

    @ResponseBody
    @GetMapping(path = "/showHousesXml", produces = MediaType.APPLICATION_XML_VALUE)
    private ModelAndView getFarmers() throws JsonProcessingException {
        List<House> list =  houseService.findAll();
        return getModelAndView(list, "addressXSL");
    }

    private ModelAndView getModelAndView(List<?> list, String viewName) throws JsonProcessingException {
        String str = new XmlMapper().writeValueAsString(list);
        ModelAndView mod = new ModelAndView(viewName);
        Source src = new StreamSource(new StringReader(str));
        mod.addObject("ArrayList", src);
        return mod;
    }

}
