package br.com.anhanguera.pos.entidades;

/**
 *
 * @author rafaelpoveda
 */
public class Dupla {
    private int id;
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    private Truqueiro truqueiro1;
    public Truqueiro getTruqueiro1(){
        return this.truqueiro1;
    }
    public void setTruqueiro1(Truqueiro t){
        this.truqueiro1 = t;
    }
    
    private Truqueiro truqueiro2;
    public Truqueiro getTruqueiro2(){
        return this.truqueiro2;
    }
    public void setTruqueiro2(Truqueiro t){
        this.truqueiro2 = t;
    }
}
