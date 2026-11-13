public class ProcedimentoCirurgico extends Procedimento {

    private Anestesista anestesista;
    private Enfermeiro enfermeiro;
    private boolean altaMedica = false;


    public ProcedimentoCirurgico(Paciente paciente, Medico medicoResponsavel, ResponsavelTecnico responsavelTecnico, Anestesista anestesista, Enfermeiro enfermeiro , String especialidadeExigida) {
        super(paciente, medicoResponsavel, responsavelTecnico, especialidadeExigida );
        this.anestesista = anestesista;
        this.enfermeiro = enfermeiro;
    }
    
    public void darAltaMedica(Medico medicoResponsavel) {
        if (medicoResponsavel.equals(getMedicoResponsavel())) {
            this.altaMedica = true;
        } else {
            System.out.println("Apenas o médico responsável pelo procedimento pode dar alta médica.");
        }
    }

    public void registrarSaidaPaciente() {
       if (this.altaMedica) {
            System.out.println("Paciente liberado para saída.");
        } else {
            System.out.println("Paciente não pode sair sem alta médica.");
        }   
        
    }

}
