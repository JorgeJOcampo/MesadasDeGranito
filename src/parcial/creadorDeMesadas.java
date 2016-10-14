package parcial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class creadorDeMesadas {
    public static void main(String args[]) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Shorshi\\MesadasDeGranito\\fatiga.in"));
        pw.println(200000);
        for(int i = 1; i <= 200000 ; i+=1){
            int j = 1000000-i;
            pw.println(i + " " + j);
        }
        pw.close();
    }
}
