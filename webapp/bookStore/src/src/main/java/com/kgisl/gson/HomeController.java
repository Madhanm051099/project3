package com.kgisl.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HomeController
 */
@Controller
@RequestMapping("/country")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public String index() {
        // public String index() {
        List<String> names = new ArrayList<String>();
        names.add("Aarthi");
        names.add("Shalini");
        Gson gson = new Gson();
        String json = gson.toJson(names);
        return json;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public String addCountry() {
        System.out.println("Country POST");
        String json = "";
        return json;
    }

}