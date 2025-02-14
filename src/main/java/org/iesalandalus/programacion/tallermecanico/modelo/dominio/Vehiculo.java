package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

public record Vehiculo() {
    private static final String ER_MARCA ;
    private static final String ER_MATRICULA = "[0-9]{4}[B-Z(^EIOU)]{3}";
}
