package com.LAAR.AFP.Bootcamp.controller;

import com.LAAR.AFP.Bootcamp.entities.Client;
import com.LAAR.AFP.Bootcamp.service.IClientService;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/laar-afp")
public class ClientController {

    @Autowired
    private IClientService service;

    @Operation(summary = "Listar todas las solicitudes de vinculación de los clientes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se listaron todos los clientes",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontraron registros",
                    content = @Content) })
    @GetMapping("/findAll")
    public Maybe<ResponseEntity<Flowable<Client>>> list(){
        return Maybe.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.findAll())
        );
    }

    @Operation(summary = "Listar registro de vinculación del clientes por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el cliente registrado por id",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontraron registros del cliente",
                    content = @Content) })
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

    @Operation(summary = "Listar todos las vinculaciones de los clientes por su AFP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el cliente registrado asociado a su AFP",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontraron registros del cliente asociado a su AFP",
                    content = @Content) })
    @GetMapping("/ClientForAFP/{AFP}")
    public List<Client> getClientForAFP(@PathVariable("AFP") String AFP) throws  Exception{
        return service.getClientForAFP(AFP);
    }
    @Operation(summary = "Listar registro de vinculación del clientes por DNI")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el cliente registrado por DNI",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Parametros invalidos",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "No se encontraron registros del cliente por DNI",
                    content = @Content) })
    @GetMapping("/ClientForDNI/{DNI}")
    public List<Client> getClientForDNI(@PathVariable("DNI") Integer DNI) throws  Exception{
        return service.getClientForDNI(DNI);
    }

    @Operation(summary = "Creación del registro de vinculación del cliente para el AFP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se creo el registro de la vinculación del cliente de forma exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Cliente no se pudo registrar de forma correcta",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Parametros invalidos al registrar",
                    content = @Content) })
    @PostMapping("/create")
    public Client create(@RequestBody @Valid Client client)throws Exception{
        return service.create(client);
    }

    @Operation(summary = "Actualización del registro de vinculación del cliente para el AFP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se actualizo el registro de la vinculación del cliente de forma exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Cliente no se pudo actuualizar de forma correcta",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Parametros invalidos al actualizar",
                    content = @Content) })
    @PutMapping("/update/{id}")
    public Client update(@PathVariable("id") Long id, @RequestBody @Valid Client client) throws Exception{
        return service.update(client, id);
    }
    @Operation(summary = "Eliminación del registro de vinculación del cliente por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se elimino el registro de la vinculación del cliente de forma exitosa",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Client.class)) }),
            @ApiResponse(responseCode = "400", description = "Cliente no se pudo eliminar de forma correcta",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Parametros invalidos al eliminar",
                    content = @Content) })
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception{
          service.delete(id);
    }


}
