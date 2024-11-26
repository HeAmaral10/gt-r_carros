package views;
import java.awt.*;
import javax.swing.*;

public class TelaInicial extends JFrame {
    private JButton loginJButton, cadastroJButton;
    private ImageIcon gtrImageIcon;
    private JLabel textoinicialJlabel;
    private JPanel imageJPanel, textJPanel, buttonJPanel;

    public TelaInicial() {

        super("GT-R CARROS");

        textoinicialJlabel = new JLabel("BEM-VINDO À GT-R CARROS");
        textJPanel = new JPanel();
        textJPanel.setLayout(new FlowLayout());
        textJPanel.add(textoinicialJlabel);

        loginJButton = new JButton("LOGIN");
        loginJButton.addActionListener((actionEvent) -> ClickLogin());
        cadastroJButton = new JButton("CADASTRO");
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new FlowLayout());
        buttonJPanel.add(loginJButton);
        buttonJPanel.add(cadastroJButton);

        add(textJPanel, BorderLayout.CENTER);
        add(buttonJPanel, BorderLayout.SOUTH);

        setSize(500, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        TelaInicial tela_inicial1 = new TelaInicial();
        tela_inicial1.setVisible(true);
    }

    private void ClickLogin() {
        new Login().setVisible(true);
        dispose();
    }
}