package com.github.huluvu424242.deployview;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
public interface ArtifactRepository extends PagingAndSortingRepository<Artifact, Long> {
    List<Artifact> findByArtifactId(@Param("artifactId") String name);
}