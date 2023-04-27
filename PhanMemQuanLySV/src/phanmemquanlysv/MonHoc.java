/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phanmemquanlysv;

/**
 *
 * @author ADMIN
 */
public class MonHoc {

    private String mamonhoc;

    public MonHoc(String mamonhoc, String monhoc, int solop) {
        this.mamonhoc = mamonhoc;
        this.monhoc = monhoc;
        this.solop = solop;
    }
    private String monhoc;
    private int solop;
    private String mota;

    public MonHoc(String mamonhoc, String monhoc, int solop, String mota) {
        this.mamonhoc = mamonhoc;
        this.monhoc = monhoc;
        this.solop = solop;
        this.mota = mota;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    public String getMamonhoc() {
        return mamonhoc;
    }

    public int getSolop() {
        return solop;
    }

    public void setSolop(int solop) {
        this.solop = solop;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public String getMota() {
        return mota;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

}
