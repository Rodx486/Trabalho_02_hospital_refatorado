/**
 * Representa um procedimento cirúrgico e controla a alta e a saída do paciente.
 */
public class ProcedimentoCirurgico extends Procedimento {

    private Anestesista anestesista;
    private Enfermeiro enfermeiro;
    private boolean altaMedica = false;

    /**
     * Inicializa um novo objeto desta classe.
     * 
     * @param paciente             paciente associado ao procedimento.
     * @param medicoResponsavel    médico responsável pelo procedimento.
     * @param responsavelTecnico   responsável técnico associado ao procedimento.
     * @param anestesista          anestesista que participará do procedimento.
     * @param enfermeiro           enfermeiro que participará do procedimento.
     * @param especialidadeExigida especialidade necessária para o procedimento.
     */
    public ProcedimentoCirurgico(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico,
            Anestesista anestesista, Enfermeiro enfermeiro, String especialidadeExigida) {
        super(paciente, medicoResponsavel, responsavelTecnico, especialidadeExigida);
        this.anestesista = anestesista;
        this.enfermeiro = enfermeiro;
    }

    /**
     * Concede alta somente quando o médico informado é o responsável pelo
     * procedimento.
     * 
     * @param medicoResponsavel médico responsável pelo procedimento.
     */
    public void darAltaMedica(Medico medicoResponsavel) {
        if (medicoResponsavel.equals(getMedicoResponsavel())) {
            this.altaMedica = true;
            System.out.println("Alta médica concedida com sucesso pelo(a) " + medicoResponsavel.getNome() + "!");
        } else {
            System.out.println("Apenas o médico responsável pelo procedimento pode dar alta médica.");
        }
    }

    /**
     * Registra a saída do paciente quando a alta médica já foi concedida.
     */
    public void registrarSaidaPaciente() {
        if (this.altaMedica) {
            System.out.println("Paciente liberado para saída.");
        } else {
            System.out.println("Paciente não pode sair sem alta médica.");
        }

    }

    /**
     * Retorna uma descrição textual do objeto.
     * 
     * @return descrição textual do objeto.
     */
    @Override
    public String toString() {
        return super.toString()
                + " | Enfermeiro(a): " + this.enfermeiro.getNome()
                + " | Anestesista: " + this.anestesista.getNome()
                + " | Alta Médica: " + this.altaMedica;
    }

}
