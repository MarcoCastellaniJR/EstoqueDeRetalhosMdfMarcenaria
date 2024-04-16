import Integrator.client.Builder;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class GeradorDeImagemPeca {
    int cent = 100; // centralizador
    int profPeca = 600;
    int largPeca = 1200;
    int etiquetaWidth = largPeca + cent*2;
    int etiquetaHeight = profPeca + cent*2;
    int posX;
    int posY;
    // Cria uma imagem BufferedImage com o tamanho especificado


    BufferedImage image = new BufferedImage(etiquetaWidth, etiquetaHeight,
            BufferedImage.TYPE_INT_RGB);
    // Obtém o contexto gráfico para desenhar na imagem
    Graphics2D g2d = image.createGraphics();



    public String gerarEtiqueta(Mdf peca) {
        // Desenha um fundo branco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, etiquetaWidth , etiquetaHeight);

        float strokeWidth = 3.0f;
        g2d.setStroke(new BasicStroke(strokeWidth));



        // Desenha um retângulo azul da peça
        g2d.setColor(Color.BLUE);
        g2d.drawRect(cent, cent, largPeca+cent, profPeca+cent);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(cent,cent+10,largPeca+cent,cent+10);

        // Adiciona texto à Imagem
        String txt = peca.getNomeDaPeca() + ": " + etiquetaWidth + "x" + etiquetaHeight;
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString(txt, etiquetaWidth / 3, etiquetaHeight - 20);

        //int i=0;i<peca.listaDeFuracao.size();i++
        for(Builder builder : peca.getListaDeFuracao()){
            g2d.setColor(Color.RED);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            String json = gson.toJson(peca.getListaDeFuracao());
            String face = builder.getFace();
            if (face == "-A"){
                double posX = builder.getPosX();
                double posY = builder.getPosY();
                double depth = builder.getDepth();
                double diameter = builder.getDiameter();
                g2d.drawOval((int) (posX+(double)cent), (int) (posY+cent/2+25), (int) diameter
                        , (int) diameter);
            }
        }

//        g2d.setColor(Color.RED);
//        g2d.drawOval(posX+cent/2,posY+cent/2+25, 10, 10);
//        g2d.drawOval(etiquetaWidth-(posX+cent/2+10),posY+cent/2+25, 10, 10);
//        g2d.drawOval(posX+cent/2,5+etiquetaHeight-(posY+cent*2), 10, 10);
//        g2d.drawOval(etiquetaWidth-(posX+cent/2+10),5+etiquetaHeight-(posY+cent*2), 10, 10);



        // Libera os recursos gráficos
        g2d.dispose();

        // Salva a imagem no desktop
        String desktopPath =
                System.getProperty("user.home") + File.separator + "Desktop" +
                        "/img";
        File outputFile = new File(desktopPath, "output2.png");
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.println("Imagem gerada com sucesso e salva no desktop!");
        } catch (
                IOException e) {
            System.err.println("Erro ao salvar a imagem: " + e.getMessage());
        }
        return null;
    }
}

