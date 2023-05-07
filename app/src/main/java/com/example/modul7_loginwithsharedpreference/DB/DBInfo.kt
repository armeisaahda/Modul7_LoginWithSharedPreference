package com.example.modul7_loginwithsharedpreference.DB

import android.provider.BaseColumns

object DBInfo {
    class UserTable: BaseColumns { //kelas percabangan
        companion object {
            val TABLE_NAME  = "user" //namaTabel
            val COL_EMAIL   = "email" //namaKolom
            val COL_PASS    = "pass" //namaKolom
            val COL_FULLNAME= "fullname" //namaKolom
            val COL_JUMLAH  = "jumlah" //namaKolom
        }
    }
}
//DB Info berfungsi untuk tabel SQLite
//Menggunakan library BaseColums yg fungsinya untuk menyediakan library standar pd SQLite