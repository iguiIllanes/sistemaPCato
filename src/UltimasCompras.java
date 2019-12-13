import java.io.*;

public class UltimasCompras {


    String filename = "UltimasCompras.txt";

    String line = null;

    void leerArchivoCompras (){
        try{
            FileReader fr = new FileReader(filename);

        }catch (FileNotFoundException ex){
            System.out.println("No se encontro el archivo \'UltimasCompras.txt\' Te gustaria crearlo?");
        }
    }

}
