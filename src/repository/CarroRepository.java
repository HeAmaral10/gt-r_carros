package repository; // Pacote para ser utilizada em outros arquivos no projeto

// Importação dos pacotes
import models.Carro;
import config.DbConnection;

// Importação das bibliotecas
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// Classe principal
public class CarroRepository {

    // Criar um novo carro
    public void adicionarCarro(Carro carro) {
        // Comando sql para inserir carro
        String sql = "INSERT INTO carros (marca, modelo, cor, ano, motor, cambio) VALUES (?, ?, ?, ?, ?, ?)";

        // Tentativa de conexão com o banco de dados
        try (Connection conn = DbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) { // Instância para ser efetuada comandos sql

            // Pegar todas as informações para enviar pro banco de dados
            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getAno());
            stmt.setString(5, carro.getMotor());
            stmt.setString(6, carro.getCambio());

            // Confere se foi adicionado um carro no banco e retorna uma mensagem
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Carro adicionado com sucesso!");
            }
        } catch (SQLException e) {
            // Erro ao tentar adicionar carro
            System.out.println("Erro ao adicionar carro.");
            e.printStackTrace();
        }
    }

    // Obter todos os carros
    public List<Carro> obterTodosCarros() {
        List<Carro> carros = new ArrayList<>(); // Array para guardar todos os carros
        String sql = "SELECT * FROM carros"; // Comando sql para consulta

        // Tentativa de conexão com o banco
        try (Connection conn = DbConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Carro carro = new Carro(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("cor"),
                    rs.getString("ano"),
                    rs.getString("motor"),
                    rs.getString("cambio")
                );
                carros.add(carro);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter todos os carros.");
            e.printStackTrace();
        }

        return carros;
    }

    // Obter carro por ID
    public Carro obterCarroPorId(int id) {
        String sql = "SELECT * FROM carros WHERE id = ?"; // Comando sql para listar um carro através do id
        Carro carro = null;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                carro = new Carro(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("cor"),
                    rs.getString("ano"),
                    rs.getString("motor"),
                    rs.getString("cambio")
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter carro por ID.");
            e.printStackTrace();
        }

        return carro;
    }

    // Atualizar um carro
    public void atualizarCarro(Carro carro) {
        // Comando sql para atualizar um carro
        String sql = 
            "UPDATE carros SET marca = ?, modelo = ?, cor = ?, ano = ?, motor = ?, cambio = ? WHERE id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getAno());
            stmt.setString(5, carro.getMotor());
            stmt.setString(6, carro.getCambio());
            stmt.setInt(7, carro.getID());
            
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Carro atualizado com sucesso!");
            } else {
                System.out.println("Carro não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar carro.");
            e.printStackTrace();
        }
    }

    // Deletar carro
    public void deletarCarro(int id) {
        String sql = "DELETE FROM carros WHERE id = ?"; // Comando sql para deletar um carro

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Carro deletado com sucesso!");
            } else {
                System.out.println("Carro não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar carro.");
            e.printStackTrace();
        }
    }
}