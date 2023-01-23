package controller;

import entity.BukuEntity;
import model.BukuModel;
import java.util.ArrayList;

public class BukuController {
    public static BukuModel bukumodel = new BukuModel();
    
    public ArrayList<BukuEntity> all(){
        return BukuModel.all();
    }

    public void insert(String judul,String pengarang,String penerbit,int tahunTerbit){
        BukuEntity objekBuku = new BukuEntity(judul, pengarang, penerbit, tahunTerbit);
        BukuModel.insert(objekBuku);
    }

    public void hapus(BukuEntity buku){
        ArrayList<BukuEntity> arrayBuku = BukuModel.all();
        arrayBuku.remove(buku);
    }

    public BukuEntity cari(String judul){
        ArrayList<BukuEntity> arrayBuku = BukuModel.all();
        for (BukuEntity databuku : arrayBuku){
            if(databuku.getJudul().equals(judul)){
                return databuku;
            }
        }
        return null;
    }
}
