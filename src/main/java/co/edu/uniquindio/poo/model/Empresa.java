package co.edu.uniquindio.poo.model;

import java.util.Collection;
import java.util.LinkedList;

public class Empresa {
    private String nombre;
    private Collection<Vehiculo> listaVehiculos = new LinkedList<>();
    private Collection<Cliente> listaClientes = new LinkedList<>();

    //═════════════════════════════════ <<< CRUD VEHICULO >>> ═════════════════════════════════

    public String crearVehiculo(Vehiculo NuevoVehiculo){
        String mensaje="";
        Vehiculo vehiculoEncontrado = buscarVehiculoPorPlaca(NuevoVehiculo.getPlaca());

        if (vehiculoEncontrado==null) {
            listaVehiculos.add(NuevoVehiculo);
            mensaje = "El vehículo ha sido añadido exitosamente";
        } else {
            mensaje = "El vehículo ya existe";
        }
        return mensaje;
    }

    private Vehiculo buscarVehiculoPorPlaca(String Placa){
        return listaVehiculos.stream().filter(vehiculo->vehiculo.getPlaca().equals(Placa)).findAny().get();
    }

    public String eliminarVehiculo(Vehiculo RemoverVehiculo){
        String mensaje="";
        Vehiculo vehiculoEncontrado = buscarVehiculoPorPlaca(RemoverVehiculo.getPlaca());

        if (vehiculoEncontrado==null) {
            mensaje="El vehículo no existe";
        } else {
            listaVehiculos.remove(vehiculoEncontrado);
            mensaje= "Vehículo eliminado exitosamente";
        }
        return mensaje;
    }

    public String actualizarVehiculo(Vehiculo ActualizarVehiculo){
        String mensaje="";
        Vehiculo vehiculoEncontrado = buscarVehiculoPorPlaca(ActualizarVehiculo.getPlaca());

        if (vehiculoEncontrado==null) {
            mensaje="El vehículo no existe";
        } else {
            listaVehiculos.remove(vehiculoEncontrado);
            listaVehiculos.add(ActualizarVehiculo);
            mensaje= "Vehículo actualizar exitosamente";
        }
        return mensaje;
    }
    
    //═════════════════════════════════ <<< CRUD CLIENTE >>> ═════════════════════════════════

    public String crearCliente(Cliente NuevoCliente){
        String mensaje="";
        Cliente ClienteEncontrado = buscarClientePorPlaca(NuevoCliente.getCedula());
    
        if (ClienteEncontrado==null) {
            listaClientes.add(NuevoCliente);
            mensaje = "El vehículo ha sido añadido exitosamente";
        } else {
            mensaje = "El vehículo ya existe";
        }
        return mensaje;
    }
    
    private Cliente buscarClientePorPlaca(String Placa){
        return listaClientes.stream().filter(Cliente->Cliente.getCedula().equals(Placa)).findAny().get();
    }
    
    public String eliminarCliente(Cliente RemoverCliente){
        String mensaje="";
        Cliente ClienteEncontrado = buscarClientePorPlaca(RemoverCliente.getCedula());
    
        if (ClienteEncontrado==null) {
            mensaje="El vehículo no existe";
        } else {
            listaClientes.remove(ClienteEncontrado);
            mensaje= "Vehículo eliminado exitosamente";
        }
        return mensaje;
    }
    
    public String actualizarCliente(Cliente ActualizarCliente){
        String mensaje="";
        Cliente ClienteEncontrado = buscarClientePorPlaca(ActualizarCliente.getCedula());
    
        if (ClienteEncontrado==null) {
            mensaje="El vehículo no existe";
        } else {
            listaClientes.remove(ClienteEncontrado);
            listaClientes.add(ActualizarCliente);
            mensaje= "Vehículo actualizar exitosamente";
        }
        return mensaje;
    }

    //═════════════════════════════════ <<< Getters and Setters >>> ═════════════════════════════════

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }

    
    
}
