package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.BukuController;
import entity.BukuEntity;
import java.util.ArrayList;

public class DataBukuView extends Frame{
    private JLabel juduLabel,pengarangLabel,penerbitLabel,tahunTerbitLabel,cariLabel;
    private JTextField juduField,pengarangField,penerbitField,tahunTerbitField,cariField;
    private BukuController buku = new BukuController();
    private JTable bukuTabel;
    private JScrollPane scrollPane;

    private JButton insertBtn,hapusBtn;

    public DataBukuView() {
        super("LOGIN", 1300, 793);
    }

    @Override
    protected void component() {
        juduLabel = new JLabel("JUDUL");
        setFontSize(juduLabel, 14);
        setFontStyle(juduLabel, Font.BOLD);
        boundedAdd(juduLabel, 156, 48, 201, 20);

        juduField = new JTextField();
        boundedAdd(juduField, 65, 68, 223, 37);

        pengarangLabel = new JLabel("PENGARANG");
        setFontSize(pengarangLabel, 14);
        setFontStyle(pengarangLabel, Font.BOLD);
        boundedAdd(pengarangLabel, 136, 132, 201, 20);

        pengarangField = new JTextField();
        boundedAdd(pengarangField, 65, 152, 223, 37);

        penerbitLabel = new JLabel("PENERBIT");
        setFontSize(penerbitLabel, 14);
        setFontStyle(penerbitLabel, Font.BOLD);
        boundedAdd(penerbitLabel, 145, 216, 201, 20);

        penerbitField = new JTextField();
        boundedAdd(penerbitField, 65, 236, 223, 37);

        tahunTerbitLabel = new JLabel("TAHUN TERBIT");
        setFontSize(tahunTerbitLabel, 14);
        setFontStyle(tahunTerbitLabel, Font.BOLD);
        boundedAdd(tahunTerbitLabel, 123, 300, 201, 20);

        tahunTerbitField = new JTextField();
        boundedAdd(tahunTerbitField, 65, 320, 223, 37);

        cariLabel = new JLabel("CARI HAPUS");
        setFontSize(cariLabel, 14);
        setFontStyle(cariLabel, Font.BOLD);
        boundedAdd(cariLabel, 514, 48, 201, 20);

        cariField = new JTextField();
        boundedAdd(cariField, 444, 68, 223, 37);

        bukuTabel = new JTable();
        bukuTabel.setModel(createDataTable());
        scrollPane = new JScrollPane(bukuTabel);
        boundedAdd(scrollPane, 444, 152, 745, 440);

        insertBtn = new JButton("TAMBAH BUKU");
        insertBtn.setBackground(color("#00D4FF"));
        insertBtn.setForeground(color("#FFFFFF"));
        insertBtn.setFocusPainted(false);
        setFontSize(insertBtn, 10);
        boundedAdd(insertBtn, 120, 400, 100, 50);

        hapusBtn = new JButton("HAPUS");
        hapusBtn.setBackground(color("#00D4FF"));
        hapusBtn.setForeground(color("#FFFFFF"));
        hapusBtn.setFocusPainted(false);
        boundedAdd(hapusBtn, 735, 68, 75, 37);
    }

    @Override
    protected void event() {
        insertBtn.addActionListener((e) -> {
            try {
                String judul = juduField.getText();
                String pengarang = pengarangField.getText();
                String penerbit = penerbitField.getText();
                int tahun = Integer.parseInt(tahunTerbitField.getText());
                buku.insert(judul, pengarang, penerbit, tahun);
                JOptionPane.showMessageDialog(null,
                            "Berhasil Ditambah",
                            "BERHASIL",
                            JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                            new DataBukuView().setVisible(true); 
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null,
                "Gagal Ditambah",
                "GAGAL",
                JOptionPane.ERROR_MESSAGE);
            }   
        });

        hapusBtn.addActionListener((e) -> {
            try {
                String judul = cariField.getText();
                BukuEntity objekBuku = buku.cari(judul);
                if(objekBuku!=null){
                    buku.hapus(objekBuku);
                    JOptionPane.showMessageDialog(null,
                        "Berhasil DiHapus",
                        "BERHASIL",
                        JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        new DataBukuView().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,
                        "Tidak Ada Data",
                        "GAGAL",
                        JOptionPane.ERROR_MESSAGE);
                        dispose();
                        new DataBukuView().setVisible(true);
                }
                
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null,
                "Gagal Ditambah",
                "GAGAL",
                JOptionPane.ERROR_MESSAGE);
            }   
        });
    }

    private DefaultTableModel createDataTable() {
        DefaultTableModel dataTable = new DefaultTableModel();

        Object column[] = {
            "Judul Buku","Pengarang","Penerbit","Tahun Terbit"};
        dataTable.setColumnIdentifiers(column);

        ArrayList<BukuEntity> bukuList = buku.all();

        for (BukuEntity buku : bukuList) {

            Object[] data = new String[] {
                    buku.getJudul(),
                    buku.getPengarang(),
                    buku.getPenerbit(),
                    String.valueOf(buku.getTahunTerbit())
            };

            dataTable.addRow(data);
        }
        return dataTable;
    }
}
