import java.util.ArrayList;
public class FuncionarioTecnicoAdministrativo extends Funcionario implements Agendador{

    private String senha;

    public FuncionarioTecnicoAdministrativo(String nome, String endereco, String cpf, String matricula, String salario, String setor, String cargo, String senha) {
        super(nome, endereco, cpf, matricula, salario, setor, cargo);
        this.senha = senha;
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
