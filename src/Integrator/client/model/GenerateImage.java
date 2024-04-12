package Integrator.client.model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GenerateImage {
    public static void main(String[] args) {
        int width = 400;
        int height = 300;

        // Cria uma imagem BufferedImage com o tamanho especificado
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Obtém o contexto gráfico para desenhar na imagem
        Graphics2D g2d = image.createGraphics();

        // Desenha um fundo branco
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);

        float strokeWidth = 3.0f;
        g2d.setStroke(new BasicStroke(strokeWidth));

        // Desenha um retângulo azul
        g2d.setColor(Color.BLUE);
        g2d.drawRect(50, 50, 300, 200);

        // Adiciona texto à Imagem
        String txt = "Base " + width + "x" + height;
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        g2d.drawString(txt , width/3 , height-20);

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
        } catch (IOException e) {
            System.err.println("Erro ao salvar a imagem: " + e.getMessage());
        }
    }
}
