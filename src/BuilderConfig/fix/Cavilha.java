package BuilderConfig.fix;

public class Cavilha implements Usinagem {
    private int diametro = 8;
    private int larg = 30;
    private int posLarg = 10;

    @Override
    public String posZero() {
        return "Z:"+diametro/2+";Y:"+posLarg;
    }

    @Override
    public int qtdFuro() {
        return 2;
    }

    @Override
    public String qualFace() {
        return "Topo/Face";
    }

    @Override
    public String extFur() {
        return "F:"+diametro+"X:"+larg;
    }
}
