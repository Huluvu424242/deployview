package com.github.huluvu424242.deployview.artifact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtifactController {


    @Autowired
    protected ArtifactRepository artifactRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long getNextVal() {
        return (Long) jdbcTemplate.queryForObject("select next_val from hibernate_sequences where sequence_name ='default'", Long.class);
    }

    @GetMapping("/api/export")
    public ExportWrapper exportArtifacts() {
        final List<Artifact> artifacts = new ArrayList<>();
        final Iterable<Artifact> iterable = this.artifactRepository.findAll();
        iterable.forEach(artifacts::add);
        final long nextVal = this.getNextVal();
        return new ExportWrapper(artifacts, nextVal);
    }

    @DeleteMapping("/api/{umgebung}/{department}/{artifact}")
    public void deleteArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName) {
        final long artifactId = artifactRepository.findByKey(umgebung, department, artifactName);
        artifactRepository.deleteById(artifactId);
    }

    protected void saveArtifactUpdate(String umgebung,
                                      String department,
                                      String artifactName,
                                      String deploymentStatus,
                                      String notiz) {
        final long artifactId = artifactRepository.findByKey(umgebung, department, artifactName);

        final Optional<Artifact> result = artifactRepository.findById(artifactId);
        if (result.isPresent()) {
            final Artifact artifact = result.get();
            artifact.setDeploymentStatus(deploymentStatus);
            artifact.setDeploymentNotice(notiz);
            artifactRepository.save(artifact);
        }
    }

    @PostMapping("/api/{umgebung}/{department}/{artifact}/{status}")
    public void updateArtifactStatus(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName,
            @PathVariable(name = "status") String deploymentStatus) {
        this.saveArtifactUpdate(umgebung, department, artifactName, deploymentStatus, " ");
    }

    @PostMapping("/api/{umgebung}/{department}/{artifact}/{status}/{notiz}")
    public void updateArtifact(
            @PathVariable(name = "umgebung") String umgebung,
            @PathVariable(name = "department") String department,
            @PathVariable(name = "artifact") String artifactName,
            @PathVariable(name = "status") String deploymentStatus,
            @PathVariable(name = "notiz") String notiz) {
        saveArtifactUpdate(umgebung, department, artifactName, deploymentStatus, notiz);
    }

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

