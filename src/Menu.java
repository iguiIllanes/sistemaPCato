/*
*
* un programa para una tienda que te muestre
* EL NOMBRE DEL ULTIMO CLIENTE
* EL PRODUCTO QUE COMPRO
* EL PRECIO
* LA CLAVE DEL PRODUCTO
*
* */

import java.util.Scanner;

public class Menu  extends utils.Utils{ //creamos la clase menu
    boolean exit = false;


//    public static void main(String[] args){
//        Menu menu = new Menu();
//        menu.runMenu();
//    }

    public void runMenu(){
        printHeader();
        while (!exit){
            printMenu();
            int eleccion = getInput();
            realizarEleccion(eleccion);
        }
    }


    private void printHeader(){ //Creamos el metodo printHeader para imprimir esto al inicio del programa
        System.out.println("--------------------");
        System.out.println("|    Bienvenido    |");
        System.out.println("|    Al Sistema    |");
        System.out.println("--------------------");
    }

    private void printMenu(){
        System.out.println("\nPorfavor escoge una opcion:");
        System.out.println("(1) Ultimas Compras");
        System.out.println("(2) Añadir o quitar productos");
        System.out.println("(3) Registrar Compra");
        System.out.println("(0) Salir");
    }


    private int getInput(){
        Scanner kb = new Scanner(System.in);
        int eleccion = -1;
        while(eleccion < 0 || eleccion > 3){
            try{
                System.out.print("\nEscoge una opcion: ");
                eleccion = Integer.parseInt(kb.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Seleccion invalida, porfavor intenta de nuevo.");
            }
        }
        return eleccion;
    }

    private void realizarEleccion(int eleccion){
        switch (eleccion){
            case 0:
                exit = true;
                break;
            case 1: // Ultimas compras
                setArchivo("UltimasCompras.txt");
                leerArchivo();
                break;

            case 2: //Anadir o quitar productos
                System.out.println("Opcion 2");
                break;
            case 3: // registrar compra
                setArchivo("UltimasCompras.txt");
                registrarCompra();
                break;
            default:
                System.out.println("Ha ocurrido algun error, intenta de nuevo.");
        }
    }
}
