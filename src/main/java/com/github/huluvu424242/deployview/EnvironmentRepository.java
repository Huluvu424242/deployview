//package com.github.huluvu424242.deployview;
//
//import java.util.List;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//
//@RepositoryRestResource(collectionResourceRel = "artifacts", path = "artifacts")
//public interface EnvironmentRepository extends PagingAndSortingRepository<Environment, Long> {
//
//    @Query(value = "SELECT u.environment FROM  artifacts u GROUP BY u.environment")
//    List<Environment> findAllEnvironments();
//
//}