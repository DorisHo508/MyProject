package tw.com.eeit.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public interface IFactoryDao {
	public void add(Factory f) throws SQLException;
	public void update(Factory f) throws SQLException;
	public void deleteById(int id) throws SQLException;
	public Factory findById(int id) throws SQLException;
	public Factory findByArea(String area) throws SQLException;
	public Factory findByCity(String city) throws SQLException;
	public void createConn() throws Exception;
	public void closeConn() throws SQLException;
	public void fileInput() throws FileNotFoundException, SQLException;
	public void imageInput() throws SQLException, FileNotFoundException ;
	public void imageRetrieve(int id) throws SQLException, IOException;

}
