package com.bekas.SBweb.controller;

import com.bekas.SBweb.model.Mahasiswa;
import com.bekas.SBweb.services.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/mahasiswas")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MahasiswaController {

    private MahasiswaService mahasiswaService;
     @Autowired
    public void setMahasiswaService(MahasiswaService mahasiswaService) {
        this.mahasiswaService = mahasiswaService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Mahasiswa> MahasiswaList(){
//         model.addAttribute("mahasiswa",mahasiswaService.listMahasiswa());
 return mahasiswaService.listMahasiswa();

//        return "mahasiswa";
    }
//    @RequestMapping(value = "/create", method = RequestMethod.GET)
//    public String tampilkanForm(Model model){
//         model.addAttribute("mahasiswa", new Mahasiswa());
//         return "formMahasiswa";
//    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String simpanDataMahasiswa(@RequestBody Mahasiswa mahasiswa){
//         model.addAttribute("mahasiswa",mahasiswaService.saveOrUpdate(mahasiswa));

        mahasiswaService.saveOrUpdate(mahasiswa);
        return "SUCESSS";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.PUT, produces = MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE )
    public String editData(@PathVariable Integer id,@RequestBody Mahasiswa mahasiswa){
        Mahasiswa mhs = mahasiswaService.getIdMahasiswa(id);

        mhs.setJurusan(mahasiswa.getJurusan());
        mhs.setNama(mahasiswa.getNama());
        mhs.setNim(mahasiswa.getNim());

        mahasiswaService.saveOrUpdate(mhs);
        return "SUCCESS";

    }

    @RequestMapping(value = "/hapus/{id}" , method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String hapus(@PathVariable Integer id){
         mahasiswaService.hapus(id);
         return "SUCESS";
    }


}
