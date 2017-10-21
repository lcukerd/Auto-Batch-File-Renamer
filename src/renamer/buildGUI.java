package renamer;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;
import javax.swing.JButton;


public class buildGUI extends JFrame {


	private static final long serialVersionUID = 5679058154927390381L;
	private JPanel contentPane;
	private JTextField add;
	private JTextField before;
	private JTextField prepend;
	private JTextField beforeT;
	private JTextField prependT;
	private JTextField addT;
	private TextArea result;
	private JButton select,checkRename;
	private JTextField filesSelected;
	private File files[];
	private Logic logic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					buildGUI frame = new buildGUI();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public buildGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		before = new JTextField();
		before.setHorizontalAlignment(SwingConstants.CENTER);
		before.setFont(new Font("Tahoma", Font.PLAIN, 15));
		before.setText("Text before number");
		before.setEditable(false);
		before.setColumns(12);
		
		prepend = new JTextField();
		prepend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prepend.setText("Text to prepend num");
		prepend.setHorizontalAlignment(SwingConstants.CENTER);
		prepend.setEditable(false);
		prepend.setColumns(12);
		
		add = new JTextField();
		add.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add.setHorizontalAlignment(SwingConstants.CENTER);
		add.setText("Add int to number");
		add.setEditable(false);
		add.setColumns(12);
		
		beforeT = new JTextField();
		beforeT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		beforeT.setHorizontalAlignment(SwingConstants.CENTER);
		beforeT.setColumns(10);
		
		prependT = new JTextField();
		prependT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		prependT.setHorizontalAlignment(SwingConstants.CENTER);
		prependT.setColumns(10);
		
		addT = new JTextField();
		addT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addT.setText("0");
		addT.setHorizontalAlignment(SwingConstants.CENTER);
		addT.setColumns(5);
		
		select = new JButton("Select files");
		select.setFont(new Font("Tahoma", Font.PLAIN, 15));
		select.addActionListener(new selector());
		
		checkRename = new JButton("Check Rename");
		checkRename.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkRename.addActionListener(new checkRename());
		
		filesSelected = new JTextField();
		filesSelected.setFont(new Font("Tahoma", Font.PLAIN, 15));
		filesSelected.setHorizontalAlignment(SwingConstants.CENTER);
		filesSelected.setText("0 files selected");
		filesSelected.setEditable(false);
		filesSelected.setColumns(10);
		
		JButton startRename = new JButton("Start Rename");
		startRename.setFont(new Font("Tahoma", Font.PLAIN, 15));
		startRename.addActionListener(new startRename());
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(before, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(prepend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(add, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(prependT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(beforeT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(addT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(select)
								.addComponent(filesSelected, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(138, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(checkRename)
							.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
							.addComponent(startRename)
							.addGap(50))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(before, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(beforeT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(prepend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(prependT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(add, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(addT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(50)
							.addComponent(select)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(filesSelected, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(checkRename))
						.addComponent(startRename))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		result = new TextArea(6,54);
		result.setFont(new Font("Tahoma", Font.PLAIN, 15));
		result.setEditable(false);
		result.setText("Example: If file names are like \"Ball Super - x English.mp4\",\r\nwhere 'x' is episode number, and reqd format of file is \r\n\"episode y\" , where 'y=x+2', then \r\n\"text before number\" : \"per - \", \"Text to prepend\" : \"episode \"\r\n\"add int to num\" : \"2\"");
		panel_1.add(result);
	}
	
	private class selector implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			FileDialog fd = new FileDialog(new Frame(), "Open", FileDialog.LOAD); 
	    	fd.setMultipleMode(true);
	    	fd.setVisible(true);
	    	files = fd.getFiles();
	    	filesSelected.setText(files.length + " files selected");
	    	result.setText("");
	    	for (File temp:files)
	    	{
    			String oldname = temp.getName();
	    		result.append(oldname + "\r\n"); 
	    	}
		}
	}
	
	private class checkRename implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			int add =0;
	    	try
	    	{
	    		add = Integer.parseInt(addT.getText());
	    		if (files == null)
		    		result.setText("No file selected!");
	    		else
	    		{
	    			if (beforeT.getText().equals(""))
			    		result.setText("before Text not written");
	    			else
	    			{
	    				logic = new Logic(beforeT.getText(),prependT.getText(),add);
	    				result.setText("");
				    	for (File temp:files)
				    	{
				    			String oldname = temp.getName();
				    			String newname = logic.renamefiles(temp,false);
				    			result.append(oldname + "  :  " + newname + "\r\n"); 
				    	}
	    			}
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		result.setText("'add int to num' should be an integer");
	    	}	
		}
	}
	private class startRename implements ActionListener
	{
		public void actionPerformed(ActionEvent a)
		{
			int add =0;
	    	try
	    	{
	    		add = Integer.parseInt(addT.getText());
	    		if (files == null)
		    		result.setText("No file selected!");
	    		else
	    		{
	    			if (beforeT.getText() == null)
			    		result.setText("before Text not written");
	    			else
	    			{
	    				if (prependT.getText() == null)
	    					logic = new Logic(beforeT.getText(),"",add);
	    				else
	    					logic = new Logic(beforeT.getText(),prependT.getText(),add);
	    				result.setText("");
				    	for (File temp:files)
				    	{
				    			String oldname = temp.getName();
				    			String newname = logic.renamefiles(temp,true);
				    			result.append(oldname + "  :  " + newname + "\r\n"); 
				    	}
	    			}
	    		}
	    	}
	    	catch(Exception e)
	    	{
	    		result.setText("'add int to num' should be an integer");
	    	}	
		}
	}
}
