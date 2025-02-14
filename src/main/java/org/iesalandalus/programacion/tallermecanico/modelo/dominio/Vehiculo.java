package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

public record Vehiculo() {
    private static final String ER_MARCA = "[A-ZÁÉÍÓÚÜ]*[a-záéíóúü]*[ |-]?[A-ZAÉÍÓÚÜ]*[a-záéíóúü]*" ;
    private static final String ER_MATRICULA = "[0-9]{4}[B-Z(^EIOU)]{3}";

    private String marca;
    private String modelo;
    private String matricula;

    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
    }

    private void validadMarca(String marca) {

    }

    private void validarModelo(String modelo) {

    }

    private void validarMatricula(String matricula) {

    }
}
