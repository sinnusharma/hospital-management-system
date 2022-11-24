import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class searchReceptionist extends JFrame 
{
	int count,age;
    	String date,id,name,gender,email,phone,Status,address,status,username,password;
	JLabel backIcon;
    	JLabel log;
	JLabel search,fname;
	JTextField sea;
    	Label mLabel;
 	JPanel p1;
    	JScrollPane sc;
    	JTable jt;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	DefaultTableModel dt = new DefaultTableModel();

	public searchReceptionist()
	{
	super("Search Receptionist Information");
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        this.setIconImage(ic.getImage());

        Object columns[] = {"S.No", "Joining Date", "Id", "Name", "Age", "Gender", "Email Address", "Phone Number", "Address", "Status", "Username", "Password"};
        dt.setColumnIdentifiers(columns);
        jt.setModel(dt);
    }

    @SuppressWarnings("unchecked")
    void initComponents() 
	{
        p1 = new JPanel();
        backIcon = new JLabel();
        log = new JLabel();
	fname = new JLabel();
	search = new JLabel();
	sea = new JTextField();
        mLabel = new Label();
        sc = new JScrollPane(jt);
        jt = new JTable();
        
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
	fname.setFont(new Font("Time New Roman", 1, 25));
        fname.setForeground(new Color(0, 155, 155));
        fname.setText("Name of Receptionist:");
	fname.setLayout(null);
	fname.setBounds(65,70,270,46);

        sea.setFont(new Font("Time New Roman", 1, 18));
        sea.setForeground(new Color(0, 204, 204));
	sea.setLayout(null);
	sea.setBounds(330,75,240,40);

	search.setIcon(new ImageIcon(getClass().getResource("/Icon/search3.png")));
	search.setLayout(null);
	search.setBounds(580,73,115,40);
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
       	mLabel.setText("Search Receptionist");

	p1.setBounds(315,10,180,51);
	sc.setBounds(0,130,787,300);

	add(backIcon);
	add(log);
	add(sc);
	add(search);
	add(sea);
	add(fname);
	sc.setViewportView(jt);
	p1.add(mLabel);
	add(p1);

	setLocationRelativeTo(null);
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
	public void jtMouseClicked(MouseEvent evt) 
	{
    	}
	public void searchMouseClicked(MouseEvent evt)  
	{
	con = connection.ConnectDb();
	dt.getDataVector().removeAllElements();
        dt.fireTableDataChanged();
	String searchKey = sea.getText();
        String sql = "select count,date,id,name,age,gender,email,phone,address,status,username,password from receptionist where name= '"+searchKey+"'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object columnData[] = new Object[12];
            while (rs.next()) {
               columnData[0] = rs.getInt("count");
                columnData[1] = rs.getString("date");
                columnData[2] = rs.getString("id");
                columnData[3] = rs.getString("name");
                columnData[4] = rs.getInt("age");
                columnData[5] = rs.getString("gender");
                columnData[6] = rs.getString("email");
                columnData[7] = rs.getString("phone");
                columnData[8] = rs.getString("address");
                columnData[9] = rs.getString("status");
                columnData[10] = rs.getString("username");
		columnData[11] = rs.getString("password");
                dt.addRow(columnData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        } 

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new searchReceptionist().setVisible(true);
        });
    }

}