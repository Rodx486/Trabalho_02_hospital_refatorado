import java.util.ArrayList;

/**
 * Define o comportamento de um funcionário autorizado a agendar procedimentos.
 */
public interface Agendador {
 /**
  * Valida a senha e, se estiver correta, adiciona o procedimento à lista de agendamentos.
  * @param lista lista na qual o procedimento será agendado.
  * @param p procedimento a ser agendado.
  * @param senha senha informada para autenticação.
  */
 public void agendarProcedimento(ArrayList<Procedimento> lista, Procedimento p, String senha);
 /**
  * Retorna a senha usada para autenticar o agendamento.
  * @return senha de autenticação.
  */
 public String getSenha();

}
