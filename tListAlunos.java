
package listas;

public class tListAlunos {

    private int tam;
    private int cap;
    private boolean achou;
    private Aluno[] listAluno;

    public tListAlunos(int cap) {
        this.cap = cap;
        this.listAluno = new Aluno[cap];
        this.tam = 0;
        this.achou = false;
    }
    /*
    public tListAlunos(int cap, boolean tipo) {
        this.cap = cap;
        this.listAluno = new Aluno[cap];
        this.tam = 0;
        this.achou = false;
    }*/

    private int buscaNaoOrdenada(String key) {
        int i = 0;
        int n = this.tam;
        this.listAluno[n] = new Aluno(key, null, null);// adicionando chave no final      
        while (this.listAluno[i].getMatricula().compareTo(key) != 0) {
            i++;
        }
        this.listAluno[n] = new Aluno();
        return i; //retorna o indice onde achou
    }

    public boolean incNaoOrdenada(Aluno aluno) {
        int n = this.tam;
        if (n <= this.cap) {
            if (buscaNaoOrdenada(aluno.getMatricula()) == n) {
                this.listAluno[n] = new Aluno(aluno.getMatricula(), aluno.getNome(), aluno.getEmail());
                this.tam++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean remNaoOrdenada(Aluno aluno) {
        int n = this.tam;	
        if (n > 0) {																								
            int i = buscaNaoOrdenada(aluno.getMatricula());
            if (i < n) {		
                for (int j = i; j < n; j++) {										
                    this.listAluno[j].setMatricula(this.listAluno[j + 1].getMatricula());
                    this.listAluno[j].setNome(this.listAluno[j + 1].getNome());
                    this.listAluno[j].setEmail(this.listAluno[j + 1].getEmail());
                }
                this.tam--;							
                return true;	
            } else {
                return false; 
            }
        } else {
            return false;
        }
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
                        this.achou = true;
                    }
                    return mid;
                }
            }
        }
        return mid;
    }

    public boolean incOrdenada(Aluno aluno) {
        int n = this.tam;
        int i = buscaOrdenada(aluno.getMatricula());
        if (i == n && n < this.cap) {
            this.listAluno[n] = new Aluno(aluno.getMatricula(), aluno.getNome(), aluno.getEmail());
            this.tam++;
            return true;
        } else if (!this.achou) {																			
            Aluno troca = new Aluno();																			
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
            this.listAluno[n] = new Aluno(aluno.getMatricula(), aluno.getNome(), aluno.getEmail());
            this.tam++;
            return true;
        } else {
            return false;
        }
    }

    public boolean remOrdenada(Aluno aluno) {
        int n = this.tam;
        if (n > 0) {
            int i = buscaOrdenada(aluno.getMatricula());
            if (this.achou) {
                this.listAluno[this.tam] = new Aluno();
                for (int j = i; j < n; j++) {
                    this.listAluno[j].setMatricula(this.listAluno[j + 1].getMatricula());
                    this.listAluno[j].setNome(this.listAluno[j + 1].getNome());
                    this.listAluno[j].setEmail(this.listAluno[j + 1].getEmail());
                }
                this.tam--;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void printList() {
        for (int i = 0; i < this.tam; i++) {
            System.out.println(this.listAluno[i].getMatricula() + " | " + this.listAluno[i].getNome() + " | " + this.listAluno[i].getEmail());
        }
    }

    public Aluno getListAluno(int n) {
        return listAluno[n];
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

}
