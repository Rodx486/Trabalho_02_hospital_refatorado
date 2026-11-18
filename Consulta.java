/**
 * Representa uma consulta médica realizada para um paciente.
 */
public class Consulta extends Procedimento {

    /**
     * Inicializa um novo objeto desta classe.
     * @param paciente paciente associado ao procedimento.
     * @param medicoResponsavel médico responsável pelo procedimento.
     * @param responsavelTecnico responsável técnico associado ao procedimento.
     * @param especialidadeExigida especialidade necessária para o procedimento.
     */
    public Consulta(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico, String especialidadeExigida) {
        super(paciente, medicoResponsavel, responsavelTecnico, especialidadeExigida);
    }
    
}
