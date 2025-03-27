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
        if (!estaCerrado()) {
            return String.format("Revisión -> %s - %s (%s - ): %s horas", cliente, vehiculo, fechaInicio.format(FORMATO_FECHA), horas);
        } else {
            return String.format("Revisión -> %s - %s (%s - %s): %s horas, %.2f € total", cliente, vehiculo, fechaInicio.format(FORMATO_FECHA),fechaFin.format((FORMATO_FECHA)), horas,getPrecio());
        }
    }
}
