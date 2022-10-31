package com.LAAR.AFP.Bootcamp.controller;

import com.LAAR.AFP.Bootcamp.entities.Client;
import com.LAAR.AFP.Bootcamp.service.IClientService;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.UnsatisfiedDependencyException;

import java.util.List;

@RestController
@RequestMapping("/laar-afp")
public class ClientController {

    @Autowired
    private IClientService service;

    @GetMapping("/findAll")
    ///public List<Client> findAll() throws Exception{
    //    return service.findAll();
    //}
    public Maybe<ResponseEntity<Flowable<Client>>> list(){
        return Maybe.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.findAll())
        );
    }

    @GetMapping("/findId/{id}")
    //public Maybe<Client> findId(@PathVariable("id") Integer id) throws  Exception{
    //    return service.findId(id);
    //}
    public Maybe<ResponseEntity<Client>> get(@PathVariable Long id) throws Exception {
        return service.findById(id).map(p -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @GetMapping("/ClientForAFP/{AFP}")
    public List<Client> getClientForAFP(@PathVariable("AFP") String AFP) throws  Exception{
        return service.getClientForAFP(AFP);
    }

    @GetMapping("/ClientForDNI/{DNI}")
    public List<Client> getClientForDNI(@PathVariable("DNI") Integer DNI) throws  Exception{
        return service.getClientForDNI(DNI);
    }

    @PostMapping("/create")
    public Client create(@RequestBody Client client)throws Exception{
        return service.create(client);
    }

    @PutMapping("/update/{id}")
    public Client update(@PathVariable("id") Long id, @RequestBody Client client) throws Exception{
        return service.update(client, id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception{
          service.delete(id);
    }


}
