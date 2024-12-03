package views; // Pacote para ser utilizada em outros arquivos no projeto

// Importação do pacote
import models.Carro;

// Importação das bibliotecas
import javax.swing.*;
import java.awt.*;

// Classe principal
public class CarroForm extends JDialog {
    // Criação dos objetos
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

    // Método construtor para iniciar o formulário
    public CarroForm(Frame parent, String title) {
        super(parent, title, true);
        this.isEditMode = false;
        initializeComponents();
    }
    
    // Método construtor para iniciar o formulário e preencher os campos automático
    public CarroForm(Frame parent, String title, Carro carro) {
        super(parent, title, true);
        this.carro = carro;
        this.isEditMode = true;
        initializeComponents();
        preencherCampos();
    }

    private void initializeComponents() {
        // Inicia os TextField, ComboBox e os botões
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

        // Cria o panel e define o layout
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

        // Adiciona margens no panel
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Ação do botão Salvar
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

        // Ação do botão Cancelar
        cancelarButton.addActionListener(e -> dispose());

        // Adiciona o painel na caixa de diálogo
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(getParent());
    }

    // Função para preencher os campos automaticamente
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

    // Função para conferir se todos os campos estão preenchidos
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

    // Função para adicionar carro
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

    // Função para atualizar carro
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

    // Serve para pegar as informações de um carro
    public Carro getCarro() {
        return carro;
    }
}