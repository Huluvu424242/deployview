package com.github.huluvu424242.deployview.dashboard;

import com.github.huluvu424242.deployview.restapi.Artifact;
import com.github.huluvu424242.deployview.restapi.ArtifactRepository;
import com.github.huluvu424242.deployview.restapi.Umgebung;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {


    @Autowired
    private ArtifactRepository artifactRepository;

    public List<Umgebung> listUmgebungen() {
        return this.artifactRepository.findAllUmgebungen();
    }


    public Iterable<Artifact> listArtifacts() {
        return this.artifactRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

}