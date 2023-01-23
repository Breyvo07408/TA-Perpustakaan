package main;

import model.AdminModel;
import view.AdminView;

public class Main {
    public static void main(String[] args) {
        AdminView admin = new AdminView();
        AdminModel.initialData();
        admin.setVisible(true);
    }
}
