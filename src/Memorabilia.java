package src;
import java.util.*;
public class Memorabilia{
    public static void main(String[] args){
        Memorabilia memorabilia = new Memorabilia();
    }

    public Memorabilia(){
        mensajeDeBienvenida();
        menuPrincipal();
    }

    Scanner scanner = new Scanner(System.in);

    
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

    int contadorPeliculas=0;

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
                            visualizarPeliculasEnSistema(i);
                        }
                    }
                    break;
                   
                case 4:
                    IngresarPeliculas();
                    break;
            
                case 5:
                    System.out.println("Submenu 5");
                    break;
                
                case 6:
                    System.out.println("Submenu 6");
                    break;     

                case 7:
                    menuReportes();
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
    public void menuReportes(){
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

    public void IngresarPeliculas(){
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

    public void visualizarPeliculasEnSistema(int posicion){
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
}