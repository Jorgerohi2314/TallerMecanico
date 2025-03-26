package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Revision extends Trabajo {
    private static final float FACTOR_HORA = 35F;



    public Revision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        super(cliente, vehiculo, fechaInicio);
    }

    public Revision(Revision revision) {
        super(revision);
    }

    public float getPrecioEspecifico() {
        return estaCerrado() ? (getHoras() * FACTOR_HORA) : 0;
    }

    @Override
    public String toString() {
        return String.format("[cliente=%s, vehiculo=%s, fechaInicio=%s, fechaFin=%s, horas=%s]", cliente, vehiculo, fechaInicio, fechaFin, horas);
    }
}
