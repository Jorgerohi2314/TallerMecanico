package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import java.util.Objects;

public record Vehiculo(String marca, String modelo, String matricula) {
    private static final String ER_MARCA = "[A-ZÁÉÍÓÚÜ]+[a-záéíóúü]*[ |-]?[A-ZÁÉÍÓÚÜ]?[a-záéíóúü]*" ;
    private static final String ER_MATRICULA = "\\d{4}[B-Z(^EIOU)]{3}";


    public Vehiculo {
        validadMarca(marca);
        validarMatricula(matricula);
        validarModelo(modelo);
    }

    private void validadMarca(String marca) {
        Objects.requireNonNull(marca, "La marca no puede ser nula.");
        if (!marca.matches(ER_MARCA)) {
            throw new IllegalArgumentException("La marca no tiene un formato válido.");
        }
    }

    private void validarModelo(String modelo) {
        Objects.requireNonNull(modelo, "El modelo no puede ser nulo.");
        if (modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar en blanco.");
        }
    }

    private void validarMatricula(String matricula) {
        Objects.requireNonNull(matricula, "La matrícula no puede ser nula.");
        if (!matricula.matches(ER_MATRICULA)) {
            throw new IllegalArgumentException("La matrícula no tiene un formato válido.");
        }
    }

    public static Vehiculo get(String matricula) {
        Objects.requireNonNull(matricula, "La matrícula no puede ser nula.");
        return new Vehiculo("Audi", "A4", matricula);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo vehiculo)) return false;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(matricula);
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", marca, modelo, matricula);
    }
}
