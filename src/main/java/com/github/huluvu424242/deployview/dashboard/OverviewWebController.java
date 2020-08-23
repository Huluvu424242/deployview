package com.github.huluvu424242.deployview.dashboard;


import com.github.huluvu424242.deployview.restapi.Umgebung;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OverviewWebController {

    @Autowired
    protected UmgebungsService umgebungsService;

    @ModelAttribute("allUmgebungen")
    public List<Umgebung> populateUmgebungen() {
        return this.umgebungsService.findAll();
    }

    @GetMapping("/overview")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
        return "overview";
    }

}