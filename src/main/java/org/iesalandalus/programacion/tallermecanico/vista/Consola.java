package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;

import java.time.LocalDate;
import java.util.Objects;

public class Consola {

    private static final String CADENA_FORMATO_FECHA = "dd/MM/yyyy";


    private Consola() {}

    public void mostarCabecera(String mensaje) {
        System.out.println(mensaje);
        System.out.println("-".repeat(mensaje.length()));
    }

    public void mostrarMenu() {
        mostarCabecera("Taller mecanico: Gestion de Clientes, vehiculos y revisiones.");
        for (Opcion opcion : Opcion.values()) {
            System.out.println(opcion);
        }
    }

    public Opcion elegirOpcion() {
        int numeroOpcion;
        do {
            numeroOpcion = leerEntero("Elige una opción: ");
        } while (!Opcion.esValida(numeroOpcion));
        return Opcion.get(numeroOpcion);

    }

    private int leerEntero(String mensaje) {
        Objects.requireNonNull(mensaje, "El mensaje no puede ser nulo");
        return 1;
    }

    private float leerReal(String mensaje) {
        Objects.requireNonNull(mensaje, "El mensaje no puede ser entero");
        return 1f;
    }

    private String leerCadena(String mensaje) {
        Objects.requireNonNull(mensaje, "El mensaje no puede ser entero");
        return mensaje;
    }

    private LocalDate leerFecha(String mensaje) {
        Objects.requireNonNull(mensaje, "El mensaje no puede ser entero");
        return LocalDate.now();
    }

    public Cliente leerCliente() {
        String nombre = leerCadena("Introduce el nombre");
        String dni = leerCadena("Introduce el DNI.");
        String telefono = leerCadena("Introduce el telefono");
        return new Cliente(nombre, dni, telefono);
    }

    public Cliente leerClienteDni() {
        String dni = leerCadena("Introduce el dni que quieres leer");
        return Cliente.get(dni);
    }

    public String leerNuevoNombre() {
        return leerCadena("Introduce el nuevo Nombre");
    }

    public String leerNuevoTelefono() {
        return leerCadena("Introduce en nuevo telefono.");
    }

    public Vehiculo leerVehiculo() {
        String marca = leerCadena("Introduce la marca");
        String modelo = leerCadena("Introduce el modelo");
        String matricula = leerCadena("Introduce la matricula");
        return new Vehiculo(marca, modelo, matricula);
    }

    public Vehiculo leerVehiculoMatricula() {
        String matricula = leerCadena("Introduce la matricula del vehículo que te interesa");
        return Vehiculo.get(matricula);
    }

    public Revision leerRevision() {
        LocalDate fechaInicio = leerFecha("Introduce la fecha de inicio.");
        Cliente cliente = leerClienteDni();
        Vehiculo vehiculo = leerVehiculoMatricula();
        return new Revision(cliente, vehiculo, fechaInicio);
    }

    public int leerHoras() {
        return 1;
    }

    public float leerPrecioMaterial() {
        return 1f;
    }

    public LocalDate leerFecha() {
        return LocalDate.now();
    }

}
