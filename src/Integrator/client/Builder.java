package Integrator.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Builder {
    private double posX = 10.0;
    private double posY = 25.5;
    private String face ="-A"; // -A - Face do painel -B Face inferior - E/D
    // - F/T
    private double depth = 8.5;
    private double diameter = 12.5;
    private String nomeFuracao = "MINIFIX";

    // Criar validação para sempre colocar o nome em uppercase
    // Criar validação para Espessuras da peça também para furação não varar
    // Confirmar se vai varar ou não para alguns casos
    // Criar variação de quadrante para usinagem desenhada de Quadrado e circulo


    public Builder() {

    }

    public Builder(double posX, double posY, String face, double depth, double diameter, String nomeFuracao) {
        this.posX = posX;
        this.posY = posY;
        this.face = face;
        this.depth = depth;
        this.diameter = diameter;
        this.nomeFuracao = nomeFuracao;
    }

    public Builder(Builder builder) {
    }

    public static String retornaJSON(Builder builder){
        Builder dados = new Builder();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dados);
        return json;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getNomeFuracao() {
        return nomeFuracao;
    }

    public void setNomeFuracao(String nomeFuracao) {
        this.nomeFuracao = nomeFuracao;
    }
}
