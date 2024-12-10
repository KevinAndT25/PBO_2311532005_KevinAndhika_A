package table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Model.Order;

public class TableOrder extends AbstractTableModel{
	List<Order> ls;
	
	private String[] columnNames = {"ID", "Nama", "Tanggal", "Tgl Kembali", 
			"Status", "Jenis Bayar", "Status Bayar", "Total"};
	
	public TableOrder(List<Order> ls) {
		this.ls = ls;
	}
	
	public int getRowCount() {
		return ls.size();
	}
	
	public int getColumnCount() {
		return 8;
	}
	
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return ls.get(rowIndex).getId();
		case 1:
			return ls.get(rowIndex).getNama();
		case 2:
			return ls.get(rowIndex).getTanggal();
		case 3:
			return ls.get(rowIndex).getTanggalPengembalian();
		case 4:
			return ls.get(rowIndex).getStatus();
		case 5:
			return ls.get(rowIndex).getPembayaran();
		case 6:
			return ls.get(rowIndex).getStatusPembayaran();
		case 7:
			return ls.get(rowIndex).getTotal();
		default:
			return null;
		}
	}
}
