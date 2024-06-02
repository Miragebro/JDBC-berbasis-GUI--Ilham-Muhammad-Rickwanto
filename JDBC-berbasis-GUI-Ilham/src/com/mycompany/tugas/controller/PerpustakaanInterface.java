package com.mycompany.tugas.controller;

import com.mycompany.tugas.model.Buku;
import java.util.List;

public interface PerpustakaanInterface {
    public void save(Buku buku);
    public void update(Buku buku);
    public void delete(Buku buku);
    public Buku get(int id);
    public List<Buku> list();
}
