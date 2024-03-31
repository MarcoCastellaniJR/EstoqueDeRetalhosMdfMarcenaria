package Builder;

public class TesteMain{
    public static void main (String[]args){

        int larg = 1200;
        int prof = 600;
        int esp = 18;
        Peca base = new Peca(larg,prof,esp);

        BuilderBase baseFura = new BuilderBase(base);
        String s = baseFura.builderBasePadrao(base);
        System.out.println(s);

        BuilderLateral lateral = new BuilderLateral();

    }

}

