import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class chooseDoctor extends JFrame 
{
	JLabel backIcon;
    	JLabel log;
	JLabel nxt;
	JLabel search,fname,sh;
	JComboBox d1;
    	Label mLabel;
 	JPanel p1,p2;
	JLabel doc;
    	JScrollPane sc;
    	JTable jt;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	DefaultTableModel dt = new DefaultTableModel();

	public chooseDoctor()
	{
	super("Set Appointment");
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        this.setIconImage(ic.getImage());

        Object columns[] = {"S.No", "Joining Date", "Id", "Name", "Age", "Gender", "Department", "Phone Number", "Email Address", "Status", "Address", "Room number", "Username"};
        dt.setColumnIdentifiers(columns);
        jt.setModel(dt);
	}
	
	@SuppressWarnings("unchecked")
	void initComponents() 
	{
        p1 = new JPanel();
	p2 = new JPanel();
        backIcon = new JLabel();
        log = new JLabel();
	fname = new JLabel();
	search = new JLabel();
	nxt = new JLabel();
	sh = new JLabel();
	doc = new JLabel();
        mLabel = new Label();
        sc = new JScrollPane(jt);
        jt = new JTable();
	String department[]={ "Select Department", "Medecine", "Dental", "Gynaecology", "Nutrition", "Neurology", "Cardiology", "Haematology", "Microbiology" };
        d1 =new JComboBox(department);

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
	nxt.setIcon(new ImageIcon(getClass().getResource("/Icon/Next.png")));
	nxt.setLayout(null);
	nxt.setBounds(350,430,108,55);
        nxt.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        nxtMouseClicked(evt);
            		}
        	});
	fname.setFont(new Font("Time New Roman", 1, 30));
        fname.setForeground(new Color(0, 155, 155));
        fname.setText("Department:");
	fname.setLayout(null);
	fname.setBounds(85,70,180,46);

  	d1.setBounds(280,75,220,40);

	doc.setFont(new Font("Tahoma", 0, 20));
        doc.setForeground(new Color(0, 204, 204));
        doc.setText("Select a Doctor and Press Next");
	doc.setLayout(null);
	doc.setBounds(0,130,300,40);

	search.setIcon(new ImageIcon(getClass().getResource("/Icon/search3.png")));
	search.setLayout(null);
	search.setBounds(510,73,115,40);
        search.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        searchMouseClicked(evt);
            		}
        	});
	jt.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        jtMouseClicked(evt);
            		}
        	});

        jt.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
       
	
	mLabel.setAlignment(Label.CENTER);
        mLabel.setBackground(new Color(0, 153, 153));
        mLabel.setFont(new Font("Arial", 0, 30));
        mLabel.setForeground(new Color(255, 255, 255));
       	mLabel.setText("Set Appointment");

	p1.setBounds(315,10,180,51);
	p2.setBounds(350,400,130,65);
	sc.setBounds(0,170,787,240);

	add(backIcon);
	add(log);
	add(sc);
	add(search);
	add(fname);
	add(d1);
	add(doc);
	sc.setViewportView(jt);
	p1.add(mLabel);
	p2.add(nxt);
	add(p2);
	add(p1);

	setLocationRelativeTo(null);
    }
	public void logMouseClicked(MouseEvent evt)  {
       	repactivity ra = new repactivity();
        ra.setVisible(true);
       	dispose();
    	}
	public void backIconMouseClicked(MouseEvent evt) 
	{
        hospital hos = new hospital();
        hos.setVisible(true);
        dispose();
    	}
	public void nxtMouseClicked(MouseEvent evt)  {
       	 int row = jt.getSelectedRow();
        String dname = (jt.getValueAt(row, 12).toString());
        int room = Integer.parseInt(jt.getValueAt(row, 11).toString());
        choosePatient cp = new choosePatient();
        cp.dName = dname;
        cp.droom = room;
        cp.setVisible(true);
       	dispose();
    	}
	public void jtMouseClicked(MouseEvent evt) {
	}
	public void searchMouseClicked(MouseEvent evt)  
	{
	con = connection.ConnectDb();
	dt.getDataVector().removeAllElements();
        dt.fireTableDataChanged();
	String searchKey = (String) d1.getSelectedItem();
        String sql = "select count,date,id,name,age,gender,dept,phone,email,status,address,room,username,password from doctor where dept= '"+searchKey+"'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object columnData[] = new Object[13];
            while (rs.next()) {
                columnData[0] = rs.getInt("count");
                columnData[1] = rs.getString("date");
                columnData[2] = rs.getString("id");
                columnData[3] = rs.getString("name");
                columnData[4] = rs.getInt("age");
                columnData[5] = rs.getString("gender");
                columnData[6] = rs.getString("dept");
                columnData[7] = rs.getString("phone");
                columnData[8] = rs.getString("email");
                columnData[9] = rs.getString("status");
                columnData[10] = rs.getString("address");
                columnData[11] = rs.getString("room");
                columnData[12] = rs.getString("username");
                dt.addRow(columnData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        } 

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new chooseDoctor().setVisible(true);
        });
    }

}
	