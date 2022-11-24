
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class repactivity extends JFrame
{
	String username;
	public repactivity() 
	{
		super(" Reception Panel ");
        	initComponents();
        	ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        	this.setIconImage(ic.getImage());
    	}
	public void User(String username) {
        this.username = username;
    	}
	JLabel l4;

	void initComponents()
	{
		
		
		JPanel p1;
		JPanel p2;
		JLabel addIcon;
		JLabel setBack;
		JLabel updateIcon;
		JLabel setIcon;
		JLabel backIcon;
		JLabel l1,l2,l3;
		JButton b1;
		JButton b2;
		JButton b3;
		Label mLabel;
		p1 = new JPanel();
		p2 = new JPanel();
		addIcon = new JLabel();
		updateIcon = new JLabel();
		setIcon = new JLabel();
		backIcon = new JLabel();
		setBack = new JLabel();
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		b1 = new JButton("Add Patient");
		b2 = new JButton("Update Patient");
		b3 = new JButton("Set Appointment");
		mLabel = new Label();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
       		setResizable(false);
        	setSize(800,500);
		setLocation(400,200);
		setBackground(Color.black);

		addIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/patient1.png")));
		addIcon.setLayout(null);
        	addIcon.setBounds(250, 200, 115,115);
		
		setBack.setIcon(new ImageIcon(getClass().getResource("/Icon/doctor2.png")));
		setBack.setSize(800,500);
		
		updateIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/upatient.png")));
		updateIcon.setLayout(null);
		updateIcon.setBounds(450,200,115,115);
		
		setIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/setappointment.png")));
		setIcon.setLayout(null);
		setIcon.setBounds(650,200,115,115);

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
       		mLabel.setText("Welcome Registrar");

		p1.setBounds(290,10,250,50);
		p2.setBounds(0,180,155,155);
		p2.setBackground(new Color(0, 153, 153));


		l1.setFont(new Font("Arial", 1, 26));
        	l1.setForeground(new Color(255, 255, 255));
        	l1.setText("Welcome");

        	l2.setFont(new Font("Arial", 1, 26));
        	l2.setForeground(new Color(255, 255, 255));
        	l2.setText("To");

        	l3.setFont(new Font("Arial", 1, 26));
        	l3.setForeground(new Color(255, 255, 255));
        	l3.setText("Reception");
        	l3.setToolTipText("");

		l4.setFont(new Font("Arial", 1, 26));
        	l4.setForeground(new Color(255, 255, 255));
        	l4.setText("Area");
		
		b1.setLayout(null);
		b2.setLayout(null);
		b3.setLayout(null);
		b1.setBounds(250,335,115,30);
		b1.setFont(new Font("Arial",1,10));
		b2.setBounds(450,335,115,30);
		b2.setFont(new Font("Arial",1,10));
		b3.setBounds(650,335,120,30);
		b3.setFont(new Font("Arial",1,10));
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
		add(addIcon);
		add(updateIcon);
		add(setIcon);
		add(backIcon);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		add(p2);
		p1.add(mLabel);
		add(p1);
		add(setBack);
		setVisible(true);
	}
	public void b1ActionPerformed(ActionEvent evt) {
       	newPatient np = new newPatient();
	np.setVisible(true);
	dispose();
    	}
	public void b2ActionPerformed(ActionEvent evt) {
       	patientinfo pi = new patientinfo();
	pi.setVisible(true);
	dispose();
    	}
	public void b3ActionPerformed(ActionEvent evt) {
       	chooseDoctor cd = new chooseDoctor();
	cd.setVisible(true);
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
            	new repactivity().setVisible(true);
        	});
    	}
}