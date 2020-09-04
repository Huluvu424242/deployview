package com.github.huluvu424242.deployview.restapi;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping("/api/{umgebung}/{department}/{artifact}")
    public void createArtifact(
            @PathVariable(name = "umgebung") String umgebungId,
            @PathVariable(name = "department") String departmentId,
            @PathVariable(name = "artifact") String artifactName) {
        final Artifact artifact = new Artifact();
        artifact.setUmgebung(umgebungId);
        artifact.setDepartmentId(departmentId);
        artifact.setName(artifactName);
        artifact.setDeploymentStatus("UNBEKANNT");
        artifact.setDeploymentNotice(" ");
        artifactRepository.save(artifact);
    }

}


