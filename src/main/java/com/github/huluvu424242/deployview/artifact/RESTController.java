package com.github.huluvu424242.deployview.artifact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {


    @Autowired
    protected DataService dataService;

    @PostMapping("/api/import" )
    public ResponseEntity<ExportWrapper> importArtifacts(@RequestBody ExportWrapper exportWrapper) {
        dataService.importArtifacts(exportWrapper);
        return ResponseEntity.ok(exportWrapper);
    }

    @GetMapping("/api/export")
    public ExportWrapper exportArtifacts() {
        return new ExportWrapper(dataService.listArtifacts(), dataService.getDefaultNextVal());
    }

    @DeleteMapping("/api/{umgebung}/{department}/{artifact}")
    public void deleteArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName) {
        dataService.deleteArtifact(umgebung, department, artifactName);
    }


    @PostMapping("/api/{umgebung}/{department}/{artifact}/{status}")
    public void updateArtifactStatus(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName,
            @PathVariable(name = "status") String deploymentStatus) {
        dataService.saveArtifactUpdate(umgebung, department, artifactName, deploymentStatus, " ");
    }

    @PostMapping("/api/{umgebung}/{department}/{artifact}/{status}/{notiz}")
    public void updateArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName,
            @PathVariable(name = "status") String deploymentStatus,
            @PathVariable(name = "notiz") String notiz) {
        dataService.saveArtifactUpdate(umgebung, department, artifactName, deploymentStatus, notiz);
    }

    @PutMapping("/api/{umgebung}/{department}/{artifact}")
    public void createArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName) {
        dataService.createArtifact(umgebung, department, artifactName);
    }

}


