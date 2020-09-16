package com.github.huluvu424242.deployview.artifact;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JPARepository extends CrudRepository<Artifact, Long> {

    @Query(value = "SELECT new java.lang.String(a.umgebung) FROM  Artifact a GROUP BY a.umgebung")
    List<String> findAllUmgebungen();


    @Query(value = "SELECT a.id FROM  Artifact a WHERE a.umgebung = :umgebung and a.department = :department and a.name = :name")
    long findByKey(@Param("umgebung") String umgebung,
                   @Param("department") String department,
                   @Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE Artifact a WHERE  a.umgebung = :umgebung and a.department = :department and a.name = :name")
    void deleteByKey(@Param("umgebung") String umgebung,
                     @Param("department") String department,
                     @Param("name") String name);

}