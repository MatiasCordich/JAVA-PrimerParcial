package menuAlumnos;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Alumno;

public class MenuAlumnos {

    // ATRIBUTOS DE LA CLASE MenuAlumnos
    private boolean activo = true;
    private Scanner sc = new Scanner(System.in);
    private ArrayList<Alumno> listaAlumnos;

    public MenuAlumnos(Scanner sc, ArrayList<Alumno> listaAlumnos) {
        this.sc = sc;
        this.listaAlumnos = listaAlumnos;
    }

    // GENERICOS

    public void iniciar() {
        System.out.println("---------------------------------------------");
        System.out.println("Bienvenido al sistema de carga de datos de los alumnos");
        while (this.activo) {
            int opcion = this.elegirOpcion();
            this.realizarOpcion(opcion);
        }
    }

    private void mostrarOpciones() {

        System.out.println("---------------------------------------------");
        System.out.println("Elija una de las siguientes opciones");
        System.out.println(" 0 - Salir");
        System.out.println(" 1 - Cargar alumno");
        System.out.println(" 2 - Mostrar alumnos");
        System.out.println(" 3 - Buscar alumno por id");
        System.out.println(" 4 - Buscar alumno con mayor y menor promedio");
        System.out.println(" 5 - Buscar alumnos aprobados");
        System.out.println(" 6 - Buscar alumnos desaprobados");
        System.out.println("---------------------------------------------");
    }

    private int elegirOpcion() {
        this.mostrarOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
    }

    private void finalizar() {
        this.activo = false;
    }

    // MENU

    private void realizarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                this.finalizar();
                break;
            case 1:
                this.cargarAlumno();
                break;
            case 2:
                this.mostrarAlumnos();
                break;
            case 3:
                this.buscarPorId();
                break;
            case 4:
                this.mostrarMayorYMenorPromedio();
                break;
            case 5:
                this.mostarAlumnosAprobados();
                break;
            default:
                System.out.println("---------------------------------------------");
                System.out.println("OPCION INCORRECTA, ELIJA UNA OPCION EXISTENTE");
                System.out.println("---------------------------------------------");
                break;
        }
    }

    // METODOS DEL MENU
    private void cargarAlumno() {

        // PIDO TODOS LOS DATOS DEL ALUMNO
        System.out.println("---------------------------------------------");
        System.out.print("Ingrese el id del Alumno: ");
        int id = this.sc.nextInt();
        System.out.print("Ingrese el nombre del Alumno: ");
        String nombre = this.sc.next();
        System.out.print("Ingrese el apellido del Alumno: ");
        String apellido = this.sc.next();
        System.out.print("Ingrese la primera nota del Alumno: ");
        int primerNota = this.sc.nextInt();
        System.out.print("Ingrese la segunda nota del Alumno: ");
        int segundaNota = this.sc.nextInt();

        // CREO UN NUEVO OBJETO DE TIPO ALUMNO CON LOS DATOS ESCRITOS POR PANTALLA
        Alumno nuevoAlumno = new Alumno(id, nombre, apellido, primerNota, segundaNota);

        // AGREGO ESE NUEVO ALUMNO AL ARRAY DE listaAlumnos
        this.listaAlumnos.add(nuevoAlumno);
        System.out.println("---------------------------------------------");
    }

    private void mostrarAlumnos() {

        // VALIDO SI EL ARRAY listaAlumnos ESTA O NO VACIO
        if (this.listaAlumnos.isEmpty()) {

            // SI LO ESTA QUE ME DEVUELVA UNA MENSAJE DE ERROR
            System.out.println("---------------------------------------------");
            System.out.println("NO HAY ALUMNOS EN LA LISTA");
        } else {

            // SI NO LO ESTA QUE ME RECORRAR EL ARRAY CON EL METODO FOREACH
            for (Alumno alumno : listaAlumnos) {

                // LLAMO A LA FUNCION MOSTRAR ALUMNO
                this.mostrarAlumno(alumno);
            }
        }
    }

    private void mostrarAlumno(Alumno alumno) {

        // PARA MOSTRAR UN ALUMNO EL METODO DEBE RECIBIR UN ALUMNO
        System.out.println("---------------------------------------------");

        // UNA VEZ RECIBIDO EL ALUMNO PUEDO UTILZAR TODOS SUS METODOS
        System.out.println("ID: " + alumno.getId());
        System.out.println("NOMBRE: " + alumno.getNombre());
        System.out.println("APELLIDO: " + alumno.getApellido());
        System.out.println("PRIMER NOTA: " + alumno.getPrimerNota());
        System.out.println("SEGUNDA NOTA: " + alumno.getSegundaNota());
        System.out.println("PROMEDIO: " + alumno.getPromedio());
    }

    private void buscarPorId() {

        // VALIDO SI EL ARRAY ESTA VACIO O NO
        if (this.listaAlumnos.isEmpty()) {

            // SI LO ESTA QUE ME MUESTRE UN MENSAJE DE ERROR
            System.out.println("---------------------------------------------");
            System.out.println("NO HAY ALUMNOS EN LA LISTA");
        } else {

            // SI NO LO ESTA, SIGO CON LA BUSQUEDA
            // INGRESO UN NUMERO Y SE GUARDA EN UNA VARIABLE LLAMADA numero
            System.out.println("---------------------------------------------");
            System.out.print("Ingrese un numero de ID: ");
            int numero = this.sc.nextInt();
            
            // INICIALIZA UNA VARIABLE DE TIPO ALUMNO EN null
            Alumno alumnoBuscado = null;

            // RECORRO EL ARRAY DE listaAlumnos
            for (Alumno alumno : listaAlumnos) {

                // POR CADA ALUMNO OBTENGO SU ID MEDIENTE EL METODO getId()
                if (alumno.getId() == numero) {
                    // SI EL ID DEL ALUMNO DE TURNO RECORRIDO EN EL ARRAY ES IGUAL AL NUMERO QUE INGRESAMOS Y ESTA EN LA VARIABLE numero GUARDAME ESE ALUMNO EN LA VARIABLE alumnoBuscado
                    alumnoBuscado = alumno;

                    // SI YA ENCONTRE EL ALUMNO NO HACE FALTA SEGUIR ITERANDO EN EL FOREACH, ENTONCES LO CORTO CON UN break
                    break;
                }
            }

            // VALIDO EL RESULTADO OBTENIDO
            if (alumnoBuscado != null) {
                // SI LA VARIABLE alumnoBuscado ES DISTINTO DE null QUIERE DECIR QUE HAY UN ALUMNO, ES DECIR, LO ENCONTRO,
                // MUESTRO EL ALUMNO ENCONTRADO MEDIANTE EL METODO mostarAlumno() QUE RECIBE LA VARIABLE alumnoBuscado
                this.mostrarAlumno(alumnoBuscado);
            } else {
                // CASO CONTRARIO QUE ME SALTE UN MENSAJE DE QUE NO SE ENCONTRO
                System.out.println("NO SE ENCONTRO EL ALUMNO");
            }
            System.out.println("---------------------------------------------");
        }

    }

    private void mostrarMayorYMenorPromedio() {

        // DECLARO MIS VARIABLES DE MAXIMOS Y MINIMOS
        Alumno maxAlumno = null;
        Alumno minAlumno = null;

        // RECORRO EL ARRAY listaAlumnos CON EL FOREACH
        for (Alumno alumno : listaAlumnos) {

            // CONDICION PARA ENCONTRAR SIEMPRE EL MAXIMO
            if (maxAlumno == null || alumno.getPromedio() > maxAlumno.getPromedio()) {
                maxAlumno = alumno;
            }

            // CONDICION PARA ENCONTRAR SIEMPRE EL MINIMO
            if (minAlumno == null || alumno.getPromedio() < minAlumno.getPromedio()) {
                minAlumno = alumno;
            }

        }

        // VALIDO LOS RESULTADOS OBTENIDOS
        if (maxAlumno != null && minAlumno != null) {
            // SI LAS VARIABLES DE MAXIMO Y MINIMO SON DISTINTAS DE null ESO QUIERE DECIR QUE TIENEN EL DATO QUE ES UN OBJETO DE TIPO ALUMNO
            // ENTONCES MUESTRO EL MAXIMO Y MINIMO
            System.out.println("-------------- MAYOR PROMEDIO --------------");
            this.mostrarAlumno(maxAlumno);
            System.out.println("-------------- MENOR PROMEDIO --------------");
            this.mostrarAlumno(minAlumno);
        } else {

            // SI NO SE CUMPLE QUIERE DECIR QUE EL ARRAY ESTA VACIO
            System.out.println("---------------------------------------------");
            System.out.println("LA LISTA ESTA VACIA");
            System.out.println("---------------------------------------------");
        }
    }

    private void mostarAlumnosAprobados() {

         // VALIDO SI EL ARRAY ESTA VACIO O NO
        if (this.listaAlumnos.isEmpty()) {

            // SI LO ESTA QUE ME MUESTRE UN MENSAJE DE ERROR
            System.out.println("NO HAY ALUMNOS EN LA LISTA");
        } else {

            // SI NO LO ESTA REALIZO EL FOREACH
            System.out.println("--------------- ALUMNOS APROBADOS ---------------");
            for (Alumno alumno : listaAlumnos) {

                // POR CADA ALUMNO VALIDO QUE EL ALUMNO DE TURNO TENGA UN PROMEDIO MAYOR A 6 PARA CONSIDERARSE APROBADO
                // CADA ALUMNO ES UN OBJETO QUE TIENE EL METODO getPromedio(), NOS DA UN DOUBLE Y LO DEBO COMPARAR CON EL 6.00 QUE ES LA NOTA APROBADA
                if (alumno.getPromedio() >= 6.00) {
                    // SI SE CUMPLE LA CONDICION QUIERO QUE ME MUESTRES EL ALUMNO APROBADO
                    this.mostrarAlumno(alumno);
                }

                // CASO CONTRARIO NO HAGAS NADA
            }
        }
    }
}
