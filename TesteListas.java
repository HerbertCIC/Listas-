
package listas;

public class TesteListas {

    public static void main(String[] args) {
    
        Aluno[] aluno = new Aluno[3];
        tListAlunos list = new tListAlunos(5);
        aluno[0] = new Aluno("201910281", "fulano", "fulano@uesc.br");
        aluno[1] = new Aluno("202010281", "ciclano", "ciclano@uesc.br");
        aluno[2] = new Aluno("202110281", "beltrano", "beltrano@uesc.br");
        
        //INCLUSÃO NÃO ORDENADA
        list.incNaoOrdenada(aluno[0]);
        list.incNaoOrdenada(aluno[1]);
        if(list.incNaoOrdenada(aluno[2])){
            System.out.println("Aluno incluido na lista com sucesso!");
            list.printList();
        }else
            System.out.println("Aluno não pode ser adicionado à lista!");
        
        System.out.println("");
        //REMOÇÃO NÃO ORDENADA
        if(list.remNaoOrdenada(aluno[0])){
            System.out.println("Aluno removido da lista com sucesso!");
            list.printList();
        }else
            System.out.println("Aluno não exite na lista!");
        /* 
        //INCLUSÃO ORDENADA
        System.out.println(list.incOrdenada(aluno[2]));
        System.out.println(list.incOrdenada(aluno[1]));
        System.out.println(list.incOrdenada(aluno[0]));
        list.printList();
         //REMOÇÃO ORDENADA
        System.out.println(list.remOrdenada(list.getListAluno(0)));
        list.printList();
        */
    }

}
