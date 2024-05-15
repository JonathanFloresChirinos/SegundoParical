package com.emergentes.modelo;

public class Seminario {
    private int id;
    private String nombres;
    private String apellidos;
    private String seminario;
    private String confirmado;
    private String fecha;

    public Seminario() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.seminario = "";
        this.confirmado = "";
        this.fecha = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    public String getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Seminario{" + "id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", seminario=" + seminario + ", confirmado=" + confirmado + ", fecha=" + fecha + '}';
    }

    
}
