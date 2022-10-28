package com.LAAR.AFP.Bootcamp.service;

import com.LAAR.AFP.Bootcamp.entities.Client;

import java.util.List;

public interface IClientService {

    Client create(Client c) throws Exception;

    List<Client> findAll() throws Exception;

    Client findId(Integer id) throws Exception;

    List<Client> getClientForAFP(String AFP) throws Exception;

    Client update(Client c, Integer id) throws Exception;

    void delete(Integer id) throws Exception;

}
