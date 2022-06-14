package com.rikal.dicodingtest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvNama;

    private ArrayList<Nama> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNama = findViewById(R.id.dicoding);
        rvNama.setHasFixedSize(true);

        list.addAll(getListName());
        showRecyclerList();

    }

    public ArrayList<Nama> getListName(){
        String[] dataName = getResources().getStringArray(R.array.name);
        String[] dataUserName = getResources().getStringArray(R.array.username);
        String[] dataRepo = getResources().getStringArray(R.array.repository);
        String[] dataFollowers = getResources().getStringArray(R.array.followers);
        String[] dataFollowing = getResources().getStringArray(R.array.following);
        String[] dataCompany = getResources().getStringArray(R.array.company);
        String[] dataLocation = getResources().getStringArray(R.array.location);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.avatar);

        ArrayList<Nama> listNama = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            Nama nama = new Nama();
            nama.setNama(dataName[i]);
            nama.setUsername(dataUserName[i]);
            nama.setRepo(dataRepo[i]);
            nama.setFollowers(dataFollowers[i]);
            nama.setFollowing(dataFollowing[i]);
            nama.setCompany(dataCompany[i]);
            nama.setLokasi(dataLocation[i]);
            nama.setFoto(dataPhoto.getResourceId(i, -1));

            listNama.add(nama);
        }
        return listNama;
    }

    private void showRecyclerList(){
        rvNama.setLayoutManager(new LinearLayoutManager(this));
        ListNameAdapter listNameAdapter = new ListNameAdapter(list);
        rvNama.setAdapter(listNameAdapter);

        listNameAdapter.setOnItemClickCallback(data -> showSelectedName(data));

    }

    private void showSelectedName(Nama nama){
        Toast.makeText(this, nama.getNama(), Toast.LENGTH_SHORT).show();


        Nama person = new Nama();
        person.setNama(nama.getNama());
        person.setUsername(nama.getUsername());
        person.setRepo(nama.getRepo());
        person.setFollowers(nama.getFollowers());
        person.setFollowing(nama.getFollowing());
        person.setLokasi(nama.getLokasi());
        person.setCompany(nama.getCompany());
        person.setFoto(nama.getFoto());

        Intent moveIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
        moveIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
        startActivity(moveIntent);


    }
}