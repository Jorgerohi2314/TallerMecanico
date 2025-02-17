package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Revision {
    private static final float PRECIO_HORA = 30;
    private static final float PRECIO_DIA = 10;
    private static final float PRECIO_MATERIAL = 1.5F;
    static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd-MM-uuuu");
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int horas = 0;
    private float precioMaterial;

    Cliente cliente;
    Vehiculo vehiculo;

    public Revision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        setCliente(cliente);
        setVehiculo(vehiculo);
        setFechaInicio(fechaInicio);
    }

    public Revision(Revision revision) {
        Objects.requireNonNull(revision, "La revisión no puede ser nula.");
        this.setCliente(revision.cliente);
        this.setVehiculo(revision.vehiculo);
        this.setFechaInicio(revision.fechaInicio);
        this.setFechaFin(revision.fechaFin);

    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    private void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    private void setFechaInicio(LocalDate fechaInicio) {
        Objects.requireNonNull(fechaInicio, "La fecha de inicio no puede ser nula.");
        if (LocalDate.now().isBefore(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha actual");
        }
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    private void setFechaFin(LocalDate fechaFin) {
        Objects.requireNonNull(fechaFin, "La fecha de fin no puede ser nula.");
        if (fechaFin.isBefore(fechaInicio) || fechaFin.isEqual(fechaInicio)) {
            throw new IllegalArgumentException("La fecha de fin no puede ser anterior a la fecha de inicio.");
        }
        if (fechaFin.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de fin no puede ser posterior a la fecha actual");
        }
        this.fechaFin = fechaFin;
    }

    public int getHoras() {
        return horas;
    }

    public void anadirHoras(int horas) {
        if (precioMaterial <= 0) {
            throw new IllegalArgumentException("Las horas no puede ser negativas o 0.");
        }
        horas += getHoras();
    }
    public float getPrecioMaterial() {
        return precioMaterial;
    }

    public void anadirPrecioMaterial(float precioMaterial) {
        if (precioMaterial <= 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo o 0.");
        }
     precioMaterial += getPrecioMaterial();
    }

    public boolean estaCerrada() {
        return fechaFin != null;
    }

    public void cerrar(LocalDate fechaFin) throws TallerMecanicoExcepcion{
        if (estaCerrada()) {
            throw new TallerMecanicoExcepcion("La revisión ya está cerrada.");
        }
        setFechaFin(fechaFin);
    }

    public float getPrecio() {
        float precio = (getHoras() * PRECIO_HORA) + (getDias() * PRECIO_DIA) + (getPrecioMaterial()*PRECIO_MATERIAL);
        return precio;
    }

    public float getDias() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Revision revision)) return false;
        return Objects.equals(fechaInicio, revision.fechaInicio) && Objects.equals(cliente, revision.cliente) && Objects.equals(vehiculo, revision.vehiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaInicio, cliente, vehiculo);
    }

    @Override
    public String toString() {
        return String.format("[fechaInicio=%s, fechaFin=%s, horas=%s, precioMaterial=%s, cliente=%s, vehiculo=%s]", fechaInicio, fechaFin, horas, precioMaterial, cliente, vehiculo);
    }
}
