public class UsinagemQuadradaRebaixo extends Usinagem {
    private double prof;
    private double posIniX;
    private double posFinX;
    private double posIniY;
    private double posFinY;

    public UsinagemQuadradaRebaixo() {
    }

    public UsinagemQuadradaRebaixo(double prof, double posIniX, double posFinX, double posIniY, double posFinY) {
        this.prof = prof;
        this.posIniX = posIniX;
        this.posFinX = posFinX;
        this.posIniY = posIniY;
        this.posFinY = posFinY;
    }

    public UsinagemQuadradaRebaixo(Object o) {
        super();
    }
}
