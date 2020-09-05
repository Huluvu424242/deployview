package com.github.huluvu424242.deployview.dashboard;


import com.github.huluvu424242.deployview.restapi.Artifact;
import com.github.huluvu424242.deployview.restapi.ArtifactRepository;
import com.github.huluvu424242.deployview.restapi.Umgebung;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OverviewWebController {

    @Autowired
    protected DashboardService dashboardService;

    @ModelAttribute("allUmgebungen")
    public List<Umgebung> populateUmgebungen() {
        return this.dashboardService.listUmgebungen();
    }

    @ModelAttribute("allArtifacts")
    public Iterable<Artifact> populateArtifacts() {
        return this.dashboardService.listArtifacts();
    }


    @GetMapping("/overview")
    public String overview() {
        return "overview";
    }

    @GetMapping("/delete/{umgebung}/{department}/{artifact}")
    public String deleteArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName) {
        this.dashboardService.deleteArtifact(umgebung,department,artifactName);
        return "redirect:/overview";
    }

}