package br.com.anhanguera.pos.dao;
import br.com.anhanguera.pos.entidades.Truqueiro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafaelpoveda
 */
public class TruqueiroDAO implements IBaseDAO<Truqueiro>{

    private Connection con = new ConnectionFactory().getConnection();
    
    @Override
    public List<Truqueiro> listar() {
        try{
            PreparedStatement stmt = this.con.prepareStatement("select * from truqueiro");
            ResultSet rs = stmt.executeQuery();
            List<Truqueiro> lstTruqueiro = new ArrayList<Truqueiro>();
            while(rs.next()){
                Truqueiro t = new Truqueiro();
                t.setCPF(rs.getString("cpf"));
                t.setNome(rs.getString("nome"));
                t.setApelido(rs.getString("apelido"));
                t.setDataNascimento(rs.getDate("dataNascimento"));
                lstTruqueiro.add(t);
            }
            stmt.close();
            this.con.close();
            return lstTruqueiro;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public Truqueiro selecionarPorNome(String nome){
        try{
            String sql = "select * from truqueiro where nome = ?";
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            Truqueiro t = new Truqueiro();
            if(rs.next()){
                t.setCPF(rs.getString("cpf"));
                t.setNome(rs.getString("nome"));
                t.setApelido(rs.getString("apelido"));
                t.setDataNascimento(rs.getDate("dataNascimento"));
            }
            stmt.close();
            this.con.close();
            return t;
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public Truqueiro selecionarPorCPF(String cpf){
        try{
            String sql = "select * from truqueiro where cpf = ? ";
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            Truqueiro t = new Truqueiro();
            if(rs.next()){
                t.setCPF(rs.getString("cpf"));
                t.setNome(rs.getString("nome"));
                t.setApelido(rs.getString("apelido"));
                t.setDataNascimento(rs.getDate("dataNascimento"));
            }
            stmt.close();
            this.con.close();
            return t;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public boolean inserir(Truqueiro t) {
        try{
            String sql = "insert into truqueiro (cpf, nome, apelido, datanascimento) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, t.getCPF());
            stmt.setString(2, t.getNome());
            stmt.setString(3, t.getApelido());
            stmt.setDate(4, (Date)t.getDataNascimento());
            stmt.execute();
            stmt.close();
            this.con.close();
            return true;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean alterar(Truqueiro t) {
        return false;
    }

    @Override
    public boolean excluir(Truqueiro t) {
        return false;
    }
    
}
