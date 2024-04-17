public class Usinagem {
    private double prof;
    private double posIniX;
    private double posFinX;
    private double posIniY;
    private double posFinY;
    static String tipo;

    public static String getTipo() {
        return tipo;
    }

    public static Usinagem criaUsinagem(String usinagem){
        if(usinagem == "rebaixo"){
            tipo = usinagem;
            return new UsinagemQuadradaRebaixo();
        }else if (usinagem == "recorte"){
            tipo = usinagem;
            return new UsinagemQuadradaRecorte();
        }else{
            throw new IllegalArgumentException("Tipo de usinagem desconhecida");
        }
    }

    public double getProf() {
        return prof;
    }

    public void setProf(double prof) {
        this.prof = prof;
    }

    public double getPosIniX() {
        return posIniX;
    }

    public void setPosIniX(double posIniX) {
        this.posIniX = posIniX;
    }

    public double getPosFinX() {
        return posFinX;
    }

    public void setPosFinX(double posFinX) {
        this.posFinX = posFinX;
    }

    public double getPosIniY() {
        return posIniY;
    }

    public void setPosIniY(double posIniY) {
        this.posIniY = posIniY;
    }

    public double getPosFinY() {
        return posFinY;
    }

    public void setPosFinY(double posFinY) {
        this.posFinY = posFinY;
    }
}
