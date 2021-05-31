package listas;

/**
 *
 * @author Herbert Nascimento
 */
public class ListSequencial {

    private Aluno[] listAluno;
    private int cap;
    private int ini;
    private int fim;
    private boolean tipo;

    public ListSequencial() {
        this.cap = 100;
        this.listAluno = new Aluno[this.cap];
        this.ini = 0;
        this.fim = 0;
        this.tipo = true;
    }

    public ListSequencial(int cap, boolean tipo) {
        this.cap = cap;
        this.listAluno = new Aluno[this.cap];
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

    public boolean remList(Aluno aluno) {
        boolean retorno;
        if (this.tipo) {
            retorno = remPilhaAlunos(aluno);
        } else {
            retorno = remFilaAlunos(aluno);
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

    private boolean remPilhaAlunos(Aluno aluno) {
        if (this.fim == 0) {
            return false;
        } else {
            this.fim--;
            aluno.copiaAluno(aluno, this.listAluno[this.fim]);
            return true;
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

    private boolean remFilaAlunos(Aluno aluno) {
        if (this.fim == this.ini) {
            return false;
        } else {
            aluno.copiaAluno(aluno, this.listAluno[this.ini % this.cap]);
            this.ini++;
            return true;
        }        
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

