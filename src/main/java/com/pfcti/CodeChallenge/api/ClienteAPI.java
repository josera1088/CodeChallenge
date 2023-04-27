package com.pfcti.CodeChallenge.api;

import com.ctc.wstx.evt.WstxEventReader;
import com.pfcti.CodeChallenge.dto.ClienteDto;
import com.pfcti.CodeChallenge.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteAPI {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/all")
    public List<ClienteDto> buscarTodosClientes() {
        return clienteService.obtnerClientes();
    }

    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable String id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.buscarPorCedula(id);
    }
    @PostMapping
    public void guardarCliente(@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.insertatCliente(clienteDto); }

    @PutMapping
    public void actualizarCliente(@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.actualizarCliente(clienteDto); }

    @PutMapping("/{desactivar}")
    public void desactivarCliente(@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.desactivarCliente(clienteDto); }
}
