package parcial;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class MesadasTest {

    @Test
    public void asd() throws IOException {
        Mesada mesada1 = new Mesada(4, 3);
        Mesada mesada2 = new Mesada(5, 3);
        Mesada mesada3 = new Mesada(1, 3);
        Mesada[] mesadas = {mesada1, mesada2, mesada3};
        Mesadas listaDeMesadas = new Mesadas(mesadas);
        listaDeMesadas.resolver();
        Assert.assertEquals(1, listaDeMesadas.getCantidadDePilas());
    }

    @Test
    public void asdfgwa() throws IOException {
        Mesadas listaDeMesadas = new Mesadas("C:\\Users\\Shorshi\\MesadasDeGranito\\pilitas.in");
        listaDeMesadas.resolver();
        Assert.assertEquals(3, listaDeMesadas.getCantidadDePilas());
    }

    @Test
    public void asdfwagwa() throws IOException {
        Mesadas listaDeMesadas = new Mesadas("C:\\Users\\Shorshi\\MesadasDeGranito\\fatiga.in");
        listaDeMesadas.resolver();
        Assert.assertEquals(3, listaDeMesadas.getCantidadDePilas());
    }

    @Test
    public void asdfwagwasdfwa() throws IOException {
        Mesadas listaDeMesadas = new Mesadas("C:\\Users\\Shorshi\\MesadasDeGranito\\esteNoFatiga.in");
        listaDeMesadas.resolver();
        Assert.assertEquals(1, listaDeMesadas.getCantidadDePilas());
    }
}