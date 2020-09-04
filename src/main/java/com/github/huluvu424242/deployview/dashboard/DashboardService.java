package com.github.huluvu424242.deployview.dashboard;

import com.github.huluvu424242.deployview.restapi.Artifact;
import com.github.huluvu424242.deployview.restapi.ArtifactRepository;
import com.github.huluvu424242.deployview.restapi.Umgebung;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {


    @Autowired
    private ArtifactRepository artifactRepository;

    public void initRepo() {
//        System.out.println("#################=================== TRY INIT 0==========");
//        final Iterable<Artifact> iterable = this.artifactRepository.findAll();
//        if (!iterable.iterator().hasNext()) {
//            System.out.println("#################=================== TRY INIT 1 ==========");
//            init();
//            System.out.println("#################=================== TRY INIT 2 ==========");
//        }
    }

    private void init() {
        System.out.println("#################=================== INIT ==========");
        final Artifact artifact = new Artifact();
        artifact.setUmgebung(new Umgebung("Platzhaltter Umgebung"));
        artifact.setDepartmentId("Platzhalter Department");
        artifact.setName("Platzhalter Artifact");
        artifact.setDeploymentStatus("UNBEKANNT");
        artifact.setDeploymentNotice(" ");
        this.artifactRepository.save(artifact);
        System.out.println("###===### ID:" + artifact.getId());
//        final Optional<Artifact> artifact1 = this.artifactRepository.findById(artifact.getId());
//            this.artifactRepository.delete(artifact);
    }


    public List<Umgebung> listUmgebungen() {
        final List<Umgebung> umgebungen = this.artifactRepository.findAllUmgebungen();
        if (umgebungen.size() < 1) {
            umgebungen.add(new Umgebung("Platzhalter Umgebung"));
        }
        return umgebungen;
    }


    public List<Artifact> listArtifacts() {
        final List<Artifact> artifacts = new ArrayList<Artifact>();
        final Iterable<Artifact> iterable = this.artifactRepository.findAll();
        iterable.forEach(artifacts::add);
        if (artifacts.size() < 1) {
            artifacts.add(new Artifact("Platzhalter Umgebung",
                    "Platzhalter Department",
                    "Platzhalter Artifact Name",
                    "UNBEKANNT",
                    " "));
        }
        return artifacts;
    }

}