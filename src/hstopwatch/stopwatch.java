package hstopwatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stopwatch implements ActionListener {
    
    JFrame f = new JFrame();
    
    JButton startbutton = new JButton("START");
    JButton stopbutton  = new JButton("Reset");
    JLabel  time = new JLabel();
    
    int elapsed = 0;
    int second  = 0;
    int minutes = 0;
    int hours   = 0;
    boolean started = false;
    
    String second_s = String.format("%02d",second);
    String second_m = String.format("%02d",minutes);
    String second_h = String.format("%02d",hours);
    
    Timer timer = new Timer(1000, new ActionListener() {
  
  public void actionPerformed(ActionEvent e) {
   
      elapsed=elapsed+1000;
      hours = (elapsed/3600000);
      minutes = (elapsed/60000) % 60;
      second = (elapsed/1000) % 60;
      second_s = String.format("%02d", second);
      second_m = String.format("%02d", minutes);
      second_h = String.format("%02d", hours);
      time.setText(second_h +":"+ second_m+":"+second_s);
   
  }})
            
    
    stopwatch(){
        
     time.setText(second_s+":"+second_m+":"+second_h);
     time.setBounds(100,100,200,100);
     time.setFont(new Font("Verdana",Font.PLAIN,35));
     time.setBorder(BorderFactory.createBevelBorder(1));
     time.setOpaque(true);
     time.setHorizontalAlignment(JTextField.CENTER);
     
     startbutton.setBounds(100, 200, 100, 50);
     startbutton.setFont(new Font("Ink Free",Font.PLAIN,20));
     startbutton.setFocusable(false);
     startbutton.addActionListener(this);
  
     stopbutton.setBounds(200,200,100,50);
     stopbutton.setFont(new Font("Ink Free",Font.PLAIN,20));
     stopbutton.setFocusable(false);
     stopbutton.addActionListener(this);
     
     f.add(startbutton);
     f.add(stopbutton);
     f.add(time);
    
     f.setTitle("MY STOPWATCH");
     f.setSize(400,400);
     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     f.setLayout(null);
     f.setVisible(true);
         
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startbutton) {
   
   if(started==false) {
         started=true;
         startbutton.setText("STOP");
         start();
   }
   else {
        started=false;
        startbutton.setText("START");
        stop();
   }
   
  }
  if(e.getSource()==stopbutton) {
        started=false;
        startbutton.setText("START");
        reset();
  }
  
 }
 void start() {
    timer.start();
 }
 
 void stop() {
     timer.stop();
 }
 
 void reset() {
  timer.stop();
  elapsed=0;
  second =0;
  minutes=0;
  hours=0;
  second_s = String.format("%02d", second);
  second_m = String.format("%02d", minutes);
  second_h = String.format("%02d", hours);     
  time.setText( second_h+":"+ second_m+":"+ second_s);
 }}
    
}
