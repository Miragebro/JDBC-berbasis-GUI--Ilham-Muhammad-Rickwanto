package com.mycompany.tugas.controller;

import com.mycompany.tugas.dbbuku.DbBuku;
import com.mycompany.tugas.model.Buku;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PerpustakaanImplement implements PerpustakaanInterface{

    @Override
    public void save(Buku buku) {
      try{
          Connection con = DbBuku.getConnection();
          String sql = "INSERT INTO jdbcperpustakaan.buku(JUDUL,TAHUN,PENULIS) VALUES (?,?,?)";
          PreparedStatement ps = con.prepareStatement(sql);
          ps.setString(1, buku.getJudul());
          ps.setString(2, buku.getTahun());
          ps.setString(3, buku.getPenulis());
          ps.executeUpdate();
          JOptionPane.showMessageDialog(null, "Tersimpan!");
      } catch(Exception e) {
          e.printStackTrace();
          JOptionPane.showMessageDialog(null, "Error");
      }
    }

    @Override
    public void update(Buku buku) {
        try {
            Connection con = DbBuku.getConnection();
            String sql = "UPDATE jdbcperpustakaan.buku SET JUDUL=?, TAHUN=?, PENULIS=? WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, buku.getJudul());
            ps.setString(2, buku.getTahun());
            ps.setString(3, buku.getPenulis());
            ps.setInt(4, buku.getId());
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Berhasil diUpdate!");
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }

    @Override
    public void delete(Buku buku) {
        try{
            Connection con = DbBuku.getConnection();
            String sql = "DELETE from jdbcperpustakaan.buku WHERE ID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, buku.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil dihapus!");
        } catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public Buku get(int id) {
       Buku buku = new Buku();
       try{
           Connection con = DbBuku.getConnection();
           String sql = "SELECT * FROM jdbcperpustakaan.buku WHERE ID=?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1, id);
           ResultSet rs = ps.executeQuery();
           if(rs.next()) {
               buku.setId(rs.getInt("id"));
               buku.setJudul(rs.getString("judul"));
               buku.setTahun(rs.getString("tahun"));
               buku.setPenulis(rs.getString("penulis"));
           }
       } catch(Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Error");
       }
       return buku;
    }

    @Override
    public List<Buku> list() {
       List<Buku> list = new ArrayList<Buku>();
       
       try{
           Connection con = DbBuku.getConnection();
           String sql = "SELECT * FROM jdbcperpustakaan.Buku";
           PreparedStatement ps = con.prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           while(rs.next()) {
               Buku buku = new Buku();
               buku.setId(rs.getInt("id"));
               buku.setJudul(rs.getString("judul"));
               buku.setTahun(rs.getString("tahun"));
               buku.setPenulis(rs.getString("penulis"));
               
               list.add(buku);
           }
       } catch(Exception e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Error");
       }
       
       return list;
    }
    
}
