package Controle;

import Modelo.Imagem;
import Util.UtilPpm;

public class ImagemControle {

    public Imagem[][] MontaMatriz(String caminho) {
        String cores[] = UtilPpm.LeArquivoPpm(caminho);

        Imagem imagem[][] = new Imagem[400][300];

        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                imagem[i][j] = new Imagem();
            }
        }
        int aux = 4;
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                imagem[i][j].setRed(Integer.parseInt(cores[aux++]));
                imagem[i][j].setGreen(Integer.parseInt(cores[aux++]));
                imagem[i][j].setBlue(Integer.parseInt(cores[aux++]));

            }
        }
        return imagem;
    }
}
