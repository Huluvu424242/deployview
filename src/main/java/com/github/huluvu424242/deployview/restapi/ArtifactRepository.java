package com.github.huluvu424242.deployview.restapi;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
public interface ArtifactRepository extends PagingAndSortingRepository<Artifact, Long> {
    List<Artifact> findByName(@Param("name") String name);

    @Query(value = "SELECT u.umgebung FROM  artifact u GROUP BY u.umgebung")
    List<Umgebung> findAllUmgebungen();

}