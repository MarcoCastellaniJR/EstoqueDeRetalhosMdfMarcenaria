package Integrator.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Builder {
    private double posX = 10.0;
    private double posY = 25.5;
    private String face ="-A";
    private double depth = 8.5;
    private double diameter = 12.5;
    private String nomeFuracao = "MINIFIX";

    // Criar validação para sempre colocar o nome em uppercase
    // Criar validação para Espessuras da peça também para furação não varar
    // Confirmar se vai varar ou não para alguns casos
    // Criar variação de quadrante para usinagem desenhada de Quadrado e circulo


    public Builder() {

    }

    public static String retornaJSON(Builder builder){
        Builder dados = new Builder();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dados);
        return json;
    }
}
