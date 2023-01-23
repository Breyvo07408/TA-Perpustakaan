package controller;

import entity.AdminEntity;
import model.AdminModel;
public class AdminController {

    public boolean status(String email, String password){
        AdminEntity objek = AdminModel.login(email, password);
        if(objek!=null){
            return true;
        }
        else{
            return false;
        }
    }
}