/**
 * Representa um procedimento estético e os profissionais envolvidos.
 */
public class ProcedimentoEstetico extends Procedimento {

    private Enfermeiro enfermeiro;
    private Anestesista anestesista;

    /**
     * Inicializa um novo objeto desta classe.
     * 
     * @param paciente             paciente associado ao procedimento.
     * @param medicoResponsavel    médico responsável pelo procedimento.
     * @param responsavelTecnico   responsável técnico associado ao procedimento.
     * @param enfermeiro           enfermeiro que participará do procedimento.
     * @param anestesista          anestesista que participará do procedimento.
     * @param especialidadeExigida especialidade necessária para o procedimento.
     */
    public ProcedimentoEstetico(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico,
            Enfermeiro enfermeiro, Anestesista anestesista, String especialidadeExigida) {
        super(paciente, medicoResponsavel, responsavelTecnico, especialidadeExigida);
        this.enfermeiro = enfermeiro;
        this.anestesista = anestesista;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Enfermeiro(a): " + this.enfermeiro.getNome()
                + " | Anestesista: " + this.anestesista.getNome();
    }

}
