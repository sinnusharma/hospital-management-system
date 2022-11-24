import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addReceptionist extends JFrame 
{

	Connection con = null;
	PreparedStatement prp = null;
	JPanel p1;
	JLabel l1,l2,l3,l4,l6,l7,l8,l9,l10,l12,l13;
	JLabel backIcon;
	JLabel log;
	JButton b1,b2;
	JTextField t1,t2,t3,t4,t5,t6,t7,uf;
	JPasswordField pf;
	JComboBox d1,d3;
	Label mLabel;
 
	public addReceptionist() 
	{
		super("Add Receptionist");
        	initComponents();
        	ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        	this.setIconImage(ic.getImage());
	}
	@SuppressWarnings("unchecked")
	void initComponents() 
	{

	p1 = new JPanel();
	l1 = new JLabel();
	l2 = new JLabel();
	l3 = new JLabel();
	l4 = new JLabel();
	l6 = new JLabel();
	l7 = new JLabel();
	l8 = new JLabel();
	l9 = new JLabel();
	l10 = new JLabel();
	l12 = new JLabel();
	l13 = new JLabel();
	backIcon = new JLabel();
	log = new JLabel();
	t1 = new JTextField(30);
	t2 = new JTextField(30);
	t3 = new JTextField(30);
	t4 = new JTextField(30);
	t5 = new JTextField(30);
	t6 = new JTextField(30);
	t7 = new JTextField(30);
	uf = new JTextField(30);
	pf = new JPasswordField(30);
	mLabel = new Label();

	String gender[]={ "Select Item", "Male", "Female","Others" };
	String status[]={ "Select Item", "Single", "Married", "Divorced" };

	d1 = new JComboBox(gender);
	d3 = new JComboBox(status);
	b1 = new JButton("Add");
	b2 = new JButton("Clear");

	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
       	setResizable(false);
        setSize(800,500);
	setLocation(400,200);
	setBackground(Color.black);

	backIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/logout.png")));
	backIcon.setLayout(null);
	backIcon.setBounds(700,10,51,48);
        backIcon.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        backIconMouseClicked(evt);
            		}
        	});

	log.setIcon(new ImageIcon(getClass().getResource("/Icon/back.png")));
	log.setLayout(null);
	log.setBounds(10,10,50,50);
        log.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        logMouseClicked(evt);
            		}
        	});
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

	mLabel.setAlignment(Label.CENTER);
        mLabel.setBackground(new Color(0, 153, 153));
        mLabel.setFont(new Font("Arial", 0, 30));
        mLabel.setForeground(new Color(255, 255, 255));
       	mLabel.setText("Add Receptionist");

	p1.setBounds(315,10,180,51);
	
	l1.setFont(new Font("Time New Roman", 0, 12));
	l1.setLayout(null);
	l1.setBounds(20,100,100,20);
        l1.setText("Joining Date:");
	l1.setForeground(new Color(0, 153, 153));

	l2.setFont(new Font("Time New Roman", 0, 12));
	l2.setLayout(null);
	l2.setBounds(30,160,100,20);
        l2.setText("Id:");
	l2.setForeground(new Color(0, 153, 153));

	l3.setFont(new Font("Time New Roman", 0, 12));
	l3.setLayout(null);
	l3.setBounds(30,220,100,20);
        l3.setText("Name:");
	l3.setForeground(new Color(0, 153, 153));
	
	l4.setFont(new Font("Time New Roman", 0, 12));
	l4.setLayout(null);
	l4.setBounds(30,280,100,20);
        l4.setText("Age:");
	l4.setForeground(new Color(0, 153, 153));
	
	l6.setFont(new Font("Time New Roman", 0, 12));
	l6.setLayout(null);
	l6.setBounds(250,100,100,20);
        l6.setText("Gender");
	l6.setForeground(new Color(0, 153, 153));
	
	l7.setFont(new Font("Time New Roman", 0, 12));
	l7.setLayout(null);
	l7.setBounds(250,160,100,20);
        l7.setText("Phone No:");
	l7.setForeground(new Color(0, 153, 153));

	l8.setFont(new Font("Time New Roman", 0, 12));
	l8.setLayout(null);
	l8.setBounds(250,220,100,20);
        l8.setText("Email:");
	l8.setForeground(new Color(0, 153, 153));

	l9.setFont(new Font("Time New Roman", 0, 12));
	l9.setLayout(null);
	l9.setBounds(250,280,100,20);
        l9.setText("Marital Status:");
	l9.setForeground(new Color(0, 153, 153));
	
	l10.setFont(new Font("Time New Roman", 0, 12));
	l10.setLayout(null);
	l10.setBounds(550,100,100,20);
        l10.setText("Address:");
	l10.setForeground(new Color(0, 153, 153));

	l12.setFont(new Font("Time New Roman", 0, 12));
	l12.setLayout(null);
	l12.setBounds(550,160,100,20);
        l12.setText("Username:");
	l12.setForeground(new Color(0, 153, 153));

	l13.setFont(new Font("Time New Roman", 0, 12));
	l13.setLayout(null);
	l13.setBounds(550,220,100,20);
        l13.setText("Password:");
	l13.setForeground(new Color(0, 153, 153));

	t1.setLayout(null);
	t1.setBounds(90,100,100,20);

	t2.setLayout(null);
	t2.setBounds(80,160,100,20);
	t2.setText("Rep");

	t3.setLayout(null);
	t3.setBounds(80,220,100,20);

	t4.setLayout(null);
	t4.setBounds(80,280,100,20);

	t5.setLayout(null);
	t5.setBounds(340,160,100,20);
	t5.setText("+91");

	t6.setLayout(null);
	t6.setBounds(340,220,100,20);
        

	t7.setLayout(null);
	t7.setBounds(640,100,100,20);

	uf.setLayout(null);
	uf.setBounds(640,160,100,20);

	pf.setLayout(null);
	pf.setBounds(640,220,100,20);
	
	b1.setLayout(null);
	b2.setLayout(null);
	b1.setBounds(400,400,80,40);
	b2.setBounds(250,400,80,40);

	d1.setBounds(340,100,100,20);
	d3.setBounds(340,280,100,20);

	add(l1);add(l2);add(l3);add(l4);add(l6);add(l7);add(l8);add(l9);add(l10);add(l12);add(l13);
	add(t1);add(t2);add(t3);add(t4);add(t5);add(t6);add(t7);add(uf);add(pf);
	add(d1);add(d3);add(backIcon);add(log);
	add(b1);add(b2);
	p1.add(mLabel);
	add(p1);

	setVisible(true);
	}
	public void b1ActionPerformed(ActionEvent evt) {
	 con = connection.ConnectDb();
         if (con != null) {
            String date = t1.getText();
            String id = t2.getText();
            String name = t3.getText();
            int age = Integer.parseInt(t4.getText());
            String gender = (String) d1.getSelectedItem();
            String phone = t5.getText();
            String email = t6.getText();
            String status = (String) d3.getSelectedItem();
            String address = t7.getText();
            String user = uf.getText();
		int count=0;
            String pass = String.valueOf(pf.getPassword());
            String sql = "insert into receptionist(count,date,id,name,age,gender,email,phone,address,status,username,password) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                prp = con.prepareStatement(sql);
		prp.setInt(1, count);
                prp.setString(2, date);
                prp.setString(3, id);
                prp.setString(4, name);
                prp.setInt(5, age);
                prp.setString(6, gender);
		prp.setString(7, email);
                prp.setString(8, phone);
                prp.setString(9, address);
                prp.setString(10, status);
                prp.setString(11, user);
                prp.setString(12, pass);
                prp.execute();
                JOptionPane.showMessageDialog(null, "Data Saved");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
       	
    	}
	public void b2ActionPerformed(ActionEvent evt) {
       	t1.setText("");
        t2.setText("Rep");
        t3.setText("");
        t4.setText("");
        t5.setText("+91");
        t7.setText("");
        d1.setSelectedIndex(0);
        d3.setSelectedIndex(0);
        uf.setText("");
        pf.setText("");
        t6.setText("");

    	}
	public void logMouseClicked(MouseEvent evt)  {
       	registrar rr = new registrar();
        rr.setVisible(true);
       	dispose();
    	}
	public void backIconMouseClicked(MouseEvent evt) 
	{
        hospital hos = new hospital();
        hos.setVisible(true);
        dispose();
    	}
	public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new addReceptionist().setVisible(true);
        });
    }
}