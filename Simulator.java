import javax.swing.*;

public class Simulator {
    public static void main(String[] args) {
        String noFaktur = null, kodeBarang = null, namaBarang = null;
        double hargaBarang = 0;
        int jumlahBeli = 0;

        // Input No Faktur
        while (true) {
            try {
                noFaktur = JOptionPane.showInputDialog(null, "Masukkan No Faktur:");
                if (noFaktur == null || noFaktur.isEmpty()) {
                    throw new Exception("No Faktur tidak boleh kosong!");
                }
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Input Kode Barang
        while (true) {
            try {
                kodeBarang = JOptionPane.showInputDialog(null, "Masukkan Kode Barang:");
                if (kodeBarang == null || kodeBarang.isEmpty()) {
                    throw new Exception("Kode Barang tidak boleh kosong!");
                }
                break; 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Input Nama Barang
        while (true) {
            try {
                namaBarang = JOptionPane.showInputDialog(null, "Masukkan Nama Barang:");
                if (namaBarang == null || namaBarang.isEmpty()) {
                    throw new Exception("Nama Barang tidak boleh kosong!");
                }
                break; 
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Input Harga Barang
        while (true) {
            try {
                String hargaInput = JOptionPane.showInputDialog(null, "Masukkan Harga Barang:");
                hargaBarang = Double.parseDouble(hargaInput); // Parse ke double
                if (hargaBarang < 0) {
                    throw new Exception("Harga Barang tidak boleh negatif!");
                }
                break; 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Harga Barang harus berupa angka!", "Exception", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Input Jumlah Beli
        while (true) {
            try {
                String jumlahInput = JOptionPane.showInputDialog(null, "Masukkan Jumlah Beli:");
                jumlahBeli = Integer.parseInt(jumlahInput);
                if (jumlahBeli < 0) {
                    throw new Exception("Jumlah Beli tidak boleh negatif!");
                }
                break; 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Jumlah Beli harus berupa angka!", "Exception", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Objek Transaksi
        Transaksi transaksi = new Transaksi(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

        // Tampilan hasil transaksi
        JOptionPane.showMessageDialog(null,
                "=== Data Transaksi ===\n" +
                        "No Faktur     : " + transaksi.getNoFaktur() + "\n" +
                        "Kode Barang   : " + transaksi.getKodeBarang() + "\n" +
                        "Nama Barang   : " + transaksi.getNamaBarang() + "\n" +
                        "Harga Barang  : " + transaksi.getHargaBarang() + "\n" +
                        "Jumlah Beli   : " + transaksi.getJumlahBeli() + "\n" +
                        "Total         : " + transaksi.calculateTotal(),
                "Hasil Transaksi", JOptionPane.INFORMATION_MESSAGE);
    }
}
