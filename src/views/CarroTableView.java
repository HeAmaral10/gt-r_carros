package views;

import models.Carro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CarroTableView extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public CarroTableView() {
        super("Gerenciamento de Carros");
        initializeComponents();
    }

    private void initializeComponents() {
        // Define column names
        String[] columnNames = {"ID", "Marca", "Modelo", "Cor", "Ano", "Motor", "Câmbio" };

        // Initialize table model and table
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Set up the layout
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);

        // Configure frame properties
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void atualizarTabela(List<Carro> carros) {
        // Clear the table
        tableModel.setRowCount(0);

        // Populate the table with data
        for (Carro carro : carros) {
            Object[] row = {
                carro.getID(),
                carro.getMarca(),
                carro.getModelo(),
                carro.getCor(),
                carro.getAno(),
                carro.getMotor(),
                carro.getCambio()
            };
            tableModel.addRow(row);
        }
    }

    public int getSelectedCarroId() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            return (int) tableModel.getValueAt(selectedRow, 0); // Get the ID from the first column
        }
        return -1; // Return -1 if no row is selected
    }
}
