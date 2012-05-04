package br.com.anhanguera.pos.entidades;

import java.util.Date;

/**
 *
 * @author rafaelpoveda
 */
public class Partida {
    private int id;
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    private Dupla duplaVencedora;
    public Dupla getDuplaVencedora(){
        return this.duplaVencedora;
    }
    public void setDuplaVencedora(Dupla dv){
        this.duplaVencedora = dv;
    }
    
    private Dupla duplaPerdedora;
    public Dupla getDuplaPerdedora(){
        return this.duplaPerdedora;
    }
    public void setDuplaPerdedora(Dupla dp){
        this.duplaPerdedora = dp;
    }
    
    private int pontosPerdedora;
    public int getPontosPerdedora(){
        return this.pontosPerdedora;
    }
    public void setPontosPerdedora(int pp){
        this.pontosPerdedora = pp;
    }
    
    private Date data;
    public Date getData(){
        return this.data;
    }
    public void setData(Date data){
        this.data = data;
    }
}
