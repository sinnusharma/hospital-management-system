
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class viewDoctor extends JFrame 
{
	JLabel backIcon;
    	JLabel log;
    	Label mLabel;
 	JPanel p1,p2;
    	JScrollPane sc;
    	JToggleButton pt;
    	JTable jt;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	DefaultTableModel dt = new DefaultTableModel();

	public viewDoctor()
	{
	super("View Doctor");
        initComponents();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        this.setIconImage(ic.getImage());

        Object columns[] = {"S.No", "Joining Date", "Id", "Name", "Age", "Gender", "Department", "Phone Number", "Email Address", "Status", "Address", "Room number", "Username", "Password"};
        dt.setColumnIdentifiers(columns);
        jt.setModel(dt);

        loadData();
    }

    public void loadData() {
        con = connection.ConnectDb();
        String sql = "select count,date,id,name,age,gender,dept,phone,email,status,address,room,username from doctor";
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

    @SuppressWarnings("unchecked")
    void initComponents() 
	{
        p1 = new JPanel();
	p2 = new JPanel();
        backIcon = new JLabel();
        log = new JLabel();
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
	pt = new JToggleButton();
	pt.setBackground(new Color(255, 0, 0));
        pt.setForeground(new Color(255, 255, 255));
        pt.setText("Show Passwords");
	pt.setLayout(null);
	pt.setBounds(350,450,100,30);
        pt.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        ptActionPerformed(evt);
              }
          });
	pt.setVisible(true);

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
       	mLabel.setText("View Doctor");

	p1.setBounds(315,10,180,51);
	p2.setBounds(350,430,100,30);
	sc.setBounds(0,70,787,365);

	add(backIcon);
	add(log);
	add(sc);
	sc.setViewportView(jt);
	p1.add(mLabel);
	p2.add(pt);
	add(p2);
	add(p1);

	setLocationRelativeTo(null);
    }
	public void logMouseClicked(MouseEvent evt)  {
       	doctorchange dc = new doctorchange();
        dc.setVisible(true);
       	dispose();
    	}
	public void backIconMouseClicked(MouseEvent evt) 
	{
        hospital hos = new hospital();
        hos.setVisible(true);
        dispose();
    	}
    	public void ptActionPerformed(ActionEvent evt) {
        if (pt.isSelected()) {
            pt.setText("Hide Passwords");
            dt.getDataVector().removeAllElements();
            dt.fireTableDataChanged();
            con = connection.ConnectDb();
            String sql = "select count,date,id,name,age,gender,dept,phone,email,status,address,room,username,password from doctor";
            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                Object columnData[] = new Object[14];
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
                    columnData[13] = rs.getString("password");
                    dt.addRow(columnData);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            pt.setText("Show Passwords");
            dt.getDataVector().removeAllElements();
            dt.fireTableDataChanged();
            con =connection.ConnectDb();
            String sql = "select count,date,id,name,age,gender,dept,phone,email,status,address,room,username,password from doctor";
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
                JOptionPane.showMessageDialog(null, "Something went wrong");
            }
        }

    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new viewDoctor().setVisible(true);
        });
    }

}