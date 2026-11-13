public abstract class Procedimento {

    private Paciente paciente;
    private Medico medicoResponsavel;
    private ResponsavelTecnico responsavelTecnico;
    private boolean liberadoResponsavelTecnico = false;
    private String especialidadeExigida;

    public Procedimento(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico,
            String especialidadeExigida) {
        this.paciente = paciente;
        this.medicoResponsavel = medicoResponsavel;
        this.responsavelTecnico = responsavelTecnico;
        this.especialidadeExigida = especialidadeExigida;
        validaEspecialidade();
    }

    public boolean getLiberadoResponsavelTecnico() {
        return this.liberadoResponsavelTecnico;
    }

    public void setLiberadoResponsavelTecnico(boolean liberadoResponsavelTecnico) {
        this.liberadoResponsavelTecnico = liberadoResponsavelTecnico;
    }

    public Medico getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void validaEspecialidade() {
        if (!medicoResponsavel.getEspecialidade().equals(especialidadeExigida)) {
            throw new IllegalArgumentException(
                    "O médico responsável não possui a especialidade exigida para este procedimento.");
        }
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public ResponsavelTecnico getResponsavelTecnico() {
        return responsavelTecnico;
    }

    // sobrescrevendo o método toString para exibir informações do procedimento
    // se não fizermos a sobrescrita, o método toString da classe Object sera 
    // chamado, e ele por padrão retorna o nome da classe e o hashcode do objeto, o que não é muito útil para nós.
    @Override
    public String toString() {
        return "Tipo: " + this.getClass().getSimpleName() + // pega o nome da suclasse concreta
                " | Paciente: " + this.paciente.getNome() + // pega o nome do paciente
                " | Médico: " + this.medicoResponsavel.getNome() + // pega o nome do médico responsável
                " | Especialidade: " + this.especialidadeExigida +
                " | Liberado pelo RT: " + this.liberadoResponsavelTecnico;
    }
}
