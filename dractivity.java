import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class dractivity extends JFrame
{
	PreparedStatement ps = null;
    	ResultSet rs = null;
    	Connection con = null;
        public String sendName;
        String findName;
	String username;
	JLabel l4;
	public dractivity(String user) 
	{
		super(" Doctor Zone ");
        	initComponents();
        	ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        	this.setIconImage(ic.getImage());
		findName = user;
    	}
	public void User(String username) {
        this.username = username;
    	}

	public dractivity(){
	//this("findName");
	initComponents();
	}

	void initComponents()
	{
		JPanel p1;
		JPanel p2;
		JLabel setIcon;
		JLabel setBack;
		JLabel backIcon;
		JLabel l1,l2,l3;
		JButton b1;
		Label mLabel;
		p1 = new JPanel();
		p2 = new JPanel();
		setIcon = new JLabel();
		setBack = new JLabel();
		backIcon = new JLabel();
		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		b1 = new JButton("Appointments");
		mLabel = new Label();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
       		setResizable(false);
        	setSize(800,500);
		setLocation(400,200);
		setBackground(Color.black);
		
		setIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/setappointment.png")));
		setIcon.setLayout(null);
		setIcon.setBounds(345,180,115,115);

		setBack.setIcon(new ImageIcon(getClass().getResource("/Icon/doctor2.png")));
		setBack.setSize(800,500);

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
        	mLabel.setFont(new Font("Arial", 1, 29));
        	mLabel.setForeground(new Color(255, 255, 255));
       		mLabel.setText("Hello Doctor");

		p2.setBounds(0,180,145,145);
		p1.setBounds(315,10,180,51);
		p2.setBackground(new Color(0, 153, 153));


		l1.setFont(new Font("Arial", 1, 28));
        	l1.setForeground(new Color(255, 255, 255));
        	l1.setText("Welcome");

        	l2.setFont(new Font("Arial", 1, 28));
        	l2.setForeground(new Color(255, 255, 255));
        	l2.setText("To");

        	l3.setFont(new Font("Arial", 1, 28));
        	l3.setForeground(new Color(255, 255, 255));
        	l3.setText("Doctor");
        	l3.setToolTipText("");

		l4.setFont(new Font("Arial", 1, 28));
        	l4.setForeground(new Color(255, 255, 255));
        	l4.setText("Zone");
		
		b1.setLayout(null);
		b1.setBounds(345,315,115,30);
		b1.setFont(new Font("Arial",1,12));
		 b1.addActionListener(new ActionListener() {
           	 public void actionPerformed(ActionEvent evt) {
                 b1ActionPerformed(evt);
          	 }
        	});

		add(b1);
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
       	con = connection.ConnectDb();
        String sql = "select pName from appointment where dName = '" + findName + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.first();
            String getPname = rs.getString("pName");
            sendName = getPname;
            Appointment app = new Appointment(sendName);
            app.setVisible(true);
            dispose();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Appointment list is Empty");
        }
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
            	new dractivity().setVisible(true);
        	});
    	}
}