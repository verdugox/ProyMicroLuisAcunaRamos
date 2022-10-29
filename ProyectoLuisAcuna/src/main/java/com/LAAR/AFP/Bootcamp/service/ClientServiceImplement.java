package com.LAAR.AFP.Bootcamp.service;

import com.LAAR.AFP.Bootcamp.entities.Client;
import com.LAAR.AFP.Bootcamp.repository.IClientRepository;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Optional;


@Service
@Log
public class ClientServiceImplement implements IClientService{

    //SLF4J's Se logea e instancia la clase
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private IClientRepository repository;

    @Override
    public Client create(Client c) throws Exception {
        return repository.save(c);
    }

    @Override
    public List<Client> findAll() throws Exception {
        return repository.findAll();
    }

    @Override
    public Client findId(Integer id) throws Exception {
        Optional<Client> optionalClient = repository.findById(id);
        return optionalClient.isPresent() ? optionalClient.get(): new Client();
    }

    @Override
    public List<Client> getClientForAFP(String AFP) throws Exception {
        return repository.getClientForAFP(AFP);
    }


    @Override
    public List<Client> getClientForDNI(Integer DNI) throws Exception {
        return repository.getClientForDNI(DNI);
    }

    @Override
    public Client update(Client c, Integer id) throws Exception {
        Optional<Client> optionalClient = repository.findById(id);
        if(optionalClient.isPresent()){
            Client clientDB = optionalClient.get();
            clientDB.setFirstName(c.getFirstName());
            clientDB.setLastName(c.getLastName());
            clientDB.setDNI(c.getDNI());
            clientDB.setPhone(c.getPhone());
            clientDB.setEmail(c.getEmail());
            clientDB.setAFP(c.getAFP());
            clientDB.setAmountAvailable(c.getAmountAvailable());
            log.info("Se vinculó correctamente al cliente en el AFP");
            LOGGER.info("No se encuentra registrado el cliente {}");
            return repository.save(clientDB);
        }else {
            log.severe("No se encuentra registrado el cliente {}\"");
            LOGGER.error("No se encuentra registrado el cliente {}");
        }
        return new Client();
    }

    @Override
    public void delete(Integer id) throws Exception {
        log.info("Se eliminó el usuario que tiene por ID: " +id);
        LOGGER.info("Se eliminó el usuario que tiene por ID: " +id);
        repository.deleteById(id);
    }
}
