package airport;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class CCI extends JFrame implements ActionListener{
 JButton jb1=new JButton("<<");
 JButton jb2=new JButton("<");
 JButton jb3=new JButton(">");
 JButton jb4=new JButton(">>");
 JPanel jp1=new JPanel();
 JPanel jp2=new JPanel();
 JPanel jp3=new JPanel();
 JPanel jp4=new JPanel();
 JLabel jl1=new JLabel();
 JLabel jl2=new JLabel();
 JLabel[]jl=new JLabel[49];
 String []week={"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
 Calendar c=Calendar.getInstance();
 int year,month,day;
 int nowyear,nowmonth,nowday;
 CCI(){
  super("简单日历");
  nowyear=c.get(Calendar.YEAR);
  nowmonth=c.get(Calendar.MONTH)+1;
  nowday=c.get(Calendar.DAY_OF_MONTH);
  year=nowyear;
  month=nowmonth;
  day=nowday;
  String s=year+"年"+month+"月";
  jl1.setForeground(Color.RED);
  jl1.setText(s);
  jb1.addActionListener(this);
  jb2.addActionListener(this);
  jb3.addActionListener(this);
  jb4.addActionListener(this);
  jp1.add(jb1);jp1.add(jb2);jp1.add(jl1);jp1.add(jb3);jp1.add(jb4);
  jp2.setLayout(null);
  createMonthPanel();
  jp2.add(jp3);
  jl2.setText("今天是"+nowyear+"年"+nowmonth+"月"+nowday+"日");
  jp4.add(jl2);
  add(jp1,BorderLayout.NORTH);
  add(jp2,BorderLayout.CENTER);
  add(jp4,BorderLayout.SOUTH);
  setSize(500,500);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  setLocationRelativeTo(null);
  setVisible(true);
 }
 @Override
 public void actionPerformed(ActionEvent ae) {
  if(ae.getSource()==jb1){
   year=year-1;
   String s=year+"年"+month+"月";
   jl1.setText(s);
   jp3.removeAll();
   createMonthPanel();
   jp3.validate();
  }
  if(ae.getSource()==jb2){
   if(month==1){
    year=year-1;
    month=12;
   }else{
    month=month-1;
   }
   String s=year+"年"+month+"月";
   jl1.setText(s);
   jp3.removeAll();
   createMonthPanel();
   jp3.validate();
  }
  if(ae.getSource()==jb3){
   if(month==12){
    year=year+1;
    month=1;
   }else{
    month=month+1;
   }
   String s=year+"年"+month+"月";
   jl1.setText(s);
   jp3.removeAll();
   createMonthPanel();
   jp3.validate();
  }
  if(ae.getSource()==jb4){
   year=year+1;
   String s=year+"年"+month+"月";
   jl1.setText(s);
   jp3.removeAll();
   createMonthPanel();
   jp3.validate();
  }
 }
 /*public static void main(String[] args) {
  new CCI();
 }*/
 public int getMonthDays(int year, int month) { 
  switch (month) { 
   case 3: 
   case 5: 
   case 7:
   case 8: 
   case 10: 
    return 31; 
   case 1: 
    if ((year%4==0&&year%100!=0)||year%400==0) { 
     return 29; 
    } else { 
     return 28; 
    } 
   default: 
    return 30; 
  } 
 } 
 public void createMonthPanel(){
  c.set(year, month-1, getMonthDays(year,month));
  int weekOfMonth=c.get(Calendar.WEEK_OF_MONTH);
  if(weekOfMonth==6){
   jp3.setLayout(new GridLayout(7,7));
   jp3.setBounds(50, 20, 420, 350);
  }else{
   jp3.setLayout(new GridLayout(6,7));
   jp3.setBounds(50, 20, 420, 300);
  }
  jp3.setBorder(BorderFactory.createEtchedBorder());
  for(int i=0;i<7;i++){
   jl[i]=new JLabel(week[i],JLabel.CENTER);
   jl[i].setBorder(BorderFactory.createEtchedBorder());
   jp3.add(jl[i]);
  }
  c.set(year, month-1, 1);
  int emptyFirst=c.get(Calendar.DAY_OF_WEEK)-1;
  int daysOfMonth=getMonthDays(year,month);
  for(int i=6+emptyFirst;i>=7;i--){
	  
   int intyear=year;
   int intmonth=month;
   if(intmonth==1){
    intyear=intyear-1;
    intmonth=12;
   }else{
    intmonth=intmonth-1;
   }
   int intdays=getMonthDays(intyear,intmonth);
   jl[i]=new JLabel((intdays+7-i)+"",JLabel.CENTER);
   jl[i].setForeground(Color.GRAY);
   jl[i].setBorder(BorderFactory.createEtchedBorder());
   jl[i].addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		//	int date=intdays+7-i;
		//Reserve.textField_2.setText(date);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		  
	  });
   jp3.add(jl[i]);
  }
  for(int i=7+emptyFirst;i<daysOfMonth+7+emptyFirst;i++){
   jl[i]=new JLabel((i-7-emptyFirst+1)+"",JLabel.CENTER);
   if((i+1)%7==0 || (i+1)%7==1 || (i-7-emptyFirst+1)==nowday&&month==nowmonth&&year==nowyear)
    jl[i].setForeground(Color.RED);
   else
    jl[i].setForeground(Color.BLACK);
    
   jl[i].setBorder(BorderFactory.createEtchedBorder());
   jp3.add(jl[i]);
  }
  if(weekOfMonth==6)
   for(int i=48;i>=daysOfMonth+emptyFirst+7;i--){
    jl[i]=new JLabel((49-i)+"",JLabel.CENTER);
    jl[i].setForeground(Color.GRAY);
    jl[i].setBorder(BorderFactory.createEtchedBorder());
    jp3.add(jl[i]);
   }
  else
   for(int i=41;i>=daysOfMonth+emptyFirst+7;i--){
    jl[i]=new JLabel((42-i)+"",JLabel.CENTER);
    jl[i].setForeground(Color.GRAY);
    jl[i].setBorder(BorderFactory.createEtchedBorder());
    jp3.add(jl[i]);
   }
 }
}