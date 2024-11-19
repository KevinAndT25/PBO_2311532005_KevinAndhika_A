package pekan1;

class Bus extends Kendaraan implements TransportasiUmum {
//    private String kelasBus;

    public Bus(String merk, String model, int tahunProduksi, String kelasBus) {
        super(merk, model, tahunProduksi);
//        this.kelasBus = kelasBus;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Nyalakan Mesin: Putar kunci untuk menyalakan");
    }

    @Override
    public String jenisBahanBakar() {
        return "Solar";
    }

    @Override
    public int kapasitasPenumpang() {
        return 50;  
    }

    public void fiturBus() {
        System.out.println("Fitur Bus: Dilengkapi kursi nyaman dan fasilitas hiburan");
    }
    
    public class JadwalPerjalanan {
        private String rute;
        private String waktuBerangkat;

        public JadwalPerjalanan(String rute, String waktuBerangkat) {
            this.rute = rute;
            this.waktuBerangkat = waktuBerangkat;
        }

        public void tampilkanJadwal() {
            System.out.println("Rute: " + rute + ", Waktu Berangkat: " + waktuBerangkat);
        }
	}
    
    public void tampilkanInfoLengkap() {
        tampilkanInfo(); 
        nyalakanMesin();
        System.out.println("Jenis Bahan Bakar: " + jenisBahanBakar());
        infoKonsumsi(); 
        System.out.println("Kapasitas Penumpang: " + kapasitasPenumpang()+ " penumpang");
        fiturBus();
//        System.out.println("Kelas Bus: " + kelasBus);
    }
}
