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
public class ListaAlunos {

    private int tam;
    private int cap;
    private boolean status;
    private Aluno[] listAluno;
    private Aluno aluno;

    public ListaAlunos(Aluno aluno, int cap) {
        this.cap = cap;
        this.listAluno = new Aluno[cap];
        //listAluno[0] = new Aluno(" ", " ", " ");
        this.tam = 0;
        this.status = false;
    }

    public int buscaNaoOrdenada(String key) {
        int i = 0;
        int n = this.tam;
        this.listAluno[n].setMatricula(key); // adicionando chave no final        
        while (this.listAluno[i].getMatricula().compareTo(key) != 0) {
            i++;
        }
        return i; //retorna o indice onde achou
    }

    public boolean incNaoOrdenada(Aluno aluno) {
        // Retorna TRUE ou FALSE
        // FALSE: Se o aluno já estiver na lista ou se a 
        // lista já estiver cheia
        int n = this.tam;
        int i = buscaNaoOrdenada(aluno.getMatricula());
        if (i == n && n < this.cap) {
            this.listAluno[n].setMatricula(aluno.getMatricula());
            this.listAluno[n].setNome(aluno.getNome());
            this.listAluno[n].setEmail(aluno.getEmail());
            this.tam++;
            return true;
        } else {
            return false;
        }
    }

    public boolean remNaoOrdenada(Aluno aluno) {
        // Retorna TRUE ou FALSE
        // FALSE: Se o aluno não estiver na lista ou se a 
        // lista já estiver vazia
        int n = this.tam;
        int i = buscaNaoOrdenada(aluno.getMatricula());
        if (i == n || n == 0) {
            return false;
        } else {
            for (int j = i; j < n; j++) {
                this.listAluno[j].setMatricula(this.listAluno[j + 1].getMatricula());
                this.listAluno[j].setNome(this.listAluno[j + 1].getNome());
                this.listAluno[j].setEmail(this.listAluno[j + 1].getEmail());
            }
        }
        this.tam--;
        return true;
    }

    public int buscaOrdenada(String key) {
        int min = 0, max = this.tam, mid = 0;
        while (min != max) {
            mid = (max + min) / 2;
            int com = this.listAluno[mid].getMatricula().compareTo(key);
            if (com < 0) {
                min = ++mid;
            } else {
                if (com > 0) {
                    max = mid;
                } else {
                    if (mid < this.tam) {
                        this.status = true;
                    }
                    return mid;
                }
            }
        }
        return mid;
    }

    public boolean incOrdenada(Aluno aluno) {
        // Retorna true ou false
        // false: Se o aluno já estiver na lista ou se a 
        // lista já estiver cheia
        int n = this.tam;
        int i = buscaOrdenada(aluno.getMatricula());
        if (i == n && n <= this.cap) {
            this.listAluno[n].setMatricula(aluno.getMatricula());
            this.listAluno[n].setNome(aluno.getNome());
            this.listAluno[n].setEmail(aluno.getEmail());
            this.tam++;
            return true;
        } else if (!this.status && n <= this.cap) {
            Aluno troca = new Aluno("", "", "");
            for (int j = i; j < n; j++) {
                troca.setMatricula(this.listAluno[j].getMatricula());
                troca.setNome(this.listAluno[j].getNome());
                troca.setEmail(this.listAluno[j].getEmail());

                this.listAluno[j].setMatricula(aluno.getMatricula());
                this.listAluno[j].setNome(aluno.getNome());
                this.listAluno[j].setEmail(aluno.getEmail());

                aluno.setMatricula(troca.getMatricula());
                aluno.setNome(troca.getNome());
                aluno.setEmail(troca.getEmail());
            }
            this.listAluno[n].setMatricula(aluno.getMatricula());
            this.listAluno[n].setNome(aluno.getNome());
            this.listAluno[n].setEmail(aluno.getEmail());
            this.tam++;
            return true;
        }
        return false;
    }

    public boolean remOrdenada(Aluno aluno) {
        // Retorna true ou false
        // FALSE: Se o aluno não estiver na lista ou se a 
        // lista já estiver vazia
        int n = this.tam;
        int i = buscaOrdenada(aluno.getMatricula());
        if (!this.status) {
            return false;
        } else {
            for (int j = i; j < n; j++) {
                this.listAluno[j].setMatricula(this.listAluno[j + 1].getMatricula());
                this.listAluno[j].setNome(this.listAluno[j + 1].getNome());
                this.listAluno[j].setEmail(this.listAluno[j + 1].getEmail());
            }
            this.tam--;
            return true;
        }
    }
    
    private static void bubbleSortList(Aluno[] listAluno){
               boolean troca = true;
               Aluno aux;
               while (troca) {
                   troca = false;                   
                   for (int i = 0; i < listAluno.length - 1; i++) {
                       if (listAluno[i].getMatricula().compareTo(listAluno[i+1].getMatricula()) > 0) {
                           aux = listAluno[i];
                           listAluno[i] = listAluno[i + 1];
                           listAluno[i + 1] = aux;
                           troca = true;
                       }
                   }
               }
       }

    private Aluno[] getListAluno() {
        return listAluno;
    }

    private void setListAluno(Aluno[] listAluno) {
        this.listAluno = listAluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

}
