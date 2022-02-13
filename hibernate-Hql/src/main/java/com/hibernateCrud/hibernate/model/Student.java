package com.hibernateCrud.hibernate.model;

import javax.persistence.*;

@Table(name = "student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(name = "ad")
    private String ad;
    @Column(name = "soyAd")
    private  String soyAd;
    @Column(name = "eMAil")
    private  String eMail;

    public Student() {
    }

    public Student( String ad, String soyAd, String eMail) {

        this.ad = ad;
        this.soyAd = soyAd;
        this.eMail = eMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyAd='" + soyAd + '\'' +
                ", eMail='" + eMail + '\'' +
                '}';
    }
}
