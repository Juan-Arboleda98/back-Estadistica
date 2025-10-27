package org.example.repositorios;

import org.example.controladores.Conexion;
import org.example.modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RepositorioUsuario {

    public void usuarioPOST(Usuario usuario){
        String consultaSQL="INSERT INTO usuarios(nombres,contraseña,perfil) VALUES(?,?,?)";
        Conexion conexion=new Conexion();
        try{
            Connection ayudaConexion=conexion.conectar();
            PreparedStatement estamento=ayudaConexion.prepareStatement(consultaSQL);
            estamento.setString(1,usuario.getNombres());
            estamento.setString(2,usuario.getContraseña());
            estamento.setString(3,usuario.getPerfil());
            estamento.executeUpdate();
            System.out.println("😊 Exito guardando los datos!!!");
        }catch(Exception error){
            System.out.println("Fallamos en la operacion de guardado 😥");

        }
    }


}
