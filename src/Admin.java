import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Desktop;
import java.net.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTextArea;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.event.ListSelectionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JToggleButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JToolBar;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Admin extends JFrame {
	private static final long serialVersionUID = 1L;
	boolean isDark = false;
	private JPanel contentPane;
	private JTextField name;
	private JTextField phoneNumber;
	private JTextField age;
	private JTextField address;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField ageField;
	private JTextField addressCombo;
	static Users usersOld = new Users(new User("admin", "admin"));
	JList<String> patientsList = new JList<String>();
	JList<String> patientsList3 = new JList<String>();
	private JTextField doctorNameFi;
	private JTextField doctorNumberFi;
	private JTextField doctorName;
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Admin frame = new Admin("N/A", null);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Admin(String username, Users users) {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		doctors.add(new Doctor("Dr. William A. Abdu, M.D, M.S.", 8, "Dr. Abdu got his accreditation in 1985 from Tufts University. He is a pioneer in the study and treatment of spine-related conditions. He hones surgery of the Spine, including Cervical, Thoracic and Lumbar Disorders, Disk Herniation, Spinal Stenosis, Spondylolisthesis, Spondylotic Myelopathy, Spinal Cord Injury, and Spine Trauma. Also, he had discovered many new techniques for spine treatment."));
		doctors.add(new Doctor("Dr. Myles. B. Abbott, M.D.",1,"Dr. Myles currently practices at East Bay Pediatric & Medical Group and is affiliated with Alta Bates Summit Medical Center Alta Bates Campus and Children’s Hospital & Research Center Oakland."));
		doctors.add(new Doctor("Dr. Fouad. M. Abbas, M.D.",15,"Dr. Abbas graduated from the University of Maryland School of Medicine in 1986. Currently, he is affiliated with Medstar Harbor Hospital and Sinai Hospital Of Baltimore."));
		doctors.add(new Doctor("Dr. Khalid Abbed, M.D.",14,"Dr. Khalid obtained his bachelor’s degree in Biological Sciences from the University of Illinois in Champaign-Urbana in 1993. He continued his education in the same University and received his Doctor of Medicine degree with Honors in 1999. Currently, he is working at Yale as a Director of the Spine Surgery Department. Many consider him the best doctor in the world."));
		doctors.add(new Doctor("Dr. Naresh Trehan",10,"Dr. Naresh was also the founder, executive director, and chief cardiovascular surgeon of Escorts Heart Institute and Research Center (EHIRC), New Delhi, India. At present, he is serving as a Chairman and Managing Director and Chief Cardiac Surgeon of MedantaTM-The Medicity, one of the largest multi-speciality hospitals at Gurgaon, Haryana."));
		doctors.add(new Doctor("Dr. Arthur Reese Abright, M.D.",11,"Dr. Reese got her accreditation from The University of Texas Southwestern Medical School. She is also an expert on mood disorders and anxiety. Currently, she is working as a Professor of Psychiatry at Icahn School of Medicine at Mount Sinai. She is also affiliated with Mount Sinai Services Elmhurst Hospital Center and New York Medical College at present."));
		doctors.add(new Doctor("Dr. Corrie T.M Anderson, M.D.",7,"In 2001, Dr. Anderson became the director of the program for Pediatric Pain Medicine in the Department of Anesthesiology at Seattle Children’s Hospital. He is also a professor of anesthesiology and associate professor of pediatrics at the University of Washington School of Medicine."));
		doctors.add(new Doctor("Dr. Mark. F. Aaron, M.D.",12,"Dr. Aaron got his accreditation from the Duke University School of Medicine in 1992. Currently, he is affiliated with River Park Hospital, Saint Thomas West Hospital, and Henry County Medical Center."));
		doctors.add(new Doctor("Dr. Sudhansu Bhattacharyya, MBBS, MS, MCH",5,"Before entering into the practice world, Dr. Sudhansu served as a full-time Professor for Cardiothoracic surgery at Sheth G.S. Medical College & K.E.M. Hospital. At present, he is affiliated with Bombay Hospital And Medical Research Center, Breach Candy Hospital, Mumbai, and Lilavati Hospital & Research Center, Mumbai."));
		doctors.add(new Doctor("Dr. Mona.M.Abaza, M.D.",3,"Dr. Abaza graduated from the Medical College of Pennsylvania in 1991. She is affiliated with Children’s Hospital Colorado At Memorial Hospital Central and the University of Colorado Hospital."));
		doctors.add(new Doctor("Dr. Bryan Kelly, MD",9,"Dr. Kelly received his degree from “Duke University School of Medicine” in Durham, NC. He finished his residency and fellowship at the hospital for special surgery. In addition to that, he finished his fellowships at the University of Pittsburgh Medical Centre and with AO Trauma, Austria."));
		doctors.add(new Doctor("Dr. Mark Pagnano, MD",4,"Dr. Pagnano received his degree from George Washington University School of Medicine. He also finished his residency at “Mayo Clinic College of Medicine” in Rochester, Minn. In addition to that, he completed his fellowship at the Insall Scott Kelly Institute for Orthopaedics and Sports Medicine in New York."));
		doctors.add(new Doctor("Dr. Mark Vargas, MD",13,"Dr. Vrahas received his degree and completed his residency at the University Of “Pittsburgh School of Medicine”. He also completed his fellowship at the “University of Toronto”, Canada."));
		doctors.add(new Doctor("Dr. Joseph Zuckerman, MD",6,"Dr. Zuckerman received his degree from the “Medical College of Wisconsin” in Milwaukee and also completed his residency at the “University of Washington Medical Centre” in Seattle. In addition to that, he completed his fellowship at the Brigham and Women’s Hospital in Boston."));
		doctors.add(new Doctor("Dr. Joshua Jacobs, MD",2,"Dr. Jacobs received his degree from the “University of Illinois College of Medicine, Chicago. In addition to that, he completed a residency at “Harvard Medical School in Boston” and a fellowship at “Rush University Medical Centre”."));
		
		usersOld = users;
		setFont(new Font("Segoe UI", Font.PLAIN, 12));
		setResizable(false);
		setTitle("HHMS by Yahya Abdulmohsin - " + username);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}
		});
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, -35, 720, 291);
		tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(tabbedPane);
		
		
		JPanel hospitalInfoPanel = new JPanel();
		hospitalInfoPanel.setToolTipText("");
		tabbedPane.addTab("Hospital Information", null, hospitalInfoPanel, null);
		hospitalInfoPanel.setLayout(new BorderLayout(0, 0));
		JLabel portfolioLink = new JLabel("<HTML><U>View my full portfolio</U></HTML>");
		portfolioLink.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		portfolioLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		portfolioLink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(new URL("https://www.yahyaabdulmohsin.com").toURI());
			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				portfolioLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		portfolioLink.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel1 = new JPanel();
		panel1.setToolTipText("");
		hospitalInfoPanel.add(panel1, BorderLayout.CENTER);
		panel1.setLayout(new BorderLayout(0, 0));
		
		JTextArea highlineDescription = new JTextArea();
		highlineDescription.setEditable(false);
		highlineDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		highlineDescription.setLineWrap(true);
		highlineDescription.setText("This application is just a demo that was created for my CS class's honors project. I do not in any way represent a real hospital, Highline College, or any of the doctors mentioned. The list of the doctors and their descriptions was obtained from:\r\nhttps://www.embibe.com/exams/top-10-doctors-around-the-world/\r\nhttps://www.madrehealthcare.com/top-10-doctors-in-the-world/");
		panel1.add(highlineDescription, BorderLayout.CENTER);
		
		JTextArea dummyAreaUp = new JTextArea();
		dummyAreaUp.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		dummyAreaUp.setEditable(false);
		panel1.add(dummyAreaUp, BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		panel1.add(panel2, BorderLayout.EAST);
		
		JPanel panel4 = new JPanel();
		panel1.add(panel4, BorderLayout.WEST);
		
		JPanel panel5 = new JPanel();
		hospitalInfoPanel.add(panel5, BorderLayout.NORTH);
		
		JLabel highlineTitle = new JLabel("Highline Hospital");
		highlineTitle.setToolTipText("");
		highlineTitle.setHorizontalAlignment(SwingConstants.CENTER);
		highlineTitle.setFont(new Font("Segoe UI", Font.PLAIN, 38));
		panel5.add(highlineTitle);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(new BorderLayout(0, 0));
		panel_6.add(portfolioLink, BorderLayout.NORTH);
		hospitalInfoPanel.add(panel_6, BorderLayout.SOUTH);
		
		JPanel panel7 = new JPanel();
		panel_6.add(panel7, BorderLayout.SOUTH);
		
		JButton addP = new JButton("Add Patient");
		addP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel7.add(addP);
		
		JButton pI = new JButton("Patients Info");
		pI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		panel7.add(pI);
		
		JButton upP = new JButton("Update Patient");
		upP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		panel7.add(upP);
		
		JButton docList = new JButton("Doctors List");
		docList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(5);
			}
		});
		
		JButton addDocc = new JButton("Add Doctor");
		addDocc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		panel7.add(addDocc);
		panel7.add(docList);
		
		JPanel panel8 = new JPanel();
		panel_6.add(panel8, BorderLayout.CENTER);
		
		JPanel addPatientPanel = new JPanel();
		tabbedPane.addTab("Add Patient", null, addPatientPanel, null);
		addPatientPanel.setLayout(new MigLayout("", "[][][grow][][][][grow]", "[][][][][][][][]"));
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(nameLabel, "cell 1 1,alignx trailing");
		
		name = new JTextField();
		name.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(name, "cell 2 1,growx");
		name.setColumns(10);
		
		JLabel phoneNumberLabel = new JLabel("Phone #");
		phoneNumberLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(phoneNumberLabel, "cell 1 2,alignx trailing");
		
		phoneNumber = new JTextField();
		phoneNumber.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(phoneNumber, "cell 2 2,growx");
		phoneNumber.setColumns(10);
		
		JLabel ageLabel = new JLabel("Age");
		ageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(ageLabel, "cell 1 3,alignx trailing");
		
		age = new JTextField();
		age.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(age, "cell 2 3,growx");
		age.setColumns(10);
		
		JLabel sexLabel = new JLabel("Sex");
		sexLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(sexLabel, "cell 1 4,alignx trailing");
		
		JComboBox<String> sexComboBox = new JComboBox<String>();
		sexComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		sexComboBox.addItem("Choose Sex...");
		sexComboBox.addItem("Male");
		sexComboBox.addItem("Female");
		addPatientPanel.add(sexComboBox, "flowy,cell 2 4,growx");
		
		JLabel bloodTypeLabel = new JLabel("Blood Type");
		bloodTypeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(bloodTypeLabel, "cell 1 5,alignx trailing");
		
		JComboBox<String> bloodTypeComboBox = new JComboBox<String>();
		bloodTypeComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		bloodTypeComboBox.addItem("Choose Blood Type...");
		bloodTypeComboBox.addItem("AB+");
		bloodTypeComboBox.addItem("AB-");
		bloodTypeComboBox.addItem("A+");
		bloodTypeComboBox.addItem("A-");
		bloodTypeComboBox.addItem("B+");
		bloodTypeComboBox.addItem("B-");
		bloodTypeComboBox.addItem("O+");
		bloodTypeComboBox.addItem("O-");
		addPatientPanel.add(bloodTypeComboBox, "cell 2 5,growx");
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(addressLabel, "cell 1 6,alignx trailing");
		
		address = new JTextField();
		address.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(address, "cell 2 6,growx");
		address.setColumns(10);
		
		JRadioButton citizenRadioButton = new JRadioButton("Citizen");
		citizenRadioButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(citizenRadioButton, "flowx,cell 2 7");
		ArrayList<Patient> patients = new ArrayList<Patient>();
		patients.add(new Patient("John","","","Choose Sex...","Choose Blood Type...","",false));
		patients.add(new Patient("Muhammed","","","Choose Sex...","Choose Blood Type...","",false));
		patients.add(new Patient("Jasmine","","","Choose Sex...","Choose Blood Type...","",false));
		patients.get(1).AddDiagnoses("Asthma");
		JButton addPatient = new JButton("Add Patient");
		addPatient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addPatientPanel.add(addPatient, "cell 2 7");
		
		JButton clearFields = new JButton("Clear Fields");
		clearFields.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		clearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				phoneNumber.setText("");
				age.setText("");
				sexComboBox.setSelectedIndex(0);
				bloodTypeComboBox.setSelectedIndex(0);
				address.setText("");
				citizenRadioButton.setSelected(false);
			}
		});
		addPatientPanel.add(clearFields, "cell 2 7");
		
		JPanel patientsInfoPanel = new JPanel();
		tabbedPane.addTab("Patients Information", null, patientsInfoPanel, null);
		patientsInfoPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel9 = new JPanel();
		patientsInfoPanel.add(panel9);
		panel9.setLayout(new MigLayout("", "[][343px]", "[0px][177px,grow]"));
		
		JScrollPane patientsScrollPane = new JScrollPane();
		patientsScrollPane.setBorder(null);
		panel9.add(patientsScrollPane, "cell 1 1,grow");
		patientsList.setModel(new AbstractListModel() {
			String[] values = new String[] {"John", "Muhammed", "Jasmine"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		patientsList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		
		patientsList.setValueIsAdjusting(true);
		
		patientsList.setToolTipText("");
		
				patientsList.setLayoutOrientation(JList.VERTICAL);
				patientsList.setBorder(null);
				patientsScrollPane.setViewportView(patientsList);
				
				JPanel panel10 = new JPanel();
				panel10.setToolTipText("");
				patientsInfoPanel.add(panel10);
				panel10.setLayout(new MigLayout("", "[357px]", "[136px]"));
				
				JPanel panel11 = new JPanel();
				panel11.setToolTipText("");
				panel10.add(panel11, "cell 0 0,grow");
				panel11.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][][]"));
				
				JLabel nameLabel2 = new JLabel("Name");
				nameLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(nameLabel2, "cell 0 0,alignx right");
				
				JLabel nameDisplay = new JLabel("");
				nameDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(nameDisplay, "cell 1 0");
				
				JLabel phoneNumberLabel2 = new JLabel("Phone #");
				phoneNumberLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(phoneNumberLabel2, "cell 0 1,alignx right");
				
				JLabel phoneDisplay = new JLabel("");
				phoneDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(phoneDisplay, "cell 1 1");
				
				JLabel ageLabel2 = new JLabel("Age");
				ageLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(ageLabel2, "cell 0 2,alignx right");
				
				JLabel ageDisplay = new JLabel("");
				ageDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(ageDisplay, "cell 1 2");
				
				JLabel sexLabel2 = new JLabel("Sex");
				sexLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(sexLabel2, "cell 0 3,alignx right");
				
				JLabel sexDisplay = new JLabel("");
				sexDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(sexDisplay, "cell 1 3");
				
				JLabel bloodTypeLabel2 = new JLabel("Blood Type");
				bloodTypeLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(bloodTypeLabel2, "cell 0 4,alignx right");
				
				JLabel bloodDisplay = new JLabel("");
				bloodDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(bloodDisplay, "cell 1 4");
				
				JLabel addressLabel2 = new JLabel("Address");
				addressLabel2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(addressLabel2, "cell 0 5,alignx right");
				
				JLabel addressDisplay = new JLabel("");
				addressDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(addressDisplay, "cell 1 5");
				
				JLabel bloodTypeLabel3 = new JLabel("Citizen");
				bloodTypeLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(bloodTypeLabel3, "cell 0 6,alignx right");
				
				JLabel citizenDisplay = new JLabel("");
				citizenDisplay.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				panel11.add(citizenDisplay, "cell 1 6");
				
				patientsList.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						if (!patientsList.getValueIsAdjusting()) {
							nameDisplay.setText(patients.get(patientsList.getSelectedIndex()).name);
							if (patients.get(patientsList.getSelectedIndex()).phoneNumber.equals("")) {
								phoneDisplay.setText("N/A");
							}else {
								phoneDisplay.setText(patients.get(patientsList.getSelectedIndex()).phoneNumber);
							}
							if (patients.get(patientsList.getSelectedIndex()).age.equals("")) {
								ageDisplay.setText("N/A");
							}else {
								ageDisplay.setText(patients.get(patientsList.getSelectedIndex()).age);
							}
							if (patients.get(patientsList.getSelectedIndex()).sex.equals("Choose Sex...")) {
								sexDisplay.setText("N/A");
							}else {
								sexDisplay.setText(patients.get(patientsList.getSelectedIndex()).sex);
							}
							if (patients.get(patientsList.getSelectedIndex()).bloodType.equals("Choose Blood Type...")) {
								bloodDisplay.setText("N/A");
							}else {
								bloodDisplay.setText(patients.get(patientsList.getSelectedIndex()).bloodType);
							}
							if (patients.get(patientsList.getSelectedIndex()).address.equals("")) {
								addressDisplay.setText("N/A");
							}else {
								addressDisplay.setText(patients.get(patientsList.getSelectedIndex()).address);
							}
							if (patients.get(patientsList.getSelectedIndex()).citizen) {
								citizenDisplay.setText("Yes");
							}else {
								citizenDisplay.setText("No");
							}
							
						}
						
					}
				});
		
		JPanel updatePatientPanel = new JPanel();
		tabbedPane.addTab("Update Patient", null, updatePatientPanel, null);
		updatePatientPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel12 = new JPanel();
		updatePatientPanel.add(panel12);
		panel12.setLayout(new MigLayout("", "[][343px]", "[0px][177px,grow]"));
		
		JScrollPane patientsScrollPane3 = new JScrollPane();
		patientsScrollPane3.setBorder(null);
		panel12.add(patientsScrollPane3, "cell 1 1,grow");
		patientsList3.setModel(new AbstractListModel() {
			String[] values = new String[] {"John", "Muhammed", "Jasmine"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		patientsList3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		patientsList3.setToolTipText("");
		
		JPanel panel13 = new JPanel();
		updatePatientPanel.add(panel13);
		panel13.setLayout(new MigLayout("", "[][][grow][]", "[][][][][][][][][]"));
		
		JLabel nameLabel3 = new JLabel("Name");
		nameLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(nameLabel3, "cell 1 1,alignx trailing");
		
		nameField = new JTextField();
		nameField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(nameField, "cell 2 1,growx");
		nameField.setColumns(10);
		
		JLabel phoneLabel3 = new JLabel("Phone #");
		phoneLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(phoneLabel3, "cell 1 2,alignx trailing");
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(phoneField, "cell 2 2,growx");
		phoneField.setColumns(10);
		
		JLabel ageLabel3 = new JLabel("Age");
		ageLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(ageLabel3, "cell 1 3,alignx trailing");
		
		ageField = new JTextField();
		ageField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(ageField, "cell 2 3,growx");
		ageField.setColumns(10);
		
		JLabel sexLabel3 = new JLabel("Sex");
		sexLabel3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(sexLabel3, "cell 1 4,alignx trailing");
		
		JComboBox<String> sexCombo = new JComboBox<String>();
		sexCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		sexCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose Sex...", "Male", "Female"}));
		panel13.add(sexCombo, "cell 2 4,growx");
		
		JLabel bloodType3 = new JLabel("Blood Type");
		bloodType3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(bloodType3, "cell 1 5,alignx trailing");
		
		JComboBox<String> bloodCombo = new JComboBox<String>();
		bloodCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		bloodCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Choose Blood Type...", "AB+", "AB-", "A+", "A-", "B+", "B-", "O+", "O-"}));
		panel13.add(bloodCombo, "cell 2 5,growx");
		
		JLabel addressType3 = new JLabel("Address");
		addressType3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(addressType3, "cell 1 6,alignx trailing");
		
		addressCombo = new JTextField();
		addressCombo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(addressCombo, "cell 2 6,growx");
		addressCombo.setColumns(10);
		
		JRadioButton citizenRadio = new JRadioButton("Citizen");
		citizenRadio.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel13.add(citizenRadio, "flowx,cell 2 7,alignx left");
		
		JButton updateButton = new JButton("Update Patient");
		updateButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
				panel13.add(updateButton, "cell 2 7,alignx right");
				
				JButton deletePatient = new JButton("Delete Patient");
				deletePatient.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						patients.remove(patientsList3.getSelectedIndex());
						DefaultListModel<String> model = new DefaultListModel<String>();
						for (int i = 0; i < patients.size(); i++) {
							model.addElement(patients.get(i).name);
						}
						patientsList3.setModel(model);
					}
				});
				panel13.add(deletePatient, "cell 2 7");
				
						updateButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (nameField.getText().equals("")) {
									patients.get(patientsList3.getSelectedIndex()).name = "N/A";
								}else {
									patients.get(patientsList3.getSelectedIndex()).name = nameField.getText();
									patients.get(patientsList3.getSelectedIndex()).phoneNumber = phoneField.getText();
									patients.get(patientsList3.getSelectedIndex()).age = ageField.getText();
									
									if (sexCombo.getSelectedItem().toString().equalsIgnoreCase("Choose Sex...")) {
										patients.get(patientsList3.getSelectedIndex()).sex = "N/A";
									}else{
										patients.get(patientsList3.getSelectedIndex()).sex = sexCombo.getSelectedItem().toString();
									}
									
									if (bloodCombo.getSelectedItem().toString().equalsIgnoreCase("Choose Blood Type...")) {
										patients.get(patientsList3.getSelectedIndex()).bloodType = "N/A";
									}else {
										patients.get(patientsList3.getSelectedIndex()).bloodType = bloodCombo.getSelectedItem().toString();
									}
									
									patients.get(patientsList3.getSelectedIndex()).address = addressCombo.getText();
									patients.get(patientsList3.getSelectedIndex()).citizen = citizenRadio.isSelected();
									
									
								}
								
								DefaultListModel<String> model = new DefaultListModel<String>();
								for (int i = 0; i < patients.size(); i++) {
									model.addElement(patients.get(i).name);
								}
								patientsList3.setModel(model);
								
							}
							
						});
		
		patientsList3.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!patientsList3.getValueIsAdjusting()) {
					
					nameField.setText(patients.get(patientsList3.getSelectedIndex()).name);
					if (patients.get(patientsList3.getSelectedIndex()).phoneNumber.equalsIgnoreCase("")) {
						phoneField.setText("N/A");
					}else {
						phoneField.setText(patients.get(patientsList3.getSelectedIndex()).phoneNumber);
					}
					
					if (patients.get(patientsList3.getSelectedIndex()).age.equalsIgnoreCase("")) {
						ageField.setText("N/A");
					}else {
						ageField.setText(patients.get(patientsList3.getSelectedIndex()).age);
					}
					
					if (patients.get(patientsList3.getSelectedIndex()).sex.equalsIgnoreCase("Choose Sex...") || patients.get(patientsList3.getSelectedIndex()).sex.equalsIgnoreCase("N/A")) {
						sexCombo.setSelectedIndex(0);
					}else if (patients.get(patientsList3.getSelectedIndex()).sex.equalsIgnoreCase("Male")) {
						sexCombo.setSelectedIndex(1);
					}else if (patients.get(patientsList3.getSelectedIndex()).sex.equalsIgnoreCase("Female")){
						sexCombo.setSelectedIndex(2);
					}
					if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("Choose Blood Type...") || patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("N/A")) {
						bloodCombo.setSelectedIndex(0);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("AB+")) {
						bloodCombo.setSelectedIndex(1);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("AB-")) {
						bloodCombo.setSelectedIndex(2);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("A+")) {
						bloodCombo.setSelectedIndex(3);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("A-")) {
						bloodCombo.setSelectedIndex(4);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("B+")) {
						bloodCombo.setSelectedIndex(5);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("B-")) {
						bloodCombo.setSelectedIndex(6);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("O+")) {
						bloodCombo.setSelectedIndex(7);
					}else if (patients.get(patientsList3.getSelectedIndex()).bloodType.equalsIgnoreCase("O-")) {
						bloodCombo.setSelectedIndex(8);
					}
					
					if (patients.get(patientsList3.getSelectedIndex()).address.equalsIgnoreCase("")) {
						addressCombo.setText("N/A");
					}else {
						addressCombo.setText(patients.get(patientsList3.getSelectedIndex()).address);
					}
					if (patients.get(patientsList3.getSelectedIndex()).citizen) {
						citizenRadio.setSelected(true);
					}else {
						citizenRadio.setSelected(false);
					}
					
				}
			}
		});
		addPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().equals("")) {
					patients.add(new Patient("N/A",phoneNumber.getText(),age.getText(),sexComboBox.getSelectedItem().toString(),bloodTypeComboBox.getSelectedItem().toString(),address.getText(),citizenRadioButton.isSelected()));
				}else {
					patients.add(new Patient(name.getText(),phoneNumber.getText(),age.getText(),sexComboBox.getSelectedItem().toString(),bloodTypeComboBox.getSelectedItem().toString(),address.getText(),citizenRadioButton.isSelected()));
				}
			}
		});
		
		patientsList3.setLayoutOrientation(JList.VERTICAL);
		patientsList3.setBorder(null);
		patientsScrollPane3.setViewportView(patientsList3);
		
		JPanel addDoctorPanel = new JPanel();
		tabbedPane.addTab("Add Doctor", null, addDoctorPanel, null);
		addDoctorPanel.setLayout(new MigLayout("", "[][][grow][][][][grow]", "[][][][grow][][][][]"));
		
		JLabel doctorNameLa = new JLabel("Name");
		doctorNameLa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addDoctorPanel.add(doctorNameLa, "cell 1 1,alignx right");
		
		doctorNameFi = new JTextField();
		doctorNameFi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		doctorNameFi.setColumns(10);
		addDoctorPanel.add(doctorNameFi, "cell 2 1,growx");
		
		JLabel doctorNumberLa = new JLabel("Room Number");
		doctorNumberLa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addDoctorPanel.add(doctorNumberLa, "cell 1 2,alignx right");
		
		doctorNumberFi = new JTextField();
		doctorNumberFi.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		doctorNumberFi.setColumns(10);
		addDoctorPanel.add(doctorNumberFi, "cell 2 2,growx");
		
		JLabel doctorDescLa = new JLabel("Description");
		doctorDescLa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		addDoctorPanel.add(doctorDescLa, "cell 1 3,alignx right,aligny top");
		
		JTextArea doctorDesAr = new JTextArea();
		addDoctorPanel.add(doctorDesAr, "cell 2 3,grow");
		
		JButton addDoc = new JButton("Add Doctor");
		addDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (doctorNameFi.getText().equals("")) {
					if (doctorNumberFi.getText().equals("")) {
						doctors.add(new Doctor("N/A",0, doctorDesAr.getText()));
					}else {
						doctors.add(new Doctor("N/A",Integer.parseInt(doctorNumberFi.getText()), doctorDesAr.getText()));
					}
				}else {
					if (doctorNumberFi.getText().equals("")) {
						doctors.add(new Doctor(doctorNameFi.getText(),0, doctorDesAr.getText()));
					}else {
						doctors.add(new Doctor(doctorNameFi.getText(),Integer.parseInt(doctorNumberFi.getText()), doctorDesAr.getText()));
					}
				}
				
			}
		});
		addDoctorPanel.add(addDoc, "flowx,cell 2 4");
		
		JButton clearFields1 = new JButton("Clear Fields");
		clearFields1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctorNameFi.setText("");
				doctorNumberFi.setText("");
				doctorDesAr.setText("");
			}
		});
		addDoctorPanel.add(clearFields1, "cell 2 4");
		
		JPanel doctorsListPanel = new JPanel();
		tabbedPane.addTab("Doctors List", null, doctorsListPanel, null);
		doctorsListPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel14 = new JPanel();
		doctorsListPanel.add(panel14);
		panel14.setLayout(new MigLayout("", "[][357px]", "[][218px]"));
		
		
		JList<String> doctorsList = new JList<String>();
		doctorsList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		doctorsList.setToolTipText("");
		doctorsList.setBorder(null);
		doctorsList.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		JScrollPane doctorsScrollPane = new JScrollPane();
		doctorsScrollPane.setViewportView(doctorsList);
		doctorsScrollPane.setBorder(null);
		doctorsList.setLayoutOrientation(JList.VERTICAL);
		
		panel14.add(doctorsScrollPane, "cell 1 1,grow");
		
		JPanel panel15 = new JPanel();
		doctorsListPanel.add(panel15);
		panel15.setLayout(null);
		
		JTextArea doctorsDescription = new JTextArea();
		doctorsDescription.setBounds(0, 51, 357, 140);
		doctorsDescription.setToolTipText("");
		doctorsDescription.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		doctorsDescription.setLineWrap(true);
		panel15.add(doctorsDescription);
		
		JTextField roomNumber = new JTextField("");
		roomNumber.setBounds(62, 202, 98, 23);
		roomNumber.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		panel15.add(roomNumber);
		
		JButton updateDoctor = new JButton("Update");
		updateDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctors.get(doctorsList.getSelectedIndex()).name = doctorName.getText();
				doctors.get(doctorsList.getSelectedIndex()).description = doctorsDescription.getText();
				doctors.get(doctorsList.getSelectedIndex()).roomNumber = Integer.parseInt(roomNumber.getText());
				DefaultListModel<String> model = new DefaultListModel<String>();
				for (int i = 0; i < doctors.size(); i++) {
					model.addElement(doctors.get(i).name);
				}
				// List Updates
				doctorsList.setModel(model);
				// List Updates
			}
		});
		updateDoctor.setBounds(169, 202, 89, 23);
		panel15.add(updateDoctor);
		
		JLabel roomNumLabel = new JLabel("Room No.");
		roomNumLabel.setBounds(0, 207, 64, 14);
		panel15.add(roomNumLabel);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doctors.remove(doctorsList.getSelectedIndex());
				DefaultListModel<String> model = new DefaultListModel<String>();
				for (int i = 0; i < doctors.size(); i++) {
					model.addElement(doctors.get(i).name);
				}
				// List Updates
				doctorsList.setModel(model);
				// List Updates
			}
		});
		deleteButton.setBounds(268, 202, 89, 23);
		panel15.add(deleteButton);
		
		doctorName = new JTextField();
		doctorName.setBounds(0, 11, 357, 20);
		panel15.add(doctorName);
		doctorName.setColumns(10);
		
		doctorsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!doctorsList.getValueIsAdjusting()) {
					int doctorSelected = doctorsList.getSelectedIndex();
					doctorName.setText(doctors.get(doctorSelected).name);
					doctorsDescription.setText(doctors.get(doctorSelected).description);
					roomNumber.setText("" + (doctors.get(doctorSelected).roomNumber));
				}
			}
		});
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBounds(5, 296, 720, 102);
		contentPane.add(footerPanel);
		footerPanel.setLayout(null);
		
		JToggleButton darkToggleButton = new JToggleButton("Dark/Light");
		darkToggleButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		darkToggleButton.setBounds(0, 35, 87, 23);		
		JToolBar toolBar = new JToolBar();
		toolBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		toolBar.setBounds(10, 73, 142, 29);
		toolBar.add(darkToggleButton);
		toolBar.add(logoutButton);
		toolBar.setEnabled(false);
		footerPanel.add(toolBar);
		
		JButton goBackButton = new JButton("< Go back");
		goBackButton.setVisible(false);
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		goBackButton.setBounds(620, 75, 89, 23);
		footerPanel.add(goBackButton);
		darkToggleButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (darkToggleButton.isSelected()) {
					try {
						UIManager.setLookAndFeel( new FlatDarkLaf() );
					} catch (UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					try {
						UIManager.setLookAndFeel( new FlatLightLaf() );
					} catch (UnsupportedLookAndFeelException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				refreshFrame();
			}

		});
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (tabbedPane.getSelectedIndex() == 0) {
					goBackButton.setVisible(false);
				}else {
					goBackButton.setVisible(true);
				}
				if (tabbedPane.getSelectedIndex() == 2) {
					DefaultListModel<String> model = new DefaultListModel<String>();
					for (int i = 0; i < patients.size(); i++) {
						model.addElement(patients.get(i).name);
					}
					// List Updates
					patientsList.setModel(model);
					// List Updates
				}
				if (tabbedPane.getSelectedIndex() == 3) {
					DefaultListModel<String> model = new DefaultListModel<String>();
					for (int i = 0; i < patients.size(); i++) {
						model.addElement(patients.get(i).name);
					}
					// List Updates
					patientsList3.setModel(model);
					// List Updates
				}
				if (tabbedPane.getSelectedIndex() == 5) {
					DefaultListModel<String> model = new DefaultListModel<String>();
					for (int i = 0; i < doctors.size(); i++) {
						model.addElement(doctors.get(i).name);
					}
					// List Updates
					doctorsList.setModel(model);
					// List Updates
				}
			}
		});
		
	}
	void logout() {
		this.dispose();
		try {
			UIManager.setLookAndFeel( new FlatLightLaf() );
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		@SuppressWarnings("unused")
		Login login = new Login(usersOld);
	}
	void refreshFrame() {
		SwingUtilities.updateComponentTreeUI(this);
		this.invalidate();
		this.validate();
		this.repaint();
	}
}
class Patient{
	public String name = "";
	public String phoneNumber = "";
	public String age = "";
	public String sex = "";
	public String bloodType = "";
	public String address = "";
	public boolean citizen = false;
	ArrayList<String> diagnoses = new ArrayList<String>();
	Patient(String name, String phoneNumber, String age, String sex, String bloodType, String address, boolean citizen){
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.sex = sex;
		this.bloodType = bloodType;
		this.address = address;
		this.citizen = citizen;
	}
	public void AddDiagnoses(String diagnoses) {
		this.diagnoses.add(diagnoses);
	}
}
class Doctor{
	String name = "";
	int roomNumber = 0;
	String description = "";
	Doctor(String name, int roomNumber, String description){
		this.name = name;
		this.roomNumber = roomNumber;
		this.description = description;
	}
}