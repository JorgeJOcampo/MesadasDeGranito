package parcial;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MesadasTest {

    @Test
    public void asd(){
        Mesada mesada1 = new Mesada(4, 3);
        Mesada mesada2 = new Mesada(5, 3);
        Mesada mesada3 = new Mesada(1, 3);
        Mesada[] mesadas = {mesada1, mesada2, mesada3};
        Mesadas listaDeMesadas = new Mesadas(mesadas);
        listaDeMesadas.resolver();
        Assert.assertEquals(1, listaDeMesadas.getCantidadDePilas());
    }
}