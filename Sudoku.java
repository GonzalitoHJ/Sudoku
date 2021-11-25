import java.util.ArrayList;

public class Sudoku{

    private static ArrayList<Integer> numeros;  //mejor stack()??
    public static void main(String args[]){
        //leer input

        numeros = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++){
            numeros.set(i, i);
        }

        if (resolverCasillaSiguiente() != null){
            System.out.println("Programa finalizado con éxito");
        }
    }

    private static Integer resolverCasillaSiguiente(){

        //avanzar a la siguiente posicion del tablero y recalcular la variable "numeros"

        //CASO TRIVIAL:
        //estamos en la ultima posicion del tablero con un unico candidato
        //if (casillaFinal)
        int nCandidatos = numeros.size(); 
        if (nCandidatos != 1){
            System.err.println("Hemos llegado a la última casilla y hay " + nCandidatos + " candidatos");
        }
        //return numeros.get(0);

        //CASO GENERAL:
        Integer candidato, siguiente;
        int i = 0;
        do{  
            if (numeros.isEmpty())  return null;    //NO HAY CANDIDATOS
            candidato = numeros.get(i++);           //COGEMOS UN CANDIDATO
            rellenarCasilla();                      //LO ESCRIBIMOS EN LA CASILLA
            siguiente = resolverCasillaSiguiente(); //LLAMADA RECURSIVA PARA SIG. CASILLA
        } while (siguiente == null);                //ESE CANDIDATO NO ERA EL BUENO, VOLVEMOS

        numeros.remove(candidato);                  //ELIMINAMOS AL CANDIDATO, POR SER EL ELEGIDO
        return candidato;
    }

    private static void rellenarCasilla(/*int i, int j*/){
        
    }

}