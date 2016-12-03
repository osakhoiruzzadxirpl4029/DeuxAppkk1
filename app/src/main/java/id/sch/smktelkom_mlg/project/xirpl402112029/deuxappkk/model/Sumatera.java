package id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.model;

import java.io.Serializable;

/**
 * Created by SUPER USER on 22/11/2016.
 */

public class Sumatera implements Serializable {
    public String judul;
    public String deskripsi;
    public String foto;
    public String detail;
    public String lokasi;

    public Sumatera(String judul, String deskripsi, String foto, String detail, String lokasi) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.detail = detail;
        this.lokasi = lokasi;
    }
}
