import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class firstWindow extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	static Settings DfaultSet;
	JRadioButton alStart;
	JRadioButton alResume;
	JRadioButton alAsk;
	
	JRadioButton highPer;
	JRadioButton medPer;
	JRadioButton lowPer;
	
	ButtonGroup group1;
	ButtonGroup group2;
	
	JButton save;
	JButton close;
	
	JLabel label1;
	JLabel label2;
	
	Font font1;
	Font font2;
	
	JCheckBox cb1;
	
	public firstWindow(Settings def) {
		super("VLC Mod Settings");
		DfaultSet = def;
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		cb1 = new JCheckBox("Continous Play? (Add All Files in the folder to the PlayList?)");
		cb1.addActionListener(this);
		cb1.setSelected(def.Contin);
		
		alStart = new JRadioButton("Always Start Over\n");
		alStart.addActionListener(this);
		alStart.setSelected(DfaultSet.Start);
		
		alResume = new JRadioButton("Always Resume (Recomended)\n");
		alResume.addActionListener(this);
		alResume.setSelected(DfaultSet.Resume);
		
		alAsk = new JRadioButton("Always Ask\n");
		alAsk.addActionListener(this);
		alAsk.setSelected(DfaultSet.Ask);
		
		group1 = new ButtonGroup();
		group1.add(alStart);
		group1.add(alResume);
		group1.add(alAsk);
		
		highPer = new JRadioButton("High Performance\n");
		highPer.addActionListener(this);
		highPer.setSelected(DfaultSet.High);
		
		medPer = new JRadioButton("Medium Performance (Recomended)\n");
		medPer.addActionListener(this);
		medPer.setSelected(DfaultSet.Med);
		
		lowPer = new JRadioButton("Low Performance\n");
		lowPer.addActionListener(this);
		lowPer.setSelected(DfaultSet.Low);
		
		group2 = new ButtonGroup();
		group2.add(highPer);
		group2.add(medPer);
		group2.add(lowPer);
		
		label1 = new JLabel("Select Default Operation :\n");
		font1 = new Font(label1.getText(), Font.BOLD, 18);
		label1.setFont(font1);
		
		label2 = new JLabel("Select Performance Level :\n");
		font2 = new Font(label2.getText(), Font.BOLD, 18);
		label2.setFont(font2);
		
		save = new JButton("Save");
		save.setEnabled(false);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure to save changes.?", "Confirm Save", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					int flag1, flag2;
					if(alStart.isSelected()){
						flag1 = 1;
					}else if(alResume.isSelected()){
						flag1 = 2;
					}else{
						flag1 = 3;
					}
				
					if(lowPer.isSelected()){
						flag2 =1;
					}else if(medPer.isSelected()){
						flag2 =2;
					}else{
						flag2 = 3;
					}
					new Operations().serial(new Settings(flag1, flag2, cb1.isSelected()));
					System.exit(0);
				}
			}
		});
		
		close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure to Exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION);
				if(resp == JOptionPane.YES_OPTION){
					System.exit(0);
				}
			}
		});
		
		JPanel p = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.gridx = 0;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.anchor = GridBagConstraints.WEST;
		
		p.add(label1, gbc);
		p.add(alStart, gbc);
		p.add(alResume, gbc);
		p.add(alAsk, gbc);
		
		JPanel p2 = new JPanel(new GridBagLayout());
		JPanel p3 = new JPanel(new GridBagLayout());
		JPanel p4 = new JPanel(new GridBagLayout());
		JPanel p5 = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc2 = new GridBagConstraints();
		gbc2.insets = new Insets(5, 15, 5, 5);
		
		GridBagConstraints gbc3 = new GridBagConstraints();
		gbc3.insets = new Insets(10, 10, 10, 10);;
		
		p2.add(label2, gbc);
		p2.add(lowPer, gbc);
		p2.add(medPer, gbc);
		p2.add(highPer, gbc);
		
		p5.add(cb1, gbc);
		
		gbc2.gridx = 0;
		gbc2.gridy = 0;
		p3.add(save, gbc2);
		
		gbc2.gridx = 1;
		gbc2.gridy = 0;
		p3.add(close, gbc2);
		
		gbc3.gridx = 0;
		gbc3.gridy = 0;
		p4.add(p, gbc3);
		
		gbc3.gridx = 0;
		gbc3.gridy = 1;
		p4.add(p2, gbc3);
		
		gbc3.gridx = 0;
		gbc3.gridy = 2;
		p4.add(p5, gbc3);

		gbc3.gridx = 0;
		gbc3.gridy = 3;
		p4.add(p3, gbc3);
		
		add(p4, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int flag1 = 2, flag2 = 2 ;
		if(alStart.isSelected()){
			flag1 = 1;
		}else if(alResume.isSelected()){
			flag1 = 2;
		}else if (alAsk.isSelected()){
			flag1 = 3;
		}
		
		if(lowPer.isSelected()){
			flag2 = 1;
		}else if(medPer.isSelected()){
			flag2 = 2;
		}else if(highPer.isSelected()){
			flag2 = 3;
		}
		
		Settings newSet = new Settings(flag1, flag2, cb1.isSelected());
		save.setEnabled(!(newSet.equals(DfaultSet)));
	}
}
