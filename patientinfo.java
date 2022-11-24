import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class patientinfo extends JFrame 
{
	int count,age,room;
    	String date,id,name,gender,phone,Status,address,status,disease;
	JLabel backIcon;
    	JLabel log;
	JLabel upd;
	JLabel search,fname,sh;
	JTextField sea;
    	Label mLabel;
 	JPanel p1,p2;
    	JScrollPane sc;
    	JTable jt;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	DefaultTableModel dt = new DefaultTableModel();

	public patientinfo()
	{
	super("Patient Management");
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        this.setIconImage(ic.getImage());

        Object columns[] = {"S.No", "Date", "Id", "Name", "Age", "Gender", "Address", "Phone Number", "Status", "Disease",  "Room number",};
        dt.setColumnIdentifiers(columns);
        jt.setModel(dt);
	loadData();
    }
	public void loadData() {
        con = connection.ConnectDb();
        String sql ="select count,date,id,name,age,gender,address,phone,status,disease,room from patient";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object columnData[] = new Object[11];
            while (rs.next()) {
                 columnData[0] = rs.getInt("count");
                columnData[1] = rs.getString("date");
                columnData[2] = rs.getString("id");
                columnData[3] = rs.getString("name");
                columnData[4] = rs.getInt("age");
                columnData[5] = rs.getString("gender");
                columnData[6] = rs.getString("address");
                columnData[7] = rs.getString("phone");
                columnData[8] = rs.getString("status");
                columnData[9] = rs.getString("disease");
                columnData[10] = rs.getString("room");
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
	fname = new JLabel();
	search = new JLabel();
	upd = new JLabel();
	sh = new JLabel();
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
	upd.setIcon(new ImageIcon(getClass().getResource("/Icon/upd.png")));
	upd.setLayout(null);
	upd.setBounds(350,430,100,40);
        upd.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        updMouseClicked(evt);
            		}
        	});
	fname.setFont(new Font("Time New Roman", 1, 28));
        fname.setForeground(new Color(0, 155, 155));
        fname.setText("Name of Patient:");
	fname.setLayout(null);
	fname.setBounds(65,70,235,46);

        sea.setFont(new Font("Time New Roman", 1, 18));
        sea.setForeground(new Color(0, 204, 204));
	sea.setLayout(null);
	sea.setBounds(285,75,220,40);

	search.setIcon(new ImageIcon(getClass().getResource("/Icon/del.png")));
	search.setLayout(null);
	search.setBounds(510,73,40,40);
        search.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        searchMouseClicked(evt);
            		}
        	});
	sh.setIcon(new ImageIcon(getClass().getResource("/Icon/del1.png")));
	sh.setLayout(null);
	sh.setBounds(553,73,115,40);
        sh.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
        shMouseClicked(evt);
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
       	mLabel.setText("Patient Management");

	p1.setBounds(315,10,180,51);
	p2.setBounds(350,420,100,40);
	sc.setBounds(0,130,787,300);

	add(backIcon);
	add(log);
	add(sc);
	add(search);
	add(sea);
	add(fname);
	add(sh);
	sc.setViewportView(jt);
	p1.add(mLabel);
	p2.add(upd);
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
	public void jtMouseClicked(MouseEvent evt) 
	{
        int row = jt.getSelectedRow();
        int rcount = Integer.parseInt((jt.getValueAt(row, 0).toString()));
        String rdate = (jt.getValueAt(row, 1).toString());
        String rid = (jt.getValueAt(row, 2).toString());
        String rname = (jt.getValueAt(row, 3).toString());
        int rage = Integer.parseInt((jt.getValueAt(row, 4).toString()));
        String rgender = (jt.getValueAt(row, 5).toString());
        String raddress = (jt.getValueAt(row, 6).toString());
        String rphone = (jt.getValueAt(row, 7).toString());
        String rstatus = (jt.getValueAt(row, 8).toString());
        String rdisease = (jt.getValueAt(row, 9).toString());
        int rroom = Integer.parseInt((jt.getValueAt(row, 10).toString()));
        count = rcount;
        date = rdate;
        id = rid;
        name = rname;
        age = rage;
        gender = rgender;
	address = raddress;
        phone = rphone;
        status = rstatus;
	disease = rdisease;
        room = rroom;
    	}
	public void updMouseClicked(MouseEvent evt)  
	{
	  dt.getDataVector().removeAllElements();
          dt.fireTableDataChanged();
          con = connection.ConnectDb();
          String sql = "update patient set date = '" + date + "', id = '" + id + "', name = '" + name + "', age = '" + age + "', gender = '" + gender + "', address = '" + address + "', phone = '" + phone + "', status = '" + status + "', disease = '"+disease+"',room = '" + room + "' where count = '" + count + "'";  
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
	public void searchMouseClicked(MouseEvent evt)  
	{
	con = connection.ConnectDb();
	String search = sea.getText();
        String sql = "Delete from patient where name ='" + search + "'";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
            if(rs.next())
	{
            JOptionPane.showMessageDialog(null, "Patient " + search + " has been deleted");  
            dt.getDataVector().removeAllElements();
            dt.fireTableDataChanged();
	    loadData();
            con.close();
	}
	else{
	     JOptionPane.showMessageDialog(null, "Patient named " + search + " not found");
	}
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Patient named " + search + " not found");
        }
        
        } 
	public void shMouseClicked(MouseEvent evt)  
	{
	con = connection.ConnectDb();
	String search = sea.getText();
        String sql = "Delete from patient where name ='" + search + "'";
        try {
            ps = con.prepareStatement(sql);
            ps.execute();
	    if(rs.next())
	{
            JOptionPane.showMessageDialog(null, "Patient " + search + " has been deleted");  
            dt.getDataVector().removeAllElements();
            dt.fireTableDataChanged();
	    loadData();
            con.close();
	}
	else{
	     JOptionPane.showMessageDialog(null, "Patient named " + search + " not found");
	}
		
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Patient named " + search + " not found");
        }
        
        } 
	
    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new patientinfo().setVisible(true);
        });
    }

}