/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author Herbert Nascimento
 */
public class TesteListas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here     
        Aluno aluno = new Aluno("201910281", "fulano", "fulano@uesc.br");
        ListaAlunos list = new ListaAlunos(aluno, 5);
                
        //list.incNaoOrdenada(aluno);
        //System.out.println(list.remNaoOrdenada(aluno));
        //System.out.println(list.buscaNaoOrdenada("201919214"));
        
        System.out.println(list.buscaOrdenada("201910281"));
        System.out.println(list.incOrdenada(aluno));
        //System.out.println(list.remOrdenada(aluno));
                
    }
    
}
