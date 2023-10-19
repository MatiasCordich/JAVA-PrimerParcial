package menuAutos;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Auto;

public class MenuAutos {

    // ATRIBUTOS
    private boolean continuar = true;
    private ArrayList<Auto> listaAutos;
    private Scanner sc;

    // CONSTRUCTOR
    public MenuAutos(ArrayList<Auto> listaAutos, Scanner sc) {
        this.listaAutos = listaAutos;
        this.sc = sc;
    }

    // GENERICOS

    public void comenzarPrograma() {
        while (this.continuar) {
            int opcion = this.elegirOpcion();
            this.realizarOpcion(opcion);
        }
    }

    private void finalizarPrograma() {
        this.continuar = false;
        System.out.println("HAS SALIDO DEL PROGRAMA");
    }

    private void mostarOpciones() {
        System.out.println("---------------------------------------------");
        System.out.println("Elija una de las siguientes opciones");
        System.out.println(" 0 - Salir");
        System.out.println(" 1 - Cargar auto");
        System.out.println(" 2 - Mostrar autos");
        System.out.println(" 3 - Buscar auto por patente");
        System.out.println(" 4 - Buscar autos en venta");
        System.out.println(" 5 - Buscar autos vendidos");
        System.out.println(" 6 - Buscar autos con mayor y menor precio");
        System.out.println(" 7 - Vender un auto");
        System.out.println("---------------------------------------------");
    }

    private int elegirOpcion() {
        this.mostarOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
    }

    // METODOS

    private void realizarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                this.finalizarPrograma();
                break;
            case 1:
                this.cargarAuto();
                break;
            case 2:
                this.mostrarAutos();
                break;
            case 3:
                this.buscarAutoPorPatente();
                break;
            case 4:
                this.buscarAutosEnVenta();
                break;
            case 5:
                this.buscarAutosVendidos();
                break;
            case 6:
                this.buscarAutosConMayorYMenorPrecio();
                break;
            case 7:
                this.venderUnAuto();
                break;
            default:
                System.out.println("------ OPCION INCORRECTA, VUELVA A ELEGIR UNA OPCION VALIDA ------");
                break;
        }
    }

    private boolean estaVacia() {
        boolean listaVacia = false;

        if (this.listaAutos.isEmpty()) {
            System.out.println("------- NO HAY AUTOS EN LA LISTA -------");
            listaVacia = true;
        }

        return listaVacia;
    }

    // METODO MOSTRAR AUTO

    private void mostrarAuto(Auto auto) {
        System.out.println("---------------------------------------------");
        System.out.println("PATENTE: " + auto.getPatente());
        System.out.println("MARCA: " + auto.getMarca());
        System.out.println("MODELO: " + auto.getModelo());
        System.out.println("ANIO: " + auto.getAnio());
        System.out.println("PRECIO: " + auto.getPrecio());
        System.out.println("ESTADO: " + auto.getEstadoVenta());
    }

    // Metodo cargarAuto()

    private void cargarAuto() {

        // Ingreso los atributos del auto
        System.out.println("---------------------------------------------");
        String patente = this.ingresarPatente();
        System.out.print("Ingrese la marca del auto: ");
        String marca = this.sc.next();
        System.out.print("Ingrese el modelo del auto: ");
        String modelo = this.sc.next();
        System.out.print("Ingrese el anio del auto: ");
        int anio = this.sc.nextInt();
        System.out.print("Ingrese el precio del auto: ");
        double precio = this.sc.nextDouble();

        // Creo un nuevo objeto de tipo Auto
        Auto nuevoAuto = new Auto(patente, marca, modelo, anio, precio);

        // Guardo ese objeto en la lista de listaAutos
        this.listaAutos.add(nuevoAuto);
        System.out.println("---------------------------------------------");
    }

    private String ingresarPatente() {

        // Creo mis variables auxiliares
        boolean continuar = true;
        boolean estaVacia = this.estaVacia();

        String patente = "";

        // Ingreso al bucle
        while (continuar) {

            // Recorro la lista de Autos
            if (estaVacia) {
                // Ingreso una patente
                System.out.print("Ingrese la patente el auto: ");
                patente = this.sc.next().toUpperCase();
                continuar = false;
            } else {
                System.out.print("Ingrese la patente el auto: ");
                patente = this.sc.next().toUpperCase();

                for (Auto auto : listaAutos) {

                    // Si la patente del auto de turno es igual a la patente que escribi por consola
                    if (auto.getPatente().equalsIgnoreCase(patente)) {

                        // Ingreso un mensaje que diga que ya existe un auto con esa patente
                        System.out.println("------- YA EXISTE UN AUTO CON ESE PATENTE -------");
                        break;
                    } else {

                        // Caso contrario salgo del bucle
                        continuar = false;
                    }
                }
            }

        }

        // Devuelvo el valor que escribi para la patente
        return patente;
    }

    // Metodo mostarAutos()
    private void mostrarAutos() {

        // Primeor valido si la lista esta vacio
        boolean estaVacia = this.estaVacia();

        // Si no esta vacia, entonces recorro la lista
        if (!estaVacia) {
            for (Auto auto : listaAutos) {
                // Muesto el auto de turno mediante el metodo mostrarAuto()
                this.mostrarAuto(auto);
            }
        }
    }

    // Meotod buscarAutoPorPatetne()
    private Auto buscarAutoPorPatente() {

        // Declaro mis variables auxiliares
        String patenteABuscar;
        Auto autoBuscado = null;
        boolean estaVacia = this.estaVacia();

        // Si la lista no esta vacia realizo el proceso de buscar el auto por patente
        if (!estaVacia) {

            // Ingreso una patente por consola
            System.out.print("Ingrese la patente del auto buscado: ");
            patenteABuscar = this.sc.next();

            // Recorro la lista de autos
            for (Auto auto : listaAutos) {

                // Si la patente del auto de turno coincide con la patente ingresada
                if (auto.getPatente().equalsIgnoreCase(patenteABuscar)) {

                    // La variable autoBuscado tendra el valor del auto de turno
                    autoBuscado = auto;

                    // Uso un break para salir del bucle foreach
                    break;
                }
            }
        }

        // Valido el resultado obtenido
        if (autoBuscado == null) {

            // Si el valor de autoBuscado es null devuelvo un mensaje de que no se encontro
            // dicho auto
            System.out.println("------- NO SE HA ENCONTRADO EL AUTO -------");
        } else {

            // Caso contrario muestro el auto buscado
            this.mostrarAuto(autoBuscado);
        }

        // Devuelvo el valor de autoBuscado
        return autoBuscado;

    }

    // Metodo buscarAutosEnVenta()
    private void buscarAutosEnVenta() {

        // Variable axuliar
        boolean estaVacia = this.estaVacia();

        // Si la lista NO esta vacia procedo a buscar los autos en venta
        if (!estaVacia) {

            // Recorro la lista de autos
            for (Auto auto : listaAutos) {

                // Si el auto de turno esta en venta, es decir, su valor es true
                if (auto.getEnVenta()) {
                    // Mostrame ese auto con el meotdo mostarAuto
                    this.mostrarAuto(auto);
                }
            }
        }
    }

    // Metodo buscarAutosVendidos()
    private void buscarAutosVendidos() {

        // Variables auxiliares
        boolean estaVacia = this.estaVacia();

        // Si la lista NO esta vacia procedo a buscar los autos vendidos
        if (!estaVacia) {

            // Recorro la lista de autos
            for (Auto auto : listaAutos) {

                // Si el auto de turno NO esta en venta, es decir, su valor es false
                if (!auto.getEnVenta()) {
                    // Mostrame el auto vendido con el metodo mostrarAuto()
                    this.mostrarAuto(auto);
                }
            }
        }
    }

    // Metodo buscarAutosConMayorYMenorPrecio()
    private void buscarAutosConMayorYMenorPrecio() {

        // Variable axuliar
        boolean estaVacia = this.estaVacia();
        Auto maxAuto = null;
        Auto minAuto = null;

        // Valido si la lista de autos NO este vacia
        if (!estaVacia) {

            // Si NO esta vacia procedo a recorrer la lista de autos
            for (Auto auto : listaAutos) {

                // Valido los maximos y minimos

                if (maxAuto == null || auto.getPrecio() > maxAuto.getPrecio()) {
                    maxAuto = auto;
                }

                if (minAuto == null || auto.getPrecio() < minAuto.getPrecio()) {
                    minAuto = auto;
                }
            }

            // Muestro por pantalla los autos con mayor y menor precio
            System.out.println("-------------- MAYOR PRECIO --------------");
            this.mostrarAuto(maxAuto);
            System.out.println("-------------- MENOR PRECIO --------------");
            this.mostrarAuto(minAuto);
        }
    }

    // Metodo venderUnAuto
    private void venderUnAuto() {

        // Variable axuliar
        boolean estaVacia = this.estaVacia();
        boolean continuar = true;

        // Si la lista NO esta vacia procedo con la venta del auto
        if (!estaVacia) {

            // Primero busco el auto a vender por su patente
            Auto autoAVender = this.buscarAutoPorPatente();

            // Valido si el auto a vender existe
            if (autoAVender != null) {
                if (!autoAVender.getEnVenta()) {
                    // Si no esta en ventam es decir, su valor es false, que me devuelva un mensaje
                    System.out.println("------- EL AUTO BUSCADO YA ESTA VENDIDO -------");
                } else {
                    while (continuar) {
                        // Si esta en venta procedo con la venta
                        System.out.print("Desea vender este auto (S/N): ");

                        // Ingreso un valor para la variable opcionS
                        String opcionS = this.sc.next().toLowerCase();

                        // Transformo la variable opcionS en opcionC para simplificar mejor la
                        // validacion
                        char opcionC = opcionS.charAt(0);

                        // Valido los posibles escenarios
                        switch (opcionC) {
                            case 's':
                                System.out.println("------- SE VA VENDIDO EL AUTO CORRECTAMENTE -------");

                                // El auto a vender seteo sus valores de enVenta y estadoDeVenta
                                autoAVender.setEnVenta(false);
                                autoAVender.setEstadoVenta("VENDIDO");
                                continuar = false;
                                break;
                            case 'n':
                                System.out.println("------- HA CANCELADO LA TRANSACCION -------");
                                continuar = false;
                                break;

                            default:
                                System.out.println("------- OPCION INCORRECTA, VUELTA A INTENTARLO -------");
                                break;
                        }
                    }

                }
            } else {
                System.out.println("------- EL AUTO NO EXISTE -------");
            }

        }

    }

}
