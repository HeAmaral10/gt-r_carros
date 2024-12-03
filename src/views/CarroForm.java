package views;

import models.Carro;

import javax.swing.*;
import java.awt.*;

public class CarroForm extends JDialog {
    private JTextField marcaField;
    private JTextField modeloField;
    private JTextField corField;
    private JTextField anoField;
    private JTextField motorField;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JComboBox<String> cambioComboBox;

    private Carro carro;
    private boolean isEditMode;

    public CarroForm(Frame parent, String title) {
        super(parent, title, true);
        this.isEditMode = false;
        initializeComponents();
    }

    public CarroForm(Frame parent, String title, Carro carro) {
        super(parent, title, true);
        this.carro = carro;
        this.isEditMode = true;
        initializeComponents();
        preencherCampos();
    }

    private void initializeComponents() {
        // Initialize fields and buttons
        marcaField = new JTextField(20);
        modeloField = new JTextField(20);
        corField = new JTextField(20);
        anoField = new JTextField(20);
        motorField = new JTextField(20);
        cambioComboBox = new JComboBox<>();
        cambioComboBox.addItem("Manual");
        cambioComboBox.addItem("Automático");
        salvarButton = new JButton("Salvar");
        cancelarButton = new JButton("Cancelar");

        // Create panel and layout
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));
        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);
        panel.add(new JLabel("Cor:"));
        panel.add(corField);
        panel.add(new JLabel("Ano:"));
        panel.add(anoField);
        panel.add(new JLabel("Motor:"));
        panel.add(motorField);
        panel.add(new JLabel("Câmbio:"));
        panel.add(cambioComboBox);
        panel.add(salvarButton);
        panel.add(cancelarButton);

        // Add margins to the panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Action listener for save button
        salvarButton.addActionListener(e -> {
            if (validarCampos()) {
                if (isEditMode) {
                    atualizarCarro();
                } else {
                    adicionarCarro();
                }
                dispose();
            }
        });

        // Action listener for cancel button
        cancelarButton.addActionListener(e -> dispose());

        // Add panel to the dialog
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(getParent());
    }

    private void preencherCampos() {
        if (carro != null) {
            marcaField.setText(carro.getMarca());
            modeloField.setText(carro.getModelo());
            corField.setText(carro.getCor());
            anoField.setText(carro.getAno());
            motorField.setText(carro.getMotor());
            String.valueOf(cambioComboBox.getSelectedItem());
        }
    }

    private boolean validarCampos() {
        if (marcaField.getText().trim().isEmpty() || modeloField.getText().trim().isEmpty() || corField.getText().trim().isEmpty()
            || anoField.getText().trim().isEmpty() ||motorField.getText().trim().isEmpty()
            ) 
            {
            JOptionPane.showMessageDialog(
                this,
                "Marca, Modelo, Cor, Ano, Motor e Câmbio são obrigatórios",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
        return true;
    }

    private void adicionarCarro() {
        carro = new Carro(
            marcaField.getText().trim(),
            modeloField.getText().trim(),
            corField.getText().trim(),
            anoField.getText().trim(),
            motorField.getText().trim(),
            String.valueOf(cambioComboBox.getSelectedItem())
        );
    }

    private void atualizarCarro() {
        if (carro != null) {
            carro.setMarca(marcaField.getText().trim());
            carro.setModelo(modeloField.getText().trim());
            carro.setCor(corField.getText().trim());
            carro.setAno(anoField.getText().trim());
            carro.setMotor(motorField.getText().trim());
            carro.setCambio(String.valueOf(cambioComboBox.getSelectedItem()));
        }
    }

    public Carro getCarro() {
        return carro;
    }
}