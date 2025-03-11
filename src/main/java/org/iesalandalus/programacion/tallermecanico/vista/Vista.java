package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.util.Objects;

public class Vista {
    private Controlador controlador;
    private Consola consola;

    public Vista() {
        consola = new Consola();
    }

    public void setControlador(Controlador controlador) {
        Objects.requireNonNull(controlador, "El controlador no puede ser nulo.");
        this.controlador = controlador;
    }

    public void comenzar() {
        Opcion opcion;
        do {
            consola.mostrarMenu();
            opcion = consola.elegirOpcion();
            ejecutar(opcion);
        } while (opcion != Opcion.SALIR);
    }

    public void terminar() {
        System.out.println("Chau!");
    }

    private void ejecutar(Opcion opcion) {

    }

    private void insetarCliente() {
        consola.mostarCabecera("Insertar Cliente");
        Cliente cliente = consola.leerCliente();
        System.out.println("Cliente insertado");
    }

    private void insertarVehiculo() {
        consola.mostarCabecera("Insertar vehiculo");
        Vehiculo vehiculo = consola.leerVehiculo();
        System.out.println("Vehiculo insertado");
    }

    private void insertarRevision() {
        consola.mostarCabecera("Insertar Revision");
        Revision revision = consola.leerRevision();
        System.out.println("Revision insertada");
    }

    private void buscarCliente() {
        consola.mostarCabecera("Buscar Cliente");
        try {
            Cliente cliente = consola.leerClienteDni();
            Cliente encontrado = controlador.buscar(cliente);
            System.out.println("Cliente encontrado: " + encontrado);
        } catch (Exception e) {
            System.out.println("Error al buscar cliente: " + e.getMessage());
        }
    }

    }

    private void buscarVehiculo() {

    }

    private void buscarRevision() {

    }

    private void modificarCliente() {

    }

    private void anadirHoras() {

    }

    private void anadirPrecioMaterial() {

    }

    private void cerrarRevision() {

    }

    private void borrarCliente() {

    }

    private void borrarVehiculo() {

    }

    private void borrarRevision() {

    }

    private void listarClientes() {

    }

    private void listarVehiculos() {

    }

    private void listarRevisiones() {

    }

    private void listarRevisionesCliente() {

    }

    private void listarRevisionesVehiculo() {

    }

    private void salir() {

    }
}
