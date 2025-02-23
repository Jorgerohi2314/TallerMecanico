package org.iesalandalus.programacion.tallermecanico.modelo.negocio;

import org.iesalandalus.programacion.tallermecanico.modelo.TallerMecanicoExcepcion;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Revisiones {

    private List<Revision> listaRevisiones;

    public Revisiones() {
        listaRevisiones = new ArrayList<>();
    }

    public List<Revision> get() {
        return new ArrayList<>(listaRevisiones);
    }

    public List<Revision> get(Cliente cliente) {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo.");
        List<Revision> revisionesDeCliente = new ArrayList<>();
        for (Revision revision : listaRevisiones) {
            if (revision.getCliente().equals(cliente)) {
                revisionesDeCliente.add(revision);
            }
        }
        return revisionesDeCliente;
    }

    public List<Revision> get(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "El vehículo no puede ser nulo.");
        List<Revision> revisionesDeVehiculo = new ArrayList<>();
        for (Revision revision : listaRevisiones) {
            if (revision.getVehiculo().equals(vehiculo)) {
                revisionesDeVehiculo.add(revision);
            }
        }
        return revisionesDeVehiculo;
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No se puede insertar una revisión nula.");

        listaRevisiones.add(revision);
    }

    private void comprobarRevision(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio) {
        Objects.requireNonNull(cliente, "El cliente no puede ser nulo.");
        Objects.requireNonNull(vehiculo, "El vehículo no puede ser nulo.");
        Objects.requireNonNull(fechaInicio, "La fecha de revisión no puede ser nula.");
    }

    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        if (horas <= 0) {
            throw new TallerMecanicoExcepcion("Debes añadir alguna hora.");
        }
        if (!listaRevisiones.contains(revision)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        revision.anadirHoras(horas);

        return revision;
    }

    private Revision getRevision(Revision revision) {
        return revision;
    }

    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        if (precioMaterial <= 0) {
            throw new TallerMecanicoExcepcion("Debes añadir precio.");
        }
        if (!listaRevisiones.contains(revision)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        revision.anadirPrecioMaterial(precioMaterial);

        return revision;
    }

    public Revision cerrar(Revision revision, LocalDate fechaFin) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No puedo operar sobre una revisión nula.");
        if (revision.estaCerrada()) {
            throw new TallerMecanicoExcepcion("La revision ya esta cerrada");
        }
        if (!listaRevisiones.contains(revision)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        revision.cerrar(fechaFin);

        return revision;
    }

    public Revision buscar(Revision revision) {
        Objects.requireNonNull(revision, "No se puede buscar una revisión nula.");
        return listaRevisiones.contains(revision) ? revision : null;
    }

    public void borrar(Revision revision) throws TallerMecanicoExcepcion {
        Objects.requireNonNull(revision, "No se puede borrar una revisión nula.");
        if (!listaRevisiones.contains(revision)) {
            throw new TallerMecanicoExcepcion("No existe ninguna revisión igual.");
        }
        listaRevisiones.remove(revision);

    }

}
