package Tugas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Error.ValidationException;
import Model.User;
import service.LoginService;
import util.ValidationUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class temporary extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMasukkan;
	private JTextField tfCek;
	private JTextField tfArray;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temporary frame = new temporary();
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
	public temporary() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMasukkan = new JLabel("Masukkan Data:");
		lblMasukkan.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMasukkan.setBounds(10, 37, 151, 25);
		contentPane.add(lblMasukkan);
		
		tfMasukkan = new JTextField();
		tfMasukkan.setFont(new Font("SansSerif", Font.BOLD, 12));
		tfMasukkan.setColumns(10);
		tfMasukkan.setBounds(10, 61, 314, 33);
		contentPane.add(tfMasukkan);
		
		JButton btnLogin = new JButton("Simpan");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfArray.setText(tfMasukkan.getText());
				tfMasukkan.setText("");
			}
		});
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLogin.setBounds(334, 61, 92, 33);
		contentPane.add(btnLogin);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblData.setBounds(10, 104, 77, 25);
		contentPane.add(lblData);
		
		JLabel lblCekArrayKe = new JLabel("Cek Array ke-");
		lblCekArrayKe.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCekArrayKe.setBounds(10, 139, 114, 25);
		contentPane.add(lblCekArrayKe);
		
		tfCek = new JTextField();
		tfCek.setFont(new Font("SansSerif", Font.BOLD, 12));
		tfCek.setColumns(10);
		tfCek.setBounds(129, 136, 195, 33);
		contentPane.add(tfCek);
		
		JButton btnCek = new JButton("Cek");
		btnCek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int Data[] = tfMasukkan.getText();
//				int Array = tfArray.getText();
//				
//				IndexCheck index = new IndexCheck(Data, Array);
//				try {
//					ValidationUtil.validate(user);
//					LoginService loginSer = new LoginService();
//					if(loginSer.authenticate(user)) {
//						System.out.println("Login Successfull!!");
//						JOptionPane.showMessageDialog(null, "Login Successfull!!");
//						new MainFrame().setVisible(true);
//						dispose();
//					}else {
//						System.out.println("Invalid Username or Password");
//						JOptionPane.showMessageDialog(null, "Login Gagal, Invalid Username or Password.");
//					}
//				}catch (ValidationException | NullPointerException exception) {
//					System.out.println("Data Tidak Valid : " + exception.getMessage());
//					JOptionPane.showMessageDialog(null, "Login Gagal: "+ exception.getMessage());
//				}finally {
//					System.out.println("Selalu Dieksekusi");
//				}
			}
		});
		btnCek.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnCek.setBounds(334, 136, 92, 33);
		contentPane.add(btnCek);
		
		tfArray = new JTextField();
		tfArray.setEditable(false);
		tfArray.setFont(new Font("SansSerif", Font.BOLD, 12));
		tfArray.setColumns(10);
		tfArray.setBounds(70, 104, 254, 25);
		contentPane.add(tfArray);
	}
}
