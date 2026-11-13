public class ProcedimentoEstetico extends Procedimento {

    private Enfermeiro enfermeiro;
    private Anestesista anestesista;

    public ProcedimentoEstetico(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico, Enfermeiro enfermeiro, Anestesista anestesista, String especialidadeExigida) {
        super(paciente, medicoResponsavel, responsavelTecnico, especialidadeExigida);
        this.enfermeiro = enfermeiro;
        this.anestesista = anestesista;
    }
    
}
