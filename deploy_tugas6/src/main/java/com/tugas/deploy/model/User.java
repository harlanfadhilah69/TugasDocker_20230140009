package com.tugas.deploy.model;

import lombok.Data;

@Data // Anotasi Lombok untuk otomatis membuat Getter, Setter, dan ToString [cite: 26, 27]
public class User {
    private String nama; // Sesuai kolom minimal: Nama [cite: 85, 86]
    private String nim;  // Sesuai kolom minimal: NIM [cite: 85, 87]
    private String jenisKelamin; // Tambahan kolom Jenis Kelamin [cite: 88]
}