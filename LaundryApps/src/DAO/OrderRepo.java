package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Order;
import config.Database;

public class OrderRepo implements OrderDAO{
	private Connection connection;
	final String insert = "INSERT INTO `order` (id, name, tanggal, tanggal_pengembalian, "
			+ "status, pembayaran, status_pembayaran, total) VALUES (?,?,?,?,?,?,?,?);";
	final String select = "SELECT * FROM `order`;";
	final String delete = "DELETE FROM `order` WHERE id=?;";
	final String update = "UPDATE `order` SET name=?, tanggal=?, tanggal_pengembalian=?, "
			+ "status=?, pembayaran=?, status_pembayaran=?, total=? WHERE id=?;";
	
	public OrderRepo() {
		connection = Database.koneksi();
	}
	
	@Override
	public void save(Order ord) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(insert);
			st.setString(1, ord.getId());
			st.setString(2, ord.getNama());
			st.setString(3, ord.getTanggal());
			st.setString(4, ord.getTanggalPengembalian());
			st.setString(5, ord.getStatus());
			st.setString(6, ord.getPembayaran());
			st.setString(7, ord.getStatusPembayaran());
			st.setString(8, ord.getTotal());
			st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public List<Order> show(){
		List<Order> order = new ArrayList<>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) {
				Order ord = new Order();
				ord.setId(rs.getString("id"));
				ord.setNama(rs.getString("name"));
				ord.setTanggal(rs.getString("tanggal"));
				ord.setTanggalPengembalian(rs.getString("tanggal_pengembalian"));
				ord.setStatus(rs.getString("status"));
				ord.setPembayaran(rs.getString("pembayaran"));
				ord.setStatusPembayaran(rs.getString("status_pembayaran"));
				ord.setTotal(rs.getString("total"));
				order.add(ord);
			}
		}catch(SQLException e) {
			Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return order;
	}
	@Override
	public void update(Order ord) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(update);
			st.setString(1, ord.getNama());
			st.setString(2, ord.getTanggal());
			st.setString(3, ord.getTanggalPengembalian());
			st.setString(4, ord.getStatus());
			st.setString(5, ord.getPembayaran());
			st.setString(6, ord.getStatusPembayaran());
			st.setString(7, ord.getTotal());
			st.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void delete(String id) {
		PreparedStatement st = null;
		try {
			st = connection.prepareStatement(delete);
					st.setString(1,id);
			st.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
