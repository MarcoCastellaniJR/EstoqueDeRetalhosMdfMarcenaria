import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GeradorDeImagemPeca {
    int etiquetaWidth = 2000;
    int etiquetaHeight = 1200;
    int cent = 50;
    int largPeca = 1200;
    int profPeca = 600;
    int posX = 15;
    int posY = 15;
    int width = largPeca + cent;
    int height = profPeca + cent*2;
    // Cria uma imagem BufferedImage com o tamanho especificado
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    // Obtém o contexto gráfico para desenhar na imagem
    Graphics2D g2d = image.createGraphics();
    public String gerarEtiqueta(String nomePeca) {
        // Desenha um fundo branco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, etiquetaWidth , etiquetaHeight);

        float strokeWidth = 3.0f;
        g2d.setStroke(new BasicStroke(strokeWidth));

        // Desenha um retângulo azul
        g2d.setColor(Color.BLUE);
        g2d.drawRect(cent/2, cent/2, largPeca, profPeca);
        g2d.setColor(Color.BLACK);
        g2d.drawLine(cent/2,cent/2+10,largPeca+cent/2,cent/2+10);

        g2d.setColor(Color.RED);
        g2d.drawOval(posX+cent/2,posY+cent/2+25, 10, 10);
        g2d.drawOval(width-(posX+cent/2+10),posY+cent/2+25, 10, 10);
        g2d.drawOval(posX+cent/2,5+height-(posY+cent*2), 10, 10);
        g2d.drawOval(width-(posX+cent/2+10),5+height-(posY+cent*2), 10, 10);

        // Adiciona texto à Imagem
        String txt = nomePeca + ": " + width + "x" + height;
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString(txt, width / 3, height - 20);

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

