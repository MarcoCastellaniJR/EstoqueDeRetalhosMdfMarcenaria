package BuilderConfig.fix;

public class TampaMinifix implements Usinagem{
    private int diametro = 15;
    private int altura = 12;
    private int parMiniTopo = 24;
    @Override
    public String posZero() {
        return "X:"+(diametro/2)+"Z:"+altura;
    }

    @Override
    public int qtdFuro() {
        return 0;
    }

    @Override
    public String qualFace() {
        return "Face";
    }

    @Override
    public String extFur() {
        return "F:"+diametro+"Z:"+altura;
    }
}
