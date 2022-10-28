package com.LAAR.AFP.Bootcamp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.LAAR.AFP.Bootcamp.entities.Client;

import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

    @Query(value = "SELECT * FROM clients WHERE AFP = :AFP" ,nativeQuery = true)
    public List<Client> getClientForAFP(@Param("AFP") String AFP);

}
