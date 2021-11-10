package main;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.scene.text.Font;

public class MyFrame extends JFrame {

	Calendar calendar;
	SimpleDateFormat timeFormat;
	SimpleDateFormat dayFormat;
	SimpleDateFormat dateFormat;
	JLabel timeLabel;
	JLabel dayLabel;
	JLabel dateLabel;
	
	String time;
	String day;
	String date;
	
	
	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My clock");
//		this.setLayout(getLayout());
		this.setSize(350, 200);
//		this.setResizable(true);

		timeFormat = new SimpleDateFormat("hh:mm:ss a");
		dayFormat = new SimpleDateFormat("E");
		dateFormat = new SimpleDateFormat("dd:mm:yyyy");
		
		timeLabel = new JLabel();
//		timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50);
		timeLabel.setForeground(new Color(0x00FF00));
		timeLabel.setBackground(Color.black);
		timeLabel.setOpaque(true);
		
		dayLabel = new JLabel();
//		dayLabel.setFont(new Font("Inke free", Font.PLAIN,35));
		dateLabel = new JLabel();
		
		

		this.add(timeLabel);
//		this.add(dayLabel);
//		this.add(dateLabel);
		this.setVisible(true);

		setTime();

	}

	public void setTime() {

		while (true) {
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeLabel.setText(time);
			
			day = dayFormat.format(Calendar.getInstance().getTime());
			dayLabel.setText(day);
			
			date = dateFormat.format(Calendar.getInstance().getTime());
			dateLabel.setText(date);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
