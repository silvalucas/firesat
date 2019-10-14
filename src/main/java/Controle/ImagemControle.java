package Controle;

import Modelo.Imagem;
import Util.UtilPpm;

public class ImagemControle {
    private final int x = 20;
    private final int y = 20;

    public Imagem[][] MontaMatriz(String caminho) {
        String cores[] = UtilPpm.LeArquivoPpm(caminho);
        Imagem imagem[][] = new Imagem[x][y];
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                imagem[i][j] = new Imagem();
            }
        }
        int aux = 4;
        System.out.println(cores.length);
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                imagem[i][j].setRed(Integer.parseInt(cores[aux++]));
                imagem[i][j].setGreen(Integer.parseInt(cores[aux++]));
                imagem[i][j].setBlue(Integer.parseInt(cores[aux++]));

            }
        }
        return imagem;
    }

    public int contadorFogo(Imagem imagem[][]) {
        int contRed = 0;
        for (int i = 0; i < imagem.length; i++) {
            for (int j = 0; j < imagem[i].length; j++) {
                if (imagem[i][j].getRed() == 255) {
                    contRed++;
                }
            }
        }
        return contRed;
    }

    public static String retornaAumento(float valFinal, float valInicial) {
        float total = valFinal - valInicial;
        if (total == 0) {
            return "Sem aumento ou diminuicao";
        }
        if (total < 0) {
            return "Diminuiu " + ((Math.abs(total))) + "%";
        }
        return "Aumentou " + ((Math.abs(total))) + "%";
    }
}
