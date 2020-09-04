package com.github.huluvu424242.deployview.restapi;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    List<Artifact> findByUmgebung(String umgebung);

    Artifact findById(long id);

}