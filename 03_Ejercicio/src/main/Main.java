package main;

import java.util.ArrayList;
import java.util.Scanner;

import menuAutos.MenuAutos;
import modelos.Auto;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Auto> listaAutos = new ArrayList<Auto>();

        MenuAutos menu = new MenuAutos(listaAutos, sc);

        menu.comenzarPrograma();

        sc.close();
    }
}
