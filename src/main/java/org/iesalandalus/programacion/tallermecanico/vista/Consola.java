package org.iesalandalus.programacion.tallermecanico.vista;

import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        Opcion opcion = null;
        do {
            try {
                opcion = Opcion.get(leerEntero("\nElige una opción: "));
            } catch (IllegalArgumentException e) {
                System.out.printf("Error: %s%n", e.getMessage());
            }
        } while (opcion == null);
        return opcion;
    }

    private int leerEntero(String mensaje) {
        System.out.println(mensaje);
        return Entrada.entero();
    }

    private float leerReal(String mensaje) {
        System.out.println(mensaje);
        return Entrada.real();
    }

    private String leerCadena(String mensaje) {
        System.out.println(mensaje);
        return Entrada.cadena() ;
    }

    private LocalDate leerFecha(String mensaje) {
        LocalDate fecha;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(CADENA_FORMATO_FECHA);
        mensaje = String.format("%s (%s)", mensaje, CADENA_FORMATO_FECHA);
        try {
            fecha = LocalDate.parse(leerCadena(mensaje), formatoFecha);
        } catch (DateTimeParseException e) {
            fecha = null;
        }
        return fecha;
    }

    public Cliente leerCliente() {
        String nombre = leerCadena("Introduce el nombre");
        String dni = leerCadena("Introduce el DNI.");
        String telefono = leerCadena("Introduce el telefono");
        return new Cliente(nombre, dni, telefono);
    }

    public Cliente leerClienteDni() {
        return Cliente.get(leerCadena("Introduce el dni que quieres leer"));
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
        return Vehiculo.get(leerCadena("Introduce la matricula del vehículo que te interesa"));
    }

    public Revision leerRevision() {
        LocalDate fechaInicio = leerFecha("Introduce la fecha de inicio.");
        Cliente cliente = leerClienteDni();
        Vehiculo vehiculo = leerVehiculoMatricula();
        return new Revision(cliente, vehiculo, fechaInicio);
    }

    public int leerHoras() {
        return leerEntero("Introduce el numero de horas");
    }

    public float leerPrecioMaterial() {
        return leerReal("Introduce el precio del material");
    }

    public LocalDate leerFechaCierre() {
        return leerFecha("Introduce la fecha de cierre");
    }
}
