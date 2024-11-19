package pekan1;

public final class Mobil extends Kendaraan implements BahanBakar{
//    private String jenisTransmisi;

    public Mobil(String merk, String model, int tahunProduksi, String jenisTransmisi) {
        super(merk, model, tahunProduksi);
//        this.jenisTransmisi = jenisTransmisi;
    }

    @Override
    public void nyalakanMesin() {
        System.out.println("Nyalakan Mesin: Tekan tombol start");
    }

    @Override
    public String jenisBahanBakar() {
        return "Bensin";
    }

    public void fiturMobil() {
        System.out.println("Fitur Mobil: Memiliki AC dan audio premium");
    }

    public void tampilkanInfoLengkap() {
        tampilkanInfo();
        nyalakanMesin();
        System.out.println("Jenis Bahan Bakar: " + jenisBahanBakar());
        infoKonsumsi();  
        fiturMobil();
//        System.out.println("Jenis Transmisi: " + jenisTransmisi);
    }

}
