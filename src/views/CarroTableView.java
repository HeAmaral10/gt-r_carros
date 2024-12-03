package views; // Pacote para ser utilizada em outros arquivos no projeto

// Importação do pacote
import models.Carro;

// Importação das bibliotecas
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

// Classe principal
public class CarroTableView extends JFrame {
    // Criação dos objetos
    private JTable table;
    private DefaultTableModel tableModel;
    // private ImageIcon imageIcon;
    // private JLabel imageLabel;

    // Método construtor para iniciar a visualização da tabela
    public CarroTableView() {
        super("Gerenciamento de Carros");
        initializeComponents();
    }

    // Função para iniciar os componentes
    private void initializeComponents() {

        // imageIcon = new ImageIcon(getClass().getResource("gt-r_image.png"));
        // imageLabel = new JLabel(imageIcon);

        // Define os nomes das colunas
        String[] columnNames = {"ID", "Marca", "Modelo", "Cor", "Ano", "Motor", "Câmbio" };

        // Inicia o modelo da tabela e a tabela
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // Adiciona a tabela no scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Define o layout
        this.setLayout(new BorderLayout());
        // this.add(imageLabel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        // Configura as propriedades da janela
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    // Função para atualizar a tabela
    public void atualizarTabela(List<Carro> carros) {
        // Limpa a tabela
        tableModel.setRowCount(0);

        // Preenche a tabela
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
            return (int) tableModel.getValueAt(selectedRow, 0); // Pega o ID da primeira coluna
        }
        return -1; // Returna -1 se nenhuma linha for selecionada
    }
}
