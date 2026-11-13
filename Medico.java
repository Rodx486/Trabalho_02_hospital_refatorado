import java.util.ArrayList;
public class Medico extends Funcionario implements Agendador {

    private String especialidade;
    private String senha;

    public Medico(String nome, String endereco, String cpf, String matricula, String salario, String setor, String cargo, String especialidade, String senha) {
        super(nome, endereco, cpf, matricula, salario, setor, cargo);
        this.especialidade = especialidade;
        this.senha = senha;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getSenha() {
        return senha;
    }

    
    public void agendarProcedimento(ArrayList<Procedimento> lista, Procedimento p, String senha) {
        if (this.senha.equals(senha)) {
            lista.add(p);
            System.out.println("Procedimento agendado com sucesso!");
        } else {
            System.out.println("Senha incorreta. Não foi possível agendar o procedimento.");
        }
    }
}


