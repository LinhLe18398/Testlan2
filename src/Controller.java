import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

    public void getAllData() throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connection();

        String query = "select * from student";

        Statement statement = connectJDBC.connection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            System.out.println(" id: " + id + " name: " + name + " age: " + age);
        }
    }

    public void insertData(Student newStudent) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connection();

        String query = "insert into student(id,name,age)  values  (?,?,?)";
        PreparedStatement preparedStatement = connectJDBC.connection().prepareStatement(query);

        preparedStatement.setString(1, newStudent.getId());
        preparedStatement.setString(2, newStudent.getName());
        preparedStatement.setInt(3,newStudent.getAge());

        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public void deleteData(String deleteId) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connection();

        String query = "delete from student where id = ?";
        PreparedStatement preparedStatement = connectJDBC.connection().prepareStatement(query);

        preparedStatement.setString(1,deleteId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void searchData(String keyword) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connection();
        String query = "select * from student where name like '%" + keyword + "%'";

        Statement statement = connectJDBC.connection().createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(" id: " + id + " name: " + name + " age: " + age);
        }

    }

    public void updateData(String id, String newValue, int newAge) throws SQLException {
        ConnectJDBC connectJDBC = new ConnectJDBC();
        connectJDBC.connection();
        String query = "update student set name = ?, age = ? where id = ?";

        PreparedStatement preparedStatement = connectJDBC.connection().prepareStatement(query);
        preparedStatement.setString(1,newValue);
        preparedStatement.setInt(2, newAge);
        preparedStatement.setString(3,id);


        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

}
