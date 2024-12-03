package config; // Pacote para ser utilizada em outros arquivos no projeto

// Importação das bibliotecas necessárias para fazer a conexão com o banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Classe principal
public class DbConnection {
    // URL do banco de dados
    private static final String URL =
        "jdbc:mysql://localhost:3306/bdcarros?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // USER para acessar o banco
    private static final String PASSWORD = ""; // Senha para acessar o banco

    private static Connection connection = null; // Objeto para conexão

    // Função para conectar com o banco de dados
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Carregar o driver do MySQL (opcional em JDBC moderno)
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                // Erro caso não encontre o driver do MySQL
                System.out.println("Driver do MySQL não encontrado.");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Função para desconectar do banco de dados
    public static void disconnect(Connection connection) {
            try {
                // Fecha a conexão
                connection.close();
            } catch (SQLException e) {
                // Mensagem de erro ao tentar desconectar
                throw new RuntimeException("Error disconnection the database", e);
            }
        }
}