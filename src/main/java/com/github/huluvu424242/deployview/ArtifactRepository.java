package com.github.huluvu424242.deployview;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
public interface ArtifactRepository extends PagingAndSortingRepository<Artifact, Long> {
    List<Artifact> findByArtifactId(@Param("id") String id);

    @Query(value = "SELECT u.umgebung FROM  artifacts u GROUP BY u.umgebung")
    List<Umgebung> findAllEnvironments();

}