/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dcc025.trabalho;

import java.util.*;

/**
 *
 * @author Gabi
 */
public class ListaQuantidadeCor {
    public static enum Cor{
        ROSA, VERMELHO, LARANJA, AMARELO, VERDE_CLARO, VERDE, CIANO, AZUL_CLARO, AZUL,
        ROXO, MAJENTA, PRETO, CINZA, BRANCO
    }
    private HashMap<Cor,Integer> quantidade;
    
    public ListaQuantidadeCor(){
        for(Cor aux : Cor.values())
            quantidade.put(aux, 0);
    }
    
    public int getQuantidade(Cor cor){
        for(Cor aux : Cor.values())
            if(cor==aux)
                return this.quantidade.get(cor);
        return 0;
    }
    
    public void setQuantidade(int quantidade, Cor cor){
        this.quantidade.put(cor, quantidade);
    }
}
