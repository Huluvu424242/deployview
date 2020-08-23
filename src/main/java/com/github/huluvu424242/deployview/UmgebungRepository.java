package com.github.huluvu424242.deployview;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "umgebungen", path = "umgebungen")
public interface UmgebungRepository extends PagingAndSortingRepository<Umgebung, Long> {

//    List<Umgebung> findById(@Param("id") String id);

}