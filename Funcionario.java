public abstract class Funcionario extends Pessoa {
    
    private String matricula;
    private String salario;
    private String setor;
    private String cargo;


    public Funcionario(String nome, String endereco, String cpf, String matricula,String salario, String setor, String cargo) {
        super(nome, endereco, cpf);
        this.matricula = matricula;
        this.salario = salario;
        this.setor = setor;
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSalario() {
        return salario;
    }

    public String getSetor() {
        return setor;
    }

    public String getCargo() {
        return cargo;
    }
}
    

