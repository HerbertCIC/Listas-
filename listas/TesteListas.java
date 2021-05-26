package listas;

import java.util.Random;

public class TesteListas {
  
    public static void main(String[] args) {      
        int n = 5;
        System.out.println("-------------LISTA-------------");
        tListAlunos list = new tListAlunos(n, true);
        geraAlunos(list);
        System.out.println(list.toString());

        System.out.println("-------------INCLUINDO NA PILHA-------------");
        tListSequencial pilha = new tListSequencial(n, true);
        for (int i = 0; i < list.getTam(); i++) {
            pilha.incList(list.getListAluno(i));
        }
        System.out.println(pilha.toString());

        System.out.println("-------------REMOVENDO DA PILHA-------------");
        Aluno meuAluno = new Aluno();
        for (int i = pilha.getFim(); i > pilha.getIni(); i--) {
            meuAluno.copiaAluno(meuAluno, pilha.remList());
            System.out.println(meuAluno.toString());
        }
        
        //segunda lista para teste
        tListAlunos list2 = new tListAlunos(10, true);
        geraAlunos(list2);

        System.out.println("\n-------------TRY: INCLUIR ELEMENTOS ALEM DA CAP-------------");
        for (int i = 0; i < list2.getTam() + 1; i++) {
            pilha.incList(list2.getListAluno(i));
        }
        System.out.println(pilha.toString());

        System.out.println("-------------TRY: ESVAZIAR ALEM DA CAP-------------");
        for (int i = pilha.getIni(); i < pilha.getFim() + 1; i++) {
            meuAluno.copiaAluno(meuAluno, pilha.remList());
            System.out.println(meuAluno.toString());
        }

        System.out.println("\n-------------INCLUIDO NA FILA-------------");
        tListSequencial fila = new tListSequencial(n, false);
        for (int i = 0; i < list.getTam(); i++) {
            fila.incList(list.getListAluno(i));
        }
        System.out.println(fila.toString());

        System.out.println("-------------REMOVIDO DA FILA-------------");
        Aluno meuAluno2 = new Aluno();
        for (int i = fila.getIni(); i < fila.getFim() / 2; i++) {
            meuAluno2.copiaAluno(meuAluno2, fila.remList());
            System.out.println(meuAluno2.toString());
        }
        System.out.println(fila.getFim());
        System.out.println(fila.getIni());

        //terceira lista de teste
        tListAlunos list3 = new tListAlunos(10, true);
        geraAlunos(list3);

        System.out.println("\n-------------TRY: INCLUIR ELEMENTOS ALEM DA CAP-------------");
        for (int i = 0; i < list3.getTam(); i++) {
            fila.incList(list3.getListAluno(i));
        }
        System.out.println(fila.toString());

        System.out.println("-------------TRY: ESVAZIAR ALEM DA CAP-------------");
        for (int i = fila.getIni(); i < fila.getFim() + 1; i++) {
            meuAluno2.copiaAluno(meuAluno2, fila.remList());
            System.out.println(meuAluno2.toString());
        }

    }

    public static void geraAlunos(tListAlunos lista) {
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
