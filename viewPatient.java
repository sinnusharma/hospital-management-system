import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
public class viewPatient extends JFrame 
{
	JLabel backIcon;
    	JLabel log;
    	Label mLabel;
 	JPanel p1;
    	JScrollPane sc;
    	JTable jt;
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	DefaultTableModel dt = new DefaultTableModel();

	public viewPatient()
	{
	super("View Patient Information");
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
	    dt.getDataVector().removeAllElements();
            dt.fireTableDataChanged(); 
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
	    JOptionPane.showMessageDialog(null, "Something went wrong");
        }
    }

    @SuppressWarnings("unchecked")
    void initComponents() 
	{
        p1 = new JPanel();
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
       	mLabel.setText("View Patient");

	p1.setBounds(315,10,180,51);
	sc.setBounds(0,70,787,365);

	add(backIcon);
	add(log);
	add(sc);
	sc.setViewportView(jt);
	p1.add(mLabel);
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

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new viewPatient().setVisible(true);
        });
    }

}