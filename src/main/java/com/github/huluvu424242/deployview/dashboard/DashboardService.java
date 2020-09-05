package com.github.huluvu424242.deployview.dashboard;

import com.github.huluvu424242.deployview.artifact.Artifact;
import com.github.huluvu424242.deployview.artifact.DataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {


    @Autowired
    private DataService dataService;

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
        final List<String> umgebungen = this.dataService.listUmgebungen();
        initUmgebungList(umgebungen);
        return umgebungen;
    }


    public List<Artifact> listArtifacts() {
        final List<Artifact> artifacts = this.dataService.listArtifacts();
        initArtifactList(artifacts);
        return artifacts;
    }

}