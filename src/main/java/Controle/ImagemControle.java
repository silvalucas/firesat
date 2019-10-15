package Controle;

import Modelo.Imagem;
import Util.UtilPpm;

/*Classe para interpretação de dados do objeto Imagem
 * @version 0.0.1
 * @author Nikollas Ferreira
 * @since 15/10/2019
 */

public class ImagemControle {
    private final int x = 20;
    private final int y = 20;

    /* Método que recebe o nome do arquivo, gera uma string dos dados do arquivo e transforma em uma matriz
     * @author Nikollas Ferreira
     * @since 15/10/2019
     * @return Imagem[][]
     */
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

    /* Método que recebe uma matriz RGB e interpreta os pixels que estão com cor vermelha(255)
     * @author Nikollas Ferreira
     * @since 15/10/2019
     * @return int
     */
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

    /* Método que interpreta se os incêncidos estão aumentando, diminuindo ou estáveis na região
     * @author Nikollas Ferreira
     * @since 15/10/2019
     * @return String
     */
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
