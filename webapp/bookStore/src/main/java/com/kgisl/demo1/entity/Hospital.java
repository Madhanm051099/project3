package com.kgisl.demo1.entity;

public class Hospital {
    public int hospital_id;
    public String hospital_name;
    public String hospital_address;
    public int hospital_conno;
    public Hospital(int hospital_id, String hospital_name, String hospital_address, int hospital_conno) {
        this.hospital_id = hospital_id;
        this.hospital_name = hospital_name;
        this.hospital_address = hospital_address;
        this.hospital_conno = hospital_conno;
    }
    
    public Hospital(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public Hospital(String hospital_name, String hospital_address, int hospital_conno) {
        this.hospital_name = hospital_name;
        this.hospital_address = hospital_address;
        this.hospital_conno = hospital_conno;
    }

    public int getHospital_id() {
        return hospital_id;
    }
    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }
    public String getHospital_name() {
        return hospital_name;
    }
    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }
    public String getHospital_address() {
        return hospital_address;
    }
    public void setHospital_address(String hospital_address) {
        this.hospital_address = hospital_address;
    }
    public int getHospital_conno() {
        return hospital_conno;
    }
    public void setHospital_conno(int hospital_conno) {
        this.hospital_conno = hospital_conno;
    }

    public void add(Hospital hospital) {
    }

    
    
}
