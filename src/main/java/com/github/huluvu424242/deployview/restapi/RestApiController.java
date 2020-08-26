package com.github.huluvu424242.deployview.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {


    @Autowired
    protected ArtifactRepository artifactRepository;


    @DeleteMapping("/api/{umgebung}/{department}/{artifact}")
    public void deleteArtifact(
            @PathVariable(name = "umgebung") String umgebungId,
            @PathVariable(name = "department") String departmentId,
            @PathVariable(name = "artifact") String artifactName) {
        final long artifactId = artifactRepository.findByKey(new Umgebung(umgebungId), departmentId, artifactName);
        artifactRepository.deleteById(artifactId);
    }

}


