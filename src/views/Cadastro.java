package views;
import java.awt.*;
import javax.swing.*;

public class Cadastro extends JFrame {
    private ImageIcon gtrImageIcon;
    private JLabel cadastroJLabel, nomeJLabel, nicknameJLabel, senhaJLabel;
    private JTextField nomeJTextField, nicknameJTextField, senhaJTextField;
    private JButton cadastrarJButton;
    private JPanel imageJPanel, cadastroJPanel, centerJPanel, buttonJPanel;

    public Cadastro() {

        super("GT-R CARROS - CADASTRO");

        cadastroJLabel = new JLabel("CADASTRO DE USUÁRIO");
        cadastroJPanel = new JPanel();
        cadastroJPanel.setLayout(new FlowLayout());
        cadastroJPanel.add(cadastroJLabel);

        nicknameJLabel = new JLabel("NICKNAME:");
        senhaJLabel = new JLabel("SENHA:       ");
        nomeJLabel = new JLabel("NOME:        ");
        nicknameJTextField = new JTextField(30);
        senhaJTextField = new JTextField(30);
        nomeJTextField = new JTextField(30);
        centerJPanel = new JPanel();
        centerJPanel.setLayout(new FlowLayout());
        centerJPanel.add(nomeJLabel);
        centerJPanel.add(nomeJTextField);
        centerJPanel.add(nicknameJLabel);
        centerJPanel.add(nicknameJTextField);
        centerJPanel.add(senhaJLabel);
        centerJPanel.add(senhaJTextField);

        cadastrarJButton = new JButton("CADASTRAR");
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new FlowLayout());
        buttonJPanel.add(cadastrarJButton);

        add(cadastroJPanel, BorderLayout.NORTH);
        add(centerJPanel, BorderLayout.CENTER);
        add(buttonJPanel, BorderLayout.SOUTH);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Cadastro telacadastro = new Cadastro();
        telacadastro.setVisible(true);
    }
}