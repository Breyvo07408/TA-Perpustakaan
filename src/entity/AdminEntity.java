package entity;

public class AdminEntity extends LoginEntity{    
    private String nama;

    public AdminEntity(String email, String password,String nama) {
        super(email, password);
        this.nama = nama;
    }

    public AdminEntity(){
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}