package com.LAAR.AFP.Bootcamp.controller;

import com.LAAR.AFP.Bootcamp.entities.Client;
import com.LAAR.AFP.Bootcamp.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.UnsatisfiedDependencyException;

import java.util.List;

@RestController
@RequestMapping("/laar-afp")
public class ClientController {

    @Autowired
    private IClientService service;

    @GetMapping("/findAll")
    public List<Client> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/findId/{id}")
    public Client findId(@PathVariable("id") Integer id) throws  Exception{
        return service.findId(id);
    }

    @GetMapping("/ClientForAFP/{AFP}")
    public List<Client> getClientForAFP(@PathVariable("AFP") String AFP) throws  Exception{
        return service.getClientForAFP(AFP);
    }

    @PostMapping("/create")
    public Client create(@RequestBody Client client)throws Exception{
        return service.create(client);
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable("id") Integer id, @RequestBody Client client) throws Exception{
        return service.update(client, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
          service.delete(id);
    }


}
