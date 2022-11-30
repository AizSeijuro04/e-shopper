package com.azhar.eshopper.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.azhar.eshopper.model.Province;

@Controller
public class IndexController {
    @GetMapping("/")
    public String showIndex(Model model){
        model.addAttribute("title", "Hello Baby 2022");
        return "index.html";
    }

    @GetMapping("/province")
    public String showProvince(Model model){
        List<Province> listOfProvince = Arrays.asList(
            new Province(1L,"DKI Jakarta"),
            new Province(2L,"Jawa Barat"),
            new Province(3L,"Jawa Timur")
        );

        model.addAttribute("listOfProvince", listOfProvince);
        
        return "province.html";
    }
}
