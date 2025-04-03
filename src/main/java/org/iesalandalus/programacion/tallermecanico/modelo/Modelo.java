//package org.iesalandalus.programacion.tallermecanico.modelo;
//
//import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Cliente;
//import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Revision;
//import org.iesalandalus.programacion.tallermecanico.modelo.dominio.Vehiculo;
//import org.iesalandalus.programacion.tallermecanico.modelo.negocio.memoria.Clientes;
//import org.iesalandalus.programacion.tallermecanico.modelo.negocio.Revisiones;
//import org.iesalandalus.programacion.tallermecanico.modelo.negocio.memoria.Vehiculos;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class Modelo {
//
//    private Clientes clientes;
//    private Vehiculos vehiculos;
//    private Revisiones revisiones;
//    Modelo() {
//        comenzar();
//    }
//
//    public void comenzar() {
//        clientes = new Clientes();
//        vehiculos = new Vehiculos();
//        revisiones = new Revisiones();
//    }
//
//    public void terminar() {
//        System.out.println("Modelo terminado.");
//    }
//
//    public void insertar(Cliente cliente) throws TallerMecanicoExcepcion {
//        clientes.insertar(new Cliente(cliente));
//    }
//
//    public void insertar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
//        vehiculos.insertar(vehiculo);
//    }
//
//    public void insertar(Revision revision) throws TallerMecanicoExcepcion {
//        Cliente cliente = clientes.buscar(revision.getCliente());
//        Vehiculo vehiculo = vehiculos.buscar(revision.getVehiculo());
//        if (cliente != null && vehiculo != null) {
//            revisiones.insertar(new Revision(cliente, vehiculo, revision.getFechaFin()));
//        }
//
//    }
//
//    public Cliente buscar(Cliente cliente) {
//        Objects.requireNonNull(cliente, "No existe ese cliente.");
//        return new Cliente(clientes.buscar(cliente));
//    }
//
//    public Vehiculo buscar(Vehiculo vehiculo) {
//        Objects.requireNonNull(vehiculo, "El vehículo no existe");
//        return vehiculos.buscar(vehiculo);
//
//    }
//
//    public Revision buscar(Revision revision) {
//        Objects.requireNonNull(revision, "No existe esa revisión");
//        return new Revision(revisiones.buscar(revision));
//    }
//
//    public Cliente modificar(Cliente cliente, String nombre, String telefono) throws TallerMecanicoExcepcion {
//        clientes.modificar(cliente, nombre, telefono);
//        return cliente;
//    }
//
//    public Revision anadirHoras(Revision revision, int horas) throws TallerMecanicoExcepcion {
//        revisiones.anadirHoras(revision, horas);
//        return revision;
//    }
//
//    public Revision anadirPrecioMaterial(Revision revision, float precioMaterial) throws TallerMecanicoExcepcion {
//        revisiones.anadirPrecioMaterial(revision, precioMaterial);
//        return revision;
//    }
//
//    public Revision cerrar(Revision revision, LocalDate fechaFin) throws TallerMecanicoExcepcion {
//        revisiones.cerrar(revision, fechaFin);
//        return revision;
//    }
//
//    public void borrar(Cliente cliente) throws TallerMecanicoExcepcion {
//        List<Revision> revisionesCliente = revisiones.get(cliente);
//        for (Revision revision : revisionesCliente) {
//            revisiones.borrar(revision);
//            clientes.borrar(cliente);
//        }
//    }
//
//    public void borrar(Vehiculo vehiculo) throws TallerMecanicoExcepcion {
//        List<Revision> revisionesVehiculo = revisiones.get(vehiculo);
//        for (Revision revision : revisionesVehiculo) {
//            revisiones.borrar(revision);
//            vehiculos.borrar(vehiculo);
//        }
//    }
//
//    public void borrar(Revision revision) throws TallerMecanicoExcepcion {
//        revisiones.borrar(revision);
//    }
//
//    public List<Cliente> getClientes() {
//        List<Cliente> coleccionClientes = clientes.get();
//        List<Cliente> nuevaListaClientes = new ArrayList<>();
//        for (Cliente cliente : coleccionClientes) {
//            nuevaListaClientes.add(new Cliente(cliente));
//        }
//        return nuevaListaClientes;
//    }
//
//    public List<Vehiculo> getVehiculos() {
//        List<Vehiculo> coleccionVehiculos = vehiculos.get();
//        return  new ArrayList<>(coleccionVehiculos);
//    }
//
//    public List<Revision> getRevisiones() {
//        List<Revision> coleccionRevisiones = revisiones.get();
//        List<Revision> nuevaListaRevisiones = new ArrayList<>();
//        for (Revision revision : coleccionRevisiones) {
//            nuevaListaRevisiones.add(new Revision(revision));
//        }
//        return nuevaListaRevisiones;
//    }
//
//    public List<Revision> getRevisiones(Cliente cliente) {
//        List<Revision> coleccionRevisiones = revisiones.get(cliente);
//        List<Revision> revisionesParaCliente = new ArrayList<>();
//        for (Revision revision : coleccionRevisiones) {
//            revisionesParaCliente.add(new Revision(revision));
//        }
//        return revisionesParaCliente;
//    }
//
//    public List<Revision> getRevisiones(Vehiculo vehiculo) {
//        List<Revision> coleccionRevisiones = revisiones.get(vehiculo);
//        List<Revision> revisionesParaVehiculo = new ArrayList<>();
//        for (Revision revision : coleccionRevisiones) {
//            revisionesParaVehiculo.add(new Revision(revision));
//        }
//        return revisionesParaVehiculo;
//    }
//
//
//}
