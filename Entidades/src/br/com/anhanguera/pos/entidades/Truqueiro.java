package br.com.anhanguera.pos.entidades;

import java.util.Date;

/**
 *
 * @author rafaelpoveda
 */
public class Truqueiro {
    private String cpf;
    public String getCPF(){
        return this.cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    
    private String nome;
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    private String apelido;
    public String getApelido(){
        return this.apelido;
    }
    public void setApelido(String apelido){
        this.apelido = apelido;
    }
    
    private Date dataNascimento;
    public Date getDataNascimento(){
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }    
}

