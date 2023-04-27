package com.pfcti.CodeChallenge.repository;

import com.pfcti.CodeChallenge.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>, JpaSpecificationExecutor<Cliente> {

    @Query(value = "select c from Cliente c where c.identificacion =:cedula")
    Cliente buscarPorCedula(String cedula);

    Cliente findByIdentificacion(String identificacion);


}
