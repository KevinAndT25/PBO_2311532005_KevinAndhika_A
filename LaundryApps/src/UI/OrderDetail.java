package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ServiceRepo;
import Model.Service;
import table.TableService;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderDetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableServices;
	private JTable table_1;
	private JTextField txtOrderID;
	private JTextField txtTanggal;
	private JTextField txtPengambilan;
	private JTextField txtTotalRp;
	private JTextField txtHargaKg;
	private JTextField txtJumlah;
	private JTextField txtTotal2;
	
	ServiceRepo srvr = new ServiceRepo();
	List<Service> ls;
	String id;
	
	public void loadTable() {
		ls = srvr.show();
		TableService ts = new TableService(ls);
		tableServices.setModel(ts);;
		tableServices.getTableHeader().setVisible(true);
	}
	
	private double total(double harga, double qty) {
		return harga * qty;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderDetail frame = new OrderDetail();
					frame.setVisible(true);
					frame.loadTable();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(261, 40, 469, 182);
		contentPane.add(scrollPane);
		
		tableServices = new JTable();
		tableServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtHargaKg.setText(tableServices.getValueAt(tableServices.getSelectedRow(),2).toString());
			}
		});
		tableServices.setToolTipText("");
		tableServices.setFont(new Font("SansSerif", Font.PLAIN, 12));
		tableServices.setFillsViewportHeight(true);
		tableServices.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableServices);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(261, 418, 469, 212);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setToolTipText("");
		table_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		table_1.setFillsViewportHeight(true);
		table_1.setBackground(Color.WHITE);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(261, 232, 469, 176);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHargakg = new JLabel("Harga/Kg");
		lblHargakg.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHargakg.setBounds(10, 10, 92, 25);
		panel.add(lblHargakg);
		
		txtHargaKg = new JTextField();
		txtHargaKg.setEditable(false);
		txtHargaKg.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtHargaKg.setColumns(10);
		txtHargaKg.setBounds(10, 33, 199, 25);
		panel.add(txtHargaKg);
		
		JLabel lblJumlah = new JLabel("Jumlah");
		lblJumlah.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblJumlah.setBounds(10, 68, 168, 25);
		panel.add(lblJumlah);
		
		txtJumlah = new JTextField();
		txtJumlah.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtJumlah.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Jumlah harus berisi");
					txtTotal2.setText("");
				}else {
					txtTotal2.setText(""+total(Double.parseDouble(txtHargaKg.getText()), Double.parseDouble(txtJumlah.getText())));
					
				}
			}
				
		});
		txtJumlah.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtJumlah.setColumns(10);
		txtJumlah.setBounds(10, 91, 199, 25);
		panel.add(txtJumlah);
		
		JLabel lblTotal2 = new JLabel("Total");
		lblTotal2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTotal2.setBounds(249, 68, 168, 25);
		panel.add(lblTotal2);
		
		txtTotal2 = new JTextField();
		txtTotal2.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtTotal2.setColumns(10);
		txtTotal2.setBounds(249, 91, 199, 25);
		panel.add(txtTotal2);
		
		JButton btnSimpan2 = new JButton("Simpan");
		btnSimpan2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSimpan2.setBounds(16, 141, 92, 25);
		panel.add(btnSimpan2);
		
		JButton btnUbah2 = new JButton("Ubah");
		btnUbah2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnUbah2.setBounds(117, 141, 92, 25);
		panel.add(btnUbah2);
		
		JButton btnHapus2 = new JButton("Hapus");
		btnHapus2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnHapus2.setBounds(218, 141, 92, 25);
		panel.add(btnHapus2);
		
		JButton btnBatal2 = new JButton("Batal");
		btnBatal2.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBatal2.setBounds(320, 141, 92, 25);
		panel.add(btnBatal2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 241, 620);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblOrderID = new JLabel("Order ID");
		lblOrderID.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblOrderID.setBounds(10, 31, 92, 25);
		panel_1.add(lblOrderID);
		
		txtOrderID = new JTextField();
		txtOrderID.setText("TRX-00001");
		txtOrderID.setEditable(false);
		txtOrderID.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtOrderID.setColumns(10);
		txtOrderID.setBounds(10, 54, 221, 25);
		panel_1.add(txtOrderID);
		
		JLabel lblPelanggan = new JLabel("Pelanggan");
		lblPelanggan.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPelanggan.setBounds(10, 89, 92, 25);
		panel_1.add(lblPelanggan);
		
		JLabel lblTanggal = new JLabel("Tanggal");
		lblTanggal.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTanggal.setBounds(10, 170, 92, 25);
		panel_1.add(lblTanggal);
		
		txtTanggal = new JTextField();
		txtTanggal.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtTanggal.setColumns(10);
		txtTanggal.setBounds(10, 193, 221, 25);
		panel_1.add(txtTanggal);
		
		JLabel lblPengambilan = new JLabel("Tanggal Pengambilan");
		lblPengambilan.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPengambilan.setBounds(10, 228, 168, 25);
		panel_1.add(lblPengambilan);
		
		txtPengambilan = new JTextField();
		txtPengambilan.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtPengambilan.setColumns(10);
		txtPengambilan.setBounds(10, 251, 221, 25);
		panel_1.add(txtPengambilan);
		
		JComboBox cbPelanggan = new JComboBox();
		cbPelanggan.setModel(new DefaultComboBoxModel(new String[] {"Pilih"}));
		cbPelanggan.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbPelanggan.setBounds(10, 113, 221, 24);
		panel_1.add(cbPelanggan);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblStatus.setBounds(10, 286, 92, 25);
		panel_1.add(lblStatus);
		
		JComboBox cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] {"Proses", "Selesai"}));
		cbStatus.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbStatus.setBounds(10, 310, 221, 24);
		panel_1.add(cbStatus);
		
		JLabel lblPembayaran = new JLabel("Pembayaran");
		lblPembayaran.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPembayaran.setBounds(10, 426, 92, 25);
		panel_1.add(lblPembayaran);
		
		JComboBox cbPembayaran = new JComboBox();
		cbPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Credit"}));
		cbPembayaran.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbPembayaran.setBounds(10, 450, 221, 24);
		panel_1.add(cbPembayaran);
		
		JLabel lblSPembayaran = new JLabel("Status Pembayaran");
		lblSPembayaran.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSPembayaran.setBounds(10, 484, 168, 25);
		panel_1.add(lblSPembayaran);
		
		JComboBox cbSPembayaran = new JComboBox();
		cbSPembayaran.setModel(new DefaultComboBoxModel(new String[] {"Lunas", "Belum Dibayar"}));
		cbSPembayaran.setFont(new Font("SansSerif", Font.BOLD, 12));
		cbSPembayaran.setBounds(10, 508, 221, 24);
		panel_1.add(cbSPembayaran);
		
		txtTotalRp = new JTextField();
		txtTotalRp.setEditable(false);
		txtTotalRp.setText("Rp. 10.000");
		txtTotalRp.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtTotalRp.setColumns(10);
		txtTotalRp.setBounds(10, 391, 221, 25);
		panel_1.add(txtTotalRp);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTotal.setBounds(10, 368, 92, 25);
		panel_1.add(lblTotal);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSimpan.setBounds(24, 585, 92, 25);
		panel_1.add(btnSimpan);
		
		JButton btnBatal = new JButton("Batal");
		btnBatal.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnBatal.setBounds(125, 585, 92, 25);
		panel_1.add(btnBatal);
		
		JLabel lblServiceList = new JLabel("Service List");
		lblServiceList.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblServiceList.setBounds(261, 10, 119, 25);
		contentPane.add(lblServiceList);
	}
}
