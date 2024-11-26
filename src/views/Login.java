package views;
import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
    private ImageIcon gtrImageIcon;
    private JLabel imageJLabel, loginJLabel, nicknameJLabel, senhaJLabel;
    private JTextField nicknameJTextField, senhaJTextField;
    private JButton logarJButton;
    private JPanel imageJPanel, loginJPanel, centerJPanel, buttonJPanel;

    public Login() {

        super("GT-R CARROS - LOGIN");

        /*gtrImageIcon = new ImageIcon(getClass().getResource("gt-r_image.png"));
        imageJLabel = new JLabel(gtrImageIcon);
        imageJLabel.setBounds(0, 0, 50, 20);
        */
        loginJLabel = new JLabel("LOGIN");
        loginJPanel = new JPanel();
        loginJPanel.setLayout(new FlowLayout());
        loginJPanel.add(loginJLabel);

        nicknameJLabel = new JLabel("NICKNAME:");
        senhaJLabel = new JLabel("SENHA:       ");
        nicknameJTextField = new JTextField(30);
        senhaJTextField = new JTextField(30);
        
        centerJPanel = new JPanel();
        centerJPanel.setLayout(new FlowLayout());
        centerJPanel.add(nicknameJLabel);
        centerJPanel.add(nicknameJTextField);
        centerJPanel.add(senhaJLabel);
        centerJPanel.add(senhaJTextField);
        
        logarJButton = new JButton("LOGAR");
        buttonJPanel = new JPanel();
        buttonJPanel.setLayout(new FlowLayout());
        buttonJPanel.add(logarJButton);

        add(loginJPanel, BorderLayout.NORTH);
        add(centerJPanel, BorderLayout.CENTER);
        add(buttonJPanel, BorderLayout.SOUTH);

        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Login telalogin = new Login();
        telalogin.setVisible(true);
    }
}