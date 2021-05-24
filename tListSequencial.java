package listas;

public class tListSequencial {

    private Aluno[] listAluno;
    private int cap;
    private int ini;
    private int fim;
    private boolean tipo;

    public tListSequencial(int cap) {
        this.listAluno = new Aluno[cap];
        this.cap = cap;
        this.ini = 0;
        this.fim = 0;
        this.tipo = true;
    }

    public tListSequencial(int cap, boolean tipo) {
        this.listAluno = new Aluno[cap];
        this.cap = cap;
        this.ini = 0;
        this.fim = 0;
        this.tipo = tipo;
    }

    public boolean incList(Aluno aluno) {
        boolean retorno;
        if (this.tipo) {
            retorno = incPilhaAlunos(aluno);
        } else {
            retorno = incFilaAlunos(aluno);
        }
        return retorno;
    }

    public boolean remList() {
        boolean retorno;
        if (this.tipo) {
            retorno = remPilhaAlunos();
        } else {
            retorno = remFilaAlunos();
        }
        return retorno;
    }

    private boolean incPilhaAlunos(Aluno aluno) {
        if (this.fim == this.cap) {
            return false;
        } else {
            this.listAluno[this.fim] = new Aluno(aluno.getMatricula(), aluno.getNome(), aluno.getEmail());
            this.fim++;
        }
        return true;
    }

    private boolean remPilhaAlunos() {
        if (this.fim == 0) {
            return false;
        } else {
            this.listAluno[this.fim % this.cap] = new Aluno(null, null, null);
            this.fim--;
        }
        return true;
    }

    private boolean incFilaAlunos(Aluno aluno) {
        if (this.fim - this.ini == this.cap) {
            return false;
        } else {
            this.listAluno[this.fim % this.cap] = new Aluno(aluno.getMatricula(), aluno.getNome(), aluno.getEmail());
        }
        this.fim++;
        return true;
    }

    private boolean remFilaAlunos() {
        if (this.fim == this.ini) {
            return false;
        } else {
            this.listAluno[this.ini % this.cap] = new Aluno(null, null, null);
            this.ini++;
        }
        return true;
    }
    
        public void printListSeq() {
        for (int i = this.ini; i < this.fim; i++) {
            System.out.println(this.listAluno[i].getMatricula() + " | " + this.listAluno[i].getNome() + " | " + this.listAluno[i].getEmail());
        }
    }

}
