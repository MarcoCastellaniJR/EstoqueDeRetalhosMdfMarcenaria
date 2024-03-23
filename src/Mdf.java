import java.security.PublicKey;
import java.util.Arrays;

public class Mdf {
    public String IdMDF;
    public int larg;
    public int prof;
    public int esp;

    public String getAcabamento() {
        return acabamento;
    }

    public String acabamento;
    public boolean fitaDireita;
    public boolean fitaEsquerda;
    public boolean fitaFrontal;
    public boolean fitaTraseira;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int cod;

    public String Area;

    public int getVeio() {
        return veio;
    }

    public void setVeio(int veio) {
        this.veio = veio;
    }

    public int veio;

    public Mdf() {

    }

    public String ID(){
        return acabamento+"-"+esp+"-"+larg+"-"+prof;
    }

    public Mdf(String IdMDF, int larg, int prof, int esp, String acabamento) {
        this.IdMDF = IdMDF;
        this.larg = larg;
        this.prof = prof;
        this.esp = esp;
        this.acabamento = acabamento;
    }
    public void MdfSemId( int larg, int prof, int esp, String acabamento,
                          String Area) {
        IdMDF = acabamento+"-"+esp+"-"+larg+"-"+prof;
        this.larg = larg;
        this.prof = prof;
        this.esp = esp;
        this.acabamento = acabamento;
        this.Area = Area;
    }

    public String Resumo() {
        return "Mdf{" +
                "larg=" + larg +
                ", prof=" + prof +
                ", esp=" + esp +
                ", Acab="+ acabamento;
    }

    public String getIdMDF() {
        return IdMDF;
    }

    public void setIdMDF(int idMDF) {
        IdMDF = String.valueOf(idMDF);
    }

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


    public void setAcabamento(String acabamento) {
        this.acabamento = acabamento;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
}

