package listas;

public class TesteListas {

    public static void main(String[] args) {
            
        Aluno[] aluno = new Aluno[3];
        tListAlunos list = new tListAlunos(5, true);
        aluno[0] = new Aluno("202210281", "fulano", "fulano@uesc.br");
        aluno[1] = new Aluno("202010281", "ciclano", "ciclano@uesc.br");
        aluno[2] = new Aluno("202110281", "beltrano", "beltrano@uesc.br");

        tListSequencial pilha = new tListSequencial(5);
        tListSequencial fila = new tListSequencial(5, false);
        System.out.println("incluindo na pilha...");
        pilha.incList(aluno[0]);
        pilha.incList(aluno[1]);
        pilha.incList(aluno[2]);
        pilha.printListSeq();
        System.out.println("removendo da pilha...");
        pilha.remList();
        pilha.printListSeq();
        System.out.println("incluindo na fila...");
        fila.incList(aluno[0]);
        fila.incList(aluno[1]);
        fila.incList(aluno[2]);
        fila.printListSeq();
        System.out.println("removendo da fila...");
        fila.remList();
        fila.printListSeq();
        /*     
        
        list.incluir(aluno[0]);
        list.incluir(aluno[1]);
        if(list.incluir(aluno[2])){
            System.out.println("Aluno incluido na lista com sucesso!");
            list.printList();
        }else
            System.out.println("Aluno não pode ser adicionado à lista!");
        
        System.out.println("");

        if(list.remover(aluno[0])){
            System.out.println("Aluno removido da lista com sucesso!");
            list.printList();
        }else
            System.out.println("Aluno não exite na lista!");
         */
    }

}
