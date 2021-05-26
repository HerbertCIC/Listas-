package listas;

public class tListSequencial {

    private Aluno[] listAluno;
    private int cap;
    private int ini;
    private int fim;
    private boolean tipo;

    public tListSequencial() {
        this.cap = 100;
        this.listAluno = new Aluno[this.cap];
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

    public Aluno remList() {
        Aluno aluno;
        if (this.tipo) {
            aluno = remPilhaAlunos();
        } else {
            aluno = remFilaAlunos();
        }
        return aluno;
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

    private Aluno remPilhaAlunos() {
        if (this.fim == 0) {
            Aluno aluno = new Aluno();
            return aluno;
        } else {
            this.fim--;
            return this.listAluno[this.fim];
        }
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

    private Aluno remFilaAlunos() {
        Aluno aluno = new Aluno();
        if (this.fim == this.ini) {
            return aluno;
        } else {
            aluno = this.listAluno[this.ini % this.cap];
            this.ini++;
        }
        return aluno;
    }

    @Override
    public String toString() {
        String list = new String();
        for (int i = 0; i < this.fim-this.ini; i++) {
            list = list + this.listAluno[i].getMatricula() + " | " + this.listAluno[i].getNome() + " | " + this.listAluno[i].getEmail() + "\n";
        }
        return list;
    }

    public int getCap() {
        return cap;
    }

    public int getIni() {
        return ini;
    }

    public int getFim() {
        return fim;
    }

}
