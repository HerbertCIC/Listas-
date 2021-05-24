package listas;

public class tListAlunos {

    private int tam;
    private int cap;
    private boolean achou;
    private Aluno[] listAluno;
    private Aluno aluno;
    private boolean isOrdenada;

    public tListAlunos() {
        this.cap = 100;
        this.listAluno = new Aluno[cap];
        this.tam = 0;
        this.achou = false;
        this.isOrdenada = true;
    }

    public tListAlunos(int cap, boolean isOrdenada) {
        this.cap = cap;
        this.listAluno = new Aluno[cap];
        this.tam = 0;
        this.achou = false;
        this.isOrdenada = isOrdenada;
    }

    private int buscaOrdenada(String key) {
        int min = 0, max = this.tam, i = 0;
        while (min != max) {
            i = (max + min) / 2;
            int com = this.listAluno[i].getMatricula().compareTo(key);
            if (com < 0) {
                min = ++i;
            } else {
                if (com > 0) {
                    max = i;
                } else {
                    if (i < this.tam) {
                        this.achou = true;
                    }
                    return i;
                }
            }
        }
        return i;
    }

    private int buscaNaoOrdenada(String key) {
        int n = this.tam, i = 0;
        this.listAluno[n] = new Aluno(key, null, null);
        while (this.listAluno[i].getMatricula().compareTo(key) != 0) {
            i++;
        }
        this.listAluno[n] = new Aluno();
        return i;
    }

    public int buscar(String matricula) {
        int index;
        if (this.isOrdenada) {
            index = buscaOrdenada(matricula);
        } else {
            index = buscaNaoOrdenada(matricula);
        }
        return index;
    }

    private boolean inclusaoOrdenada(Aluno aluno) {
        int n = this.tam;
        int i = buscar(aluno.getMatricula());
        if (i == n && n < this.cap) {
            this.listAluno[n] = new Aluno(aluno.getMatricula(), aluno.getNome(), aluno.getEmail());
            this.tam++;
            return true;
        } else if (!this.achou) {																								// se não achei na lista
            Aluno troca = new Aluno();																							// variavel de troca
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

    private boolean inclusaoNaoOrdenada(Aluno aluno) {
        int n = this.tam;
        if (n <= this.cap) {  
            if (buscar(aluno.getMatricula()) == n) {
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

    public boolean incluir(Aluno aluno) {
        if(this.tam == this.cap){
          return false;
        }
        boolean ok;
        if (this.isOrdenada) {
            ok = inclusaoOrdenada(aluno);
        } else {
            ok = inclusaoNaoOrdenada(aluno);
        }
        return ok;
    }

    private boolean remocaoOrdenada(Aluno aluno) {
        int n = this.tam;
        if (n > 0) {
            int i = buscar(aluno.getMatricula());
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

    private boolean remocaoNaoOrdenada(Aluno aluno) {
        int n = this.tam;
        if (n > 0) {																										// se a lista não estiver vazia
            int i = buscar(aluno.getMatricula());
            if (i < n) {																									// se achei na lista
                for (int j = i; j < n; j++) {																// removo o elemento de i
                    this.listAluno[j].setMatricula(this.listAluno[j + 1].getMatricula());
                    this.listAluno[j].setNome(this.listAluno[j + 1].getNome());
                    this.listAluno[j].setEmail(this.listAluno[j + 1].getEmail());
                }
                this.tam--;																							// e decrementa o tamanho
                return true;																							// consegui remover
            } else {
                return false; 																				// não cosnegui pq não achei		
            }
        } else {
            return false;
        }
    }

    public boolean remover(Aluno aluno) {
        if(this.tam == 0){
            return false;
        }
        boolean ok;
        if (this.isOrdenada) {
            ok = remocaoOrdenada(aluno);
        } else {
            ok = remocaoNaoOrdenada(aluno);
        }
        return ok;
    }

    public void printList() {
        for (int i = 0; i < this.tam; i++) {
            System.out.println(this.listAluno[i].getMatricula() + " | " + this.listAluno[i].getNome() + " | " + this.listAluno[i].getEmail());
        }
    }

    public Aluno getAluno(int n) {
        if (n < 0 || n >= this.tam) {
            return null;
        } else {
            return listAluno[n];
        }
    }

    public Aluno getAluno(String matricula) {
        int i = buscar(matricula);
        if ((this.isOrdenada && this.achou) && (!this.isOrdenada && i < this.tam)) {
            return listAluno[i];
        } else {
            return null;
        }
    }

    public int getTam() {
        return tam;
    }

    public int getCap() {
        return cap;
    }

}

