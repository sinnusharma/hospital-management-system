import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Doctor extends JFrame {

    PreparedStatement prp = null;
    ResultSet result = null;
    Connection con = null;
    String username;
     JPanel p1;
     JPanel p2;
     Label l1;
     JButton lb;
     JPasswordField pf;
     JTextField uf;
     JLabel ul,setBack;
     JButton eb;
     JLabel u2;
     Label mLabel;

    public Doctor() {
	super(" Hello Doctor ");
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        this.setIconImage(ic.getImage());
    }

     void initComponents() {

        ul = new JLabel();
	p1 = new JPanel();
	p2 = new JPanel();
	l1 = new Label();
        u2 = new JLabel();
	setBack = new JLabel();
        uf = new JTextField(25);
        pf = new JPasswordField(25);
        eb = new JButton();
        lb = new JButton();
        mLabel = new Label();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 500);
	setLocation(400,200);

        ul.setFont(new Font("Tahoma", 0, 20));
	ul.setLayout(null);
	ul.setForeground(new Color(255, 255, 255));
	ul.setBounds(200,200,100,33);
        ul.setText("Username:");

        u2.setFont(new Font("Tahoma", 0, 20));
	u2.setLayout(null);
	u2.setForeground(new Color(255, 255, 255));
	u2.setBounds(200,250,100,33);
        u2.setText("Password:");

	pf.setLayout(null);
	pf.setBounds(330,250,150,33);
	
	p1.setBounds(250,10,350,50);
	p2.setBounds(0,100,180,50);
	

	l1.setAlignment(Label.LEFT);
	l1.setBackground(new Color(0, 153, 153));
	l1.setForeground(new Color(255, 255, 255));	
	l1.setFont(new Font("Arial", 0, 24));
        l1.setText("Login As Doctor");
	
	setBack.setIcon(new ImageIcon(getClass().getResource("/Icon/admin1.png")));
	setBack.setSize(800,500);

	uf.setLayout(null);
	uf.setBounds(330,200,150,33);
        uf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ufActionPerformed(evt);
            }
        });

        eb.setFont(new Font("Tahoma", 0, 18));
	eb.setBackground(new Color(0, 153, 153));
        eb.setForeground(new Color(255, 255, 255));
        eb.setText("Home");
        eb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ebActionPerformed(evt);
            }
        });

	eb.setLayout(null);
	lb.setLayout(null);
	eb.setBounds(150,350,120,40);
	lb.setBounds(400,350,120,40);

        lb.setFont(new Font("Tahoma", 0, 18));
	lb.setBackground(new Color(0, 153, 153));
        lb.setForeground(new Color(255, 255, 255));
        lb.setText("Login");
        lb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lbActionPerformed(evt);
            }
        });

        mLabel.setAlignment(Label.CENTER);
        mLabel.setBackground(new Color(0, 153, 153));
        mLabel.setFont(new Font("Arial", 0, 26));
        mLabel.setForeground(new Color(255, 255, 255));
        mLabel.setText("Hospital Management System");

	add(ul);
	add(u2);
	add(uf);
	add(pf);
	add(eb);
	add(lb);
	p2.add(l1);
	p1.add(mLabel);
	add(p2);
	add(p1);
	add(setBack);
	setVisible(true);
    }

     public void ebActionPerformed(ActionEvent evt) {
        hospital hos = new hospital();
        hos.setVisible(true);
        dispose();
    }

     public void lbActionPerformed(ActionEvent evt) {
        con = connection.ConnectDb();
        String user = uf.getText();
        String pass = String.valueOf(pf.getPassword());

        try {
            String sql = "select * from Doctor where username='"+user+"' and password='"+pass+"'";
            prp = con.prepareStatement(sql);
            result = prp.executeQuery();
	    username = user;
            if (result.next()) {
                dractivity dr = new dractivity(username);
                dr.setVisible(true);
                JOptionPane.showMessageDialog(null, "Login Succesful", "Welcome " +user, JOptionPane.INFORMATION_MESSAGE);
		dispose();
                dr.User(username);
                con.close();
            } else {
                JOptionPane.showMessageDialog(null, "Login Failed", "Error", JOptionPane.WARNING_MESSAGE);
//                JOptionPane.showMessageDialog(null, "user or password wrong.");
			uf.setText("");
			pf.setText("");
            }

        } catch (HeadlessException | SQLException e) {
//            JOptionPane.showMessageDialog(null, e);
            JOptionPane.showMessageDialog(null, "User or Password wrong.");
        }

    }

     void ufActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new Doctor().setVisible(true);
        });
    }
}