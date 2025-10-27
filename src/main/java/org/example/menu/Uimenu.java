package org.example.menu;

import org.example.controladores.estadistica;
import org.example.repositorios.EstadisticaRepositorio;

import java.util.Scanner;

public class Uimenu {

    public static void showMenu(){
        Scanner sc = new Scanner(System.in);
        estadistica estadistica2 = new estadistica();
        EstadisticaRepositorio estadisticarepositorio = new EstadisticaRepositorio();
        byte op = 3;

        do{
            System.out.println("Plataforma de registro");
            System.out.println("***********************");
            System.out.println("\nBienvenido 😊");

            System.out.println("1. Registro");
            System.out.println("2. Consulta");
            System.out.println("3. Eliminar");
            System.out.println("4. Salir");

            op = Byte.valueOf(sc.nextLine());

            switch (op){

                case 1:
                    Registro.showRegistro();
                    break;
                case 2:
                    estadisticarepositorio.consultarTodos();
                    break;
                case 3:
                    estadisticarepositorio.eliminar();
                    break;
                case 4:
                    System.out.println("Gracias por su visita");
                    break;
                    default:
                        System.out.println("!! Porfavor digite la opcion correcta del 1 al 4");

            }


        }while(op != 4 );
    }
}
