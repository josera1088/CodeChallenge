package com.pfcti.CodeChallenge.service;

import com.pfcti.CodeChallenge.model.Cliente;
import com.pfcti.CodeChallenge.repository.ClienteRepository;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.pfcti.CodeChallenge.dto.ClienteDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;
    public List<ClienteDto> obtnerClientes() {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });

        return clienteDtos;
    }

    public ClienteDto buscarPorCedula(String cedula){

        ClienteDto clienteDto = new ClienteDto();
        Cliente cliente = clienteRepository.findByIdentificacion(cedula);
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;

    }


    public void insertatCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombres(clienteDto.getNombres());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setPaisRecidencia(clienteDto.getPaisRecidencia());
        cliente.setPaisNacimiento(clienteDto.getPaisNacimiento());
        cliente.setDireccionDomicilio(clienteDto.getDireccionDomicilio());
        cliente.setTelefonoContacto(clienteDto.getTelefonoContacto());
        clienteRepository.save(cliente);
    }

    public void actualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> {
                            throw new RuntimeException("NO Existe el cliente");
                        }
                );
        cliente.setId(clienteDto.getId());
        cliente.setPaisRecidencia(clienteDto.getPaisRecidencia());
        cliente.setDireccionDomicilio(clienteDto.getDireccionDomicilio());
        cliente.setTelefonoContacto(clienteDto.getTelefonoContacto());

        clienteRepository.save(cliente);
    }


    public void desactivarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> {
                            throw new RuntimeException("NO Existe el cliente");
                        }
                );
        cliente.setId(clienteDto.getId());
        cliente.setEstado(false);

        clienteRepository.save(cliente);
    }

    private ClienteDto fromClienteToClienteDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }


}
