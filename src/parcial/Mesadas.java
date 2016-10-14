package parcial;

import java.io.*;
import java.util.*;

public class Mesadas {
    private int cantidadDeMesadas;
    private Mesada[] mesadas;
    private int cantidadDePilas = 0;

    public int getCantidadDePilas() {
        return cantidadDePilas;
    }

    public Mesadas(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        cantidadDeMesadas = sc.nextInt();
        mesadas = new Mesada[cantidadDeMesadas];
        for(int i = 0 ; i < cantidadDeMesadas ; i++){
            mesadas[i] = new Mesada(sc.nextInt(), sc.nextInt());
        }
        sc.close();
    }

    public Mesadas(Mesada[] mesadas){
        this.mesadas = mesadas;
    }

    public void resolver() throws IOException {
        acomodarPorDimension();
        ordenarPorLargo();
        contarPilas();
        grabar("C:\\Users\\Shorshi\\MesadasDeGranito\\pilas.out");
    }

    private void grabar(String path) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(path));
        pw.println(cantidadDePilas);
        pw.close();
    }

    private void contarPilas() {
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
