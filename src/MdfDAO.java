

import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MdfDAO {
    String id;
    PreparedStatement ps;
    public void cadastrarChapa(Mdf mdf){
        String sql = "INSERT INTO mdf_estoque (ID,LARGURA,PROFUNDIDADE," +
                "ESPESSURA,ACABAMENTO,AREA) VALUES (?,?,?,?,?,?)";

        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1,mdf.getIdMDF());
            ps.setInt(2,mdf.getLarg());
            ps.setInt(3,mdf.getProf());
            ps.setInt(4,mdf.getEsp());
            ps.setString(5,mdf.getAcabamento());
            ps.setString(6, mdf.getArea());
            ps.execute();
            ps.close();
            try {
                logDataBase("Chapa Cadastrada: " + mdf.getIdMDF());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirChapa(String id){
        String sql = "DELETE FROM mdf_estoque WHERE (ID) = (?)";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1,id);
            ps.execute();
            ps.close();
            try {
                logDataBase("Excluiu retalho: "+ id);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarAreas(String nomeArea){
        String sql = "INSERT INTO areas (NAME) VALUES ( ? )";
        try{
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1,nomeArea);
            ps.execute();
            ps.close();
            try {
                logDataBase("Cadastro de Área: " + nomeArea);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }



    public void excluirAreas(String nomeArea){
        String sql = "DELETE FROM areas WHERE name=(?)";
        try{
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1,nomeArea);
            ps.execute();
            ps.close();
            try {
                logDataBase("Excluiu Área: "+ nomeArea);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void cadastrarAcabamento(String name, int veio, int codigo){
        String sql = "INSERT INTO acabamentos (name, veio, cod) VALUES (?,?,?)";
        try{

            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1,name);
            ps.setInt(2,veio);
            ps.setInt(3,codigo);
            ps.execute();
            ps.close();
            try {
                logDataBase("Cadastro de Acabamento:"+name+"-"+codigo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void excluirAcabamentos(int codigo){
        String sql = "DELETE FROM acabamentos WHERE cod = (?)";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.execute();
            ps.close();
            try {
                logDataBase("Excluir acabamento:" + codigo);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean validaAcabamento(int codigo){
        String sql = "SELECT * FROM acabamentos WHERE cod = (?)";
        boolean find = false;
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setInt(1,codigo);
            ResultSet rs = ps.executeQuery();
            find = rs.next();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return find;
    }

    public boolean validaArea(String Area){
        String sql = "SELECT * FROM areas WHERE name = (?)";
        boolean find = false;
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1,Area);
            ResultSet rs = ps.executeQuery();
            find = rs.next();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return find;
    }

    public Mdf[] listarRetalhos(){
        String sql = "SELECT * FROM mdf_estoque";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mdf> listaMDF = new ArrayList<>();
            while (rs.next()){
                Mdf retalho = new Mdf();
                retalho.setAcabamento(rs.getString("acabamento"));
                retalho.setEsp(rs.getInt("espessura"));
                retalho.setLarg(rs.getInt("largura"));
                retalho.setProf(rs.getInt("profundidade"));
                retalho.setArea(rs.getString("area"));
                listaMDF.add(retalho);
            }
            Mdf[] arrayMdf = listaMDF.toArray(new Mdf[0]);
            rs.close();
            ps.close();
            return arrayMdf;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Mdf[] listarRetalhosPorAcabamento(int acabamento){
        String sql = "SELECT * FROM mdf_estoque WHERE acabamento = (?)";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setInt(1,acabamento);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mdf> listaMDF = new ArrayList<>();
            while (rs.next()){
                Mdf retalho = new Mdf();
                retalho.setAcabamento(rs.getString("acabamento"));
                retalho.setEsp(rs.getInt("espessura"));
                retalho.setLarg(rs.getInt("largura"));
                retalho.setProf(rs.getInt("profundidade"));
                retalho.setArea(rs.getString("area"));
                listaMDF.add(retalho);
            }
            Mdf[] arrayMdf = listaMDF.toArray(new Mdf[0]);
            rs.close();
            ps.close();
            return arrayMdf;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Mdf[] listarRetalhosPorEspessura(int acabamento){
        String sql = "SELECT * FROM mdf_estoque WHERE espessura = (?)";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setInt(1,acabamento);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mdf> listaMDF = new ArrayList<>();
            while (rs.next()){
                Mdf retalho = new Mdf();
                retalho.setAcabamento(rs.getString("acabamento"));
                retalho.setEsp(rs.getInt("espessura"));
                retalho.setLarg(rs.getInt("largura"));
                retalho.setProf(rs.getInt("profundidade"));
                retalho.setArea(rs.getString("area"));
                listaMDF.add(retalho);
            }
            Mdf[] arrayMdf = listaMDF.toArray(new Mdf[0]);
            rs.close();
            ps.close();
            return arrayMdf;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Mdf[] listarRetalhosPorArea(String Area){
        String sql = "SELECT * FROM mdf_estoque WHERE area = (?)";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ps.setString(1,Area);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mdf> listaMDF = new ArrayList<>();
            while (rs.next()){
                Mdf retalho = new Mdf();
                retalho.setAcabamento(rs.getString("acabamento"));
                retalho.setEsp(rs.getInt("espessura"));
                retalho.setLarg(rs.getInt("largura"));
                retalho.setProf(rs.getInt("profundidade"));
                retalho.setArea(rs.getString("area"));
                listaMDF.add(retalho);
            }
            Mdf[] arrayMdf = listaMDF.toArray(new Mdf[0]);
            rs.close();
            ps.close();
            return arrayMdf;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Mdf[] listarAcabamentos(){
        String sql = "SELECT * FROM acabamentos";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            //ps.setString(1,Area);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mdf> listaMDF = new ArrayList<>();
            while (rs.next()){
                Mdf retalho = new Mdf();
                retalho.setAcabamento(rs.getString("name"));
                retalho.setVeio(rs.getInt("veio"));
                retalho.setCod(rs.getInt("cod"));
                listaMDF.add(retalho);
            }
            Mdf[] arrayMdf = listaMDF.toArray(new Mdf[0]);
            rs.close();
            ps.close();
            return arrayMdf;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Mdf[] listarAreas(){
        String sql = "SELECT * FROM areas";
        try {
            ps = ConexaoJDBC.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Mdf> listaMDF = new ArrayList<>();
            while (rs.next()){
                Mdf retalho = new Mdf();
                retalho.setArea(rs.getString("name"));
                listaMDF.add(retalho);
            }
            Mdf[] arrayMdf = listaMDF.toArray(new Mdf[0]);
            rs.close();
            ps.close();
            return arrayMdf;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void logDataBase(String line) throws IOException {
        FileWriter writer = new FileWriter("Log.txt",true);
        writer.write(line+"\n");
        writer.close();
    }






}
