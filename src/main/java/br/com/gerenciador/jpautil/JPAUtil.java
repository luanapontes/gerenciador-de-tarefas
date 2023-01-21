package br.com.gerenciador.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory = null;

	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("gerenciador-de-tarefas");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object obj) {
		return factory.getPersistenceUnitUtil().getIdentifier(obj);
		
	}

}
