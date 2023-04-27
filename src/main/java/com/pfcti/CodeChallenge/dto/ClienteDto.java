package com.pfcti.CodeChallenge.dto;

import lombok.Data;

@Data
public class ClienteDto {
    private int id;
    private  String identificacion;
    private  String nombres;
    private  String apellidos;
    private  String paisRecidencia;
    private  String paisNacimiento;
    private  String direccionDomicilio;
    private  String telefonoContacto;
    private  Boolean estado;
}
