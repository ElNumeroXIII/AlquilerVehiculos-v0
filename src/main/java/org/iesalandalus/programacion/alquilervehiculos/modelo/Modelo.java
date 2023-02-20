package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {

	private Alquileres alquileres;
	private Clientes clientes;
	private Turismos turismos;
	
	
	
	
	public Modelo() {
		
    }
    public void comenzar() {
    	
     alquileres = new Alquileres();
     clientes = new Clientes();
     turismos = new Turismos();
     
    }
    public void terminar() {
    	System.out.printf("La ejecución ha finalizado");
    }
    public void insertar(Cliente cliente) throws OperationNotSupportedException {
    	Cliente clienteNuevo = new Cliente(cliente);
    	clientes.insertar(clienteNuevo);
    }
    public void insertar (Turismo turismo) throws OperationNotSupportedException {
    	Turismo turismoNuevo = new Turismo(turismo);
    	turismos.insertar(turismoNuevo);
    }
    
    public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
    	Alquiler alquilerNuevo = new Alquiler(alquiler);
    	alquileres.insertar(alquilerNuevo);
    }
    
    public Cliente buscar (Cliente cliente) {
    	Cliente clienteNuevo = new Cliente(cliente);
		return clientes.buscar(clienteNuevo);
    	
    }
    public Turismo buscar (Turismo turismo) {
    	Turismo turismoNuevo = new Turismo(turismo);
    	return turismos.buscar(turismoNuevo);
    	
    	
    }
    public Alquiler buscar (Alquiler alquiler) {
    	Alquiler alquilerNuevo = new Alquiler(alquiler);
    	return alquileres.buscar(alquilerNuevo);
    	
    	
    }
    
    public void modificar (Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
    	clientes.modificar(cliente, nombre, telefono);
    }
    
    public void devolver(Alquiler alquiler,LocalDate fechaDevolucion) throws OperationNotSupportedException {
    	alquileres.devolver(alquiler, fechaDevolucion);
    }
    
    public void borrar (Cliente cliente) throws OperationNotSupportedException {
    	for(Alquiler alquiler:alquileres.get(cliente))
    		alquileres.borrar(alquiler);
    	clientes.borrar(cliente);
    }
    
    public void borrar (Turismo turismo) throws OperationNotSupportedException {
    	for(Alquiler alquiler:alquileres.get(turismo))
    		alquileres.borrar(alquiler);
    	turismos.borrar(turismo);
    }
    public void borrar (Alquiler alquiler) throws OperationNotSupportedException {
    	alquileres.borrar(alquiler);
    }
    
    public List<Cliente> getClientes(){
    	return clientes.get();
    }
    public List<Turismo> getTurismos(){
    	return turismos.get();
    }
    public List<Alquiler> getAlquileres(){
    	return alquileres.get();
    }
    
    public List<Alquiler> getAlquileres(Cliente cliente){
    	List<Alquiler> listaNueva = alquileres.get(cliente);
    return listaNueva;
    }
    public List<Alquiler> getAlquileres(Turismo turismo){
    	List<Alquiler> listaNueva = alquileres.get(turismo);
    	return listaNueva;
    }
    
}
	
	

