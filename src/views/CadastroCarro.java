package views;
import java.awt.*;
import javax.swing.*;

public class CadastroCarro extends JFrame {

    private ImageIcon gtrImageIcon;
    private JLabel cadastroJLabel, marcaJLabel, modeloJLabel, corJLabel, anoJLabel, motorJLabel, cambioJLabel;
    private JTextField marcaJTextField, modeloJTextField, corJTextField, anoJTextField, motorJTextField;
    private JComboBox<String> cambioJComboBox;
    private JButton cadastrarButton;
    private JPanel imgcadJPanel, cadastroJPanel, buttonJPanel;

    public CadastroCarro() {

        super("GT-R CARROS - CADASTRO DE CARRO");

        cadastroJLabel = new JLabel("CADASTRO DE CARRO");
        imgcadJPanel = new JPanel();
        imgcadJPanel.setLayout(new GridLayout(1,1));
        imgcadJPanel.add(cadastroJLabel);

        marcaJLabel = new JLabel("MARCA:  ");
        modeloJLabel = new JLabel("MODELO:");
        corJLabel = new JLabel("COR:   ");
        anoJLabel = new JLabel("ANO:");
        motorJLabel = new JLabel("MOTOR:");
        cambioJLabel = new JLabel("CÂMBIO:");
        marcaJTextField =  new JTextField(25);
        modeloJTextField = new JTextField(25);
        corJTextField = new JTextField(25);
        anoJTextField = new JTextField(25);
        motorJTextField = new JTextField(25);
        cambioJComboBox = new JComboBox<>();
        cambioJComboBox.addItem("AUTOMÁTICO");
        cambioJComboBox.addItem("MANUAL");
        cadastroJPanel = new JPanel();
        cadastroJPanel.setLayout(new FlowLayout());
        cadastroJPanel.add(marcaJLabel);
        cadastroJPanel.add(marcaJTextField);
        cadastroJPanel.add(modeloJLabel);
        cadastroJPanel.add(modeloJTextField);
        cadastroJPanel.add(corJLabel);
        cadastroJPanel.add(corJTextField);
        cadastroJPanel.add(anoJLabel);
        cadastroJPanel.add(anoJTextField);
        cadastroJPanel.add(motorJLabel);
        cadastroJPanel.add(motorJTextField);
        cadastroJPanel.add(cambioJLabel);
        cadastroJPanel.add(cambioJComboBox);

        cadastrarButton = new JButton("CADASTRAR");
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new FlowLayout());
        buttonJPanel.add(cadastrarButton);

        add(imgcadJPanel, BorderLayout.NORTH);
        add(cadastroJPanel, BorderLayout.CENTER);
        add(buttonJPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(335, 300);

    }

    public static void main(String[] args) {
        CadastroCarro telacadastrocarro = new CadastroCarro();
        telacadastrocarro.setVisible(true);
    }
}