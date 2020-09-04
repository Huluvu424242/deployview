//package com.github.huluvu424242.deployview.dashboard;
//
//
//import com.github.huluvu424242.deployview.restapi.Artifact;
//import com.github.huluvu424242.deployview.restapi.ArtifactRepository;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@Controller
//public class OverviewWebController {
//
//    @Autowired
//    protected DashboardService dashboardService;
//
//
//
//    @ModelAttribute("allUmgebungen")
//    public List<String> populateUmgebungen() {
//        return this.dashboardService.listUmgebungen();
//    }
//
//    @ModelAttribute("allArtifacts")
//    public List<Artifact> populateArtifacts() {
//        return this.dashboardService.listArtifacts();
//    }
//
//
//    @GetMapping("/overview")
//    public String overview() {
//        return "overview";
//    }
//
////    @GetMapping("/delete/{umgebung}/{department}/{artifact}")
////    public String deleteArtifact(
////            @PathVariable(name = "umgebung") String umgebungId,
////            @PathVariable(name = "department") String departmentId,
////            @PathVariable(name = "artifact") String artifactName) {
////        System.out.println("1####################################################################################");
////        final long artifactId = artifactRepository.findByKey(new Umgebung(umgebungId), departmentId, artifactName);
////        System.out.println("2 delete"+artifactId);
////        artifactRepository.deleteById(artifactId);
////        System.out.println("3####################################################################################");
////        return "redirect:/overview";
////    }
//
//}