/**
 * Esta es la clase que permite ingresar y mostrar datos.
 * Universidad del Valle de Guatemala
 * @author: Mark Albrand
 * @author: Jimena Hernández
 * @author: Emily Pérez
 * @version: 2-mar-22
 */

/**
 * imports
 */
import java.util.Scanner;

public class Vista {
    private Scanner scan = new Scanner(System.in);

    /**
    * @param: String
    * imprime texto
    **/ 
    public void mensaje(String mensaje){
        System.out.println(mensaje);
    }

    /**
     * Bienvenida del interprete
     */
    public void inicio(){
        System.out.println("\n Interprete Lisp 0.0.1 (grupo 5) AED ");
    }

    /**
     * 
     * @return operacion
     */
    public String getOperacion(){

        System.out.printf("\n >>> ");
        String operacion = scan.nextLine();
        return operacion;
    }

    /**
    * metodo para salir 
    * 
    */
    public void salida(){

        String salidatexto= scan.nextLine();

        if(salidatexto == "(EXIT)"){
           mensaje(">>>");
           System.exit(0);
        }
    }  
    



}