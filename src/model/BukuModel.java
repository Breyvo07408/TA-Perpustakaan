package model;
import entity.BukuEntity;
import java.util.ArrayList;

public class BukuModel extends AdminModel{
    private static ArrayList<BukuEntity> arrayBuku = new ArrayList<>();
    
    public static ArrayList<BukuEntity> all(){
        return arrayBuku;
    }


    public static void insert(BukuEntity buku){
        arrayBuku.add(buku);
    }

    public int indexData(BukuEntity datacari){
        return arrayBuku.indexOf(datacari);
    }
    
    public static BukuEntity carijudulBuku(String judul){
        for (BukuEntity databuku : arrayBuku){
            if(databuku.getJudul().equals(judul)){
                return databuku;
            }
        }
        return null;
    }   

    public BukuModel() {
        
    }
}
