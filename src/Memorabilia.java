/**
 * Definimos la carpeta donde se encuentra nuestro codigo fuente
 * E importamos todas las clases del paquete java util
 */
package src;
import java.util.*;
public class Memorabilia{
    public static void main(String[] args){
        /**
         * Instanciamos objeto para evitar problemas con el ambito estatico
         */
        Memorabilia memorabilia = new Memorabilia();
    }

    /**
     * Constructor de la clase donde se hacen los llamados a los metodos correspondientes
     */
    public Memorabilia(){
        /**
         * Damos un mensaje de bienvenida e imprimimos el menu principal
         */
        mensajeDeBienvenida();
        menuPrincipal();
    }

    /**
     * Instanciamos un objeto de la clase scanner para poder leer desde consola
     */
    Scanner scanner = new Scanner(System.in);

    /**
     * Conjunto de arreglos, los cuales nos permitiran almacenar la informacion ingresadad por el usuario
     */
    int[] clienteId = new int[50];
    String[] nombreCliente = new String[50];
    int[] telefonoCliente = new int[50];
    boolean[] tienePeliculaPrestada = new boolean[50];
    int[] peliculaId = new int[50];
    String[] nombrePelicula = new String[50];
    String[] categoriaPelicula = new String[50];
    int[] anioPelicula = new int[50];
    boolean[] peliculaDisponible = new boolean[50];
    int[] peliculaPrestadaId = new int[50];
    int[] clienteQuePrestoPelicula = new int[50];
    int[] cantidadDiasPrestamo = new int[50];

    /**
     * Variables enteras para saber cuantos clientes y peliculas en el sistema
     */
    int contadorPeliculas=0, contadorClientes=0;

    /**
     * Metodo para imprimir mensaje de bienvenida en pantalla
     */
    public void mensajeDeBienvenida(){
        System.out.println("Bienvenido a Memorabilia");
        System.out.println("En nuestro sistema puedes prestar peliculas y verlas desde la comodidad de tu casa");
        System.out.println("\n");
    }

    /**
     * Metodo para navegar por el menu principal
     */
    public void menuPrincipal(){
        boolean salir = false;
        int opcion=0;
        do{
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
            switch (opcion) {
                case 1:
                    System.out.println("Submenu 1");
                    break;
            
                case 2:
                    System.out.println("Submenu 2");
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
        int opcion = 0;
        boolean salir = false;

        do{
            System.out.println("\n");
            System.out.println("1) Revisar cantidad de peliculas por categoria");
            System.out.println("2) Peliculas por categoria especifica");
            System.out.println("3) Cantidad de veces que se presto una pelicula");
            System.out.println("4) Pelicula mas prestada");
            System.out.println("5) Pelicula menos prestada");
            System.out.println("6) Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Revisar cantidad de peliculas por categoria");
                    break;
                
                case 2:
                    System.out.println("Peliculas por categoria especifica");
                    break;
                    
                case 3:
                    System.out.println("Cantidad de veces que se presto una pelicula");
                    break;
                
                case 4:
                    System.out.println("Pelicula mas prestada");
                    break;  
                
                case 5:
                    System.out.println("Pelicula menos prestada");
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
     * Metodo para ingresar una nueva pelicula al sistema
     */
    public void IngresarPelicula(){
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
        contadorPeliculas++;
    }

    /**
     * Metodo para visualizar peliculas en el sistema, el cual es iterable
     * @param posicion
     */
    public void visualizarPeliculaEnSistema(int posicion){
        System.out.println("\n");
        System.out.println("El id de la pelicula es: "+peliculaId[posicion]);
        System.out.println("El nombre de la pelicula es: "+nombrePelicula[posicion]);
        System.out.println("El anio de la pelicula es: "+anioPelicula[posicion]);
        System.out.println("La categoria de la pelicula es: "+categoriaPelicula[posicion]);
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
     * @param posicion
     */
    public void mostrarClienteEnSistema(int posicion){
        System.out.println("\n");
        System.out.println("El id del cliente es: "+clienteId[posicion]);
        System.out.println("El nombre del cliente es: "+nombreCliente[posicion]);
        System.out.println("El telefono del cliente es: "+telefonoCliente[posicion]);
        if(tienePeliculaPrestada[posicion]==true){
            System.out.println("El cliente "+nombreCliente[posicion]+" presto al menos una pelicula");
        }
        else if(peliculaDisponible[posicion]==false){
            System.out.println("El cliente "+nombreCliente[posicion]+" no tiene peliculas prestadas");
        } 
    }
}