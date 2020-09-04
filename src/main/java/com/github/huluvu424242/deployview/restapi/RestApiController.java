package com.github.huluvu424242.deployview.restapi;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {


    @Autowired
    protected ArtifactRepository artifactRepository;


//    @DeleteMapping("/api/{umgebung}/{department}/{artifact}")
//    public void deleteArtifact(
//            @PathVariable(name = "umgebung") String umgebungId,
//            @PathVariable(name = "department") String departmentId,
//            @PathVariable(name = "artifact") String artifactName) {
//        final long artifactId = artifactRepository.findByKey(new Umgebung(umgebungId), departmentId, artifactName);
//        artifactRepository.deleteById(artifactId);
//    }

//    @PostMapping("/api/{umgebung}/{department}/{artifact}/{status}")
//    public void updateArtifact(
//            @PathVariable(name = "umgebung") String umgebungId,
//            @PathVariable(name = "department") String departmentId,
//            @PathVariable(name = "artifact") String artifactName,
//            @PathVariable(name = "status") String deploymentStatus) {
//        final long artifactId = artifactRepository.findByKey(new Umgebung(umgebungId), departmentId, artifactName);
//        final Optional<Artifact> result = artifactRepository.findById(artifactId);
//        if(result.isPresent()) {
//            final Artifact artifact = result.get();
//            artifact.setDeploymentStatus(deploymentStatus);
//            artifactRepository.save(artifact);
//        }
//    }

    @GetMapping("/test/{umgebung}/{department}/{artifact}/create")
    public void createTestArtifact(
            @PathVariable(name = "umgebung") String umgebungId,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName
    ) {
        final Artifact artifact = new Artifact();
        artifact.setUmgebung(umgebungId);
        artifact.setDepartment(department);
        artifact.setName(artifactName);
        artifact.setDeploymentStatus("UNBEKANNT");
        artifact.setDeploymentNotice(" ");
        artifactRepository.save(artifact);
    }


    @GetMapping("/api/artifacts")
    public Iterable<Artifact> listAllArtifacts() {
        return artifactRepository.findAll();
//        Artifact artifact = new Artifact("Platzhalter Umgebung",
//                "Plathalter Department",
//                "Platzhalter Name",
//                "UNBEKANNT",
//                " ");
//        return Arrays.asList(artifact);
    }

    @PutMapping("/api/{umgebung}/{department}/{artifact}")
    public void createArtifact(
            @PathVariable(name = "umgebung") String umgebungId,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName) {
        final Artifact artifact = new Artifact();
        artifact.setUmgebung(umgebungId);
        artifact.setDepartment(department);
        artifact.setName(artifactName);
        artifact.setDeploymentStatus("UNBEKANNT");
        artifact.setDeploymentNotice(" ");
        artifactRepository.save(artifact);
    }

}


