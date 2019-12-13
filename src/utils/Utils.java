package utils;


import java.io.*;
import java.util.Scanner;


public class Utils {
    private String filename;

    String line = null;


    Scanner sc = new Scanner(System.in);

    public void leerArchivo(){
        try{
            FileReader fr =  new FileReader(filename);

            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch (FileNotFoundException ex){
            System.out.println("No se encontró ningun archivo con el nombre de \'" + filename + "\' o no se tienen los permisos necesarios. te gustaria crear uno nuevo? (y/n)");
            char choice;
            choice = sc.nextLine().charAt(0);
            if(choice == 'y' || choice == 'Y'){
                System.out.println(filename);
                crearAchivo();
            }else{
                System.out.println("Entrada no valida. Intenta de nuevo");
            }

        }catch(IOException ex){
            System.out.println("No se pudo leer el archivo " + filename);
        }
    }

//    public String getArchivo(){
//        return filename;
//    }

    public void setArchivo(String s){
        filename = s;
    }



    public void crearAchivo(){
        File file = new File(filename);
        boolean result;

        try{
            result = file.createNewFile();
            if(result){
                System.out.println("Se creo el archivo " + filename + " de manera satisfactoria.");
            }else{
                System.out.println("El archivo " +filename+ "ya existe.");
            }

        }catch (IOException ex){
            System.out.println("Ha ocurrido un error, intenta de nuevo");

            ex.printStackTrace();
        }
    }

    boolean existeArchivo(){
        File file = new File(filename);
        if(file.exists()){
            return  true;
        }else{
            return false;
        }
    }


    public void registrarCompra(){
        if(existeArchivo()){
            try{
                FileWriter fileWriter = new FileWriter(filename);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                String nombre;
                int codigoDeProducto;

                System.out.println("Introduce el nombre del cliente");
                nombre = sc.nextLine();
                printWriter.print(nombre);

                printWriter.print(" | ");

                System.out.println("Introduce el codigo del producto");
                codigoDeProducto = sc.nextInt();
                printWriter.print(codigoDeProducto + "\n");

                printWriter.close();
            }catch (IOException ex) {
                System.out.println("Se produjo un error, intenta de nuevo.");
            }

        }else{
            System.out.println("No existe ningun archivo para el registro de compras. te gustaria crear uno?");
            char choice;
            choice = sc.nextLine().charAt(0);
            if(choice == 'y' || choice == 'Y'){
                crearAchivo();
                registrarCompra();
            }else{
                System.out.println("Entrada no valida, intenta de nuevo.");
            }
        }
    }
}
