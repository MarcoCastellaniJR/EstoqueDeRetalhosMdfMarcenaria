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
        Rasgo rasgo1 = new Rasgo(0,55.5,Base.getLarg(),55.5,6,"-A");
        Base.adicionarRasgo(rasgo);
        Base.adicionarRasgo(rasgo1);
        Base.setNomeDaPeca("Base");
        Base.adicionaFuracao(bui);
        Base.adicionaFuracao(buiSerraCopo);
        String a = Base.retornaFuracao();
        System.out.println(a);



        Usinagem usi = Usinagem.criaUsinagem("rebaixo");
        usi.setPosIniX(110);
        usi.setPosIniY(110);
        usi.setPosFinX(220);
        usi.setPosFinY(220);

        Usinagem usi2 = Usinagem.criaUsinagem("recorte");
        usi2.setPosIniX(100);
        usi2.setPosIniY(100);
        usi2.setPosFinX(200);
        usi2.setPosFinY(220);

        System.out.println(usi);
        System.out.println(usi2);
        System.out.println(usi.getColor());
        System.out.println(usi2.getColor());

        Base.adicionaUSinagem(usi2);
        Base.adicionaUSinagem(usi);


        gerar.gerarEtiqueta(Base);

    }
}

