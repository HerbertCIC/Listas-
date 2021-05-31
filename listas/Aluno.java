package listas;

/**
 *
 * @author Herbert Nascimento
 */
public class Aluno {

    private String matricula;
    private String nome;
    private String email;

    public Aluno(String matricula, String nome, String email) {
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void copiaAluno(Aluno destino, Aluno origem){
        destino.setMatricula(origem.getMatricula());
        destino.setNome(origem.getNome());
        destino.setEmail(origem.getEmail());
    }

    @Override
    public String toString() {
        return matricula + " | " + nome + " | " + email;
    }

}