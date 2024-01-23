package tw.com.eeit.project;

public class FactoryDao {
	
	public static IFactoryDao createFactoryDao() {
		return new FactoryDaoImpl();
	}

}
