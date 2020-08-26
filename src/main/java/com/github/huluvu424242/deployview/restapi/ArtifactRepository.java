package com.github.huluvu424242.deployview.restapi;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
public interface ArtifactRepository extends PagingAndSortingRepository<Artifact, Long> {

    @Query(value = "SELECT a.id FROM  artifact a WHERE a.umgebung = :umgebung and a.departmentId = :departmentId and a.name = :name")
    long findByKey(@Param("umgebung") Umgebung umgebung,
                       @Param("departmentId") String departmentId,
                       @Param("name") String name);

    @Query(value = "SELECT a.umgebung FROM  artifact a GROUP BY a.umgebung")
    List<Umgebung> findAllUmgebungen();

}