package com.example.__MaiTheNghia_KTGiuaKi.service;

import com.example.__MaiTheNghia_KTGiuaKi.entity.PHONGBAN;
import com.example.__MaiTheNghia_KTGiuaKi.repository.IPhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhongBanService {
    @Autowired
    private IPhongBanRepository iPhongBanRepository;

    public List<PHONGBAN> getAllPhongBan() {
        return iPhongBanRepository.findAll();
    }

    public PHONGBAN getPhongBanById(String id) {
        return iPhongBanRepository.findById(id).orElse(null);
    }

    public PHONGBAN savePhongBan(PHONGBAN phongban) {
        return iPhongBanRepository.save(phongban);
    }

    public void deletePhongBan(String id) {
        iPhongBanRepository.deleteById(id);
    }

}
