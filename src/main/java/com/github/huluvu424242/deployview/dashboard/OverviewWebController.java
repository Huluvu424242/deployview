package com.github.huluvu424242.deployview.dashboard;


import com.github.huluvu424242.deployview.restapi.Artifact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class OverviewWebController {

    @Autowired
    protected DashboardService dashboardService;

    @ModelAttribute("allUmgebungen")
    public List<String> populateUmgebungen() {
        return this.dashboardService.listUmgebungen();
    }

    @ModelAttribute("allArtifacts")
    public List<Artifact> populateArtifacts() {
        return this.dashboardService.listArtifacts();
    }

    @GetMapping("/overview")
    public String overview() {
        return "overview";
    }


}