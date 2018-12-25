package Controller;

import DAO.DAO_BuktiPesan;
import Model.BuktiPesan;
import View.TBuktiPesan;
import java.awt.Color;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

public class Controller_BuktiPesan {

    TBuktiPesan form;
    DAO_BuktiPesan model;
      
    String[] header = new String[]{"KODE KATEGORI", "NAMA KATEGORI", "KODE BARANG", "NAMA BARANG", "HARGA", "QTY", "TOTAL"}; //deklarasi variable untuk membuat judul kolom pada objek JTable
    DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
       
    @Override
    //Supaya grid JTable tidak dapat diedit
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    };

    //konstruktor    
    public Controller_BuktiPesan(TBuktiPesan form) {
        this.form = form;
        model = new DAO_BuktiPesan();
        form.getTbldetil().setModel(tblModel);
        form.getTbldetil().setShowGrid(true);
        form.getTbldetil().setShowVerticalLines(true);
        form.getTbldetil().setGridColor(Color.blue);
    }

    //method untuk memanggil autonumber pada DAO_BuktiPesan
    //fungsinya untuk menampilkan urutan kode barang berikutnya
    public void tampilurutankode() {
        form.getTxtnobp().setText(model.autonumber2());
    }

    //method rest, reset2 dan reset3 untuk membersihkan objek inputan yang ada pada Form   
    public void reset() {
        SimpleDateFormat tgl = new SimpleDateFormat("yyyy-MM-dd");
        form.getTxttglbp().setText(String.valueOf(tgl.format(new Date())));
 
        form.getTxttotal().setText("Rp. 0");
        form.getCmbkategori().setSelectedIndex(0);
        form.getCmbbarang().setSelectedIndex(0);
        form.getTxtkdbrg().setText("");
        form.getTxtkdkategori().setText("");
        form.getTxtharga().setText("");
        form.getTxtqty().setText("");
        form.getTxtstok().setText("");

        tampilurutankode();
        isicombokategori();
        tblModel.setRowCount(0);
        form.getTxtnobp().setEditable(false);   
        form.getTxttglbp().setEditable(false);   
        form.getTxtstok().setEditable(false);   
    }

    public void reset2() {
        form.getTxtharga().setText("");
        form.getTxtqty().setText("");
        form.getTxtstok().setText("");        
        form.getTxtkdbrg().requestFocus();
        form.getTxtstok().setEditable(false);   
    }
    
    public void reset3() {
        form.getCmbkategori().setSelectedIndex(0);
        form.getCmbbarang().setSelectedIndex(0);        
        form.getTxtkdbrg().setText("");
        form.getTxtkdkategori().setText("");
        form.getTxtharga().setText("");
        form.getTxtqty().setText("");
        form.getTxtstok().setText("");
        form.getTxtkdkategori().requestFocus();
        form.getTxtstok().setEditable(false);   
    }
   
    //method untuk menghapus baris data pada JTable
    public void resetrow() {
     int[] selectedRows = form.getTbldetil().getSelectedRows();
        if (selectedRows.length > 0) {
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                tblModel.removeRow(selectedRows[i]);
            }
        }
        form.getTxtkdbrg().requestFocus();
    }
    

    //method untuk menambahkan data kedalam JTabel 
    public void isiTable() {
        int jmlbaris = tblModel.getRowCount();
        int i,datasama = 0;
        int stok=1;
        
        //cek inputan qty/jumlah beli        
        if((form.getTxtqty().getText().isEmpty()==true) ||
            (Integer.parseInt(form.getTxtqty().getText()) > Integer.parseInt(form.getTxtstok().getText()))){
            
            JOptionPane.showMessageDialog(null, "Quantity/Jumlah tidak boleh kosong atau melebihi stok yang tersedia! ");               
            stok=0;
        }
        
        if (!form.getTxtkdkategori().getText().isEmpty() && stok>0) {
            if (jmlbaris == 0) {
                //jika posisi jtable belum ada isi sama sekali                
                    tblModel.addRow(new Object[]{
                    form.getTxtkdkategori().getText(),
                    form.getCmbkategori().getSelectedItem().toString(),
                    form.getTxtkdbrg().getText(),
                    form.getCmbbarang().getSelectedItem().toString(),
                    form.getTxtharga().getText(),
                    form.getTxtqty().getText(),
                    (Integer.parseInt(form.getTxtharga().getText())*Integer.parseInt(form.getTxtqty().getText()))                    
                });
            } else {
                //jika sudah ada didalam Jtable, maka cek validasi
                //tidak boleh add kode barang yang sama 
                for (i = 0; i < jmlbaris; i++) {
                    if (form.getTxtkdbrg().getText().equals(tblModel.getValueAt(i, 2).toString())) {
                        datasama = 1;
                        JOptionPane.showMessageDialog(null, "Kode barang  " + tblModel.getValueAt(i, 2).toString() + "  sudah pernah ada, dan akan diupdate dengan data terbaru.");                           
                        
                        tblModel.setValueAt(form.getTxtkdkategori().getText(), i, 0);
                        tblModel.setValueAt(form.getCmbkategori().getSelectedItem().toString(), i, 1);
                        tblModel.setValueAt(form.getTxtkdbrg().getText(), i, 2);
                        tblModel.setValueAt(form.getCmbbarang().getSelectedItem().toString(), i, 3);
                        tblModel.setValueAt(form.getTxtharga().getText(), i, 4);
                        tblModel.setValueAt(form.getTxtqty().getText(), i, 5);
                        tblModel.setValueAt((Integer.parseInt(form.getTxtharga().getText())*Integer.parseInt(form.getTxtqty().getText())), i, 6);
                        break;
                    } else {
                        datasama = 0;
                    }
                }

                //jika kode barang belum pernah ada didalam list, maka add data ke dalam jtable
                if (datasama == 0) {
                    tblModel.addRow(new Object[]{
                        form.getTxtkdkategori().getText(),
                        form.getCmbkategori().getSelectedItem().toString(),
                        form.getTxtkdbrg().getText(),
                        form.getCmbbarang().getSelectedItem().toString(),
                        form.getTxtharga().getText(),
                        form.getTxtqty().getText(),
                        (Integer.parseInt(form.getTxtharga().getText())*Integer.parseInt(form.getTxtqty().getText()))                    
                });                    
                }                 
            }
        }
    }

    //method untuk menghitung keseluruhan total belanja
    public void hitung_grandtotal(){
        int jmlbaris = tblModel.getRowCount();
        int total=0;
        int Amount = 0;   
        DecimalFormat konversi=new DecimalFormat("###,###,###.00");
        for(int i = 0; i < tblModel.getRowCount(); i++){       
            Amount = Integer.parseInt(String.valueOf(tblModel.getValueAt(i,6).toString()));        
            total = Amount+total;     
        }

        //jmlbaris!= 0 >> jika jtabel berisi data
        if (jmlbaris!= 0){
            form.getTxttotal().setText("Rp. "+ konversi.format(Integer.parseInt(String.valueOf(total))));
        }else{
            form.getTxttotal().setText("Rp. 0");
        }
    }
    
    //method untuk meletakkan data ke dalam text berdasatkan data yang dipilih dari JTabel  
    public void isiField(int row) {     
          form.getTxtkdkategori().setText(String.valueOf(tblModel.getValueAt(row,0)));
          form.getCmbkategori().setSelectedItem(tblModel.getValueAt(row, 1).toString());  
          form.getTxtkdbrg().setText(tblModel.getValueAt(row, 2).toString());
          form.getCmbbarang().setSelectedItem(tblModel.getValueAt(row, 3).toString());
          form.getTxtharga().setText(String.valueOf(tblModel.getValueAt(row,4)));
          form.getTxtqty().setText(String.valueOf(tblModel.getValueAt(row,5)));
    }

    //===========================combo kategori============================== 
    //memanggil method isicombokateogori pada DAO_BuktiPesan  
    //method ini akan digunakan untuk mengisikan data kedalam combo kode kategori
    public void isicombokategori() {
        form.getCmbkategori().removeAllItems();
        form.getCmbkategori().addItem("-Pilih-");
        for (BuktiPesan b : model.isicombokateogori()) {
            form.getCmbkategori().addItem(b.getNamakategori());
        }
    }

    //memanggil method getkdkategori pada DAO_BuktiPesan    
    //method ini akan digunakan untuk menampilkan kode kategori berdasarkan inputan combo nama kategori
    public void tampilkdkategori() {
        if (form.getCmbkategori().getSelectedIndex() != 0) {
            for (BuktiPesan b : model.getkdkategori(form.getCmbkategori().getSelectedItem().toString())) {
                form.getTxtkdkategori().setText(String.valueOf(b.getKodekategori()));
            }
        }
    }

    //memanggil method getnmkategori pada DAO_BuktiPesan    
    //method ini akan digunakan untuk menampilkan nama kategori berdasarkan inputan text kode kategori    
    public void tampilnmkategori() {
        for (BuktiPesan b : model.getnmkategori(Integer.parseInt(form.getTxtkdkategori().getText()))) {
            form.getCmbkategori().setSelectedItem(b.getNamakategori());
        }
    }

    //===========================combo barang==============================   
    //memanggil method isicombobarang pada DAO_BuktiPesan 
    //method ini digunakan untuk mengisikan data kedalam combo kode barang
    //berdasarkan parameter kode kategori
    public void isicombobarang() {
        form.getCmbbarang().removeAllItems();
        form.getCmbbarang().addItem("-Pilih-");
        for (BuktiPesan b : model.isicombobarang(Integer.parseInt(form.getTxtkdkategori().getText()))) {
            form.getCmbbarang().addItem(b.getNamabarang());
        }
    }

    //memanggil method isicombobarang2 pada DAO_BuktiPesan 
    //method ini digunakan untuk mengisikan data kedalam combo kode barang
    //berdasarkan parameter kode barang
    public void isicombobarang2() {
        form.getCmbbarang().removeAllItems();
        form.getCmbbarang().addItem("-Pilih-");
        for (BuktiPesan b : model.isicombobarang2(form.getTxtkdbrg().getText())) {
            form.getCmbbarang().addItem(b.getNamabarang());
            form.getCmbbarang().setSelectedItem(b.getNamabarang());
        }
    }

    //memanggil method getkdbrg pada DAO_BuktiPesan     
    //untuk menampilkan data barang berdasarkan inputan combo nama barang
    public void tampilkdbarang() {
        if (form.getCmbkategori().getSelectedIndex() != 0) {
            for (BuktiPesan b : model.getkdbrg(form.getCmbbarang().getSelectedItem().toString())) {
                form.getTxtkdbrg().setText(String.valueOf(b.getKodebarang()));
                form.getTxtharga().setText(String.valueOf(b.getHarga()));
                form.getTxtstok().setText(String.valueOf(b.getStok()));
            }
        }
    }

    //memanggil method getnmbarang pada DAO_BuktiPesan     
    //untuk menampilkan data barang berdasarkan inputan text kode barang
    public void tampilnmbarang() {
        for (BuktiPesan b : model.getnmbarang(form.getTxtkdbrg().getText())) {
            form.getCmbbarang().setSelectedItem(b.getNamabarang());
            form.getCmbkategori().setSelectedItem(b.getNamakategori());
            form.getTxtkdkategori().setText(String.valueOf(b.getKodekategori()));
            form.getTxtharga().setText(String.valueOf(b.getHarga()));
            form.getTxtstok().setText(String.valueOf(b.getStok()));
            
            if (b.getKodebarang().equals("")) {
                form.getTxtkdbrg().setText("");
            }
        }
    }
    
    //memanggil method simpan_transaksi pada DAO_BuktiPesan      
    //method ini digunakan untuk simpan data pada tabel buktipesan
    public void simpan_transaksi() {
        BuktiPesan B = new BuktiPesan();                         
        B.setNobp(form.getTxtnobp().getText());              
        B.setTglbp(form.getTxttglbp().getText());        
        model.insert(B);
    }

    //memanggil method simpan_detiltransaksi pada DAO_BuktiPesan      
    //method ini digunakan untuk simpan data pada tabel detilpesan dan
    //mengubah stok pada tabel barang
    public void simpan_detiltransaksi() {
        int jmlbaris = tblModel.getRowCount();
        int simpan=0;
        int i=0;
        for (i = 0; i < jmlbaris; i++) {;   
            BuktiPesan B = new BuktiPesan();  
           
            B.setNobp(form.getTxtnobp().getText());             
            B.setKodebarang(tblModel.getValueAt(i,2).toString());//kodebarang            
            B.setHarga(Integer.parseInt(tblModel.getValueAt(i,4).toString()));//harga
            B.setQty(Integer.parseInt(tblModel.getValueAt(i,5).toString()));//qty
            model.insert_detiltransaksi(B);
            model.update_stok(B);
            simpan=simpan+1;
        }
        //message dibawah ini boleh di remark
        if(simpan>0){
            JOptionPane.showMessageDialog(null, "Detil belanja berhasil di simpan dan stok barang sudah diubah!");
        }
    }
    
    public void cetak(){
        try{
            Connection conn = Koneksi.DataBase.KoneksiDB();
            String path = "src/Report/RepBuktiPesan.jasper";         
            HashMap parameter = new HashMap();
            parameter.put("nops", (form.getTxtnobp().getText()));                                       
            
            JasperReport jp=(JasperReport)JRLoader.loadObject(path);
            JasperPrint print   = JasperFillManager.fillReport(jp,parameter,conn);
            JasperViewer.viewReport(print,false);
            JasperViewer.setDefaultLookAndFeelDecorated(true); 
        
            //cetak ke pdf
            OutputStream output = new FileOutputStream(new File("D:/BuktiPesan"+(form.getTxtnobp().getText())+ ".pdf")); 
            JasperExportManager.exportReportToPdfStream(print, output); 
            
            //cetak ke excel
            File xlsx = new File("D:/BuktiPesan"+(form.getTxtnobp().getText())+ ".xlsx");           
            JRXlsxExporter Xlsxexporter = new JRXlsxExporter();
            Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
            Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE,xlsx);
            Xlsxexporter.exportReport();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Data Tidak Dapat Dicetak!! "+ex.getMessage(),
              "Cetak Data",JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
