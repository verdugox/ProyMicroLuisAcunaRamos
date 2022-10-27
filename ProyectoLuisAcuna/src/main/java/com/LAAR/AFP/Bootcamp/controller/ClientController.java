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

    @GetMapping()
    public List<Client> findAll() throws Exception{
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Client findId(@PathVariable("id") Integer id) throws  Exception{
        return service.findId(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client)throws Exception{
        return service.create(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable("id") Integer id, @RequestBody Client client) throws Exception{
        return service.update(client, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }


}
