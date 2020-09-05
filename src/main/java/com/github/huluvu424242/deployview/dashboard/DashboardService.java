package com.github.huluvu424242.deployview.dashboard;

import com.github.huluvu424242.deployview.restapi.Artifact;
import com.github.huluvu424242.deployview.restapi.ArtifactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {


    @Autowired
    private ArtifactRepository artifactRepository;

    public List<String> listUmgebungen() {
        return this.artifactRepository.findAllUmgebungen();
    }


    public Iterable<Artifact> listArtifacts() {
        return this.artifactRepository.findAll();
    }

    public void deleteArtifact(final String umgebung, final String department, final String artifactName) {
        System.out.println("1####################################################################################");
        final long artifactId = artifactRepository.findByKey(umgebung, department, artifactName);
        System.out.println("2 delete" + artifactId);
        artifactRepository.deleteById(artifactId);
        System.out.println("3####################################################################################");
    }
}