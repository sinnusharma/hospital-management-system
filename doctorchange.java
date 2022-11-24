import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class doctorchange extends JFrame
{
	public doctorchange()
	{
		super("Doctor Management");
		initComponents();
        	ImageIcon ic = new ImageIcon(getClass().getResource("/Icon/hospital1.png"));
        	this.setIconImage(ic.getImage());
        }
    	void initComponents() 
	{
		JPanel p1;
		JPanel p2;
		JLabel addIcon;
		JLabel updateIcon;
		JLabel deleteIcon,setBack;
		JLabel viewIcon;
		JLabel searchIcon;
		JLabel log;	
		JLabel backIcon;
		Label l1,l2,l3,l4;
		JButton b1;
		JButton b2;
		JButton b3,b4,b5;
		Label mLabel;
		p1 = new JPanel();
		p2 = new JPanel();
		addIcon = new JLabel();
		updateIcon = new JLabel();
		deleteIcon = new JLabel();
		viewIcon = new JLabel();
		setBack = new JLabel();
		searchIcon = new JLabel();
		log = new JLabel();
		backIcon = new JLabel();
		l1 = new Label();
		l2 = new Label();
		l3 = new Label();
		l4 = new Label();
		b1 = new JButton("Add Doctor");
		b2 = new JButton("Update Doctor");
		b3 = new JButton("Delete Doctor");
		b4 = new JButton("View Doctor");
		b5 = new JButton("Search Doctor");
		mLabel = new Label();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
       		setResizable(false);
        	setSize(800,500);
		setLocation(400,200);
		setBackground(Color.black);

		addIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/add1.png")));
		addIcon.setLayout(null);
        	addIcon.setBounds(180,100,80,80);
		
		
		updateIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/update1.png")));
		updateIcon.setLayout(null);
		updateIcon.setBounds(400,100,80,80);
		
		deleteIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/delete1.png")));
		deleteIcon.setLayout(null);
		deleteIcon.setBounds(620,100,80,80);

		viewIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/view1.png")));
		viewIcon.setLayout(null);
		viewIcon.setBounds(290,240,80,80);
		
		setBack.setIcon(new ImageIcon(getClass().getResource("/Icon/back2.png")));
		setBack.setSize(800,500);

		searchIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/search1.png")));
		searchIcon.setLayout(null);
		searchIcon.setBounds(510,240,80,80);

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

		mLabel.setAlignment(Label.CENTER);
        	mLabel.setBackground(new Color(0, 153, 153));
        	mLabel.setFont(new Font("Arial", 0, 30));
        	mLabel.setForeground(new Color(255, 255, 255));
       		mLabel.setText("Doctor Management");

		p1.setBounds(250,10,300,51);
		p2.setBounds(0,150,145,145);
		p2.setBackground(new Color(0, 153, 153));

        	l1.setFont(new Font("Arial", 1, 22));
        	l1.setForeground(new Color(255, 255, 255));
        	l1.setText("Welcome");

        	l2.setFont(new Font("Arial", 1, 22));
        	l2.setForeground(new Color(255, 255, 255));
        	l2.setText("To");

        	l3.setFont(new Font("Arial", 1, 22));
        	l3.setForeground(new Color(255, 255, 255));
        	l3.setText("Doctor");

		l4.setFont(new Font("Arial", 1, 22));
        	l4.setForeground(new Color(255, 255, 255));
        	l4.setText("Management");

		b1.setLayout(null);
		b2.setLayout(null);
		b3.setLayout(null);
		b4.setLayout(null);
		b5.setLayout(null);
		b1.setBounds(168,190,115,20);
		b2.setBounds(388,190,118,20);
		b3.setBounds(608,190,115,20);
		b4.setBounds(278,340,115,20);
		b5.setBounds(498,340,118,20);
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
		 b3.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
                b3ActionPerformed(evt);
           	 }
        	});

		 b4.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
                b4ActionPerformed(evt);
           	 }
        	});

		 b5.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
                b5ActionPerformed(evt);
           	 }
        	});
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(addIcon);
		add(updateIcon);
		add(deleteIcon);
		add(viewIcon);
		add(searchIcon);
		add(backIcon);
		add(log);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(l4);
		add(p2);
		p1.add(mLabel);
		add(p1);
		add(setBack);
		setVisible(true);
	}
	public void b1ActionPerformed(ActionEvent evt) {
       	addDoctor ad = new addDoctor();
	ad.setVisible(true);
	dispose();
    	}
	public void b2ActionPerformed(ActionEvent evt) {
       	updateDoctor ud = new updateDoctor();
	ud.setVisible(true);
	dispose();
    	}
	public void b3ActionPerformed(ActionEvent evt) {
       	deleteDoctor dd = new deleteDoctor();
	dd.setVisible(true);
	dispose();
    	}
	public void b4ActionPerformed(ActionEvent evt) {
       	viewDoctor vd = new viewDoctor();
	vd.setVisible(true);
	dispose();
    	}
	public void b5ActionPerformed(ActionEvent evt) {
       	searchDoctor sd = new searchDoctor();
	sd.setVisible(true);
	dispose();
    	}
	public void logMouseClicked(MouseEvent evt)  {
       	adminactivity ad = new adminactivity();
        ad.setVisible(true);
       	dispose();
    	}
	public void backIconMouseClicked(MouseEvent evt) 
	{
        hospital hos = new hospital();
        hos.setVisible(true);
        dispose();
    	}
	public static void main(String args[]) 
	{
		EventQueue.invokeLater(() -> {
            	new doctorchange().setVisible(true);
        	});
  
    }
}