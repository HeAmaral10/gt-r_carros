package repository;

import models.Carro;
import config.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarroRepository {

    // Criar um novo contato
    public void adicionarCarro(Carro carro) {
        String sql = "INSERT INTO carros (marca, modelo, cor, ano, motor, cambio) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getAno());
            stmt.setString(5, carro.getMotor());
            stmt.setString(6, carro.getCambio());


            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Carro adicionado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar carro.");
            e.printStackTrace();
        }
    }

    // Obter todos os contatos
    public List<Carro> obterTodosCarros() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carros";

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
            System.out.println("Erro ao obter contatos.");
            e.printStackTrace();
        }

        return carros;
    }

    // Obter contato por ID
    public Carro obterCarroPorId(int id) {
        String sql = "SELECT * FROM carros WHERE id = ?";
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
            System.out.println("Erro ao obter contato por ID.");
            e.printStackTrace();
        }

        return carro;
    }

    // Atualizar um contato
    public void atualizarCarro(Carro carro) {
        String sql = "UPDATE carros SET marca = ?, modelo = ?, cor = ?, ano = ?, motor = ?, cambio = ? WHERE id = ?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getMarca());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getAno());
            stmt.setString(5, carro.getMotor());
            stmt.setString(6, carro.getCambio());
            
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

    // Deletar um contato
    public void deletarCarro(int id) {
        String sql = "DELETE FROM carros WHERE id = ?";

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