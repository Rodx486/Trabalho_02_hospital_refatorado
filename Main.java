import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {

        //Aqui será guardados todos os pacientes cadastrados.
        ArrayList<Paciente> pacientes = new ArrayList<>();
        pacientes.add(new Paciente("Carlos Silva", "Rua das Flores, 123", "111.222.333-44"));
        pacientes.add(new Paciente("Mariana Souza", "Av. Brasil, 456", "555.666.777-88"));
        pacientes.add(new Paciente("Roberto Oliveira", "Rua Central, 789", "999.000.111-22"));

        //Aqui será guarddo todos os funicionarios cadastrados.
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Medico("Dr. João Mendes", "Rua A, 10", "123.456.789-00", "M001", "15000.00", "Centro Cirúrgico", "Médico", "Cirurgia Geral", "senha123"));
        funcionarios.add(new Medico("Dra. Fernanda Costa", "Rua D, 40", "456.789.012-33", "M002", "14500.00", "Ambulatório", "Médica", "Cardiologia", "med456"));
        funcionarios.add(new Medico("Dr. Rafael Almeida", "Rua E, 50", "567.890.123-44", "M003", "16000.00", "Estética", "Médico", "Dermatologia", "med789"));
        funcionarios.add(new Medico("Dra. Juliana Rocha", "Rua F, 60", "678.901.234-55", "M004", "15200.00", "Ortopedia", "Médica", "Ortopedia", "med321"));
        funcionarios.add(new Enfermeiro("Ana Paula", "Rua B, 20", "234.567.890-11", "E001", "5500.00", "Enfermaria", "Enfermeira", "COREN-12345", "senha456"));
        funcionarios.add(new Anestesista("Dr. Bruno Martins", "Rua G, 70", "789.012.345-66", "A001", "14000.00", "Centro Cirúrgico", "Anestesista", "CRM-54321", "anest123"));
        funcionarios.add(new ResponsavelTecnico("Dra. Patrícia Lima", "Rua H, 80", "890.123.456-77", "RT001", "18000.00", "Diretoria Clínica", "Responsável Técnico", "COREN-99999", "rt123"));
        funcionarios.add(new FuncionarioTecnicoAdministrativo("Lucas Ferreira", "Rua C, 30", "345.678.901-22", "T001", "3800.00", "Recepção", "Técnico Administrativo", "admin123"));

        //Aqui será guardado todos os procedimentos agendados.
        ArrayList<Procedimento> procedimentosAgendados = new ArrayList<>();


        




        
       
    }

}
