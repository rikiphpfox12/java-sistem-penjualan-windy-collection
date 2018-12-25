/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.DAO_Barang;
import Model.Barang;
import View.MBarang;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author praktek
 */
public class Controller_Barang{
   
    MBarang form;
    DAO_Barang model;
    List<Barang> list;
    String[] header;
    
    public Controller_Barang(MBarang form) {
        this.form = form;
        model = new DAO_Barang();
        list  = model.getAll();
        header = new String[]{"KODE BARANG", "NAMA BARANG", "UKURAN", "HARGA", "STOK", "KODE KATEGORI", "NAMA KATEGORI"};
        
        form.getTblbarang().setShowGrid(true);
        form.getTblbarang().setShowVerticalLines(true);
        form.getTblbarang().setGridColor(Color.blue);
    }
    
    public void isicombokategori() {
        form.getCmbkategori().removeAllItems();
        form.getCmbkategori().addItem("--Pilih--");
        for(Barang B : model.isicombokat()) {
            form.getCmbkategori().addItem(B.getNamakategori());
        }
    }
    
    public void tampilurutankode() {
        if (form.getCmbkategori().getSelectedIndex() > 0) {
            form.getTxtkdbarang().setText(String.valueOf(model.autonumber2(Integer.parseInt
            (form.getTxtnmkategori().getText()))));
        } 
    }
    
    public void tampilkategori() {
        if (form.getCmbkategori().getSelectedIndex() != 0) {
            for (Barang b : model.getkdkat(form.getCmbkategori().getSelectedItem().toString())) {
                form.getTxtnmkategori().setText(String.valueOf(b.getKodekategori()));
            }
        }
    }
    
    public void isiTable() {
        list = model.getAll();
        
        // script agar jtable gabisa di edit
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header) {
            public boolean  isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        
        Object[] data = new Object[header.length];
        for(Barang B : list) {
            data[0] = B.getKodebarang();
            data[1] = B.getNamabarang();
            data[2] = B.getUkuran();
            data[3] = B.getHarga();
            data[4] = B.getStok();
            data[5] = B.getKodekategori();
            data[6] = B.getNamakategori();
            tblModel.addRow(data);
        }
        form.getTblbarang().setModel(tblModel);
    }
    
    public void reset() {
        form.getCmbkategori().setSelectedIndex(0);
        form.getTxtnmkategori().setText("");
        form.getTxtkdbarang().setText("");
        form.getTxtnmbarang().setText("");
        form.getCmbsatuan().setSelectedIndex(0);
        form.getTxtharga().setText("");
        form.getTxtstok().setText("");
        form.getTxtkatakunci().setText("");
        form.getTxtnmbarang().requestFocus();
        form.getTxtnmkategori().setEditable(false);
        form.getTxtkdbarang().setEditable(false);
        isicombokategori();
        tampilurutankode();
        isiTable();
    }
    
    public void isiField(int row) {
        form.getCmbkategori().setSelectedItem(list.get(row).getKodekategori());
        form.getTxtnmkategori().setText(Integer.toString(list.get(row).getKodekategori()));
        form.getTxtkdbarang().setText(list.get(row).getKodebarang());
        form.getTxtnmbarang().setText(list.get(row).getNamabarang());
        form.getCmbsatuan().setSelectedItem(list.get(row).getUkuran());
        form.getTxtharga().setText(String.valueOf(list.get(row).getHarga()));
        form.getTxtstok().setText(String.valueOf(list.get(row).getStok()));
    }    

    public void insert() {
        Barang B = new Barang();
        B.setKodebarang(form.getTxtkdbarang().getText());
        if(form.getCmbsatuan().getSelectedItem().toString() != "-") {
            B.setNamabarang(form.getTxtnmbarang().getText()+" ["+form.getCmbsatuan().getSelectedItem().toString()+"]");
        } else {
            B.setNamabarang(form.getTxtnmbarang().getText());
        }
        B.setUkuran(form.getCmbsatuan().getSelectedItem().toString());
        B.setHarga(Integer.parseInt(form.getTxtharga().getText()));
        B.setStok(Integer.parseInt(form.getTxtstok().getText()));
        B.setKodekategori(Integer.parseInt(form.getTxtnmkategori().getText()));
        model.insert(B);
    }
    
    public void update() {
        Barang B = new Barang();
        B.setNamabarang(form.getTxtnmbarang().getText());
        B.setUkuran(form.getCmbsatuan().getSelectedItem().toString()+" ["+form.getCmbsatuan().getSelectedItem().toString()+"]");
        B.setHarga(Integer.parseInt(form.getTxtharga().getText()));
        B.setStok(Integer.parseInt(form.getTxtstok().getText()));
        B.setKodekategori(Integer.parseInt(form.getTxtnmkategori().getText()));
        B.setKodebarang(form.getTxtkdbarang().getText());
        model.update(B);
    }    
 
    public void delete() {
        if(!form.getTxtkdbarang().getText().trim().isEmpty()) {
            String id = (form.getTxtkdbarang().getText());
            model.delete(id);
        } 
        else {
            JOptionPane.showMessageDialog(form,"Pilih data yang akan dihapus!");
        
        }
    }
    
    public void isiTableCari() {
        list = model.getCari(form.getTxtkatakunci().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        
        for(Barang B : list) {
            data[0] = B.getKodebarang();
            data[1] = B.getNamabarang();
            data[2] = B.getUkuran();
            data[3] = B.getHarga();
            data[4] = B.getStok();
            data[5] = B.getKodekategori();
            data[6] = B.getNamakategori();
            tblModel.addRow(data);
        }
        form.getTblbarang().setModel(tblModel);
    }
    
    public void tampilnamakategori() {
        if(form.getCmbkategori().getSelectedIndex() != 0) {
            for(Barang b : model.getDataKategori(Integer.parseInt(form.getCmbkategori().getSelectedItem().toString()))) {
                form.getTxtnmkategori().setText(b.getNamakategori());
            }
        }
    }
    
}
