package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // List untuk menyimpan data sementara (Temporary) [cite: 74]
    private List<User> daftarMahasiswa = new ArrayList<>();

    // 1. Halaman Login [cite: 70]
    @GetMapping("/")
    public String loginPage() {
        return "login"; // Mengarah ke login.html [cite: 56]
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {
        // Validasi: username = admin, password = nim masing-masing [cite: 70]
        if ("admin".equals(username) && "20230140009".equals(password)) {
            return "redirect:/home";
        }
        return "login";
    }

    // 2. Halaman Home [cite: 74]
    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("listMhs", daftarMahasiswa); // Menampilkan data mahasiswa [cite: 78]
        return "home"; // Mengarah ke home.html [cite: 55]
    }

    // 3. Halaman Form Input
    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("user", new User());
        return "form"; // Mengarah ke form.html [cite: 54]
    }

    // 4. Proses Simpan Data (Temporary) [cite: 92]
    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        daftarMahasiswa.add(user); // Data tidak disimpan di database [cite: 74]
        return "redirect:/home"; // Kembali ke home setelah input [cite: 91]
    }
}
