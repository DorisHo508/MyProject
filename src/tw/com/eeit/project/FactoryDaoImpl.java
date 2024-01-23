package tw.com.eeit.project;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FactoryDaoImpl implements IFactoryDao {

	@Override
	public void add(Factory f) throws SQLException {
		String sqlstr = "insert into Factory(area, city, name, address, phone, website) values (?,?,?,?,?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, f.getArea());
		state.setString(2, f.getCity());
		state.setString(3, f.getName());
		state.setString(4, f.getAddress());
		state.setString(5, f.getPhone());
		state.setString(6, f.getWebsite());
		state.executeUpdate();
		System.out.println("insert finish!");
		state.close();
	}

	@Override
	public void update(Factory f) throws SQLException {
		String sqlstr = "update Factory set area=?, city=?, address=?, phone=? where id=? ";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, f.getArea());
		state.setString(2, f.getCity());
		state.setString(3, f.getAddress());
		state.setString(4, f.getPhone());
		state.setInt(5, f.getId());
		state.executeUpdate();
		System.out.println("update finish!");
		state.close();
	}

	@Override
	public void deleteById(int id) throws SQLException {
		String sqlstr = "delete from Factory where id=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, id);
		state.execute();
		System.out.println("delete finish!");
		state.close();
	}
	
	@Override
	public Factory findById(int id) throws SQLException {
		String sqlstr = "select * from Factory where id=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, id);;
		ResultSet rs = state.executeQuery();
		Factory f = null;
		if(rs.next()) {
			f = new Factory(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)); 
		}
		System.out.println("id:"+rs.getInt(1));
		System.out.println("area:"+rs.getString(2));
		System.out.println("city:"+rs.getString(3));
		System.out.println("name:"+rs.getString(4));
		System.out.println("address:"+rs.getString(5));
		System.out.println("phone:"+rs.getString(6));
		System.out.println("website:"+rs.getString(7));
		rs.close();
		state.close();
		return f;
	}
	
	@Override
	public Factory findByArea(String area) throws SQLException {
		String sqlstr = "select * from Factory where area=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, area);;
		ResultSet rs = state.executeQuery();
		Factory f = null;
		while(rs.next()) {
		System.out.println("id:"+rs.getInt(1));
		System.out.println("area:"+rs.getString(2));
		System.out.println("city:"+rs.getString(3));
		System.out.println("name:"+rs.getString(4));
		System.out.println("address:"+rs.getString(5));
		System.out.println("phone:"+rs.getString(6));
		System.out.println("website:"+rs.getString(7));
		
		}
		rs.close();
		state.close();
		return f;
	}

	@Override
	public Factory findByCity(String city) throws SQLException {
		String sqlstr = "select * from Factory where city=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, city);
		ResultSet rs = state.executeQuery();
		Factory f = null;
		while(rs.next()) {
			System.out.println("id:"+rs.getInt(1));
			System.out.println("area:"+rs.getString(2));
			System.out.println("city:"+rs.getString(3));
			System.out.println("name:"+rs.getString(4));
			System.out.println("address:"+rs.getString(5));
			System.out.println("phone:"+rs.getString(6));
			System.out.println("website:"+rs.getString(7));
		}
		rs.close();
		state.close();
		return f;
	}
	
	@Override
	public void imageInput() throws SQLException, FileNotFoundException {
		FileInputStream fis1 = new FileInputStream("C:\\test\\images01.jpg");  //檔案位置
		String sqlstr = "insert into FactoryImages(fileName, fileContent) values(?,?)";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setString(1, "images01");  //檔案名稱
		state.setBinaryStream(2, fis1);
		state.executeUpdate();
		state.close();
	}
	
	@Override
	public void imageRetrieve(int id) throws SQLException, IOException {
		String sqlstr = "select * from FactoryImages where fileId=?";
		PreparedStatement state = conn.prepareStatement(sqlstr);
		state.setInt(1, id);
		ResultSet rs = state.executeQuery();
		
		if(rs.next()) {
			Blob blob = rs.getBlob(3);
			int length = (int)blob.length();
			
			BufferedOutputStream bos1 = new BufferedOutputStream(new FileOutputStream("C:/test/newImages01.jpg"));  //新的檔案位置
			bos1.write(blob.getBytes(1, length));
			bos1.flush();
			bos1.close();
			
			rs.close();
			state.close();
			System.out.println("File Download");
		}
		
	}
	
	private Connection conn;

	@Override
	public void createConn() throws Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String urlstr = "jdbc:sqlserver://localhost:1433;databaseName=MyProject;user=watcher;password=P@sswOrd;encrypt=true;trustServerCertificate=true";
		conn = DriverManager.getConnection(urlstr); 
		System.out.println("Connection Status:" + !conn.isClosed());
		
	}

	@Override
	public void closeConn() throws SQLException {
		if (conn != null) {
			conn.close();
		}
		System.out.println("Connection Closed");
	}

	@Override
	public void fileInput() throws FileNotFoundException, SQLException {
try {
			
			FileReader fr = new FileReader("C:\\test\\TourismFactory.csv");
			BufferedReader bf = new BufferedReader(fr);
			String Line = null;
			bf.readLine();
			 while((Line = bf.readLine())!=null) {
				 
				 String[] array=Line.split(",");
					for(int i=1;i<array.length;i++){
					}
					String sqlstr = "insert into Factory(area, city, name, address, phone, webSite) values(?,?,?,?,?,?)";
							
					PreparedStatement state = conn.prepareStatement(sqlstr);
					state.setString(1, array[1]);
					state.setString(2, array[2]);
					state.setString(3, array[3]);
					state.setString(4, array[4]);
					state.setString(5, array[5]);
					state.setString(6, array[6]);
					state.executeUpdate();
					state.close();
		}
			 bf.close();
	}catch (IOException e) {e.printStackTrace();}
		
	}
}
