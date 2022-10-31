package com.LAAR.AFP.Bootcamp.service;

import com.LAAR.AFP.Bootcamp.entities.Client;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IClientService {

    Client create(Client c) throws Exception;

    //List<Client> findAll() throws Exception;
    public Flowable<Client> findAll();
    public Maybe<Client> findById(Long id);
    public Maybe<Client> findByIdError(Long id);

    List<Client> getClientForAFP(String AFP) throws Exception;
    List<Client> getClientForDNI(Integer DNI) throws Exception;

    Client update(Client c, Long id) throws Exception;

    void delete(Long id) throws Exception;

}
