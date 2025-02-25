package org.iesalandalus.programacion.tallermecanico.modelo;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Clientes;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Revisiones;
import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Vehiculos;

import java.time.LocalDate;
import java.util.Objects;

public class Modelo {

    private Clientes clientes;
    private Vehiculos vehiculos;
    private Revisiones revisiones;
    Modelo() {
        comenzar();
    }

    public void comenzar() {
        clientes = new Clientes();
        vehiculos = new Vehiculos();
        revisiones = new Revisiones();
    }

    public void terminar() {
        System.out.println("Modelo terminado.");
    }

    public void insertar(Cliente cliente) throws TallerMecanicoExcepcion {
        clientes.insertar(new Cliente(cliente));
    }

    public void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
        vehiculos.insertar(vehiculo);
    }

    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
        revisiones.insertar(revision);

    }

    public Cliente buscar(Cliente cliente) {
        Objects.requireNonNull(cliente, "No existe ese cliente.");
        return new Cliente(cliente);
    }

    public Vehiculo buscar(Vehiculo vehiculo) {
        Objects.requireNonNull(vehiculo, "El vehículo no existe");
        return new Vehiculo(vehiculo);
    }

    public Revision buscar(Revision revision) {
        Objects.requireNonNull(revision, "No existe esa revisión");
        return new Revision(revision);
    }

    public Cliente modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion {
        clientes.modificar(cliente, nombre, telefono);
        return cliente;
    }

    public Revision anadirHoras(Revision revision, int horas) {
        return revision;
    }

    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) {
        return revision;
    }

    public Revision cerrar(Revision revision, LocalDate fechaFin) {
        return revision;
    }







}
