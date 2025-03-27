package org.iesalandalus.programacion.tallermecanico.modelo.dominio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;

import java.time.LocalDate;

public class Mecanico extends Trabajo {

    private static final float FACTOR_HORA = 30F;
    private static final float FACTOR_PRECIO_MATERIAL = 1.5F;
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
            throw new TallerMecanicoExcepcion("No se puede añadir precio del material, ya que el trabajo mecánico está cerrado.");
        }
        precioMaterial += cantidad;
    }

    public float getPrecioEspecifico() {
        return estaCerrado() ? (FACTOR_HORA * getHoras() + FACTOR_PRECIO_MATERIAL * precioMaterial) : 0;
    }

    @Override
    public String toString() {
        if (!estaCerrado()) {
            return String.format("Mecánico -> %s - %s (%s - ): %s horas, %.2f € en material", cliente, vehiculo, fechaInicio.format(FORMATO_FECHA),  horas, precioMaterial);
        } else {
            return String.format("Mecánico -> %s - %s (%s - %s): %s horas, %.2f € en material, %.2f € total", cliente, vehiculo, fechaInicio.format(FORMATO_FECHA),fechaFin.format((FORMATO_FECHA)), horas, precioMaterial, getPrecio());

        }
    }
}
