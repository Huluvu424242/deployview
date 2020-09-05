package com.github.huluvu424242.deployview.artifact;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {


    @Autowired
    protected JPARepository jpaRepository;

    @Autowired
    protected JDBCDao dao;


    public long getDefaultNextVal() {
        return dao.getDefaultNextVal();
    }

    public void saveArtifactUpdate(String umgebung,
                                   String department,
                                   String artifactName,
                                   String deploymentStatus,
                                   String notiz) {
        final long artifactId = jpaRepository.findByKey(umgebung, department, artifactName);

        final Optional<Artifact> result = jpaRepository.findById(artifactId);
        if (result.isPresent()) {
            final Artifact artifact = result.get();
            artifact.setDeploymentStatus(deploymentStatus);
            artifact.setDeploymentNotice(notiz);
            jpaRepository.save(artifact);
        }
    }

    public Artifact createArtifact(final String umgebung,
                                   final String department,
                                   final String artifactName) {
        final Artifact artifact = new Artifact();
        artifact.setUmgebung(umgebung);
        artifact.setDepartmentId(department);
        artifact.setName(artifactName);
        artifact.setDeploymentStatus("UNBEKANNT");
        artifact.setDeploymentNotice(" ");
        jpaRepository.save(artifact);
        return artifact;
    }

    public List<String> listUmgebungen() {
        return this.jpaRepository.findAllUmgebungen();
    }

    public List<Artifact> listArtifacts() {
        final List<Artifact> artifacts = new ArrayList<>();
        final Iterable<Artifact> iterable = this.jpaRepository.findAll();
        iterable.forEach(artifacts::add);
        return artifacts;
    }

    public void deleteArtifact(final String umgebung, final String department, final String artifactName) {
        final long artifactId = jpaRepository.findByKey(umgebung, department, artifactName);
        jpaRepository.deleteById(artifactId);
    }
}