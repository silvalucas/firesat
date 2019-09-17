package Util;
import java.io.*;

public class UtilPpm {
    public static String[] LeArquivoPpm(String caminho) {
        String texto = "";
        try {
            File file = new File(caminho);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String aux;
            while ((aux = br.readLine()) != null) {
                texto += aux + " ";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto.split(" ");
    }

}
