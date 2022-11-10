package com.LAAR.AFP.Bootcamp.business;

import com.LAAR.AFP.Bootcamp.entities.Client;
import com.LAAR.AFP.Bootcamp.repository.IClientRepository;
import com.LAAR.AFP.Bootcamp.service.ClientServiceImplement;
import com.LAAR.AFP.Bootcamp.util.TestUtil;
import io.reactivex.observers.TestObserver;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceImplMockTest {

    @Mock
    IClientRepository clientRepository;

    @InjectMocks
    ClientServiceImplement clientService;

    Client client;

    Client clientSave;

    @BeforeEach
    void setUp() throws IOException {
        Client clientPrueba = TestUtil.readFile("client-ok","mocks", Client.class);

        clientSave = new Client();
        clientSave.setFirstName(clientPrueba.getFirstName());
        clientSave.setLastName(clientPrueba.getLastName());
        clientSave.setDNI(clientPrueba.getDNI());
        clientSave.setPhone(clientPrueba.getPhone());
        clientSave.setEmail(clientPrueba.getEmail());
        clientSave.setAFP(clientPrueba.getAFP());
        clientSave.setAmountAvailable(clientPrueba.getAmountAvailable());

    }

    @DisplayName("Retorna un cliente sin nombre")
    @Test
    public void whenClientIsOk() throws Exception {
        Client client = TestUtil.readFile("client-search-id-null","mocks", Client.class);

        when(clientRepository.findById(any()))
                .thenReturn(Optional.of(client));

        TestObserver<Client> test = clientService.findById(any()).test();

        test.assertNoErrors();
        //test.assertValue(p -> p.getFirstName() == null);
        //test.assertValue(x -> x.getPrice() == 200.00);
        test.assertValues(client);

        Mockito.verify(clientRepository,Mockito.times(1)).findById(any());
    }

    @Test
    public void whenClientNotFound(){
        when(clientRepository.findById(any()))
                .thenReturn(Optional.empty());

        TestObserver<Client> test = clientService.findByIdError(any()).test();
        test.assertNotComplete();
        test.assertError(Exception.class);
    }

    @Test
    public void anemicTest() throws IOException {
        Client client = TestUtil.readFile("client-search-id-null","mocks", Client.class);

        Integer DNITest = client.getDNI();

        Assertions.assertEquals(46285513, DNITest);
    }

    @DisplayName("Prueba de una registro de cliente")
    @Test
    public void save() throws Exception {
        when(clientRepository.save(any(Client.class))).thenReturn(clientSave);
        assertNotNull(clientService.create(new Client()));
    }

}
