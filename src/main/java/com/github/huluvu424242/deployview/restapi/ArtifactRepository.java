package com.github.huluvu424242.deployview.restapi;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    List<Artifact> findByUmgebung(String umgebung);

    Artifact findById(long id);

}