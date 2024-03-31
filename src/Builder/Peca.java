package Builder;

public class Peca {
    private int larg;
    private int prof;
    private int esp;

    public Peca(int larg, int prof, int esp) {
        this.larg = larg;
        this.prof = prof;
        this.esp = esp;
    }
    public Peca(){}

    public int getLarg() {
        return larg;
    }

    public void setLarg(int larg) {
        this.larg = larg;
    }

    public int getProf() {
        return prof;
    }

    public void setProf(int prof) {
        this.prof = prof;
    }

    public int getEsp() {
        return esp;
    }

    public void setEsp(int esp) {
        this.esp = esp;
    }
}
