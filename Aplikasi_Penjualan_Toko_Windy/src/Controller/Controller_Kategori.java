/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import DAO.DAO_Kategori;
import DAO.Model_DAO;
import Model.Kategori;
//import View.MKategori;
import View.MKategoriBarang;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author praktek
 */
public class Controller_Kategori {
    MKategoriBarang form;
    Model_DAO<Kategori> model;
    List<Kategori> list;
    String[] header;
    
    public Controller_Kategori(MKategoriBarang form) {
        this.form = form;
        model = new DAO_Kategori();
        list  = model.getAll();
        header = new String[]{"KODE KATEGORI", "NAMA KATEGORI"};
        
        form.getTblkategori().setShowGrid(true);
        form.getTblkategori().setShowVerticalLines(true);
        form.getTblkategori().setGridColor(Color.blue);       
    }
    
    public void tampilurutankode() {
        Kategori k = new Kategori();
        model.autonumber(k);
        form.getTxtkdkategori().setText(String.valueOf(model.autonumber(k)));
    }
    
    public void reset() {
        form.getTxtkdkategori().setText("");
        form.getTxtnmkategori().setText("");
        form.getTxtnmkategori().requestFocus();
        tampilurutankode();
        isiTable();
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
        for(Kategori K : list) {
            data[0] = K.getKode();
            data[1] = K.getNama();
            tblModel.addRow(data);
        }
        form.getTblkategori().setModel(tblModel);
    }
    
    public void isiField(int row) {
        form.getTxtkdkategori().setText(String.valueOf(list.get(row).getKode()));
        form.getTxtnmkategori().setText(list.get(row).getNama());
    }
    
    public void insert() {
        Kategori k = new Kategori();
        k.setKode(Integer.parseInt(form.getTxtkdkategori().getText()));
        k.setNama(form.getTxtnmkategori().getText()); 
        model.insert(k);
    }
    
    public void update() {
        Kategori k = new Kategori();
        k.setKode(Integer.parseInt(form.getTxtkdkategori().getText()));
        k.setNama(form.getTxtnmkategori().getText());   
        model.update(k);
    }
    
    public void delete() {
        if(!form.getTxtkdkategori().getText().trim().isEmpty()) {
            int id = Integer.parseInt((form.getTxtkdkategori().getText()));
            model.delete(id);
        } 
        else {
            JOptionPane.showMessageDialog(form,"Pilih data yang akan dihapus!");
        
        }
    }
    
    public void isiTableCari() {
        list = model.getCari(form.getTxtkdkategori().getText().trim());
        DefaultTableModel tblModel = new DefaultTableModel(new Object[][]{}, header);
        Object[] data = new Object[header.length];
        
        for(Kategori k : list) {
            data[0] = k.getKode();
            data[1] = k.getNama();
            tblModel.addRow(data);
        }
        form.getTblkategori().setModel(tblModel);
    }
    
}
