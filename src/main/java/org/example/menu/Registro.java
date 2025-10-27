package org.example.menu;

import org.example.controladores.estadistica;
import org.example.repositorios.EstadisticaRepositorio;

import java.util.Scanner;

public class Registro {

    public static void showRegistro(){
        estadistica estadistica2 = new estadistica();
        EstadisticaRepositorio estadisticarepositorio = new EstadisticaRepositorio();

        Scanner sc = new Scanner(System.in);
        System.out.print("Digita la cedula del estudiante -> ");
        estadistica2.setCodigoEstudiante(sc.nextLine());

        System.out.print("Digite el nombre del estaudiante -> ");
        estadistica2.setNombreEstudiante(sc.nextLine());

        System.out.print("Digite la materia del estudiante -> ");
        estadistica2.setMateria(sc.nextLine());

        System.out.print("Digite el semestre en el que se encuentra -> ");
        estadistica2.setSemestre(sc.nextLine());

        System.out.print("Digite la nota del estudiante -> ");
        estadistica2.setNota(sc.nextFloat());

        estadisticarepositorio.guardarPOS(estadistica2);
    }
}
