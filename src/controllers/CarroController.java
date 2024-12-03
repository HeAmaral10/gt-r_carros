package controllers; // Pacote para ser utilizada em outros arquivos no projeto

// Importação dos pacotes
import models.Carro;
import repository.CarroRepository;
import views.CarroForm;
import views.CarroTableView;

// Importação das bibliotecas para criação da interface gráfica, ação dos botões e listas
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Classe principal
public class CarroController {
    // Criação dos objetos para utilização das funções em repository e para criação da tabela
    private CarroRepository repository;
    private CarroTableView tableView;
    // private ImageIcon imageIcon;
    // private JLabel imageLabel;

    // Método construtor para iniciar o controller    
    public CarroController() {
        repository = new CarroRepository();
        tableView = new CarroTableView();
        inicializar();
    }

    // Função para iniciar a tabela, toolBar e os botões
    private void inicializar() {
        // Atualizar a tabela com os carros existentes
        atualizarTabela();

        // imageIcon = new ImageIcon(getClass().getResource("gt-r_image.png"));
        // imageLabel = new JLabel(imageIcon);
        
        // Criar a barra de ferramentas (toolbar) com botões
        JToolBar toolBar = new JToolBar();
        JButton adicionarButton = new JButton("Adicionar");
        JButton editarButton = new JButton("Editar");
        JButton deletarButton = new JButton("Deletar");
        toolBar.add(adicionarButton);
        toolBar.add(editarButton);
        toolBar.add(deletarButton);

        // tableView.add(imageLabel, java.awt.BorderLayout.NORTH);
        tableView.add(toolBar, java.awt.BorderLayout.NORTH);

        // Ações dos botões
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarCarro();
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarCarro();
            }
        });

        deletarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletarCarro();
            }
        });

        tableView.setVisible(true);
    }

    // Função para atualizar a tabela
    private void atualizarTabela() {
        List<Carro> carros = repository.obterTodosCarros();
        tableView.atualizarTabela(carros);
    }

    // Função para adicionar carro
    private void adicionarCarro() {
        CarroForm form = new CarroForm(tableView, "Adicionar Carro");
        form.setVisible(true);
        Carro novoCarro = form.getCarro();
        if (novoCarro != null) {
            repository.adicionarCarro(novoCarro);
            atualizarTabela();
        }
    }

    // Função para editar carro
    private void editarCarro() {
        int selectedId = tableView.getSelectedCarroId();
        if (selectedId != -1) {
            Carro carro = repository.obterCarroPorId(selectedId);
            if (carro != null) {
                CarroForm form = new CarroForm(tableView, "Editar Carro", carro);
                form.setVisible(true);
                Carro carroAtualizado = form.getCarro();
                if (carroAtualizado != null) {
                    carroAtualizado = new Carro(
                        selectedId,
                        carroAtualizado.getMarca(),
                        carroAtualizado.getModelo(),
                        carroAtualizado.getCor(),
                        carroAtualizado.getAno(),
                        carroAtualizado.getMotor(),
                        carroAtualizado.getCambio()
                    );
                    repository.atualizarCarro(carroAtualizado);
                    atualizarTabela();
                }
            } else {
                JOptionPane.showMessageDialog(tableView,
                        "Carro não encontrado.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(tableView,
                    "Selecione um carro para editar.",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Função para deletar carro
    private void deletarCarro() {
        int selectedId = tableView.getSelectedCarroId();
        if (selectedId != -1) {
            int confirm = JOptionPane.showConfirmDialog(
                    tableView,
                    "Tem certeza que deseja deletar este carro?",
                    "Confirmar Deleção",
                    JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_NO_OPTION) {
                repository.deletarCarro(selectedId);
                atualizarTabela();
            }
        } else {
            JOptionPane.showMessageDialog(
                    tableView,
                    "Selecione um carro para deletar.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void iniciar() {
        // Ações são inicializadas no construtor
    }
}