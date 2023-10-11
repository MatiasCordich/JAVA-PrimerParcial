package main;

import java.util.ArrayList;
import java.util.Scanner;

import menuPokemon.MenuPokemon;
import modelos.Pokemon;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pokemon> listaPokemones = new ArrayList<Pokemon>();

        MenuPokemon mPokemon = new MenuPokemon(sc, listaPokemones);

        mPokemon.inicarPokedex();

        sc.close();
    }
}
