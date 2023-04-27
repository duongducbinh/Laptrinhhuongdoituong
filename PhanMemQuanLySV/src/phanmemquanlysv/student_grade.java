/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phanmemquanlysv;

/**
 *
 * @author ADMIN
 */
public class student_grade {

    private int MSSV;
    private String name;
    private String mamonhoc;

    public student_grade(int MSSV, String name, String mamonhoc) {
        this.MSSV = MSSV;
        this.name = name;
        this.mamonhoc = mamonhoc;
    }

    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    public student_grade(int MSSV, String name, String mamonhoc, float diem) {
        this.MSSV = MSSV;
        this.name = name;
        this.mamonhoc = mamonhoc;
        this.diem = diem;
    }

    private float diem;

    public int getMSSV() {
        return MSSV;
    }

    public String getName() {
        return name;
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

    public void setDiem(float diem) {
        this.diem = diem;
    }

}
