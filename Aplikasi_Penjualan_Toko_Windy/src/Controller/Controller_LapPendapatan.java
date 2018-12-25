
package Controller;

import DAO.DAO_BuktiPesan;
import View.LapPendapatan;
import View.TBuktiPesan;
import java.awt.Color;
import java.io.File;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Controller_LapPendapatan {
    
    LapPendapatan form;
    
     public Controller_LapPendapatan(LapPendapatan form) {
        this.form = form;        
    }
    public void awal(){
     SimpleDateFormat tgl1 = new SimpleDateFormat("yyyy-MM-dd");
     SimpleDateFormat tgl2 = new SimpleDateFormat("yyyy-MM-dd");
     form.getTgl1().setText(String.valueOf(tgl1.format(new Date())));
     form.getTgl2().setText(String.valueOf(tgl2.format(new Date())));
    }
    
    
    public void cetak_preview(){
      try{
          Connection conn = Koneksi.DataBase.KoneksiDB();
          String path = "src/Report/RepLapPendapatan.jasper";   
          HashMap parameter = new HashMap();
          parameter.put("tgl_awal", (form.getTgl1().getText()));   
          parameter.put("tgl_akhir", (form.getTgl2().getText()));   
           
          JasperReport jp=(JasperReport)JRLoader.loadObject(path);
          JasperPrint print   = JasperFillManager.fillReport(jp,parameter,conn);
          JasperViewer.viewReport(print,false);
          JasperViewer.setDefaultLookAndFeelDecorated(true);        

      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,"Data Tidak Dapat Dicetak!! "+ex.getMessage(),
            "Cetak Data",JOptionPane.ERROR_MESSAGE);
      }        
    }
       
    public void cetak_excel(){
        try{
            Connection conn = Koneksi.DataBase.KoneksiDB();
            String path = "src/Report/RepLapPendapatan.jasper";  
            File xlsx = new File("D:/LapPendapatan.xlsx");  
            HashMap parameter = new HashMap();
            parameter.put("tgl_awal", (form.getTgl1().getText()));   
            parameter.put("tgl_akhir", (form.getTgl2().getText())); 
          
            JasperPrint print   = JasperFillManager.fillReport(path,parameter,conn);
            
            JRXlsxExporter Xlsxexporter = new JRXlsxExporter();
            Xlsxexporter.setParameter(JRExporterParameter.JASPER_PRINT,print);
            Xlsxexporter.setParameter(JRExporterParameter.OUTPUT_FILE,xlsx);
            Xlsxexporter.exportReport();
            
            JOptionPane.showMessageDialog(null,"Cek file pada drive D:/LapPendapatan.xlsx");
             
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Data Tidak Dapat Dicetak!! "+ex.getMessage(),
              "Cetak Data",JOptionPane.ERROR_MESSAGE);
        }        
    }
    
}
