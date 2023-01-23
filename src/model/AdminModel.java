package model;
import entity.AdminEntity;
import java.util.ArrayList;

public class AdminModel{
    private static ArrayList <AdminEntity> arrayAdmin = new ArrayList <>();

    public static void initialData(){
        arrayAdmin.add(new AdminEntity("brevo", "1", "sialan"));
        arrayAdmin.add(new AdminEntity("prass", "12", "haris"));
    }

    public static AdminEntity login(String email,String password){
        for(AdminEntity objek : arrayAdmin){
            if(objek.getEmail().equals(email) && objek.getPassword().equals(password)){
                return objek;
            }
        }
        return null;
    }
}
