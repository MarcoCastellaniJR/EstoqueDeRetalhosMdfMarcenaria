package BuilderConfig.fix;

public class ParafusoMinifix implements Usinagem{
    private int diaPar = 6;
    private int largPar = 34;
    private int furTopo = 11;
    @Override
    public String posZero() {
        return "Z:"+(diaPar/2)+"X:"+furTopo;
    }

    @Override
    public int qtdFuro() {
        return 3;
    }

    @Override
    public String qualFace() {
        return "Topo/Face";
    }

    @Override
    public String extFur() {
        return "F:"+diaPar+"X:"+largPar;
    }
}
