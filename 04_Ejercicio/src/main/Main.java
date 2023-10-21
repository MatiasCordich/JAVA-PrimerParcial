package main;

import java.util.ArrayList;
import java.util.Scanner;

import menuesEmpleados.MenuEmpleados;
import modelos.Empleado;

public class Main {
    public static void main(String[] args) throws Exception {
        
        // DEPENDENCIAS
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();

        // MENU
        MenuEmpleados menu = new MenuEmpleados(sc, listaEmpleados);

        // INCIAR PROGRAMA

        menu.iniciar();

        // FIN DEL PROGRAMA
        // CIERRA DEL SCANNER
        sc.close();

        
    }
}
