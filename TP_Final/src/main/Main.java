package main;

import java.util.ArrayList;
import java.util.Scanner;

import menues.MenuLogin;
import modelos.Usuario;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        MenuLogin mLogin = new MenuLogin(sc, listaUsuarios);

        mLogin.iniciar();
    }
}
