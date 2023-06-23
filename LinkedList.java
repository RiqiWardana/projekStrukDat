import java.util.Scanner;

class LinkedList {
    private Node front;
    private Node rear;
    private int count;
    private String[] barangArray;

    public LinkedList() {
        this.front = null;
        this.rear = null;
        this.count = 0;
        this.barangArray = new String[100];

    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void PenambahanBarang(Barang barang) {
        Node newNode = new Node(barang.nama);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
        System.out.println("Barang " + barang.nama + " (jumlah: " + barang.jumlah + ") telah ditambahkan ke dalam gudang.");
    }

    public Object PengambilanBarang() {
        if (isEmpty()) {
            System.out.println("Antrian Kosong!");
            return null;
        }
        Object temp = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        count--;
        System.out.println("Barang " + temp + " telah diambil dari gudang.");
        for (int i = 0; i < barangArray.length; i++) {
            if (barangArray == null) {
                barangArray[i] = (String) temp;
            }
        }
        return temp;
    }

    public void TampilkanDataBarang() {
        if (isEmpty()) {
            System.out.println("Tidak ada Barang di gudang");
            return;
        }
        System.out.println("Data Barang dalam Gudang:");
        Node current = front;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.data);
            current = current.next;
            index++;
        }
    }

    public void TampilkanDataBarangArray() {
        System.out.println("Data Barang yang telah diambil:");
        for (int i = 0; i >= barangArray.length; i++) {
            System.out.println((i + 1) + ". " + barangArray[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList data = new LinkedList();

        int choice = 0;
        while (true) {
            System.out.println("\n=====================================");
            System.out.println("              MENU GUDANG             ");
            System.out.println("=====================================");
            System.out.println("1. Masukkan Nama Barang");
            System.out.println("2. Kirim Barang");
            System.out.println("3. Tampilkan Data Barang");
            System.out.println("4. Tampilkan Data Barang yang Telah Diambil");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan Anda: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan Nama Barang: ");
                    String namaBarang = input.nextLine();
                    System.out.print("Masukkan Jumlah Barang: ");
                    int jumlahBarang = input.nextInt();
                    input.nextLine(); // Membersihkan newline dari buffer
                    Barang barang = new Barang(namaBarang, jumlahBarang);
                    data.PenambahanBarang(barang);
                    break;

                case 2:
                    Object elemen = data.PengambilanBarang();
                    if (elemen != null) {
                        System.out.print("Masukkan Alamat Pengiriman: ");
                        String alamat = input.nextLine();
                        System.out.println("Barang Yang Harus Dikirim: " + elemen + " Ke Alamat " + alamat);
                    }
                    break;

                case 3:
                    data.TampilkanDataBarang();
                    break;

                case 4:
                    data.TampilkanDataBarangArray();
                    break;

                case 5:
                    System.out.println("Terima Kasih");
                    System.exit(0); // Menghentikan program

                default:
                    System.out.println("Inputan Anda Salah!");
            }
        }
    }
}
