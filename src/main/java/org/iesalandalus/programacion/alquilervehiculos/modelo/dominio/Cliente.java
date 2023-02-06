package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Cliente {
    private static String ER_NOMBRE = "[A-ZÁÉÍÓÚÜÑ][a-záéíóúÜñ]+([ '-][A-ZÁÉÍÓÚÜÑ][a-záéíóúÜñ]+)*";
    private static String ER_DNI = "([0-9]{8})([A-Za-z])";
    private static String ER_TELEFONO = "[96]?[0-9]{8}";
    private String nombre;
    private String dni;
    private String telefono;

    public Cliente(String Nombre, String DNI, String Telefono) {
        setNombre(Nombre);
        setDni(DNI);
        setTelefono(Telefono);
    }

    public Cliente(Cliente cliente) {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre==null) {
            throw new NullPointerException("El nombre introducido no puede ser nulo");
        }
        if(!nombre.matches(ER_NOMBRE)) {
            throw new IllegalArgumentException("El nombre elegido no sigue el patron indicado");
        }
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        if(dni==null) {
            throw new NullPointerException("El nombre introducido no puede ser nulo");
        }
        if(!dni.matches(ER_DNI)) {
            throw new IllegalArgumentException("El nombre elegido no sigue el patron indicado");
        }
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono==null) {
            throw new NullPointerException("El nombre introducido no puede ser nulo");
        }
        if(!telefono.matches(ER_TELEFONO)) {
            throw new IllegalArgumentException("El nombre elegido no sigue el patron indicado");
        }
        this.telefono = telefono;
    }

}