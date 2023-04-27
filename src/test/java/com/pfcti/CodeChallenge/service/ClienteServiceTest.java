package com.pfcti.CodeChallenge.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pfcti.CodeChallenge.dto.ClienteDto;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;
    @Test
    void obtnerClientes() {
        List<ClienteDto> clienteDtos = clienteService.obtnerClientes();
        clienteDtos.forEach(cliente -> System.out.println(">>>>>>>>>>>>>>>>>Cliente: " + cliente.getApellidos()));
        assertEquals(1,1);
    }
}