package Controller;

import DAO.DAO_Suplier;
import DAO.Model_DAO;
import Model.Suplier;
import View.MSuplier;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controller_Suplier {

    MSuplier form;
    Model_DAO<Suplier> model;
    List<Suplier> list; //deklarasi method "List" yang sudah dibuat pada interface MODEL_DAO
    String[] header; //deklarasi variable untuk membuat judul kolom pada objek JTable
    
    //konstruktor
    public Controller_Suplier(MSuplier form){
        this.form = form;
        model = new DAO_Suplier();
        list = model.getAll();
        header = new String[]{"KODE", "NAMA SUPLIER", "ALAMAT", "TELEPON"};
        
        form.getTblsuplier().setShowGrid(true);
        form.getTblsuplier().setShowVerticalLines(true);
        form.getTblsuplier().setGridColor(Color.blue);        
    }
    
   //method untuk menampilkan kode pelanggan berikutnya
    public void tampilurutankode(){            
            Suplier p = new Suplier();      
            model.autonumber(p); 
            form.getTxtkdsuplier().setText(String.valueOf(model.autonumber(p)));          
   }
   
    //method untuk membersihkan objek inputan yang ada pada Form   
    public void reset(){
        form.getTxtkdsuplier().setText("");
        form.getTxtnmsuplier().setText("");
        form.getTxtalamat().setText("");
        form.getTxttelp().setText("");     
        form.getTxtnmsuplier().requestFocus();
        tampilurutankode();    
        isiTable();
        
    }
     
    //method untuk menampilkan semua data kedalam JTabel
    public void isiTable(){
        list = model.getAll();
        
         //Script agar jtable tidak bisa di edit
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean isCellEditable(int rowIndex, int columnIndex) { 
                return false;
             }
        };
        
        Object[] data = new Object[header.length];
        for (Suplier p : list) {
            data[0] = p.getKode();
            data[1] = p.getNama();
            data[2] = p.getAlamat();
            data[3] = p.getTelpon();
            tblModel.addRow(data);
        }
        form.getTblsuplier().setModel(tblModel);       
    }
  
  //method untuk meletakkan data ke dalam text berdasatkan data yang dipilih dari JTabel 
  public void isiField(int row){
        form.getTxtkdsuplier().setText(String.valueOf(list.get(row).getKode()));
        form.getTxtnmsuplier().setText(list.get(row).getNama());
        form.getTxtalamat().setText(list.get(row).getAlamat());
        form.getTxttelp().setText(list.get(row).getTelpon());
    }
   
  
  //method untuk simpan data
  public void insert(){
        Suplier p = new Suplier();
        p.setKode(Integer.parseInt(form.getTxtkdsuplier().getText()));
        p.setNama(form.getTxtnmsuplier().getText());
        p.setAlamat(form.getTxtalamat().getText());
        p.setTelpon(form.getTxttelp().getText());
        
        model.insert(p);
    }
  
  //method untuk mengubah data
   public void update(){
        Suplier p = new Suplier();
        p.setKode(Integer.parseInt(form.getTxtkdsuplier().getText()));
        p.setNama(form.getTxtnmsuplier().getText());
        p.setAlamat(form.getTxtalamat().getText());
        p.setTelpon(form.getTxttelp().getText());
        
        model.update(p);
    }
   
   //method untuk menghapus data
    public void delete(){
        if(!form.getTxtkdsuplier().getText().trim().isEmpty()){
            int kode =Integer.parseInt(form.getTxtkdsuplier().getText());
            model.delete(kode);
        }else{
            JOptionPane.showMessageDialog(form, "Pilih data yang akan dihapus");
        }
    }
        
    //method ini akan dipakai untuk memfilter data berdasarkan inputan yg ada pada text kode pelanggan
    public void isiTableCari(){
        list = model.getCari(form.getTxtkdsuplier().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        for (Suplier p : list) {
            data[0] = p.getKode();
            data[1] = p.getNama();
            data[2] = p.getAlamat();
            data[3] = p.getTelpon();
            tblModel.addRow(data);//menampilkan ke JTable 
            
            form.getTxtnmsuplier().setText(p.getNama());   //menampilkan ke text
            form.getTxtalamat().setText(p.getAlamat());   //menampilkan ke text
            form.getTxttelp().setText(p.getTelpon());   //menampilkan ke text         
        }
        form.getTblsuplier().setModel(tblModel);
    }

}