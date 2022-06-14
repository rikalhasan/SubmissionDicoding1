package com.rikal.dicodingtest1;

import android.os.Parcel;
import android.os.Parcelable;

public class Nama implements Parcelable {
    private String nama;
    private String deskripsi;
    private Integer foto;
    private String username;
    private String lokasi;
    private String repo;
    private String company;
    private String followers;
    private String following;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nama);
        parcel.writeString(this.username);
        parcel.writeString(this.repo);
        parcel.writeString(this.followers);
        parcel.writeString(this.following);
        parcel.writeString(this.company);
        parcel.writeString(this.lokasi);
        parcel.writeInt(foto);
    }

    Nama(){

    }

    private Nama(Parcel in) {
        this.nama = in.readString();
        this.username = in.readString();
        this.repo = in.readString();
        this.followers = in.readString();
        this.following = in.readString();
        this.company = in.readString();
        this.lokasi = in.readString();
        this.foto = in.readInt();
    }

    public static final Parcelable.Creator<Nama> CREATOR = new Parcelable.Creator<Nama>() {
        @Override
                public Nama createFromParcel(Parcel source){
            return new Nama(source);
        }
        @Override
                public Nama[] newArray(int size){
            return new Nama[size];
        }

    };


}
