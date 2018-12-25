package DAO;
import Koneksi.DataBase;
import Model.BuktiPesan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAO_BuktiPesan implements Model_DAO<BuktiPesan> {
    
    Connection connection;
    public DAO_BuktiPesan(){
        connection = DataBase.KoneksiDB();
    }

    @Override
    //method untuk simpan data ke dalam tabel buktipesan
    public void insert(BuktiPesan object) {
       PreparedStatement statement;
       
        try {
            String SELECT = "select * from buktipesan where nopesan=?";   
            statement = connection.prepareStatement(SELECT);
            statement.setString(1, object.getNobp());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) //jika data sudah pernah disimpan
            {
                JOptionPane.showMessageDialog(null, "Data sudah pernah di simpan!");
            } else {    //jika data belum pernah disimpan             
                
                //insert ke dalam table buktipesan
                PreparedStatement statement2;                
                String INSERT = "insert into buktipesan(nopesan,tglpesan) values(?,?)";   
                statement2 = connection.prepareStatement(INSERT);                
                statement2.setString(1, object.getNobp());
                statement2.setString(2, object.getTglbp());
                statement2.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data transaksi berhasil di simpan!");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    //method untuk simpan data ke dalam tabel detilpesan
      public void insert_detiltransaksi(BuktiPesan object) {
        PreparedStatement statement;       
        try {
                //insert ke dalam table detilpesan    
                String INSERTDETIL = "insert into detilpesan(nopesan,kdbrg,hrgpesan,jmlpesan) values(?,?,?,?)";
                statement = connection.prepareStatement(INSERTDETIL);
                statement.setString(1, object.getNobp());
                statement.setString(2, object.getKodebarang());               
                statement.setInt(3, object.getHarga());    
                statement.setInt(4, object.getQty());                  
                statement.executeUpdate();  
                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    //method untuk mengubah stok barang ke dalam tabel barang  
    public void update_stok(BuktiPesan object) {
       PreparedStatement statement;
       int stok_akhir=0;
        try {
                String SELECT = "select stok from barang where kdbrg=?";   
                statement = connection.prepareStatement(SELECT);
                statement.setString(1, object.getKodebarang());
                ResultSet rs = statement.executeQuery();     
                
                if (rs.next()){ //jika data ditemukan (baik null maupun tidak null)
                    if (rs.getInt("stok")<0){
                        JOptionPane.showMessageDialog(null, "Stok Kode Barang : " +object.getKodebarang() +"Kosong!");                     
                        stok_akhir=0;
                    }else{
                        //hitung stok akhir berdasarkan qty masing2 kode barang yang ada di jtabel 
                        stok_akhir=rs.getInt("stok")- object.getQty();

                        //update stok barang ke dalam table barang                     
                        PreparedStatement statement2; 
                        String UPDATESTOCK ="update barang set stok=? where kdbrg=?";
                        statement2 = connection.prepareStatement(UPDATESTOCK);                
                        statement2.setInt(1, stok_akhir);
                        statement2.setString(2, object.getKodebarang());     
                        statement2.executeUpdate();
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }      
    }
    
    //method untuk membuat penomoran buktipesan secara otomatis
    public String autonumber2() {
        PreparedStatement statement;
        int nomor_berikutnya = 0;
        String urutan = "";
        try {
            
            String COUNTER = "SELECT ifnull(max(convert(right(nopesan,5),signed integer)),0) as kode,"
            + "ifnull(length(max(convert(right(nopesan,5)+1,signed integer))),0)as panjang from buktipesan";

            statement = connection.prepareStatement(COUNTER);            
            ResultSet rs2 = statement.executeQuery();
            if (rs2.next()) {               
                 nomor_berikutnya = rs2.getInt("kode") + 1;                
                if (rs2.getInt("kode")!= 0) {//jika nomor transaksi sudah pernah ada                         
                            if (rs2.getInt("panjang") == 1) { //jika jumlah digitnya adalah 1
                                urutan = "BP" + "0000" + nomor_berikutnya;
                            } else if (rs2.getInt("panjang") == 2) { //jika jumlah digitnya adalah 2
                                urutan = "BP" + "000" + nomor_berikutnya;                            
                            } else if (rs2.getInt("panjang") == 3) { //jika jumlah digitnya adalah 3
                                urutan = "BP" + "00" + nomor_berikutnya;
                            }else if (rs2.getInt("panjang") == 4) { //jika jumlah digitnya adalah 4
                                urutan = "BP" + "0" + nomor_berikutnya;
                            }else if (rs2.getInt("panjang") == 5) { //jika jumlah digitnya adalah 5
                                urutan = "BP" + nomor_berikutnya;
                            }
                    }
                    else {//jika nomor transaksi belum pernah ada                      
                        urutan = "BP" + "00001";
                } 

            }else
                 JOptionPane.showMessageDialog(null, "Data tidak ditemukan!");              
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urutan;
    }
    
    //============================Combo Pelanggan===================================
    //method untuk menampilkan nama pelanggan kedalam combo nama pelanggan
    public List<BuktiPesan> isicomboplg() {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String TAMPILPELANGGAN = "SELECT * FROM pelanggan order by nmplg";
            statement = connection.prepareStatement(TAMPILPELANGGAN);
            ResultSet rs = statement.executeQuery();              
            while (rs.next()) {
                BuktiPesan b = new BuktiPesan();  
                b.setNamaplg(rs.getString("nmplg"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      
    //method untuk menampilkan kode pelanggan berdasarkan inputan combo nama pelanggan     
    public List<BuktiPesan> getkdplg(String namaplg) {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String CARIPELANGGAN2 = "SELECT * FROM pelanggan where nmplg=?";    
            statement = connection.prepareStatement(CARIPELANGGAN2);
            statement.setString(1, namaplg);
            ResultSet rs = statement.executeQuery();   
           
            while (rs.next()) {                         
                BuktiPesan b = new BuktiPesan();
                b.setKodeplg(rs.getInt("kdplg"));
                list.add(b);            
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }  
    
    //method untuk menampilkan nama pelanggan berdasarkan inputan text kode pelanggan     
    public List<BuktiPesan> getnmplg(Integer kode) {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String CARIPELANGGAN = "SELECT * FROM pelanggan where kdplg=?";
            statement = connection.prepareStatement(CARIPELANGGAN);
            statement.setInt(1, kode);
            ResultSet rs = statement.executeQuery();       
            if (!rs.next()){ 
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");  
            } else{
                    BuktiPesan b = new BuktiPesan();
                    b.setNamaplg(rs.getString("nmplg"));
                    list.add(b);                    
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }   
      
    //============================Combo Kategori===================================
    //method untuk menampilkan nama kategori kedalam combo nama kategori
    public List<BuktiPesan> isicombokateogori() {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String TAMPILKATEGORI = "SELECT * FROM kategori order by nmkategori";
            statement = connection.prepareStatement(TAMPILKATEGORI);
            ResultSet rs = statement.executeQuery();              
            while (rs.next()) {
                BuktiPesan b = new BuktiPesan();  
                b.setNamakategori(rs.getString("nmkategori"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         
    //method untuk menampilkan kode kategori berdasarkan inputan combo nama kategori     
    public List<BuktiPesan> getkdkategori(String namakat) {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String CARIKATEGORI2 = "SELECT * FROM kategori where nmkategori=?"; 
            statement = connection.prepareStatement(CARIKATEGORI2);
            statement.setString(1, namakat);
            ResultSet rs = statement.executeQuery();   
           
            while (rs.next()) {                         
                BuktiPesan b = new BuktiPesan();
                b.setKodekategori(rs.getInt("kdkategori"));
                list.add(b);            
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }  
    
    //method untuk menampilkan nama kategori berdasarkan inputan text kode kategori     
    public List<BuktiPesan> getnmkategori(Integer kode) {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String CARIKATEGORI = "SELECT * FROM kategori where kdkategori=?";
            statement = connection.prepareStatement(CARIKATEGORI);
            statement.setInt(1, kode);
            ResultSet rs = statement.executeQuery();       
            if (!rs.next()){ 
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");  
            } else{
                    BuktiPesan b = new BuktiPesan();
                    b.setNamakategori(rs.getString("nmkategori"));
                    list.add(b);                    
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }   
      
    //============================Combo Barang===================================
    //mengisi data kedalam combo nama barang berdasarkan inputan kode kategori
    public List<BuktiPesan> isicombobarang(Integer kode) {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String TAMPILBARANG= "SELECT * FROM barang where kdkategori=? order by nmbrg";
            statement = connection.prepareStatement(TAMPILBARANG);
            statement.setInt(1, kode);
            ResultSet rs = statement.executeQuery();              
            while (rs.next()) {
                BuktiPesan b = new BuktiPesan();  
                b.setNamabarang(rs.getString("nmbrg"));
                b.setUkuran(rs.getString("ukuran"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
        
    //mengisi data kedalam combo nama barang berdasarkan inputan kode barang
    public List<BuktiPesan> isicombobarang2(String kode) {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String TAMPILBARANG= "SELECT * FROM barang where kdbrg=? order by nmbrg";
            statement = connection.prepareStatement(TAMPILBARANG);
            statement.setString(1, kode);
            ResultSet rs = statement.executeQuery();              
            while (rs.next()) {
                BuktiPesan b = new BuktiPesan();  
                b.setNamabarang(rs.getString("nmbrg"));
                b.setUkuran(rs.getString("ukuran"));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //method untuk menampilkan data barang berdasarkan inputan nama barang    
    public List<BuktiPesan> getkdbrg(String namaplg) {
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();            
            String CARIBARANG2 = "SELECT * FROM barang where nmbrg=?"; 
            statement = connection.prepareStatement(CARIBARANG2);
            statement.setString(1, namaplg);
            ResultSet rs = statement.executeQuery();   
           
            while (rs.next()) {                         
                BuktiPesan b = new BuktiPesan();
                b.setKodebarang(rs.getString("kdbrg"));
                b.setHarga(rs.getInt("hargabrg"));
                b.setStok(rs.getInt("stok"));
                list.add(b);            
            } 

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }  
       
    //method untuk menampilkan data barang beserta kategori berdasarkan inputan kode barang    
    public List<BuktiPesan> getnmbarang(String kode) {
        int i=0;
        PreparedStatement statement;
        List<BuktiPesan> list = null;
        try {
            list = new ArrayList();
            String CARIBARANG = "SELECT a.*, b.* FROM barang a, kategori b where a.kdkategori=b.kdkategori and kdbrg=?";
            statement = connection.prepareStatement(CARIBARANG);
            statement.setString(1, kode);
            ResultSet rs = statement.executeQuery();   
            BuktiPesan b = new BuktiPesan();
            if (!rs.next()){ 
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan"); 
                    b.setKodekategori(0);
                    b.setNamakategori("-Pilih-");                    
                    b.setKodebarang("");
                    b.setNamabarang("");
                    b.setHarga(0);
                    b.setStok(0);
                    list.add(b);         
            } else{
                    
                    b.setKodekategori(rs.getInt("a.kdkategori"));
                    b.setNamakategori(rs.getString("nmkategori"));
                    b.setNamabarang(rs.getString("nmbrg"));
                    b.setHarga(rs.getInt("hargabrg"));
                    b.setStok(rs.getInt("stok"));
                    list.add(b);                    
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
 
    //method-method dibawah ini merupakan hasil implements Model_DAO, namun tidak digunakan  
    @Override
    public int autonumber(BuktiPesan object) {
       throw new UnsupportedOperationException("Not supported yet.");  
    }
    
    @Override
    public void update(BuktiPesan object) {
        throw new UnsupportedOperationException("Not supported yet.");  
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<BuktiPesan> getAll() {
       List<BuktiPesan> list = null;        
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public List<BuktiPesan> getCari(String key) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
