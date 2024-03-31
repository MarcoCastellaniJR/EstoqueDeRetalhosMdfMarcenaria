package BuilderConfig.client;

import java.time.LocalDate;

public class Client {
    private static int ID;
    private String name;
    private int cpf;
    private String rua;
    private String bairro;
    private int nmrEndereco;
    private LocalDate nascimento;

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Client.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNmrEndereco() {
        return nmrEndereco;
    }

    public void setNmrEndereco(int nmrEndereco) {
        this.nmrEndereco = nmrEndereco;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
