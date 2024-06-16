package com.example.__MaiTheNghia_KTGiuaKi.controller;

import com.example.__MaiTheNghia_KTGiuaKi.entity.NHANVIEN;
import com.example.__MaiTheNghia_KTGiuaKi.service.NhanVienService;
import com.example.__MaiTheNghia_KTGiuaKi.service.PhongBanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;

    @GetMapping
    public String showAllNhanVien(Model model) {
        List<NHANVIEN> nhanviens = nhanVienService.getAllNhanVien();
        model.addAttribute("nhanviens", nhanviens);
        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model) {
        model.addAttribute("nhanvien", new NHANVIEN());
        model.addAttribute("phongbans", phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }

    @PostMapping("/add")
    public String addNhanVien(@Valid @ModelAttribute("nhanvien") NHANVIEN nhanvien, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/add";
        }
        nhanVienService.addnhanvien(nhanvien);
        return "redirect:/nhanviens";
    }
    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable("id") String id, Model model){
        NHANVIEN nhanvien = nhanVienService.getNhanVienId(id);
        if(nhanvien != null){
            model.addAttribute("nhanvien", nhanvien);
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        return "redirect:/nhanviens";
    }

    @PostMapping("/edit")
    public String editNhanVien(@Valid @ModelAttribute("nhanvien") NHANVIEN nhanvien, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        nhanVienService.updateNhanVien(nhanvien);
        return "redirect:/nhanviens";
    }


    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id") String id) {
        nhanVienService.deleteNhanVien(id);
        return "redirect:/nhanviens";
    }
}
