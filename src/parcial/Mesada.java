package parcial;

public class Mesada {
    private int largo;
    private int ancho;

    public Mesada(int largo, int ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    public void intercambiarDimensiones(){
        int aux;
        aux = ancho;
        ancho = largo;
        largo = aux;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public boolean esCompatible(Mesada mesada) {
        return this.getAncho() >= mesada.getAncho();
    }
}
