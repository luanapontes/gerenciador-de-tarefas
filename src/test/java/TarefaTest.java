import javax.persistence.Persistence;

public class TarefaTest {

	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("gerenciador-de-tarefas");

	}

}
