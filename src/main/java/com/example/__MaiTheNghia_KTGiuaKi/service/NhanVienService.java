package com.example.__MaiTheNghia_KTGiuaKi.service;

import com.example.__MaiTheNghia_KTGiuaKi.entity.NHANVIEN;
import com.example.__MaiTheNghia_KTGiuaKi.repository.INhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NhanVienService {
    @Autowired
    private INhanVienRepository iNhanVienRepository;

    public List<NHANVIEN> getAllNhanVien() {
        return iNhanVienRepository.findAll();
    }

    public NHANVIEN getNhanVienId(String id) {
        return iNhanVienRepository.findById(id).orElse(null);
    }

    public void addnhanvien(NHANVIEN nhanvien) {
        iNhanVienRepository.save(nhanvien);
    }
    public void updateNhanVien(NHANVIEN nhanvien) {
        iNhanVienRepository.save(nhanvien);
    }
    public void deleteNhanVien(String id) {
        iNhanVienRepository.deleteById(id);
    }
}
