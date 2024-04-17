import Integrator.client.Builder;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//            GerenciamentoDeSobras tela = new GerenciamentoDeSobras();
//            tela.setContentPane(tela.TELAGER);
//            tela.setTitle("Gerenciamento de Estoque - Retalhos");
//            tela.setSize(800,800);
//            tela.setVisible(true);
//            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GeradorDeImagemPeca gerar = new GeradorDeImagemPeca();

        Builder bui = new Builder();
        Builder buiSerraCopo = new Builder(500.0,250.0,"-A",15.0,60.0,"SERRA " +
                "COPO");
        String s = bui.retornaJSON(bui);
        System.out.println(s);




        Mdf Base = new Mdf();
        Base.setProf(400);
        Base.setLarg(1000);
        Rasgo rasgo = new Rasgo(0,15.5,Base.getLarg(),15.5,6,"-A");
        Base.adicionarRasgo(rasgo);
        Base.setNomeDaPeca("Base");
        Base.adicionaFuracao(bui);
        Base.adicionaFuracao(buiSerraCopo);
        String a = Base.retornaFuracao();
        System.out.println(a);



//        Usinagem usi = Usinagem.criaUsinagem("rebaixo");
//        usi.setPosIniX(20);
//        usi.setPosFinX(20);
//        usi.setPosIniY(60);
//        usi.setPosFinY(60);


        gerar.gerarEtiqueta(Base);

    }
}

