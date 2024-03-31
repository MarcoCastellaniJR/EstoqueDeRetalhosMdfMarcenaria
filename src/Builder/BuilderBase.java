package Builder;

public class BuilderBase {
    Peca peca = new Peca();
    private int larg;
    private int prof;
    private int esp;
    private int minPosZ = 5;
    private int minPosY = 15;
    private int minPosX = 13;
    private int minEspTopo = 5;
    private int minEspFace = 12;

    public BuilderBase(int larg, int prof, int esp) {
        this.larg = larg;
        this.prof = prof;
        this.esp = esp;
    }
    public BuilderBase(Peca peca){
        this.peca = peca;
        this.larg = peca.getLarg();
        this.prof = peca.getProf();
        this.esp = peca.getEsp();
    }
    public String builderBasePadrao(Peca peca){
        String medPeca = "Peça com medida de Largura: " + larg +
                " Profundidade: " + prof + " Espessura: " + esp;

        String fur =
                " Frontal: Y:" + minPosY +" Z:"+ (esp-minPosZ)+ " R:"+minEspTopo+
                        "\n Traseiro: Y:" + (prof-minPosY) + " Z:"+ (esp-minPosZ)+" R:"+minEspTopo;
        String fac =
                " Face Superior Esquerda Traseira: X:" + minPosX +" Y:"+ (prof-minPosY) +" R:"+minEspFace+
                        "\n Face Superior Direita Traseira: X:" + (larg-minPosX) + " " +
                        "Y:" + (prof-minPosY) + " R:" + minEspFace;
        String facFron =
                " Face Superior Esquerda Frontal: X:" + minPosX +" Y:"+ (minPosY) +" R:"+minEspFace+
                        "\n Face Superior Direita Frontal: X:" + (larg-minPosX) +
                        " " +
                        "Y:" + (minPosY) + " R:" + minEspFace;
        return medPeca +"\nFuração Topo Dir/Esq\n"+ fur + "\nFuração Face\n"+fac+
                "\n"+facFron;

    }
}
