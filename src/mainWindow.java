import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainWindow extends JFrame {

    private JLabel usernameLabel, passwordLabel, messageLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, resetButton;

    public mainWindow() {
        setTitle("Login Window");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        usernameLabel = new JLabel("Username:");
        panel.add(usernameLabel);

        usernameField = new JTextField();
        panel.add(usernameField);

        passwordLabel = new JLabel("Password:");
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        panel.add(passwordField);

        loginButton = new JButton("Login");
        panel.add(loginButton);

        resetButton = new JButton("Reset");
        panel.add(resetButton);

        messageLabel = new JLabel("");
        panel.add(messageLabel);

        add(panel);

        loginButton.addActionListener(new LoginAction());
        resetButton.addActionListener(new ResetAction());
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            authentication account=new authentication();
            if (account.auth(username, password)) {
                messageLabel.setText("Login successful!");

                coreWindow colorWindow = new coreWindow();

                colorWindow.setVisible(true);

                dispose();
            } else {
                messageLabel.setText("Invalid username or password!");
            }
        }
    }


    private class ResetAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            usernameField.setText("");
            passwordField.setText("");
            messageLabel.setText("");
        }
    }

    private class coreWindow extends JFrame {
        private JTextField textField;

        private ButtonGroup businessChoice=new ButtonGroup();
        private JRadioButton myAccounts;
        private JRadioButton myTransactions;
        private JRadioButton makeTransaction;
        private JRadioButton contactUs;

        public coreWindow() {
            setTitle("bank.psu.edu");
            setSize(800, 600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());


            textField = new JTextField();
            panel.add(textField, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(12, 1));


            myAccounts = new JRadioButton("My Accounts");
            buttonPanel.add(myAccounts);
            businessChoice.add(myAccounts);

            myTransactions = new JRadioButton("My Transactions ");
            buttonPanel.add(myTransactions);
            businessChoice.add(myTransactions);

            makeTransaction = new JRadioButton("Make a Transaction");
            buttonPanel.add(makeTransaction);
            businessChoice.add(makeTransaction);

            contactUs = new JRadioButton("Contact Us");
            buttonPanel.add(contactUs);
            businessChoice.add(contactUs);

            panel.add(buttonPanel, BorderLayout.WEST);

            add(panel);

            myAccounts.addActionListener(new services("My Accounts"));
            myTransactions.addActionListener(new services("My Transactions"));
            makeTransaction.addActionListener(new services("Make a Transaction"));
            contactUs.addActionListener(new services("Phone Number: xxx-xxx-xxxx"));
        }

        private class services implements ActionListener {
            private String text;

            public services(String text) {
                this.text = text;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(text);
            }
        }
    }

    // Create a main method that launches the window
    public static void main(String[] args) {
        // Create an instance of the LoginWindow class
        mainWindow loginWindow = new mainWindow();

        // Make the window visible
        loginWindow.setVisible(true);
    }
}
