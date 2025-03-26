package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.time.LocalDate;

public class Mecanico extends Trabajo {

    private static final float FACTOR_HORA = 1.5F;
    private static final float FACTOR_PRECIO_MATERIAL = 3F;
    private float precioMaterial;

    public Mecanico(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        super(cliente, vehiculo, fechaInicio);
    }

    public Mecanico(Mecanico mecanico) {
        super(mecanico);
        precioMaterial = mecanico.precioMaterial;
    }

    public float getPrecioMaterial() {
        return precioMaterial;
    }

    public void anadirPrecioMaterial(float cantidad) throws TallerMecanicoExcepcion {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("El precio del material a añadir debe ser mayor que cero.");
        }
        if (estaCerrado()) {
            throw new TallerMecanicoExcepcion("No se puede añadir precio del material, ya que la revisión está cerrada.");
        }
        precioMaterial += cantidad;
    }

    public float getPrecioEspecifico() {
        return estaCerrado() ? (FACTOR_HORA * getHoras() + FACTOR_PRECIO_MATERIAL * precioMaterial) : 0;
    }

    @Override
    public String toString() {
        return String.format("[precioMaterial=%s, cliente=%s, vehiculo=%s, fechaInicio=%s, fechaFin=%s, horas=%s]", precioMaterial, cliente, vehiculo, fechaInicio, fechaFin, horas);
    }
}
