
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class adminactivity extends JFrame
{
	String username;
	public adminactivity() 
	{
		super("  Welcome To Admin Panel ");
        	initComponents();
        	ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        	this.setIconImage(ic.getImage());
    	}
	public void User(String username) {
        this.username = username;
    	}

	void initComponents()
	{
		
		
		JPanel p1;
		JPanel p2;
		JLabel setBack;
		JLabel patientIcon;
		JLabel doctorIcon;
		JLabel receptionIcon;
		JLabel backIcon;
		JLabel l1,l2,l3;
		JButton b1;
		JButton b2;
		JButton b3;
		Label mLabel;
		p1 = new JPanel();
		p2 = new JPanel();
		patientIcon = new JLabel();
		doctorIcon = new JLabel();
		setBack = new JLabel();
		receptionIcon = new JLabel();
		backIcon = new JLabel();
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		b1 = new JButton("Patient Info");
		b2 = new JButton("Doctor Info");
		b3 = new JButton("Receptionist");
		mLabel = new Label();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
       		setResizable(false);
        	setSize(800,500);
		setLocation(400,200);
		setBackground(Color.black);

		patientIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/patient.png")));
		patientIcon.setLayout(null);
        	patientIcon.setBounds(250, 200, 110,110);
		
		setBack.setIcon(new ImageIcon(getClass().getResource("/Icon/doctor2.png")));
		setBack.setSize(800,500);
		
		doctorIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/doctor1.png")));
		doctorIcon.setLayout(null);
		doctorIcon.setBounds(450,200,110,110);
		
		receptionIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/reception1.png")));
		receptionIcon.setLayout(null);
		receptionIcon.setBounds(650,200,110,110);

		backIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/logout.png")));
		backIcon.setLayout(null);
		backIcon.setBounds(700,10,51,48);
        	backIcon.addMouseListener(new MouseAdapter() {
            	public void mouseClicked(MouseEvent evt) {
                backIconMouseClicked(evt);
            		}
        	});
		
		mLabel.setAlignment(Label.CENTER);
        	mLabel.setBackground(new Color(0, 153, 153));
        	mLabel.setFont(new Font("Arial", 1, 26));
        	mLabel.setForeground(new Color(255, 255, 255));
       		mLabel.setText("Welcome Admin");

		p1.setBounds(300,10,210,50);
		p2.setBounds(0,200,140,140);
		p2.setBackground(new Color(0, 153, 153));

		l1.setFont(new Font("Arial", 1, 24));
        	l1.setForeground(new Color(255, 255, 255));
        	l1.setText("Welcome");

        	l2.setFont(new Font("Arial", 1, 24));
        	l2.setForeground(new Color(255, 255, 255));
        	l2.setText("To");

        	l3.setFont(new Font("Arial", 1, 22));
        	l3.setForeground(new Color(255, 255, 255));
        	l3.setText("Admin Portal");
        	l3.setToolTipText("");
		
		b1.setLayout(null);
		b2.setLayout(null);
		b3.setLayout(null);
		b1.setBounds(250,335,110,30);
		b2.setBounds(450,335,110,30);
		b3.setBounds(650,335,110,30);

		b1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        	b1ActionPerformed(evt);
          		}
        	});
		b2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        	b2ActionPerformed(evt);
           		}
        	}); 
		b3.addActionListener(new ActionListener() {
       		public void actionPerformed(ActionEvent evt) {
        	b3ActionPerformed(evt);
         		 }
         	});
		
		add(b1);
		add(b2);
		add(b3);
		add(patientIcon);
		add(doctorIcon);
		add(receptionIcon);
		add(backIcon);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		add(p2);
		p1.add(mLabel);
		add(p1);
		add(setBack);
		setVisible(true);
	}
	public void b1ActionPerformed(ActionEvent evt) {
       	patientactivity pt = new patientactivity();
	pt.setVisible(true);
	dispose();
    	}
	public void b2ActionPerformed(ActionEvent evt) {
       	doctorchange dc = new doctorchange();
	dc.setVisible(true);
	dispose();
    	}
	public void b3ActionPerformed(ActionEvent evt) {
       	registrar rg = new registrar();
	rg.setVisible(true);
	dispose();
    	}
	public void backIconMouseClicked(MouseEvent evt) 
	{
        hospital hos = new hospital();
        hos.setVisible(true);
        dispose();
    	}
	public static void main(String args[]) 
	{
        	EventQueue.invokeLater(() -> {
            	new adminactivity().setVisible(true);
        	});
    	}
}
	
	