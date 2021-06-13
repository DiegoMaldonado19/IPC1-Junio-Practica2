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

    /*
    int[] clienteId = new int[];
    String[] nombre = new String[];
    int[] telefonoCliente = new int[];
    boolean[] tienePeliculaPrestada = new boolean[];
    int[] peliculaId = new int[];
    String[] nombrePelicula = new String[];
    String[] categoriaPelicula = new String[];
    boolean[] peliculaDisponible = new boolean[];
    int[] peliculaPrestadaId = new int[];
    int[] clienteQuePrestoPelicula = new int[];
    int[] cantidadDiasPrestamo = new int[];
    */

    public void mensajeDeBienvenida(){
        System.out.println("Bienvenido a Memorabilia");
        System.out.println("En nuestro sistema puedes prestar peliculas y verlas desde la comodidad de tu casa");
        System.out.println("\n");
    }

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
                    System.out.println("Submenu 3");
                    break;
                   
                case 4:
                    System.out.println("Submenu 4");
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
}