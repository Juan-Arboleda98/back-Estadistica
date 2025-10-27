package org.example.repositorios;

import org.example.controladores.Conexion;
import org.example.controladores.estadistica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EstadisticaRepositorio {

    public void guardarPOS(estadistica estadistica2){
        String consultaSQL="INSERT INTO estadistica(codigoEstudiante,nombreEstudiante,nota,materia,semestre) VALUES(?,?,?,?,?)";
        Conexion conexion=new Conexion();
        try{
            Connection ayudaConexion=conexion.conectar();
            PreparedStatement estamento=ayudaConexion.prepareStatement(consultaSQL);
            estamento.setString(1,estadistica2.getCodigoEstudiante());
            estamento.setString(2,estadistica2.getNombreEstudiante());
            estamento.setFloat(3,estadistica2.getNota());
            estamento.setString(4,estadistica2.getMateria());
            estamento.setString(5,estadistica2.getSemestre());
            estamento.executeUpdate();
            System.out.println("😊 Exito guardando los datos!!!");
        }catch(Exception error){
            System.out.println("No se guardaron los datos de forma correcta 😥"+ error.getMessage());
        }
    }

    public List<estadistica> consultarTodos() {
        List<estadistica> lista = new ArrayList<>();
        String consultaSQL = "SELECT * FROM estadistica";
        Conexion conexion = new Conexion();

        try {
            Connection ayudaConexion = conexion.conectar();
            PreparedStatement estamento = ayudaConexion.prepareStatement(consultaSQL);
            ResultSet resultado = estamento.executeQuery();

            System.out.println("============================================");
            System.out.println("📋 LISTA DE REGISTROS DE ESTADÍSTICA");
            System.out.println("============================================");
            System.out.printf("%-15s %-25s %-10s %-20s %-10s%n",
                    "Código", "Nombre", "Nota", "Materia", "Semestre");
            System.out.println("--------------------------------------------------------------------------");

            while (resultado.next()) {
                estadistica e = new estadistica();
                e.setCodigoEstudiante(resultado.getString("codigoEstudiante"));
                e.setNombreEstudiante(resultado.getString("nombreEstudiante"));
                e.setNota(resultado.getFloat("nota"));
                e.setMateria(resultado.getString("materia"));
                e.setSemestre(resultado.getString("semestre"));

                lista.add(e);

                // 👇 Mostrar en consola cada registro
                System.out.printf("%-15s %-25s %-10.2f %-20s %-10s%n",
                        e.getCodigoEstudiante(),
                        e.getNombreEstudiante(),
                        e.getNota(),
                        e.getMateria(),
                        e.getSemestre());
            }

            System.out.println("--------------------------------------------------------------------------");
            System.out.println("✅ Consulta exitosa. Se obtuvieron " + lista.size() + " registros.");
            System.out.println("============================================\n");

        } catch (Exception error) {
            System.out.println("❌ Error al consultar los datos: " + error.getMessage());
        }

        return lista;
    }

    public void eliminar() {

        Scanner entrada = new Scanner(System.in);
        System.out.print("🆔 Ingrese la cédula del estudiante a eliminar: ");
        String codigoEstudiante = entrada.nextLine();  // 👈 Aquí el usuario digita la cédula

        String consultaSQL = "DELETE FROM estadistica WHERE codigoEstudiante = ?";
        Conexion conexion = new Conexion();

        try {
            Connection ayudaConexion = conexion.conectar();
            PreparedStatement estamento = ayudaConexion.prepareStatement(consultaSQL);
            estamento.setString(1, codigoEstudiante);
            int filasAfectadas = estamento.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("🗑️ Registro eliminado correctamente.");
            } else {
                System.out.println("⚠️ No se encontró ningún registro con esa cédula.");
            }

        } catch (Exception error) {
            System.out.println("❌ Error al eliminar el registro: " + error.getMessage());
        }
    }



}

