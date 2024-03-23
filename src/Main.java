import javax.swing.*;

public class Main {
    public static void main(String[] args) {

            GerenciamentoDeSobras tela = new GerenciamentoDeSobras();
            tela.setContentPane(tela.GER);
            tela.setTitle("Gerenciamento de Estoque - Retalhos");
            tela.setSize(800,800);
            tela.setVisible(true);
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
