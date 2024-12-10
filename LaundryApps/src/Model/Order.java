package Model;

public class Order {
	String id, nama, tanggal, tanggalPengembalian, status, 
		pembayaran, statusPembayaran, total;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTanggal() {
		return tanggal;
	}

	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}

	public String getTanggalPengembalian() {
		return tanggalPengembalian;
	}

	public void setTanggalPengembalian(String tanggalPengembalian) {
		this.tanggalPengembalian = tanggalPengembalian;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPembayaran() {
		return pembayaran;
	}

	public void setPembayaran(String pembayaran) {
		this.pembayaran = pembayaran;
	}

	public String getStatusPembayaran() {
		return statusPembayaran;
	}

	public void setStatusPembayaran(String statusPembayaran) {
		this.statusPembayaran = statusPembayaran;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	
	
	
}
