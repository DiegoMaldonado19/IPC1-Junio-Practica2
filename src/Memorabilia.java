/**
 * Definimos la carpeta donde se encuentra nuestro codigo fuente
 * E importamos todas las clases del paquete java util
 */
package src;
import java.util.*;
public class Memorabilia{
    public static void main(String[] args){
        /**
         * Instanciamos objeto de la clase para evitar problemas con el ambito estatico y poder usar los metodos
         */
        Memorabilia memorabilia = new Memorabilia();
    }

    /**
     * Programa correspondiente a la practica 2, Introducción y Programacíón I, Escuela de Vacaciones 2021
     * @author Diego Maldonado
     * @author dj_maldonado19@hotmail.es
     * @version 1.0
     */

    /**
     * Constructor de la clase donde se hacen los llamados a los metodos correspondientes
     */
    public Memorabilia(){
        /**
         * Damos un mensaje de bienvenida
         * Inicializamos y llenamos de datos los arreglos para clientes y peliculas
         * Luego mostramos el menu principal
         */
        mensajeDeBienvenida();
        inicializarCliente();
        inicializarPelicula();
        menuPrincipal();
    }

    /**
     * Instanciamos un objeto de la clase scanner para poder leer desde consola
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Conjunto de arreglos, los cuales nos permitiran almacenar la informacion ingresada por el usuario
     */
    /**
     * Arreglos para cliente, los cuales guardan el id, nombre, telefono y si tiene una pelicula prestada
     */
    int[] clienteId = new int[50];
    String[] nombreCliente = new String[50];
    int[] telefonoCliente = new int[50];
    boolean[] tienePeliculaPrestada = new boolean[50];
    /**
     * Arreglos para pelicula, los cuales contienen a su id, nombre, categoria, año y si esta disponible la pelicula
     */
    int[] peliculaId = new int[50];
    String[] nombrePelicula = new String[50];
    String[] categoriaPelicula = new String[50];
    int[] anioPelicula = new int[50];
    boolean[] peliculaDisponible = new boolean[50];
    /**
     * Arreglos para prestamos, los cuales contienen el id de la pelicula prestada, que cliente la presto y la cantidad de dia que se presto
     */
    int[] peliculaPrestadaId = new int[50];
    int[] clienteQuePrestoPelicula = new int[50];
    int[] cantidadDiasPrestamo = new int[50];

    /**
     * Variables enteras, para saber la cantidad de peliculas, clientes y  peliculas prestadas, y un contador para el metodo prestar pelicula
     */
    int contadorPeliculas=0, contadorClientes=0, cantidadPeliculasPrestadas=0, contador=0;

    /**
     * Metodo para imprimir mensaje de bienvenida en pantalla
     */
    public void mensajeDeBienvenida(){
        /**
         * Imprimimos un mensaje de bienvenida e imprimimos un salto de linea
         */
        System.out.println("Bienvenido a Memorabilia");
        System.out.println("En nuestro sistema puedes prestar peliculas y verlas desde la comodidad de tu casa");
        System.out.println("\n");
    }

    /**
     * Metodo para navegar por el menu principal
     */
    public void menuPrincipal(){
        /**
         * Variables para saber si el usuario desea salir y para almacenar la opcion que elija
         */
        boolean salir = false;
        int opcion=0;
        /**
         * Ciclo para repetir la impresion del menu hasta que el usuario deseee salir
         */
        do{
            /**
             * Impresion de opciones para el usuario y posterior almacenamiento de la opcion
             */
            System.out.println("\n");
            System.out.println("1) Prestar pelicula");
            System.out.println("2) Devolver pelicula");
            System.out.println("3) Mostrar peliculas en el sistema");
            System.out.println("4) Ingresar pelicula nueva al sistema");
            System.out.println("5) Ingresar cliente nuevo al sistema");
            System.out.println("6) Mostrar clientes en el sistema");
            System.out.println("7) Menu de reportes");
            System.out.println("8) Salir");
            opcion = scanner.nextInt();
            /**
             * Ciclo switch para llamar a los metodos segun eleccion del usuario
             */
            switch (opcion) {
                case 1:
                    prestarPelicula();
                    break;
            
                case 2:
                    devolverPelicula();
                    break;
                
                case 3:
                    if(contadorPeliculas==0){
                        System.out.println("\n");
                        System.out.println("Aun no se han ingresado peliculas al sistema");
                    }
                    else if(contadorPeliculas!=0){
                        for(int i=0; i<contadorPeliculas; i++){
                            visualizarPeliculaEnSistema(i);
                        }
                    }
                    break;
                   
                case 4:
                    IngresarPelicula();
                    break;
            
                case 5:
                    ingresarCliente();
                    break;
                
                case 6:
                    if(contadorClientes==0){
                        System.out.println("\n");
                        System.out.println("Aun no se han ingresado clientes al sistema");
                    }
                    else if(contadorClientes!=0){
                        for(int i=0; i<contadorClientes; i++){
                            mostrarClienteEnSistema(i);
                        }
                    }
                    break;     

                case 7:
                    menuReporte();
                    break;
                    
                case 8:
                    System.out.println("Esta saliendo");
                    salir = true;
                    break;  
                    
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }
        while(salir==false);
    }

    /**
     * Metodo para navegar por el menu de reportes
     */
    public void menuReporte(){
        /**
         * Variables para almacenar la opcion ingresadad por el usuario y una booleana por si desea salir
         */
        int opcion = 0;
        boolean salir = false;

        /**
         * Ciclo para repetir el menu de reportes hasta que el usuario desee salir
         */
        do{
            /**
             * Impresion de opciones para el usuario y posterior almacenamiento
             */
            System.out.println("\n");
            System.out.println("1) Revisar cantidad de peliculas por categoria");
            System.out.println("2) Peliculas por categoria especifica");
            System.out.println("3) Cantidad de veces que se presto una pelicula");
            System.out.println("4) Pelicula mas prestada");
            System.out.println("5) Pelicula menos prestada");
            System.out.println("6) Salir");
            opcion = scanner.nextInt();
            /**
             * Ciclo para desarrollar logica segun la eleccion del usuario
             */
            switch (opcion) {
                case 1:
                    System.out.println("\n");
                    System.out.println("La cantidad de peliculas por categoria es de: "+contadorPeliculas);
                    break;
                
                case 2:
                    System.out.println("\n");
                    peliculasPorCategoria();
                    break;
                    
                case 3:
                    System.out.println("\n");
                    System.out.println("La cantidad de veces que se prestó una pelicula fue de: "+cantidadPeliculasPrestadas);
                    break;
                
                case 4:
                    System.out.println("\n");
                    peliculaMasPrestada();
                    break;  
                
                case 5:
                    System.out.println("\n");
                    peliculaMenosPrestada();
                    break;

                case 6:
                    System.out.println("Esta saliendo");
                    salir = true;
                    break; 
                    
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        }while(salir==false);
    }

    /**
     * Metodo inicializar cliente, el cual inicializa los clientes por defecto que tiene el sistema
     * Se generan datos en las primeras 3 posiciones para los arreglos de cliente
     */
    public void inicializarCliente(){
        clienteId[0] = 1;
        nombreCliente[0] = "Diego Maldonado";
        telefonoCliente[0] = 58414925;
        tienePeliculaPrestada[0] = false;
        contadorClientes++;

        clienteId[1] = 2;
        nombreCliente[1] = "Karin Monterroso";
        telefonoCliente[1] = 42259075;
        tienePeliculaPrestada[1] = false;
        contadorClientes++;

        clienteId[2] = 3;
        nombreCliente[2] = "Edwin Maldonado";
        telefonoCliente[2] = 41515768;
        tienePeliculaPrestada[2] = false;
        contadorClientes++;
    }

    /**
     * Metodo inicializar pelicula, el cual inicializa las peliculas por defecto del sistema
     * Se generan datos para las primeras 5 posiciones de los arreglos de peliculas
     */
    public void inicializarPelicula(){
        peliculaId[0] = 1;
        nombrePelicula[0] = "Batman: El Caballero de la Noche";
        anioPelicula[0] = 2008;
        categoriaPelicula[0] = "Accion";
        peliculaDisponible[0] = true;
        contadorPeliculas++;

        peliculaId[1] = 2;
        nombrePelicula[1] = "Star Wars: La Venganza de los Sith";
        anioPelicula[1] = 2005;
        categoriaPelicula[1] = "Ciencia Ficcion";
        peliculaDisponible[1] = true;
        contadorPeliculas++;

        peliculaId[2] = 3;
        nombrePelicula[2] = "Hereditary";
        anioPelicula[2] = 2005;
        categoriaPelicula[2] = "Terror Psicologico";
        peliculaDisponible[2] = true;
        contadorPeliculas++;

        peliculaId[3] = 4;
        nombrePelicula[3] = "Como si Fuera la Primera Vez";
        anioPelicula[3] = 2005;
        categoriaPelicula[3] = "Romance";
        peliculaDisponible[3] = true;
        contadorPeliculas++;

        peliculaId[4] = 5;
        nombrePelicula[4] = "Tierra de Osos";
        anioPelicula[4] = 2005;
        categoriaPelicula[4] = "Infantil";
        peliculaDisponible[4] = true;
        contadorPeliculas++;
    }

    /**
     * Metodo para ingresar una nueva pelicula al sistema
     */
    public void IngresarPelicula(){
        /**
         * Se le solicita al usuario el ingreso de los datos para llenar los arreglos de cliente
         * Se le sugiere que siga una pauta para no perder una relacion en los id
         */
        System.out.println("\n");
        System.out.println("Para seguir un pauta, te recordamos que el siguiente id debe ser "+(contadorPeliculas+1));
        System.out.println("\n");
        System.out.println("Ingrese el id de la pelicula ");
        peliculaId[contadorPeliculas] = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la pelicula");
        nombrePelicula[contadorPeliculas] = scanner.nextLine();
        System.out.println("Ingrese el año de la pelicula");
        anioPelicula[contadorPeliculas] = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese la categoria de la pelicula");
        categoriaPelicula[contadorPeliculas] = scanner.nextLine();
        peliculaDisponible[contadorPeliculas] = true; 
        /**
         * Sumamos 1 al contador de peliculas
         */
        contadorPeliculas++;
    }

    /**
     * Metodo para visualizar peliculas en el sistema, el cual es iterable
     * @param posicion variable recibir la posicion de iteracion 
     */
    public void visualizarPeliculaEnSistema(int posicion){
        /**
         * Escribimos los datos de los arreglos en el indice "posicion"
         */
        System.out.println("\n");
        System.out.println("El id de la pelicula es: "+peliculaId[posicion]);
        System.out.println("El nombre de la pelicula es: "+nombrePelicula[posicion]);
        System.out.println("El anio de la pelicula es: "+anioPelicula[posicion]);
        System.out.println("La categoria de la pelicula es: "+categoriaPelicula[posicion]);
        /**
         * Bifurcacion para saber si la pelicula esta disponible
         */
        if(peliculaDisponible[posicion]==true){
            System.out.println("La pelicula "+nombrePelicula[posicion]+" esta disponible");
        }
        else if(peliculaDisponible[posicion]==false){
            System.out.println("La pelicula "+nombrePelicula[posicion]+" no esta disponible");
        } 
    }

    /**
     * Metodo para ingresar los datos de un nuevo cliente al sistema
     */
    public void ingresarCliente(){
        /**
         * Peticion de datos al usuario y posterior almacenamiento
         */
        System.out.println("\n");
        System.out.println("Para seguir una correlacion, te recordamos que el siguiente id en el sistema debe ser "+(contadorClientes+1));
        System.out.println("\n");
        System.out.println("Ingresa el id del cliente");
        clienteId[contadorClientes] = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa el nombre del cliente");
        nombreCliente[contadorClientes] = scanner.nextLine();
        System.out.println("Ingresa el telefono del cliente");
        telefonoCliente[contadorClientes] = scanner.nextInt();
        tienePeliculaPrestada[contadorClientes] = false;
        contadorClientes++;
    }

    /**
     * Metodo para mostrar clientes en el sistema, el cual es iterable
     * @param posicion variable posicion la cual es iterable
     */
    public void mostrarClienteEnSistema(int posicion){
        /**
         * Impresion de datos en los arreglos en el indice "posicion"
         */
        System.out.println("\n");
        System.out.println("El id del cliente es: "+clienteId[posicion]);
        System.out.println("El nombre del cliente es: "+nombreCliente[posicion]);
        System.out.println("El telefono del cliente es: "+telefonoCliente[posicion]);
        /**
         * Bifurcacion para saber si el cliente presto peliculas
         */
        if(tienePeliculaPrestada[posicion]==true){
            System.out.println("El cliente "+nombreCliente[posicion]+" presto al menos una pelicula");
        }
        else if(peliculaDisponible[posicion]==false){
            System.out.println("El cliente "+nombreCliente[posicion]+" no tiene peliculas prestadas");
        } 
    }

    /**
     * Metodo que retorna la eleccion de cliente para prestar una pelicula
     * @return retorna la variable entera eleccion de cliente 
     */
    public int escogerCliente(){
        /**
         * Imprimimos los clientes en el sistema y solicitamos que elija un cliente
         */
        int eleccionCliente =0;
        System.out.println("\n");
        System.out.println("Los clientes en el sistema son: ");
        for(int i=0; i<contadorClientes; i++){
            System.out.println((i+1)+") "+nombreCliente[i]);
        }
        System.out.println("\n");
        System.out.println("¿Qué cliente prestará una pelicula?");
        eleccionCliente = scanner.nextInt();
        return eleccionCliente;
    }

    /**
     * Metodo que retorna la eleccion de pelicula para poder prestarla
     * @return la variable entera eleccion de pelicula 
     */
    public int escogerPelicula(){
        /**
         * Mostramos las peliculas disponibles para poder elegir una
         */
        int eleccionPelicula = 0;
        System.out.println("\n");
        System.out.println("Las peliculas disponibles en el sistema son:");
        for(int i=0; i<contadorPeliculas; i++){
            if(peliculaDisponible[i]==true){
               System.out.println((i+1)+") "+nombrePelicula[i]+", año: "+anioPelicula[i]+", categoria: "+categoriaPelicula[i]);
            }
        }
        System.out.println("\n");
        System.out.println("¿Que pelicula desea prestar?");
        eleccionPelicula = scanner.nextInt();
        return eleccionPelicula;
    }

    /**
     * Metodo para prestar pelicula, el cual es para prestar mas de una pelicula por usuario
     */
    public void prestarPelicula(){
        /**
         * Pedimos cuantas peliculas desea prestar al usuario y mostramos la peliculas disponibles
         */
        int cantidadPeliculas=0;
        System.out.println("¿Cuantas peliculas deseas prestar?");
        cantidadPeliculas = scanner.nextInt();
        if(cantidadPeliculas>contadorPeliculas){
            System.out.println("Solo existen "+contadorPeliculas+" peliculas en el sistema");
        }
        else if(cantidadPeliculas<contadorPeliculas){
            do{
                int eleccionCliente = escogerCliente();
                int eleccionPelicula = escogerPelicula();
                peliculaDisponible[eleccionPelicula-1] = false;
                tienePeliculaPrestada[eleccionCliente-1] = true;
                peliculaPrestadaId[contador] = peliculaId[eleccionPelicula-1];
                clienteQuePrestoPelicula[contador] = clienteId[eleccionCliente-1];
                cantidadPeliculasPrestadas++;
                contador++;
            }while(cantidadPeliculasPrestadas<cantidadPeliculas);
        }
    }

    /**
     * Metodo devolver pelicula, el cual hace los llamados y devuelve las peliculas en cuestion
     */
    public void devolverPelicula(){
        /**
         * Guardamos los valores retornados de los metodos y seteamos la informacion obtenida
         */
        int opcionCliente=0;
        int opcionPelicula=0;
        System.out.println("\n");
        opcionCliente = verUsuariosConPeliculasPrestadas();
        opcionPelicula = verPeliculasPrestadasPorUsuario(opcionCliente);
        tienePeliculaPrestada[opcionCliente-1] = false;
        peliculaDisponible[opcionPelicula-1] = true;
    }

    /**
     * Metodo para visualizar que clientes han prestado peliculas y elegir uno para devolver 
     * @return variable entera eleccion que retorna el id del cliente elegido
     */
    public int verUsuariosConPeliculasPrestadas(){
        /**
         * Imprimimos los clientes con peliculas prestadas y retornamos al cliente elegido
         */
        int eleccion;
        for(int i=0; i<contadorClientes; i++){
            if(tienePeliculaPrestada[i]==true){
                System.out.println((clienteId[i])+") El cliente "+nombreCliente[i]+" tiene peliculas prestadas");
            }
        }
        System.out.println("Eliga el usuario que devolvera una pelicula");
        eleccion = scanner.nextInt();

        return eleccion;
    }

    /**
     * Metodo para visualizar las peliculas prestadas por el usuario, el cual retorna la eleccion de pelicula
     * @param clienteId para saber que cliente ha sido elegido por el usuario y que peliculas tiene prestadas
     * @return retornamos la variable entera eleccion, que es la eleccion de la pelicula
     */
    public int verPeliculasPrestadasPorUsuario(int clienteId){
        /**
         * Imprimimos las peliculas prestads por x cliente y almacenamos la pelicula elegida para devolver
         */
        int eleccion=0;
        System.out.println("\n");
        System.out.println("El cliente prestó las siguientes peliculas:");
        for(int i=0; i<contadorPeliculas; i++){
            if(clienteQuePrestoPelicula[i]==clienteId ){
                System.out.println(peliculaId[peliculaPrestadaId[i]-1]+") "+nombrePelicula[peliculaPrestadaId[i]-1]);
            }
        }
        System.out.println("Elige que pelicula devolvera");
        eleccion = scanner.nextInt();
        return eleccion;
    }

    /**
     * Metodo para saber cuantas peliculas hay por categoria
     */
    public void peliculasPorCategoria(){
        /**
         * Contadores para saber cuantas peliculas hay por categoria
         */
        int contadorCiencia=0, contadorAccion=0, contadorInfantil=0, contadorRomance=0, contadorTerror=0;
        /**
         * Ciclo para analizar cuantas peliculas hay en el arreglo de peliculas por categoria
         */
        for(int i=0; i<contadorPeliculas; i++){
            if(categoriaPelicula[i].equals("Ciencia Ficcion")){
                contadorCiencia++;
                System.out.println("La cantidad de peliculas de Ciencia Ficcion es: "+contadorCiencia);
            }
            else if(categoriaPelicula[i].equals("Romance")){
                contadorRomance++;
                System.out.println("La cantidad de peliculas de Romance es: "+contadorRomance);
            }
            else if(categoriaPelicula[i].equals("Accion")){
                contadorAccion++;
                System.out.println("La cantidad de peliculas de Accion es: "+contadorAccion);
            }
            else if(categoriaPelicula[i].equals("Terror Psicologico")){
                contadorTerror++;
                System.out.println("La cantidad de peliculas de Terror Psicologico es: "+contadorTerror);
            }
            else if(categoriaPelicula[i].equals("Infantil")){
                contadorInfantil++;
                System.out.println("La cantidad de peliculas Infantiles es: "+contadorInfantil);
            } 
        }
    }

    /**
     * Metodo para saber cual es la pelicula más prestadad en el sistema
     */
    public void peliculaMasPrestada(){
        /**
         * Metodo con ciclo for para almacenar el nombre de la pelicula, donde se repita mas su id en el arreglo de peliculas prestadas id
         */
        String peliculaMasPrestada="";
        for(int i=0; i<cantidadPeliculasPrestadas; i++){
            for(int j=0; j<contadorPeliculas; j++){
                if(peliculaPrestadaId[i]==peliculaId[j]){
                    peliculaMasPrestada =  nombrePelicula[peliculaId[j]];
                }
            }
        }
        System.out.println("La pelicula más prestada es: "+peliculaMasPrestada);
    }

    /**
     * Metodo para saber cual es la pelicula menos prestada en el sistema
     */
    public void peliculaMenosPrestada(){
        /**
         * Analizamos el arreglo peliculas prestadas con un for y el id de la pelicula que menos se repita es el que almacenaremos
         */
        String peliculaMenosPrestada="";
        for(int i=0; i<contadorPeliculas; i++){
            if(peliculaPrestadaId[i]!=peliculaId[i]){
                peliculaMenosPrestada = nombrePelicula[peliculaId[i]-1];
            }
        }
        System.out.println("La pelicula menos prestada es: "+peliculaMenosPrestada);
    }
}