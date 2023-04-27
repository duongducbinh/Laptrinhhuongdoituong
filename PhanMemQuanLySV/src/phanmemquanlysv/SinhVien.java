/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phanmemquanlysv;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class SinhVien {
    private int MSSV;
    private String name;
    private String svnam;
    private String gioitinh;
    private String khoa;
    private Date ngaysinh;
    private String trangthai;
    private float diem;
    
    
    public SinhVien(int MSSV, String name, String svnam, String gioitinh, String khoa,  float diem, String trangthai) {
        this.MSSV = MSSV;
        this.name = name;
        this.svnam = svnam;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
        this.trangthai = trangthai;
        this.diem = diem;
    }
    

    public SinhVien(int MSSV, String name, String svnam, String gioitinh, String khoa, Date ngaysinh,float diem, String trangthai ) {
        this.MSSV = MSSV;
        this.name = name;
        this.svnam = svnam;
        this.gioitinh = gioitinh;
        this.khoa = khoa;
        this.ngaysinh = ngaysinh;
        this.trangthai = trangthai;
        this.diem = diem;
    }

    public int getMSSV() {
        return MSSV;
    }

    public String getName() {
        return name;
    }

    public String getSvnam() {
        return svnam;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getKhoa() {
        return khoa;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public float getDiem() {
        return diem;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSvnam(String svnam) {
        this.svnam = svnam;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }

    
}