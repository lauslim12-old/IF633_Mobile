package umn.ac.id.week07b_32827;

import java.io.Serializable;

public class SumberVideo implements Serializable {
    private String judul;
    private String keterangan;
    private String videoUri;

    public SumberVideo(String judul, String keterangan, String videoUri) {
        this.judul = judul;
        this.keterangan = keterangan;
        this.videoUri = videoUri;
    }

    public String getJudul() {
        return this.judul;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public String getVideoUri() {
        return this.videoUri;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setVideoUri(String videoUri) {
        this.videoUri = videoUri;
    }

    public String toString() {
        return this.getJudul() + "=>" + this.getKeterangan();
    }
}
