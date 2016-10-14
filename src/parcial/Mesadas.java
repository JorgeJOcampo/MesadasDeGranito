package parcial;

import java.io.*;
import java.util.*;

public class Mesadas {
    private int cantidadDeMesadas;
    private List<Mesada> mesadas;
    private int cantidadDePilas = 0;

    public int getCantidadDePilas() {
        return cantidadDePilas;
    }

    public Mesadas(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        cantidadDeMesadas = sc.nextInt();
        mesadas = new ArrayList<>();
        while(sc.hasNext()){
            mesadas.add(new Mesada(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
    }

    public Mesadas(List<Mesada> mesadas){
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
        Iterator it = mesadas.iterator();
        while(it.hasNext()){
            while(it.hasNext()){
                Mesada mesada = (Mesada) it.next();
                Mesada mesadaEliminada = mesada.clone();
                it.remove();
                while(it.hasNext()){
                    mesada = (Mesada) it.next();
                    if(mesadaEliminada.esCompatible(mesada)){
                        it.remove();
                    }
                }
                cantidadDePilas++;
            }
            it = mesadas.iterator();
        }
    }

    private void ordenarPorLargo() {
        Mesada aux;

        for(int i=1;i<cantidadDeMesadas;i++){
            aux=mesadas.get(i);
            for(int j=i-1;j>=0 && aux.getLargo()>mesadas.get(j).getLargo();j-- ){
                mesadas.set(j+1, mesadas.get(j));
                mesadas.set(j, aux);
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
