package main;

import java.util.ArrayList;
import java.util.Scanner;

import menuAlumnos.MenuAlumnos;
import modelos.Alumno;

public class Main {
    public static void main(String[] args) {

        // Mis dependencias

        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

        // El objeto Menu

        MenuAlumnos menu = new MenuAlumnos(sc, listaAlumnos);

        menu.iniciar();

        System.out.println("Fin del programa");

        sc.close();
    }
}
