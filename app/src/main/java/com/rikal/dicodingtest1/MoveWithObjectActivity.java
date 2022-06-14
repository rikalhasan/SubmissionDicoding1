package com.rikal.dicodingtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        TextView tvNama = findViewById(R.id.detail_name);
        TextView tvUserName = findViewById(R.id.detail_username);
        TextView tvRepository = findViewById(R.id.detail_repository);
        TextView tvFollowers = findViewById(R.id.detail_followers);
        TextView tvFollowing = findViewById(R.id.detail_following);
        TextView tvCompany = findViewById(R.id.detail_company);
        TextView tvAlamat = findViewById(R.id.detail_location);
        ImageView ivPhoto = findViewById(R.id.detail_photo);


        Nama nama = getIntent().getParcelableExtra(EXTRA_PERSON);

        String textNama = nama.getNama();
        String textUsername = nama.getUsername();
        String textRepository = nama.getRepo();
        String textFollowers = nama.getFollowers();
        String textFollowing = nama.getFollowing();
        String textCompany = nama.getCompany();
        String textLokasi = nama.getLokasi();
        Integer photo = nama.getFoto();


        tvNama.setText(textNama);
        tvUserName.setText("Username : " + textUsername);
        tvRepository.setText("Repository : " + textRepository);
        tvFollowers.setText("Followers : " + textFollowers);
        tvFollowing.setText("Following : " + textFollowing);
        tvCompany.setText("Company : " + textCompany);
        tvAlamat.setText("Location : " + textLokasi);
        ivPhoto.setImageResource(photo);

    }
}