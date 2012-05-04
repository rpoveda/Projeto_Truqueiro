/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.anhanguera.pos.dao;

import br.com.anhanguera.pos.entidades.Dupla;
import br.com.anhanguera.pos.entidades.Partida;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class PartidaDAO implements IBaseDAO<Partida>{

    private Connection con = new ConnectionFactory().getConnection();
    
    @Override
    public List<Partida> listar() {
        try{
            List<Partida> listPartida = new ArrayList<Partida>();
            PreparedStatement stmt = con.prepareStatement("select * from partida");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Partida p = new Partida();
                Dupla dv = new Dupla();
                Dupla dp = new Dupla();
                p.setId(rs.getInt("codigopartida"));
                p.setData(rs.getDate("data"));
                dv.setId(rs.getInt("dupla_vencedora"));
                dp.setId(rs.getInt("dupla_perdedora"));
                p.setDuplaVencedora(dv);
                p.setDuplaPerdedora(dp);
                listPartida.add(p);
            }
            stmt.close();
            con.close();
            return listPartida;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public Partida selecionarPelaPartida(int id){
        try{
            Partida d = new Partida();
            Dupla dv = new Dupla();
            Dupla dp = new Dupla();
            
            String sql = "select * from partida where codigopartida = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                d.setId(rs.getInt("codigopartida"));
                d.setData(rs.getDate("data"));
                dv.setId(rs.getInt("dupla_vencedora"));
                dp.setId(rs.getInt("dupla_perdedora"));
                d.setDuplaVencedora(dv);
                d.setDuplaPerdedora(dp);
            }
            stmt.close();
            con.close();
            return d;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public Partida selecionarPelaDupla(int idDv, int idDp){
        try{
            Partida p = new Partida();
            Dupla dv = new Dupla();
            Dupla dp = new Dupla();
            
            String sql = "select * from partida where dupla_vencedora = ? and dupla_perdedora = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idDv);
            stmt.setInt(2, idDp);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                p.setId(rs.getInt("codigopartida"));
                p.setData(rs.getDate("data"));
                dv.setId(rs.getInt("dupla_vencedora"));
                dp.setId(rs.getInt("dupla_perdedora"));
                p.setDuplaVencedora(dv);
                p.setDuplaPerdedora(dp);
            }
            stmt.close();
            con.close();
            return p;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean inserir(Partida t) {
        try{
            String sql = "insert into partida (dupla_vencedora, dupla_perdedora_pontos_perdedor_data) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, t.getDuplaVencedora().getId());
            stmt.setInt(2, t.getDuplaPerdedora().getId());
            stmt.setInt(3, t.getPontosPerdedora());
            stmt.setDate(4, (Date)t.getData());
            stmt.execute();
            stmt.close();
            con.close();
            return true;
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean alterar(Partida t) {
        return false;
    }

    @Override
    public boolean excluir(Partida t) {
        return false;
    }
    
}
