import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GuiExample {

	private int count = 0;
	private JLabel label;
	private JFrame frame;
	private JPanel panel;
	private JButton button;

	public GuiExample(){
		this.frame = new JFrame();

		this.button = new JButton("Click Me");
		this.button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addButton();
			}
		});

		this.label = new JLabel("Number of clicks: 0");

		this.panel = new JPanel();

		this.panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		this.panel.setLayout(new GridLayout(0, 1));
		this.panel.add(this.button);
		this.panel.add(this.label);


		this.frame.add(panel, BorderLayout.CENTER);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setTitle("Gui Title");
		this.frame.pack();
		this.frame.setVisible(true);

	}

	public void addButton(){
		this.count++;
		this.label.setText("Number of Clicks: " + this.count);
	}

	public static void main(String[] args){
		//System.out.println("Pool");
		new GuiExample();
	}
	//public void actionPerformed(ActionEvent e) {
		//this.count++;
		//this.label.setText("Number of clicks:" + count);
	//}
}
