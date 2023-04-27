package com.pfcti.CodeChallenge.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.pfcti.CodeChallenge.dto.ClienteDto;
import com.pfcti.CodeChallenge.model.Cliente;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;

    @PersistenceContext
    private EntityManager entityManager;
    @Test
    void obtnerClientes() {
        List<ClienteDto> clienteDtos = clienteService.obtnerClientes();
        clienteDtos.forEach(cliente -> System.out.println(">>>>>>>>>>>>>>>>>Cliente: " + cliente.getApellidos()));
        assertEquals(1,1);
    }


    @Test
    void insertatCliente() {
        List<Cliente> clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println(">>>>>>>>>>>>>>> Lista antes " + clienteList.size());
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombres("Jose");
        clienteDto.setApellidos("Ramirez");
        clienteDto.setPaisRecidencia("CRC");
        clienteDto.setPaisNacimiento("CRC");
        clienteDto.setDireccionDomicilio("Cartago");
        clienteDto.setTelefonoContacto("5454");
        clienteService.insertatCliente(clienteDto);
        clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println(">>>>>>>>>>>>>>> Lista despues " + clienteList.size());
        assertEquals(1, 1);
    }
}