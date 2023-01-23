package entity;

public class BukuEntity{
    private String judul;
    private String pengarang;
    private String penerbit;
    private int tahunTerbit;

    public BukuEntity(String judul, String pengarang, String penerbit, int tahunTerbit) {
        this.judul = judul;
        this.pengarang = pengarang;   
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;     
    }

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return this.pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    public String getPenerbit() {
        return this.penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahunTerbit() {
        return this.tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public BukuEntity() {
    }
}
