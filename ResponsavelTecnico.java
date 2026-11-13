public class ResponsavelTecnico extends Funcionario {
    public ResponsavelTecnico(String nome, String endereco, String cpf, String matricula, String salario, String setor, String cargo, String coren,
            String senha) {
        super(nome, endereco, cpf, matricula, salario, setor, cargo);
   
    }

    public void liberarProcedimento(Procedimento p) {
        if(this.equals(p.getResponsavelTecnico())) {
            p.setLiberadoResponsavelTecnico(true);
        } else {
            System.out.println("Apenas o responsável técnico do procedimento pode liberá-lo.");
        }
    }

}
