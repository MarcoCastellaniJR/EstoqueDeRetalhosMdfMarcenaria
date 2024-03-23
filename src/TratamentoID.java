public class TratamentoID{
    String s1;

    public void TratamentoCadastro(String s1){
        this.s1 = s1;
        int tam = s1.length();
        char separador = '-';

        String acabamento = "";
        String largura = "";
        String profundidade = "";
        String espessura = "";

        int contador=0;

        //int indiceSeparador = s1.indexOf(separador);
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) == '-') {
                contador++;
            }
            if(s1.charAt(i) != '-' && i != s1.length()-1 && i != 0){
                if(contador == 0){
                    acabamento =
                            acabamento.concat(Character.toString(s1.charAt(i)));}
                else if(contador == 1){
                    espessura = espessura.concat(Character.toString(s1.charAt(i)));}
                else if(contador == 2){
                    largura = largura.concat(Character.toString(s1.charAt(i)));}
                else if(contador == 3){
                    profundidade = profundidade.concat(Character.toString(s1.charAt(i)));}
            }
        }
        String id =
                ("0"+acabamento+"-"+espessura+"-"+largura+"-"+profundidade+
                "0");
        ConexaoJDBC.getConexao();
        Mdf chapa = new Mdf(id,Integer.parseInt(largura),
                Integer.parseInt(profundidade),Integer.parseInt(espessura),
                acabamento);
        MdfDAO cadastro = new MdfDAO();
        cadastro.cadastrarChapa(chapa);
    }
}
