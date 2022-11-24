
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class hospital extends JFrame
{
	public hospital()
	{
		super("Welcome To Hospital Management System");
		initComponents();
        	ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        	this.setIconImage(ic.getImage());
        }
    	void initComponents() 
	{
		JPanel p1;
		JPanel p2;
		JLabel adminIcon;
		JLabel doctorIcon;
		JLabel setBack;
		JLabel receptionIcon;
		Label l1;
		JButton b1;
		JButton b2;
		JButton b3;
		Label mLabel;
		p1 = new JPanel();
		p2 = new JPanel();
		adminIcon = new JLabel();
		doctorIcon = new JLabel();
		setBack = new JLabel();
		receptionIcon = new JLabel();
		l1 = new Label();
		b1 = new JButton("Admin");
		b2 = new JButton("Doctor");
		b3 = new JButton("Registrar");
		mLabel = new Label();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
       		setResizable(false);
        	setSize(800,500);
		setLocation(400,200);
		setBackground(Color.black);

		adminIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/admin.png")));
		adminIcon.setLayout(null);
        	adminIcon.setBounds(50, 200, 130,130);
		
		setBack.setIcon(new ImageIcon(getClass().getResource("/Icon/hospital2.png")));
		setBack.setSize(800,500);

		doctorIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/doctor.png")));
		doctorIcon.setLayout(null);
		doctorIcon.setBounds(310,200,130,130);
		
		receptionIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/reception.png")));
		receptionIcon.setLayout(null);
		receptionIcon.setBounds(600,200,130,130);
		

		mLabel.setAlignment(Label.CENTER);
        	mLabel.setBackground(new Color(0, 153, 153));
        	mLabel.setFont(new Font("Arial", 0, 26));
        	mLabel.setForeground(new Color(255, 255, 255));
       		mLabel.setText("Hospital Management System");

		p1.setBounds(250,10,350,55);
		p2.setBounds(0,100,120,50);

		l1.setAlignment(Label.LEFT);
		l1.setBackground(new Color(0, 153, 153));
		l1.setForeground(new Color(255, 255, 255));	
		l1.setFont(new Font("Arial", 0, 28));
        	l1.setText("Login As");
		
		b1.setLayout(null);
		b2.setLayout(null);
		b3.setLayout(null);
		b1.setBounds(50,350,130,30);
		b2.setBounds(310,350,130,30);
		b3.setBounds(600,350,130,30);
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
		add(receptionIcon);
		add(doctorIcon);
		add(adminIcon);
		p2.add(l1);
		add(p2);
		p1.add(mLabel);
		add(p1);
		add(setBack);
		setVisible(true);
	}
	public void b1ActionPerformed(ActionEvent evt) {
       	admin adm = new admin();
        adm.setVisible(true);
       	dispose();
    	}
	public void b2ActionPerformed(ActionEvent evt) {
       	Doctor doc = new Doctor();
        doc.setVisible(true);
       	dispose();
    	}
	public void b3ActionPerformed(ActionEvent evt) {
       	receptionist rep = new receptionist();
        rep.setVisible(true);
       	dispose();
    	}

	public static void main(String args[]) 
	{
            	splashscreen sp = new splashscreen();
		sp.setVisible(true);
		sp.dispose();
		EventQueue.invokeLater(() -> {
            	new hospital().setVisible(true);
        	});
  
    }
}
	

		
		
