package com.github.huluvu424242.deployview.dashboard;

import com.github.huluvu424242.deployview.artifact.Artifact;
import com.github.huluvu424242.deployview.artifact.ArtifactRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {


    @Autowired
    private ArtifactRepository artifactRepository;

    protected void initArtifactList(final List<Artifact> artifacts) {
        if (artifacts.size() < 1) {
            artifacts.add(new Artifact());
        }
    }

    protected void initUmgebungList(final List<String> umgebungen) {
        if (umgebungen.size() < 1) {
            umgebungen.add("Platzhalter Umgebung");
        }
    }

    public List<String> listUmgebungen() {
        final List<String> umgebungen = this.artifactRepository.findAllUmgebungen();
        initUmgebungList(umgebungen);
        return umgebungen;
    }


    public List<Artifact> listArtifacts() {
        final List<Artifact> artifacts = new ArrayList<>();
        final Iterable<Artifact> iterable = this.artifactRepository.findAll();
        iterable.forEach(artifacts::add);
        initArtifactList(artifacts);
        return artifacts;
    }

    public void deleteArtifact(final String umgebung, final String department, final String artifactName) {
        final long artifactId = artifactRepository.findByKey(umgebung, department, artifactName);
        artifactRepository.deleteById(artifactId);
    }
}