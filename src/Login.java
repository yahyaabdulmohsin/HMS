import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JPanel;

public class Login {
	private JFrame loginFrame;
	JPanel registerPanel;
	JPanel loginPanel;
	JLabel incorrectLabel;
	static Users usersOld = new Users(new User("admin", "admin"));
	static JLabel accountExists;
	int state = 0;
	private final JTextField username = new JTextField();
	private JPasswordField password;
	private JTextField usernameField2;
	private JPasswordField passwordField2;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel( new FlatLightLaf() );
					Login window = new Login(usersOld);
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login(Users usersOld) {
		initialize(usersOld);
	}
	private void initialize(Users usersOld) {
		Users users = new Users(usersOld);
		username.setText("");
		username.setBounds(121, 98, 191, 20);
		username.setColumns(10);
		loginFrame = new JFrame();
		loginFrame.setResizable(false);
		loginFrame.setTitle("HHMS Login by Yahya Abdulmohsin");
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setVisible(true);
		
		registerPanel = new JPanel();
		registerPanel.setBounds(0, 0, 434, 261);
		registerPanel.setLayout(null);
		registerPanel.setVisible(true);
		
		
		JLabel registerLabel = new JLabel("HHMS");
		registerLabel.setVerticalAlignment(SwingConstants.TOP);
		registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		registerLabel.setBounds(199, 11, 36, 14);
		registerPanel.add(registerLabel);
		
		loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 434, 261);
		loginPanel.setLayout(null);
		
		
		
		JLabel HHMSLabel = new JLabel("HHMS");
		HHMSLabel.setBounds(199, 11, 36, 14);
		HHMSLabel.setVerticalAlignment(SwingConstants.TOP);
		HHMSLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(HHMSLabel);
		loginPanel.add(username);
		
		password = new JPasswordField();
		password.setBounds(121, 129, 191, 20);
		loginPanel.add(password);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(39, 101, 79, 14);
		loginPanel.add(usernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel.setBounds(39, 132, 79, 14);
		loginPanel.add(PasswordLabel);
		

		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean incorrect = true;
				for (int i = 0; i < users.list.size(); i++) {
					if (username.getText().equals(users.list.get(i).username) && password.getText().equals(users.list.get(i).password)) {
						loginFrame.dispose();
						incorrect = false;
						Admin admin = new Admin(users.list.get(i).username, users);
						admin.setLocationRelativeTo(null);
						admin.setVisible(true);
					}
				}
				if (incorrect)
					incorrectLabel.setVisible(true);;
			}
		});
		loginButton.setBounds(172, 200, 89, 23);
		loginPanel.add(loginButton);
		
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch();
			}
		});
		registerButton.setBounds(172, 227, 89, 23);
		loginPanel.add(registerButton);
		
		incorrectLabel = new JLabel("Incorrect credentials");
		incorrectLabel.setForeground(Color.RED);
		incorrectLabel.setBounds(163, 160, 109, 14);
		incorrectLabel.setVisible(false);
		loginPanel.add(incorrectLabel);
		
		registerPanel.setVisible(false);

		
		loginFrame.getContentPane().add(registerPanel);
		
		JButton loginPageButton = new JButton("< Login");
		loginPageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Switch();
			}
		});
		loginPageButton.setBounds(10, 10, 77, 23);
		registerPanel.add(loginPageButton);
		
		JLabel usernameLabel2 = new JLabel("Username");
		usernameLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel2.setBounds(39, 101, 79, 14);
		registerPanel.add(usernameLabel2);
		
		JLabel PasswordLabel2 = new JLabel("Password");
		PasswordLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordLabel2.setBounds(39, 132, 79, 14);
		registerPanel.add(PasswordLabel2);
		
		JButton registerButton2 = new JButton("Register");
		registerButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				users.CreateUser(usernameField2.getText(), passwordField2.getText());
			}
		});
		registerButton2.setBounds(172, 200, 89, 23);
		registerPanel.add(registerButton2);
		
		usernameField2 = new JTextField();
		usernameField2.setText("");
		usernameField2.setColumns(10);
		usernameField2.setBounds(121, 98, 191, 20);
		registerPanel.add(usernameField2);
		
		passwordField2 = new JPasswordField();
		passwordField2.setBounds(121, 129, 191, 20);
		registerPanel.add(passwordField2);
		
		accountExists = new JLabel("Account already exists");
		accountExists.setForeground(Color.RED);
		accountExists.setBounds(158, 160, 118, 16);
		accountExists.setVisible(false);
		registerPanel.add(accountExists);
		loginFrame.getContentPane().add(loginPanel);
		
}
	protected void Switch() {
		// TODO Auto-generated method stub
		if (state == 0) {
			loginPanel.setVisible(false);
			registerPanel.setVisible(true);
			state = 1;
		}else {
			loginPanel.setVisible(true);
			registerPanel.setVisible(false);
			state = 0;
		}
	}
}
class Users{
	ArrayList<User> list = new ArrayList<User>();
	public Users(User e) {
		list.add(e);
	}
	public Users(Users usersOld) {
		// TODO Auto-generated constructor stub
		list = usersOld.list;
	}
	void CreateUser(String username, String password) {
		boolean found = false;
		for (int i = 0; i < list.size(); i++) {
			if (username.equals(list.get(i).username)) {
				found = true;
				Login.accountExists.setVisible(true);
				break;
			}
			Login.accountExists.setVisible(false);
		}
		if (!found) {
			System.out.print("test");
			list.add(new User(username, password));
		}
	}
}
class User{
	String username = "";
	String password = "";
	User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	boolean CheckPassword(String password) {
		if (this.password == password)
			return true;
		return false;
	}
}