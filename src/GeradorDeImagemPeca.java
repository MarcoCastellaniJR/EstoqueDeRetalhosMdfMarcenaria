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
import javax.imageio.ImageIO;

public class GeradorDeImagemPeca {
    int cent = 100; // centralizador
    int profPeca;
    int largPeca;
    int etiquetaWidth;
    int etiquetaHeight;

    // Cria uma imagem BufferedImage com o tamanho especificado






    public String gerarEtiqueta(Mdf peca) {
        this.profPeca = peca.getProf();
        this.largPeca = peca.getLarg();
        this.etiquetaHeight = peca.getProf()+cent*2;
        this.etiquetaWidth = peca.getLarg()+cent*2;

        BufferedImage image = new BufferedImage(etiquetaWidth, etiquetaHeight,
                BufferedImage.TYPE_INT_RGB);
        // Obtém o contexto gráfico para desenhar na imagem
        Graphics2D g2d = image.createGraphics();

        // Desenha um fundo branco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0,etiquetaWidth,etiquetaHeight);

        float strokeWidth = 3.0f;
        g2d.setStroke(new BasicStroke(strokeWidth));



        // DESENHA A PEÇA EM SI
        g2d.setColor(Color.BLUE);
        g2d.drawRect(cent, cent, largPeca, profPeca);
        //g2d.setColor(Color.BLACK);
        //g2d.drawLine(cent,cent+10,largPeca+cent,cent+10);

        // ADICIONA TEXTO NA ETIQUETA
        String txt = peca.getNomeDaPeca() + ": " + largPeca + "x" + profPeca;
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString(txt, etiquetaWidth / 3, etiquetaHeight - 20);

        // GERAR FURAÇÕES DE BROCAS
        for(Builder builder : peca.getListaDeFuracao()){
            g2d.setColor(Color.RED);
//          String json = gson.toJson(peca.getListaDeFuracao());
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

        // GERAR LINHA DE RASGo
        for ( Rasgo rasgo : peca.getListaDeRasgo()){
            if(rasgo.face == "-A"){
                double posIniX = rasgo.getInicialX();
                double posIniY = rasgo.getInicialY();
                double posFinX = rasgo.getFinalX();
                double posFinY = rasgo.getFinalY();
                g2d.drawLine((int) (cent+posIniX), (int) (cent+posIniY),
                        (int) (cent+posFinX),
                        (int) (cent+posFinY));
            }
        }

        // Gerar usinagem Quadrada de Rebaixo
        for(Usinagem usinagem: peca.getListaDeUsinagem()){
//            if(usinagem.getTipo() == "rebaixo"){
//                g2d.setColor(Color.ORANGE);
//            }
//            else if(usinagem.getTipo() == "recorte"){
//                g2d.setColor(Color.GREEN);
//            }else{ g2d.setColor(Color.BLACK); }
            g2d.setColor(usinagem.getColor());
            double posIniX = usinagem.getPosIniX();
            double posIniY = usinagem.getPosIniY();
            double posFinX = usinagem.getPosFinX();
            double posFinY = usinagem.getPosFinY();
            g2d.drawRect((int) posIniX+cent, (int) posIniY+cent,
                    (int) posFinX+cent, (int) posFinY+cent);

        }

        // Gerar usinagem de Recorte quadrado






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

