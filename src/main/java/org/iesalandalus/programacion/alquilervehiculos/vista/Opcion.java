package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	
	
	SALIR("Salir"),
	INSERTAR_CLIENTE("Insertar Cliente"),
	INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"),
	BUSCAR_CLIENTE("Buscar cliente"),
	MODIFICAR_CLIENTE("Modificar cliente"),
	DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"),
	BORRAR_TURISMO("Borrar turismo"),
	BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"),
	LISTAR_TURISMOS("Listar turismos"),
	LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres turismo");
	
	 private String texto="";
	
	private Opcion(String string) {
		texto = string;
	}
	private boolean esOrdinalValido(int ordinal) {
		boolean returnal=false;
		if (ordinal<0 || ordinal>values().length) {
			returnal=false;
			throw new IllegalArgumentException();
		}
		else
			returnal = true;
		
		return returnal;
	}
	public Opcion getOpcion(int ordinal) {
		if(esOrdinalValido(ordinal)) {
			 return values()[ordinal];	
		}
		else
			throw new IllegalArgumentException("Ordinal no válido");
			
	}
	@Override
    public String toString() {
        return ordinal() + ": " + texto;
    }
	
	}
