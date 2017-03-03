package cifradocesar;
import java.util.Scanner;
/**
 * @author Anggy Arguello - Holmes Ayala
 */
/**
 * 
 * Clase principal
 */
public class CifradoCesar {
    Scanner leer = new Scanner(System.in);
    String texto;
    int opcion, clave, letra;
    char[] abecedario={'a','b','c','d','e','f','g','h','i','j','k','l','m',
        'n','o','p','q','r','s','t','u','v','w','x','y','z',' ',';',','};
    char[]textoUno;
    
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
    /**
     * En este metodo se encuentra el menu de seleccion
     */
    public void menuCifrado(){
        boolean validar;
        //Valida que la opcion sea correcta
        do{
            validar = true;
            System.out.println("Ingrese");
            System.out.print("1. Cifrar o 2.Descifrar: ");
            opcion = leer.nextInt();
            if(opcion < 1 || opcion > 2){
                System.out.println("Opcion no valida!");
                validar = false;
            }
        }while(!validar);
        //Valida que la clave no sea 0 o tenga un numero negativo
        do{
            validar = true;
            System.out.println("Ingrese la clave");
            clave = leer.nextInt();
            if(clave <= 0){
                System.out.println("Clave no valida.");
                validar = false;
            }
        }while(!validar);
    }
    /**
     * Este metodo nos recibe el texto
     */
    public void solicitarTexto(){
        switch(opcion){
            case 1:
               System.out.println("Ingrese el texto a cifrar: ");
                leer.nextLine();
                texto = leer.nextLine(); 
                break;
            case 2:
                System.out.println("Ingrese el texto a descifrar: ");
                leer.nextLine();
                texto = leer.nextLine();
                break;
        }
        //Pasamos la cadena a un arreglo 
        textoUno = texto.toCharArray();
        
    }
    /**
     * Este metodo cifra el texto ingresado
     */
    public void cifrarTexto(){
        System.out.println();
        System.out.println("Texto cifrado:");
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
                if(j == textoUno.length){
                    break;
                }
            }
        }
        System.out.println();
    }
    /**
     * Este metodo descifra el texto ingresado si la opcion lo pide
     */
    public void descifrarTexto(){
        System.out.println();
        System.out.println("Texto descifrado:");
        int j = 0;
        for(int i = 0; i < abecedario.length; i++){
           // System.out.println(i);
            if(textoUno[j] == abecedario[i]){
                letra = 0;
                int contadorAtras = i;
                //  Lo que hace es retroceder en el abecedario un numero de veces
                //  igual a la clave Ejem: clave = 15 -> retrocede 15 veces y si
                //  llega a la posicion [0] retoma en la posicion [28]
                while(contadorAtras < abecedario.length){
                    contadorAtras--;
                    letra++;
                    if(contadorAtras == -1){
                        contadorAtras = abecedario.length - 1;
                    }
                    if(letra == clave){
                        letra = contadorAtras;
                        i = -1;
                        j++;
                        break;
                    }
                }
                System.out.print(abecedario[letra]);
                if(j == textoUno.length){
                    break;
                }
            }
        }
        System.out.println();
    }   
    
    public static void main(String[] args) {
        CifradoCesar cifradoCesar = new  CifradoCesar();
    }
    
}