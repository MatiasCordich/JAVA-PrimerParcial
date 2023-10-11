package menuPokemon;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Pokemon;

public class MenuPokemon {

    private boolean continuar = true;
    private Scanner sc;
    private ArrayList<Pokemon> listaPokemones;

    // Constructor
    public MenuPokemon(Scanner sc, ArrayList<Pokemon> listaPokemones) {
        this.sc = sc;
        this.listaPokemones = listaPokemones;
    }

    // Genericos

    public void inicarPokedex() {
        System.out.println("------------- POKEDEX -------------");
        System.out.println("BIENVENIDO/A A LA POKEDEX, DONDE PUEDES GUARDAR INFORMACION DE TUS POKEMONES");
        while (this.continuar) {
            int opcion = this.elegirOpcion();
            this.realizarOpcion(opcion);
        }
    }

    public void finalizarPokedex() {
        this.continuar = false;
        System.out.println("Has salido de la Pokedex, hasta luego!!!");
    }

    private void mostrarOpciones() {
        System.out.println("---------------------------------------------");
        System.out.println("ELIJA UNA DE LAS SIGUIENTES OPCIONES");
        System.out.println(" 0 - Salir");
        System.out.println(" 1 - Cargar Pokemon");
        System.out.println(" 2 - Mostrar Pokemones");
        System.out.println(" 3 - Buscar Pokemon por id");
        System.out.println(" 4 - Simular una batalla Pokemon");
        System.out.println(" 5 - Buscar Pokemones por tipo");
        System.out.println("---------------------------------------------");
    }

    private void mostrarTipos() {
        System.out.println("---------------------------------------------");
        System.out.println("ELIJA UNA DE LAS SIGUIENTES TIPOS");
        System.out.println(" 1 - AGUA");
        System.out.println(" 2 - BICHO");
        System.out.println(" 3 - DRAGON");
        System.out.println(" 4 - ELECTRICO");
        System.out.println(" 5 - FANTASMA");
        System.out.println(" 6 - FUEGO");
        System.out.println(" 7 - HADA");
        System.out.println(" 8 - HIELO");
        System.out.println(" 9 - LUCHA");
        System.out.println(" 10 - NORMAL");
        System.out.println(" 11 - PLANTA");
        System.out.println(" 12 - PSIQUICO");
        System.out.println(" 13 - ROCA");
        System.out.println(" 14 - TIERRA");
        System.out.println(" 15 - VENENO");
        System.out.println("---------------------------------------------");
    }

    private int elegirOpcion() {
        this.mostrarOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
    }

    // Metodos

    private void realizarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                this.finalizarPokedex();
                break;
            case 1:
                this.cargarPokemon();
                break;
            case 2:
                this.mostrarPokemones();
                break;
            case 3:
                this.mostrarPokemonPorId();
                break;
            case 4:
                this.simularBatalla();
                break;
            case 5:
                this.mostrarPokemonesPorTipo();
                break;
            default:
                break;
        }
    }

    public void mostrarPokemon(Pokemon pokememon) {
        System.out.println("----------------------------------");
        System.out.println("ID: " + pokememon.getId());
        System.out.println("NOMBRE: " + pokememon.getNombre());
        System.out.println("TIPO: " + pokememon.getTipo());
        System.out.println("ATAQUE: " + pokememon.getAtaque());
    }

    public void cargarPokemon() {
        System.out.println("---------------------------------------------");

        System.out.print("Ingrese el id del Pokemon: ");
        int id = this.sc.nextInt();
        System.out.print("Ingrese el nombre del Pokemon: ");
        String nombre = this.sc.next();

        String tipo = this.elegirTipo();

        System.out.print("Ingrese los puntos de ataque del Pokemon: ");
        int ataque = this.sc.nextInt();

        Pokemon nuevPokememon = new Pokemon(id, nombre, tipo, ataque);

        this.listaPokemones.add(nuevPokememon);

        System.out.println("---------------------------------------------");
    }

    private int elegirOpcionTipo() {
        this.mostrarTipos();
        int opcion = this.sc.nextInt();
        return opcion;
    }

    private String elegirTipo() {

        String tipo = "";
        boolean continuarTipo = true;

        while (continuarTipo) {
            int opcion = this.elegirOpcionTipo();
            switch (opcion) {
                case 1:
                    tipo = "AGUA";
                    continuarTipo = false;
                    break;
                case 2:
                    tipo = "BICHO";
                    continuarTipo = false;
                    break;
                case 3:
                    tipo = "DRAGON";
                    continuarTipo = false;
                    break;
                case 4:
                    tipo = "ELECTRICO";
                    continuarTipo = false;
                    break;
                case 5:
                    tipo = "FANTASMA";
                    continuarTipo = false;
                    break;
                case 6:
                    tipo = "FUEGO";
                    continuarTipo = false;
                    break;
                case 7:
                    tipo = "HADA";
                    continuarTipo = false;
                    break;
                case 8:
                    tipo = "HIELO";
                    continuarTipo = false;
                    break;
                case 9:
                    tipo = "LUCHA";
                    continuarTipo = false;
                    break;
                case 10:
                    tipo = "NORMAL";
                    continuarTipo = false;
                    break;
                case 11:
                    tipo = "PLANTA";
                    continuarTipo = false;
                    break;
                case 12:
                    tipo = "PSIQUICO";
                    continuarTipo = false;
                    break;
                case 13:
                    tipo = "ROCA";
                    continuarTipo = false;
                    break;
                case 14:
                    tipo = "TIERRA";
                    continuarTipo = false;
                    break;
                case 15:
                    tipo = "VENENO";
                    continuarTipo = false;
                    break;
                default:
                    System.out.println("HAS ELEGIDO UN TIPO INCORRECTO");
                    break;
            }
        }

        return tipo;

    }

    private void mostrarPokemones() {
        if (this.listaPokemones.isEmpty()) {
            System.out.println("NO HAY POKEMONES EN LA POKEDEX");
        } else {
            for (Pokemon pokememon : listaPokemones) {
                this.mostrarPokemon(pokememon);
            }
        }
    }

    private void mostrarPokemonPorId() {

        if (this.listaPokemones.isEmpty()) {
            System.out.println("NO HAY POKEMONES EN LA POKEDEX");
        } else {

            System.out.println("---------------------------------------------");
            System.out.print("Ingrese el numero de ID del Pokemon: ");
            int numero = this.sc.nextInt();

            Pokemon pokemonABuscar = null;

            for (Pokemon pokememon : listaPokemones) {
                if (pokememon.getId() == numero) {
                    pokemonABuscar = pokememon;
                    break;
                }
            }

            if (pokemonABuscar != null) {
                this.mostrarPokemon(pokemonABuscar);
            } else {
                System.out.println("NO SE ENCONTRO EL POKEMON");
            }
            System.out.println("---------------------------------------------");
        }
    }

    private Pokemon buscarPokemonPorId() {

        Pokemon pokemonABuscar = null;

        if (this.listaPokemones.isEmpty()) {
            System.out.println("NO HAY POKEMONES EN LA POKEDEX");
        } else {
            System.out.println("---------------------------------------------");
            System.out.print("Ingrese el ID del pokemon: ");

            int id = this.sc.nextInt();

            for (Pokemon pokememon : listaPokemones) {
                if (pokememon.getId() == id) {
                    pokemonABuscar = pokememon;
                    break;
                }
            }
        }

        return pokemonABuscar;
    }

    private void simularBatalla() {

        boolean continuar = true;

        if (this.listaPokemones.isEmpty()) {
            System.out.println("NO HAY POKEMONES EN LA POKEDEX");
        } else {
            while (continuar) {
                System.out.println("---------------------------------------------");
                Pokemon pokemon1 = this.buscarPokemonPorId();
                Pokemon pokemon2 = this.buscarPokemonPorId();

                if (pokemon1 != null && pokemon2 != null) {
                    if (pokemon1.getAtaque() > pokemon2.getAtaque()) {
                        System.out.println(pokemon1.getNombre() + " gano la batalla");
                        continuar = false;
                    } else {
                        System.out.println(pokemon2.getNombre() + " gano la batalla");
                        continuar = false;
                    }
                } else {
                    System.out.println("NO SE PUEDO HACER LA BATALLA");
                    continuar = false;
                }
            }

        }
    }

    private void mostrarPokemonesPorTipo() {

        if (this.listaPokemones.isEmpty()) {
            System.out.println("NO HAY POKEMONES EN LA POKEDEX");
        } else {
            this.mostrarTipos();
            String tipoElegido = this.elegirTipo();

            for (Pokemon pokemon : listaPokemones) {
                if (pokemon.getTipo().equalsIgnoreCase(tipoElegido)) {
                    this.mostrarPokemon(pokemon);
                }
            }
        }

    }

}
