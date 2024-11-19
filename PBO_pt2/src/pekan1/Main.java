package pekan1;

public class Main {

	public static void main(String[] args) {
    	Mobil m = new Mobil("Toyota", "Avanza", 2021, "Matic" );
    	m.tampilkanInfoLengkap();
    	
    	System.out.println();
    	
    	Bus b = new Bus("Mercedes-Benz", "Bus Pariwisata", 2018, "A");
        Bus.JadwalPerjalanan bj = b.new JadwalPerjalanan("Jakarta - Bandung", "08:00");
    	b.tampilkanInfoLengkap();
		System.out.print("Jadwal Perjalanan: ");
		bj.tampilkanJadwal();
    }

}
