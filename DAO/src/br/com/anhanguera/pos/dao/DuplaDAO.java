/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.dao;

import br.com.anhanguera.pos.entidades.Dupla;
import br.com.anhanguera.pos.entidades.Truqueiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class DuplaDAO implements IBaseDAO<Dupla>{

    private Connection con = new ConnectionFactory().getConnection();
    
    @Override
    public List<Dupla> listar() {
        try{
            List<Dupla> listDupla = new ArrayList<Dupla>();
            PreparedStatement stmt = con.prepareStatement("select * from dupla");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Dupla d = new Dupla();
                Truqueiro t1 = new Truqueiro();
                Truqueiro t2 = new Truqueiro();
                d.setId(rs.getInt("codigodupla"));
                t1.setCPF(rs.getString("truqueiro1"));
                d.setTruqueiro1(t1);
                t2.setCPF(rs.getString("truqueiro2"));
                d.setTruqueiro2(t2);
                listDupla.add(d);
            }
            this.con.close();
            return listDupla;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public Dupla selecionarPeloId(int id){
        try{
            String sql = "select * from dupla where codigodupla = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Dupla d = new Dupla();
            Truqueiro t1 = new Truqueiro();
            Truqueiro t2 = new Truqueiro();
            if(rs.next()){
                d.setId(rs.getInt("codigodupla"));
                t1.setCPF(rs.getString("truqueiro1"));
                t2.setCPF(rs.getString("truqueiro2"));
                d.setTruqueiro1(t1);
                d.setTruqueiro2(t2);
            }
            stmt.close();
            this.con.close();
            return d;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    //Precisa melhorar esse metodo
    public Dupla selecionarPeloNomes(String truqueiro1, String truqueiro2){
        try{
            Dupla d = new Dupla();
            Truqueiro t1 = new Truqueiro();
            Truqueiro t2 = new Truqueiro();
            String sql = "select d.*, t.* from dupla d"+
            "join truqueiro t on t.cpf = d.truqueiro1 or t.cpf = truqueiro2"+
            "where t.nome = ? or t.nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, truqueiro1);
            stmt.setString(2, truqueiro2);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                d.setId(rs.getInt("codigodupla"));
                t1.setCPF(rs.getString("truqueiro1"));
                t2.setCPF(rs.getString("truqueiro2"));
                d.setTruqueiro1(t1);
                d.setTruqueiro2(t2);
            }
            stmt.close();
            this.con.close();
            return d;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public boolean inserir(Dupla t) {
        try{
            String sql = "insert into dupla (truqueiro1, truqueiro2) values (? ,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getTruqueiro1().getCPF());
            stmt.setString(2, t.getTruqueiro2().getCPF());
            stmt.execute();
            stmt.close();
            this.con.close();
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean alterar(Dupla t) {
        return false;
    }

    @Override
    public boolean excluir(Dupla t) {
        return false;
    }
    
}
