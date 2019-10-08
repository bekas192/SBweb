package com.bekas.SBweb.services;

import com.bekas.SBweb.model.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MahasiswaService {

    List <Mahasiswa> listMahasiswa();
    Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);
    Mahasiswa getIdMahasiswa(Integer id);
    void hapus(Integer id);

}
