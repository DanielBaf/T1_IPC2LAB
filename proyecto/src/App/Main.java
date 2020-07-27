package App;

import java.util.Scanner;

public class Main{
    
    static Scanner in = new Scanner(System.in);
    static char [] pal1;
    static char [] pal2;
    static String match, ADN1, ADN2;
    
    public Main () {
        
    }
    
    public void setADNs(String ADN1, String ADN2){
        this.ADN1 = ADN1;
        pal1 = ADN1.toCharArray();
        this.ADN2 = ADN2;
        pal2 = ADN2.toCharArray();
        int menor;
        
        menor = calcularPalabraMenor(ADN1,ADN2);//para ver cuál comparará
        
        switch (menor){
            case 1: compP1(); break;
            case 2: compP2(); break;
        }
    }

    /**
     * Este metodo nos devuelve cual palabra es menor en longitud
     */
    public static int calcularPalabraMenor(String t1, String t2){
        if(t1.length() < t2.length())
            return 1;
        else if (t1.length() > t2.length())
            return 2;
        return 1;
    }

    /**
     * buscamo coincidencias de palabras de 2, 3, 4 hasta el no de letras que tenga
     * la palabra mas corta
     */
    private static void compP1() {
        
        boolean coincidencia = false, continuar = true;
        String busqueda = "", auxiliar = "", temporal = "";
        int cantidad = 2, pos = 0;
        
        do{
            busqueda = "";//reiniciamos la palabra que se busca
            //generamos una palabra para la busqueda
            if (cantidad + pos <= pal1.length){
                for (int i = pos; i < pos + cantidad; i++){
                    busqueda += pal1[i];
                }
            }else{
                if (cantidad == pal1.length)
                    coincidencia = true;
                if (pos > pal1.length){
                    pos = -1;
                    cantidad++;
                }
            }
            
            //busqueda de la palabra
            for (int i = 0; i <= pal2.length - cantidad; i++){
                auxiliar = "";//reiniciamos el auxiliar
                for (int j = 0; j < cantidad; j++){
                    auxiliar += pal2[i+j];
                }
                if (auxiliar.equalsIgnoreCase(busqueda)){
                    temporal = auxiliar;
                }else{
                }
            }
            pos++;
        }while(coincidencia == false && continuar == true);
        
        Main.match = temporal;
        
    }

    private static void compP2() {
        
        boolean coincidencia = false, continuar = true;
        String busqueda = "", auxiliar = "", temporal = "";
        int cantidad = 2, pos = 0;
        
        do{
            busqueda = "";//reiniciamos la palabra que se busca
            //generamos una palabra para la busqueda
            if (cantidad + pos <= pal2.length){
                for (int i = pos; i < pos + cantidad; i++){
                    busqueda += pal2[i];
                }
            }else{
                if (cantidad == pal2.length)
                    coincidencia = true;
                if (pos > pal2.length){
                    pos = -1;
                    cantidad++;
                }
            }
            
            //busqueda de la palabra
            for (int i = 0; i <= pal1.length - cantidad; i++){
                auxiliar = "";//reiniciamos el auxiliar
                for (int j = 0; j < cantidad; j++){
                    auxiliar += pal1[i+j];
                }
                if (auxiliar.equalsIgnoreCase(busqueda)){
                    temporal = auxiliar;
                }else{
                }
            }
            pos++;
        }while(coincidencia == false && continuar == true);
        
        Main.match = temporal;
    }
    
    public String getPalabra(){
        return Main.match;
    }
}
