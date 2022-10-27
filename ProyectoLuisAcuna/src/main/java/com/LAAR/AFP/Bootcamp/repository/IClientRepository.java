package com.LAAR.AFP.Bootcamp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LAAR.AFP.Bootcamp.entities.Client;
@Repository
public interface IClientRepository extends JpaRepository<Client, Integer> {

}
