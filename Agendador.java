import java.util.ArrayList;

public interface Agendador {
 public void agendarProcedimento(ArrayList<Procedimento> lista, Procedimento p, String senha);
 public String getSenha();

}
