import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class registrar extends JFrame
{
	public registrar()
	{
		super("Receptionist Management");
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
		JLabel deleteIcon;
		JLabel viewIcon,setBack;
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
		searchIcon = new JLabel();
		setBack = new JLabel();
		log = new JLabel();
		backIcon = new JLabel();
		l1 = new Label();
		l2 = new Label();
		l3 = new Label();
		l4 = new Label();
		b1 = new JButton("Add registrar");
		b2 = new JButton("Update registrar");
		b3 = new JButton("Delete registrar");
		b4 = new JButton("View registrar");
		b5 = new JButton("Search registrar");
		mLabel = new Label();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
       		setResizable(false);
        	setSize(800,500);
		setLocation(400,200);
		setBackground(Color.black);

		addIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/add2.png")));
		addIcon.setLayout(null);
        	addIcon.setBounds(180,100,80,80);
		
		
		updateIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/update2.png")));
		updateIcon.setLayout(null);
		updateIcon.setBounds(400,100,80,80);
		
		deleteIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/delete2.png")));
		deleteIcon.setLayout(null);
		deleteIcon.setBounds(620,100,80,80);

		setBack.setIcon(new ImageIcon(getClass().getResource("/Icon/back2.png")));
	        setBack.setSize(800,500);

		viewIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/view2.png")));
		viewIcon.setLayout(null);
		viewIcon.setBounds(290,242,80,80);

		searchIcon.setIcon(new ImageIcon(getClass().getResource("/Icon/search2.png")));
		searchIcon.setLayout(null);
		searchIcon.setBounds(510,242,80,80);

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
       		mLabel.setText("Receptionist Management");

		p1.setBounds(250,10,355,51);
		p2.setBounds(0,150,145,145);
		p2.setBackground(new Color(0, 153, 153));

        	l1.setFont(new Font("Arial", 1, 20));
        	l1.setForeground(new Color(255, 255, 255));
        	l1.setText("Welcome");

        	l2.setFont(new Font("Arial", 1, 20));
        	l2.setForeground(new Color(255, 255, 255));
        	l2.setText("To");

        	l3.setFont(new Font("Arial", 1, 20));
        	l3.setForeground(new Color(255, 255, 255));
        	l3.setText("Reception");

		l4.setFont(new Font("Arial", 1, 20));
        	l4.setForeground(new Color(255, 255, 255));
        	l4.setText("Management");

		b1.setLayout(null);
		b2.setLayout(null);
		b3.setLayout(null);
		b4.setLayout(null);
		b5.setLayout(null);
		b1.setBounds(165,190,118,19);
		b2.setBounds(378,190,127,19);
		b3.setBounds(605,190,124,19);
		b4.setBounds(275,340,118,19);
		b5.setBounds(490,340,126,19);
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
       	addReceptionist ar = new addReceptionist();
	ar.setVisible(true);
	dispose();
    	}
	public void b2ActionPerformed(ActionEvent evt) {
       	updateReceptionist ur = new updateReceptionist();
	ur.setVisible(true);
	dispose();
    	}
	public void b3ActionPerformed(ActionEvent evt) {
       	deleteReceptionist dr = new deleteReceptionist();
	dr.setVisible(true);
	dispose();
    	}
	public void b4ActionPerformed(ActionEvent evt) {
       	viewReceptionist vr = new viewReceptionist();
	vr.setVisible(true);
	dispose(); 
    	}
	public void b5ActionPerformed(ActionEvent evt) {
       	searchReceptionist sr = new searchReceptionist();
	sr.setVisible(true);
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
            	new registrar().setVisible(true);
        	});
  
    }
}