package Modelo;

import java.io.*;
import java.util.ArrayList;

public class ImagemPpm {
    private int red;
    private int green;
    private int blue;

    public ImagemPpm() {
    }

    public ImagemPpm(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public String[] LeArquivo(String nome) {
        String texto = "";
        try {
            File file = new File(nome);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String aux;
            while ((aux = br.readLine()) != null) {
                //  if (br.readLine() != null) {
                texto += aux + " ";
                // }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return texto.split(" ");
    }

    public void MontaClasse() {
        String cores[] = LeArquivo("lagoa.ppm");
        ArrayList<ImagemPpm> array = new ArrayList<>();
        ImagemPpm imagem = new ImagemPpm();
        int aux = 0;
        for (int i = 4; i < cores.length; i++) {

            switch (aux) {
                case 0:
                    imagem.setRed(Integer.parseInt(cores[i]));
                    break;
                case 1:
                    imagem.setGreen(Integer.parseInt(cores[i]));
                    break;
                case 2:
                    imagem.setBlue(Integer.parseInt(cores[i]));
                    break;
                case 3:
                    array.add(imagem);
                    imagem = new ImagemPpm();
                    aux = -1;
                    i--;
                    break;
            }
            if(i==cores.length-1){
                array.add(imagem);
            }
            aux++;

        }


        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "ImagemPpm{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }
}
