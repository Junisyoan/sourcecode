
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestMySQL {

	public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://129.28.83.44:3306/cymedical";
        //MySQL配置时的用户名
        String user = "admin";
        //MySQL配置时的密码
        String password = "123";
        //遍历查询结果集
            //加载驱动程序
            try {
				Class.forName(driver);
				//1.getConnection()方法，连接MySQL数据库！！
				con = DriverManager.getConnection(url,user,password);
				if(!con.isClosed()) {
					System.out.println("连接成功");
					Thread.sleep(5000);
					con.close();
				}else {
					System.out.println("失败");
				}
            } catch (ClassNotFoundException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            } catch (SQLException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	
}
