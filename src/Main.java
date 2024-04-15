import Integrator.client.Builder;

public class Main {
    public static void main(String[] args) {

//            GerenciamentoDeSobras tela = new GerenciamentoDeSobras();
//            tela.setContentPane(tela.TELAGER);
//            tela.setTitle("Gerenciamento de Estoque - Retalhos");
//            tela.setSize(800,800);
//            tela.setVisible(true);
//            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


//        GeradorDeImagemPeca gerar = new GeradorDeImagemPeca();
//
//        String nomePeca = "Lateral";
//        gerar.gerarEtiqueta(nomePeca);

        Builder bui = new Builder();
        String s = bui.retornaJSON(bui);
        System.out.println(s);


    }
}

