package com.example.__MaiTheNghia_KTGiuaKi.repository;

import com.example.__MaiTheNghia_KTGiuaKi.entity.PHONGBAN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhongBanRepository extends JpaRepository<PHONGBAN, String> {
}
