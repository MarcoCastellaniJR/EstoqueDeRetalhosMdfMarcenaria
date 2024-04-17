import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Rasgo {
    private double inicialX;
    private double inicialY;
    private double finalX;
    private double finalY;
    private int prof;

    String face = "-A";

    public Rasgo(double inicialX, double inicialY, double finalX,
                 double finalY, int prof, String face) {
        this.inicialX = inicialX;
        this.inicialY = inicialY;
        this.finalX = finalX;
        this.finalY = finalY;
        this.prof = prof;
        this.face = face;
    }

    public String retornaRasgo(Rasgo rasgo){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(rasgo);
        return json;
    }

    public double getInicialX() {
        return inicialX;
    }

    public double getInicialY() {
        return inicialY;
    }

    public double getFinalX() {
        return finalX;
    }

    public double getFinalY() {
        return finalY;
    }

    public int getProf() {
        return prof;
    }
}
