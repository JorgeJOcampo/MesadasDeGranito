package parcial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Mesadas {
    private int cantidadDeMesadas;
    private Mesada[] mesadas;
    private int cantidadDePilas;

    public int getCantidadDePilas() {
        return cantidadDePilas;
    }

    public Mesadas(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        cantidadDeMesadas = sc.nextInt();
        for(int i = 0 ; i < cantidadDeMesadas ; i++){
            mesadas[i] = new Mesada(sc.nextInt(), sc.nextInt());
        }
    }

    public Mesadas(Mesada[] mesadas){
        cantidadDeMesadas = 3;
        this.mesadas = mesadas;
    }

    public void resolver(){
        acomodarPorDimension();
        ordenarPorLargo();
        cantidadDePilas = 0;
        for(int i = 0 ; i < cantidadDeMesadas ; i++){
            if(mesadas[i].getLargo() != 0){
                mesadas[i].setLargo(0);
                for(int j = i ; j < cantidadDeMesadas ; j++){
                    if(mesadas[i].esCompatible(mesadas[j])){
                        mesadas[j].setLargo(0);
                    }
                }
                cantidadDePilas++;
            }
        }
    }

    private void ordenarPorLargo() {
        Mesada aux;

        for(int i=1;i<cantidadDeMesadas;i++){
            aux=mesadas[i];
            for(int j=i-1;j>=0 && aux.getLargo()>mesadas[j].getLargo();j-- ){
                mesadas[j+1]=mesadas[j];
                mesadas[j]=aux;
            }
        }
    }

    private void acomodarPorDimension() {
        for(Mesada mesada : mesadas){
            if(mesada.getAncho() > mesada.getLargo()){
                mesada.intercambiarDimensiones();
            }
        }
    }

}
