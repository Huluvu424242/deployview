package com.github.huluvu424242.deployview.restapi;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {

    @Query(value = "SELECT a.id FROM  Artifact a WHERE a.umgebung = :umgebung and a.department = :department and a.name = :name")
    long findByKey(@Param("umgebung") String umgebung,
                   @Param("department") String department,
                   @Param("name") String name);

    @Query(value = "SELECT a.umgebung FROM  Artifact a GROUP BY a.umgebung")
    List<Umgebung> findAllUmgebungen();

}