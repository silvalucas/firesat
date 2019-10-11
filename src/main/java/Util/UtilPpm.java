package Util;
import Modelo.Imagem;

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
    public static String matrizImagemToString(Imagem[][] imagem) {
        StringBuilder txt = new StringBuilder();
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                txt.append(imagem[i][j].getRed()).append(" ").
                        append(imagem[i][j].getGreen()).append(" ").
                        append(imagem[i][j].getBlue()).append(" ");
            }
            txt.deleteCharAt(txt.length() - 1);
            txt.append("\r\n");
        }
        return txt.toString();
    }

}
