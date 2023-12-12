import java.sql.*;


public class File {
    private final static String url = "jdbc:mysql://127.0.0.1:3306/shop";
    private final static String username = "root";
    private final static String password = "1234567890";
    public String showAllProducts(){
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT d.name, p.name, p.price FROM department d JOIN product p ON d.iddepartment = p.department_id";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            StringBuilder result = new StringBuilder();
            String currentDepartment = null;
            while (resultSet.next()) {
                String departmentName = resultSet.getString(1);
                String productName = resultSet.getString(2);
                String productPrice = resultSet.getString(3);
                if (!departmentName.equals(currentDepartment)) {
                    if (currentDepartment != null) {
                        result.append("\n");
                    }
                    result.append("Department: ")
                            .append(departmentName)
                            .append("\n\t");
                    currentDepartment = departmentName;
                }
                result.append(productName)
                        .append(" Цена: ")
                        .append(productPrice)
                        .append("\n\t");
            }
            resultSet.close();
            statement.close();
            return result.toString();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String showProductInTheDepartment(String name){
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT d.name, p.name, p.price FROM department d JOIN product p ON d.iddepartment = p.department_id WHERE d.name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                String departmentName = resultSet.getString(1);
                String productName = resultSet.getString(2);
                String productPrice = resultSet.getString(3);
                result.append("Department: ")
                        .append(departmentName)
                        .append("\n\t")
                        .append(productName)
                        .append(" Цена: ")
                        .append(productPrice)
                        .append("\n\t");
            }
            resultSet.close();
            statement.close();
            return result.toString();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String showEmptyDepartment(){
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT d.name FROM department d WHERE d.iddepartment NOT IN (SELECT p.department_id FROM product p)";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                String departmentName = resultSet.getString(1);
                result.append("Empty Department: ")
                        .append(departmentName)
                        .append("\n");
            }
            resultSet.close();
            statement.close();
            return result.toString();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String addProduct(String name, String department, String price){
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String findDepartmentQuery = "SELECT iddepartment FROM department WHERE name = ?";
            PreparedStatement findDepartmentStatement = connection.prepareStatement(findDepartmentQuery);
            findDepartmentStatement.setString(1, department);
            ResultSet departmentResultSet = findDepartmentStatement.executeQuery();
            if (departmentResultSet.next()) {
                int departmentId = departmentResultSet.getInt("iddepartment");
                String insertProductQuery = "INSERT INTO product (name, price, department_id) VALUES (?, ?, ?)";
                PreparedStatement insertProductStatement = connection.prepareStatement(insertProductQuery);
                insertProductStatement.setString(1, name);
                insertProductStatement.setString(2, price);
                insertProductStatement.setInt(3, departmentId);
                int rowsAffected = insertProductStatement.executeUpdate();

                if (rowsAffected > 0) {
                    return "Товар добавлен";
                } else {
                    return "Не удалось добавить товар";
                }
            }
            return "Отдел не найден";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String addDepartment(String department, String openingHours){
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            // Проверка наличия отдела с таким же именем в базе данных
            String checkDepartmentQuery = "SELECT * FROM department WHERE name = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkDepartmentQuery);
            checkStatement.setString(1, department);
            ResultSet checkResultSet = checkStatement.executeQuery();
            if (checkResultSet.next()) {
                return "Найден отдел с таким же именем";
            }

            // Добавление нового отдела в базу данных
            String insertDepartmentQuery = "INSERT INTO department (name, opening_hours) VALUES (?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertDepartmentQuery);
            insertStatement.setString(1, department);
            insertStatement.setString(2, openingHours);
            int rowsAffected = insertStatement.executeUpdate();

            if (rowsAffected > 0) {
                return "Отдел добавлен";
            } else {
                return "Не удалось добавить отдел";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String deleteProduct(String name, String department){
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String findDepartmentQuery = "SELECT iddepartment FROM department WHERE name = ?";
            PreparedStatement findDepartmentStatement = connection.prepareStatement(findDepartmentQuery);
            findDepartmentStatement.setString(1, department);
            ResultSet departmentResultSet = findDepartmentStatement.executeQuery();
            if (departmentResultSet.next()) {
                int departmentId = departmentResultSet.getInt("iddepartment");
                String deleteProductQuery = "DELETE FROM product WHERE name = ? AND department_id = ?";
                PreparedStatement deleteProductStatement = connection.prepareStatement(deleteProductQuery);
                deleteProductStatement.setString(1, name);
                deleteProductStatement.setInt(2, departmentId);
                int rowsAffected = deleteProductStatement.executeUpdate();

                if (rowsAffected > 0) {
                    return "Товар удален";
                } else {
                    return "Товар не найден";
                }
            }

            return "Отдел не найден";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String deleteDepartment(String department){
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "DELETE FROM department WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, department);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return "Department removed";
            } else {
                return "Department not found";
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}