package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Stack extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JList<String> list = new JList<String>();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		setTitle("Stefan Krstanovic I7 4/2019");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
	
		JButton btnAdd = new JButton("Dodaj");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlgS = new DlgStack();
				dlgS.setVisible(true);
				
				if (dlgS.isOk) {

					Rectangle r = new Rectangle(
							new Point(Integer.parseInt(dlgS.getTxtX().getText()),
									Integer.parseInt(dlgS.getTxtY().getText())),
							
							Integer.parseInt(dlgS.getTxtHeight().getText()),
							Integer.parseInt(dlgS.getTxtWidth().getText()));

					dlm.add(0, r.toString());
					
				}
			}
		});
		
		
		JButton btnDelete = new JButton("Izbriši");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DlgStack dlgS = new DlgStack();
				
				if(!list.isSelectionEmpty()) {
					
					
					String[] split = list.getSelectedValue().toString().split(" ");
					
					dlgS.getTxtX().setText(split[2].replaceAll("\\D+", ""));

					dlgS.getTxtY().setText(split[3].replaceAll("\\D+", ""));

					dlgS.getTxtWidth().setText(split[5].replaceAll("\\D+", ""));

					dlgS.getTxtHeight().setText(split[7].replaceAll("\\D+", ""));

					dlgS.setVisible(true);
					
						if(dlgS.isOk) {
							
						dlm.removeElement(list.getSelectedValue());
						
						}
				
				}else {
					JOptionPane.showMessageDialog(null, "Niste selektovali nijedan Pravougaonik!");
				}
			}
		});
		
	
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(85, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 371, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addComponent(btnAdd)
							.addGap(18)
							.addComponent(btnDelete))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		list.setModel(dlm);
	}
}
