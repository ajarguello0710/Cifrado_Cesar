package cifradocesar;
import java.lang.Math;
import java.util.Scanner;
/**
 * @author Anggy Arguello - Holmes Ayala
 */
public class CifradoCesar {
    Scanner leer = new Scanner(System.in);
    String texto;
    int opcion, clave, letra;
    char[] abecedario={'a','b','c','d','e','f','g','h','i','j','k','l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y','z',32,';',','};
    char[] textoUno;
    
    public CifradoCesar(){//Constructor, aqui se llaman los metodos
        menuCifrado();
        solicitarTexto();
        if(opcion == 1){
            cifrarTexto();
        }
        else if(opcion == 2){
            descifrarTexto();
        }
    }
    private void menuCifrado(){
        System.out.println("Ingrese: ");
        System.out.println("1. Cifrar o 2.Descifrar  ");
        opcion = leer.nextInt();
        System.out.println("Ingrese la clave");
        clave = leer.nextInt();
    }
    
    private void solicitarTexto(){
        switch(opcion){
            case 1:
               System.out.println("Ingrese el texto a cifrar: ");
                leer.nextLine();
                texto = leer.nextLine(); 
                break;
            case 2:
                System.out.println("Ingrese el texto a descifrar");
                leer.nextLine();
                texto = leer.nextLine();
                break;
            case 3:
                System.out.println("Opcion Invalida");
                break;
        }
        //Pasamos la cadena a un arreglo 
        textoUno = texto.toCharArray();
        
    }
    
    private void cifrarTexto(){
        int j = 0;
        for(int i = 0; i < abecedario.length; i++){
           //System.out.println(i);
            if(textoUno[j] == abecedario[i]){
                letra = (clave + i) % abecedario.length;
                //System.out.println(letra);
                System.out.print(abecedario[letra]);
                //System.out.print(abecedario.length);
                i = -1;
                j++;
            }
        }
    }
    
    private void descifrarTexto(){
        int j = 0;
        for(int i = 0; i < abecedario.length; i++){
           // System.out.println(i);
            if(textoUno[j] == abecedario[i]){
                letra = (clave - i) % abecedario.length;
                letra = Math.abs(letra);
                //System.out.println(letra);
                System.out.print(abecedario[letra]);
                i = -1;
                j++;
            }
        }
    }   
    
    public static void main(String[] args) {
        CifradoCesar cifradoCesar = new  CifradoCesar();
    }
    
}
