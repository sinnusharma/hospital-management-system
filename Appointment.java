import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Appointment extends JFrame {

	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;
	String pname;
	JLabel l1,l2,l3,l4,pl,il,al,gl;
	JLabel backIcon;
	JLabel log;
	JLabel Next;
	Label mLabel;
	JPanel p1;
	
	public Appointment(String pName) {
        super("Check Appointment");
	initComponents();
        pname = pName;
        ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        this.setIconImage(ic.getImage());

        con = connection.ConnectDb();
        String sql = "SELECT id,age,gender FROM patient WHERE name = '" + pName + "'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
	    rs.first();
            String Id = rs.getString("id");
            int iage = rs.getInt("age");
            String gender = rs.getString("gender");
            String age = Integer.toString(iage);
            pl.setText(pName);
            il.setText(Id);
            al.setText(age);
            gl.setText(gender);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something Went Wrong");
        }

    }
	public Appointment(){
	//this("pName");
	initComponents();	
	}
    @SuppressWarnings("unchecked")

    void initComponents() {
	p1 = new JPanel();
	l1 = new JLabel();
	l2 = new JLabel();
	l3 = new JLabel();
	l4 = new JLabel();
	pl = new JLabel();
	il = new JLabel();
	al = new JLabel();
	gl = new JLabel();
	backIcon = new JLabel();
	log = new JLabel();
	Next = new JLabel();
	mLabel = new Label();

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
	Next.setIcon(new ImageIcon(getClass().getResource("/Icon/detail.png")));
	Next.setLayout(null);
	Next.setBounds(310,300,110,42);
        Next.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        NextMouseClicked(evt);
            		}
        	});

	mLabel.setAlignment(Label.CENTER);
        mLabel.setBackground(new Color(0, 153, 153));
        mLabel.setFont(new Font("Arial", 1, 35));
        mLabel.setForeground(new Color(255, 255, 255));
       	mLabel.setText("Appointment");

	p1.setBounds(315,10,180,51);
	
	l1.setFont(new Font("Time New Roman", 1, 18));
	l1.setLayout(null);
	l1.setBounds(180,150,150,30);
        l1.setText("Patient Name:");
	l1.setForeground(new Color(0, 153, 153));

	l2.setFont(new Font("Time New Roman", 1, 18));
	l2.setLayout(null);
	l2.setBounds(180,185,100,30);
        l2.setText("Id:");
	l2.setForeground(new Color(0, 153, 153));

	l3.setFont(new Font("Time New Roman", 1, 18));
	l3.setLayout(null);
	l3.setBounds(520,150,100,30);
        l3.setText("Age:");
	l3.setForeground(new Color(0, 153, 153));
	
	l4.setFont(new Font("Time New Roman", 1, 18));
	l4.setLayout(null);
	l4.setBounds(520,185,100,30);
        l4.setText("Gender:");
	l4.setForeground(new Color(0, 153, 153));
	
	pl.setFont(new Font("Time New Roman", 0, 16));
	pl.setLayout(null);
	pl.setBounds(355,150,150,25);
	pl.setForeground(new Color(153, 153, 153));
	
	il.setFont(new Font("Time New Roman", 0, 16));
	il.setLayout(null);
	il.setBounds(355,185,150,25);
	il.setForeground(new Color(153, 153, 153));

	al.setFont(new Font("Time New Roman", 0, 16));
	al.setLayout(null);
	al.setBounds(622,150,150,25);
	al.setForeground(new Color(153, 153, 153));

	gl.setFont(new Font("Time New Roman", 0, 16));
	gl.setLayout(null);
	gl.setBounds(622,185,150,25);
	gl.setForeground(new Color(153, 153, 153));

	add(l1);add(l2);add(l3);add(l4);add(pl);add(il);add(al);add(gl);
	add(backIcon);add(log);
	add(Next);
	p1.add(mLabel);
	add(p1);

	setVisible(true);
       }
	public void logMouseClicked(MouseEvent evt)  {
	dractivity da = new dractivity();
        da.setVisible(true);
       	dispose();
    	}
	public void NextMouseClicked(MouseEvent evt)  {
	patientdetail pd = new patientdetail(pname);
        pd.setVisible(true);
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
           new Appointment().setVisible(true);
        });
    }
}