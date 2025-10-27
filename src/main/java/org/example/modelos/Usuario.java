package org.example.modelos;

public class Usuario {

    private Integer id;
    private String nombres;
    private String contraseña;

    private String perfil;

    public Usuario() {
    }

    public Usuario(Integer id, String nombres, String contraseña, String perfil) {
        this.id = id;
        this.nombres = nombres;
        this.contraseña = contraseña;
        this.perfil = perfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
