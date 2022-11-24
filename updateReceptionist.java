import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class updateReceptionist extends JFrame 
{
	int count,age;
    	String date,id,name,gender,email,phone,Status,address,status,username,password;
	JLabel backIcon;
    	JLabel log;
	JLabel upd;
    	Label mLabel;
 	JPanel p1,p2;
    	JScrollPane sc;
    	JTable jt;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	DefaultTableModel dt = new DefaultTableModel();

	public updateReceptionist()
	{
	super("Update Receptionist Information");
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        this.setIconImage(ic.getImage());

        Object columns[] = {"S.No", "Joining Date", "Id", "Name", "Age", "Gender", "Email Address", "Phone Number", "Address", "Status", "Username", "Password"};
        dt.setColumnIdentifiers(columns);
        jt.setModel(dt);

        loadData();
    }

    public void loadData() {
        con = connection.ConnectDb();
        String sql = "select count,date,id,name,age,gender,email,phone,address,status,username,password from receptionist";
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

    @SuppressWarnings("unchecked")
    void initComponents() 
	{
        p1 = new JPanel();
	p2 = new JPanel();
        backIcon = new JLabel();
        log = new JLabel();
	upd = new JLabel();
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
	upd.setIcon(new ImageIcon(getClass().getResource("/Icon/upd.png")));
	upd.setLayout(null);
	upd.setBounds(350,430,100,40);
        upd.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        updMouseClicked(evt);
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
       	mLabel.setText("Update Receptionist");

	p1.setBounds(315,10,180,51);
	p2.setBounds(350,420,100,40);
	sc.setBounds(0,70,787,355);

	add(backIcon);
	add(log);
	add(sc);
	sc.setViewportView(jt);
	p1.add(mLabel);
	p2.add(upd);
	add(p2);
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
        int row = jt.getSelectedRow();
        int rcount = Integer.parseInt((jt.getValueAt(row, 0).toString()));
        String rdate = (jt.getValueAt(row, 1).toString());
        String rid = (jt.getValueAt(row, 2).toString());
        String rname = (jt.getValueAt(row, 3).toString());
        int rage = Integer.parseInt((jt.getValueAt(row, 4).toString()));
        String rgender = (jt.getValueAt(row, 5).toString());
	String remail = (jt.getValueAt(row, 6).toString());
        String rphone = (jt.getValueAt(row, 7).toString());
        String raddress = (jt.getValueAt(row, 8).toString());
        String rstatus = (jt.getValueAt(row, 9).toString());    
        String rusername = (jt.getValueAt(row, 10).toString());
        String rpassword = (jt.getValueAt(row, 11).toString());
        count = rcount;
        date = rdate;
        id = rid;
        name = rname;
        age = rage;
        gender = rgender;
        email = remail;
        phone = rphone;
        address = raddress;
        status = rstatus;
        username = rusername;
        password = rpassword;
    	}
	public void updMouseClicked(MouseEvent evt)  
	{
	  dt.getDataVector().removeAllElements();
          dt.fireTableDataChanged();
          con = connection.ConnectDb();
          String sql = "update receptionist set date = '" + date + "', id = '" + id + "', name = '" + name + "', age = '" + age + "', gender = '" + gender + "', email = '" + email + "', phone = '" + phone + "',   address = '" + address + "', status = '" + status + "', username = '" + username + "', password = '" + password + "' where count = '" + count + "'";  
	try
	{
	    ps = con.prepareStatement(sql);
	    ps.execute();
	    loadData();
            JOptionPane.showMessageDialog(null, "Data Updated");   
         } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } 

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new updateReceptionist().setVisible(true);
        });
    }

}