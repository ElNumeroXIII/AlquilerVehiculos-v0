//Joaquin Francisco Sanchez Capel

package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	private final String PATRON_FECHA = "dd/MM/yyyy";
	private final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public void mostrarCabecera(String mensaje) {
		System.out.printf("%s", mensaje);
		StringBuilder otroString = new StringBuilder();
		for (int i = 0; i < mensaje.length() - 1; i++) {
			otroString.append("-");
		}
		System.out.printf("%s", otroString);

	}

	public void mostrarMenu() {
		mostrarCabecera("Menu de manejo del sistema de alquiler");
		System.out.printf("Opciones:");
		for(Opcion opcion: Opcion.values()) {
			System.out.printf("%s%n",opcion.toString());
		}
	}

	private String leerCadena(String mensaje) {
		System.out.printf("%s%n", mensaje);
		return Entrada.cadena();
	}

	private Integer leerEntero(String mensaje) {
		System.out.printf("%s%n", mensaje);
		return Entrada.entero();
	}

	private LocalDate leerFecha(String mensaje) {
		System.out.printf("%s", mensaje);
        LocalDate fecha = null;
        
        if(LocalDate.parse(Entrada.cadena(), FORMATO_FECHA)==null)
        	throw new IllegalArgumentException();

        return fecha;
	}

	public Opcion elegirOpcion() {
		return Opcion.values()[leerEntero("Elige opcion")];
	}

	public Cliente leerCliente() {
			Cliente clienteDevolver = new Cliente(leerCadena("Nombre del cliente"),leerCadena("DNI del cliente"), leerCadena("telefono del cliente"));
		return clienteDevolver;	
	}

	public Cliente leerClienteDni() {
		Cliente clienteDevolver = new Cliente(Cliente.getClienteConDni(leerCadena("DNI de cliente")));
		return clienteDevolver;
	}

	public String leerNombre() {
		return	leerCadena("Dame el nombre");
	}

	public String leerTelefono() {
		return	leerCadena("Dame el numero");
	}

	public Turismo leerTurismo() {
		Turismo turismo = new Turismo(leerCadena("Marca"),leerCadena("Modelo"),leerEntero("Cilindrada"), leerCadena("Matricula"));
		return turismo;
	}

	public Turismo leerTurismomatricula() {
		Turismo turismo = new Turismo(Turismo.getTurismoConMatricula(leerCadena("matricula")));
		return turismo;
	}

	public Alquiler leerAlquiler() {
		Alquiler alquiler = new Alquiler(leerCliente(),leerTurismo(),leerFecha("Fecha Alquiler"));
		return alquiler;
	}

	public LocalDate leerFechaDevolucion() {
		return leerFecha("Fecha Devolucion");
	}
}
