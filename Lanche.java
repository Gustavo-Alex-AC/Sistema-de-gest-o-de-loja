/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package snackbar;

/**
 *
 * @author LENOVO
 */
public class Lanche extends Prato{
    private String pao;
    private String recheio;
    private String molho;


    public Lanche(Double precoDeVenda, String dataDeValidade, Double peso, String pao, String recheio, String molho) {
        super(precoDeVenda, dataDeValidade, peso);
        this.pao = pao;
        this.recheio = recheio;
        this.molho = molho;
    }
    
     public Lanche() {
    }

    public String getPao() {
        return pao;
    }

    public void setPao(String pao) {
        this.pao = pao;
    }

    public String getRecheio() {
        return recheio;
    }

    public void setRecheio(String recheio) {
        this.recheio = recheio;
    }

    public String getMolho() {
        return molho;
    }

    public void setMolho(String molho) {
        this.molho = molho;
    }
}
