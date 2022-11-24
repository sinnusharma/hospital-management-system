import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class updatePatient extends JFrame 
{
	int count,age,room;
    	String date,id,name,gender,address,phone,Status,status,disease;
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

	public updatePatient()
	{
	super("Update Patient Information");
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
        String sql = "select count,date,id,name,age,gender,address,phone,status,disease,room from patient";
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
       	mLabel.setText("Update Patient");

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
       	patientactivity pa = new patientactivity();
        pa.setVisible(true);
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

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new updatePatient().setVisible(true);
        });
    }

}