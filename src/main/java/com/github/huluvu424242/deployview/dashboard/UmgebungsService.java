package com.github.huluvu424242.deployview.dashboard;

import com.github.huluvu424242.deployview.restapi.ArtifactRepository;
import com.github.huluvu424242.deployview.restapi.Umgebung;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmgebungsService {


    @Autowired
    private ArtifactRepository artifactRepository;

    public List<Umgebung> findAll() {
        return this.artifactRepository.findAllUmgebungen();
    }

//    public void add(final Umgebung umgebung) {
//        this.artifactRepository.add(umgebung);
//    }

}