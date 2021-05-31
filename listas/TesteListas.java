package listas;

import java.util.Random;

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
        int cont = 0;//conta a quantidade de elementos add/rem
        ListAlunos list = new ListAlunos();
        geraAlunos(list);
        System.out.println("LISTA:\n" + list.toString());

        System.out.println("-------------REMOVENDO DA LISTA E INCLUINDO NA FILA-------------");
        ListSequencial fila = new ListSequencial(list.getTam(), false);
        Aluno aux;
        for (int i = list.getTam()-1; i >= 0; i--) {
            aux = list.getListAluno(i);
            if (list.remover(aux)) {
                if (fila.incList(aux))
                    cont++;
            }
        }
        /*outra alternativa...
        int fim_da_lista = list.getTam();
        for (int i = 0 ; i < fim_da_lista; i++) {
             aux = list.getListAluno(0);
            if(list.remover(aux)){
                if(fila.incList(aux))
                    cont++;
            }
        }*/
        System.out.println("LISTA:\n" + list.toString());
        System.out.println(cont + " elementos foram adicionados a fila: \n" + fila.toString());

        cont = 0;
        System.out.println("-------------REMOVENDO DA FILA E INCLUINDO NA PILHA-------------");
        ListSequencial pilha = new ListSequencial(fila.getFim(), true);
        Aluno meuAluno = new Aluno();
        for (int i = fila.getIni(); i < fila.getFim(); i++) {
            if (fila.remList(meuAluno)) {
                if (pilha.incList(meuAluno)) {
                    cont++;
                } else {
                    System.out.println("Pilha cheia!");
                }
            } else {
                System.out.println("Não é possivel remover, fila vazia!");
            }
        }
        System.out.println("FILA:\n" + fila.toString());
        System.out.println(cont + " elementos foram adicionados a pilha:\n" + pilha.toString());

    }

    public static void geraAlunos(ListAlunos lista) {
        long matricula;
        Aluno aluno = new Aluno();
        Random rand = new Random();
        while (lista.getTam() < lista.getCap()) {
            matricula = (2017 + rand.nextInt(5)) * 100000 + rand.nextInt(100000);
            aluno.setMatricula(Long.toString(matricula));
            aluno.setNome("Nome SobrenomeM SobrenomeP");
            aluno.setEmail("NSmSp@uesc.br");
            lista.inclusaoNaoOrdenada(aluno);
        }
    }

}
