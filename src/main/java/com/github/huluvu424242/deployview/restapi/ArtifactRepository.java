package com.github.huluvu424242.deployview.restapi;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

//@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
public interface ArtifactRepository extends CrudRepository<Artifact, Long> {
//
//    @Query(value = "SELECT a.id FROM  Artifact a WHERE a.umgebung = :umgebung and a.departmentId = :departmentId and a.name = :name")
//    long findByKey(@Param("umgebung") Umgebung umgebung,
//                       @Param("departmentId") String departmentId,
//                       @Param("name") String name);

//    @Query(value = "SELECT a.umgebung FROM  Artifact a GROUP BY a.umgebung")
//    List<Umgebung> findAllUmgebungen();


    List<Artifact> findByUmgebung(String umgebung);

    Artifact findById(long id);

}