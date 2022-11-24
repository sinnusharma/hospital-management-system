
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class splashscreen extends JFrame {
   
    JFrame frame;
    JLabel image=new JLabel(new ImageIcon("hospital.png"));
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();
    splashscreen()
    {
        createGUI();
	addImage();
        addProgressBar();
        addMessage();
        runningPBar();
	
    }
    public void createGUI(){
        frame=new JFrame();
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
	frame.setSize(600,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void addImage(){
        image.setLayout(null);
	image.setBounds(0,50,600,293);
        frame.add(image);
    }
    public void addMessage()
    {
        message.setBounds(250,360,200,40);
        message.setForeground(Color.black);
        message.setFont(new Font("arial",Font.BOLD,15));
        frame.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        frame.add(progressBar);
    }
    public void runningPBar(){
        int i=0;

        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("LOADING "+Integer.toString(i)+"%");
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }



        }
    }
	 public static void main(String[] args){
         new splashscreen();

    }
}
