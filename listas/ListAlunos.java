package listas;

/**
 *
 * @author Herbert Nascimento
 */
public class ListAlunos {

    private int tam;
    private int cap;
    private boolean achou;
    private Aluno[] listAluno;
    private Aluno aluno;
    private boolean isOrdenada;

    public ListAlunos() {
        this.cap = 100;
        this.listAluno = new Aluno[this.cap];
        this.tam = 0;
        this.achou = false;
        this.isOrdenada = true;
    }

    public ListAlunos(int cap, boolean isOrdenada) {
        this.cap = cap;
        this.listAluno = new Aluno[this.cap];
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
        this.listAluno[n] = new Aluno(null, null, null);
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
        } else if (!this.achou) {																								// se n??o achei na lista
            Aluno troca;																							// variavel de troca
            for (int j = i; j < n; j++) {
                troca = this.listAluno[j];
                listAluno[j] = aluno;
                aluno = troca;
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
                for (int j = i; j < n - 1; j++) {
                    this.listAluno[j].copiaAluno(listAluno[j], this.listAluno[j + 1]);
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
        if (n > 0) {																										// se a lista n??o estiver vazia
            int i = buscar(aluno.getMatricula());
            if (i < n) {																									// se achei na lista
                for (int j = i; j < n - 1; j++) // removo o elemento de i
                {
                    this.listAluno[j].copiaAluno(listAluno[j], this.listAluno[j + 1]);
                }
                this.tam--;																							// e decrementa o tamanho
                return true;																							// consegui remover
            } else {
                return false; 																				// n??o cosnegui pq n??o achei		
            }
        } else {
            return false;
        }
    }

    public boolean remover(Aluno aluno) {
        boolean ok;
        if (this.isOrdenada) {
            ok = remocaoOrdenada(aluno);
        } else {
            ok = remocaoNaoOrdenada(aluno);
        }
        return ok;
    }

    public Aluno getListAluno(int n) {
        if (n < 0 || n >= this.tam) {
            return null;
        } else {
            return listAluno[n];
        }
    }

    public Aluno getAluno(String matricula) {
        int i = buscar(matricula);
        if ((this.isOrdenada && this.achou) || (!this.isOrdenada && i < this.tam)) {
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

    @Override
    public String toString() {
        String list = new String();
        for (int i = 0; i < this.tam; i++) {
            list = list + this.listAluno[i].getMatricula() + " | " + this.listAluno[i].getNome() + " | " + this.listAluno[i].getEmail() + "\n";
        }
        return list;
    }

}

