package com.example.__MaiTheNghia_KTGiuaKi.repository;

import com.example.__MaiTheNghia_KTGiuaKi.entity.NHANVIEN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INhanVienRepository extends JpaRepository<NHANVIEN, String> {
}
