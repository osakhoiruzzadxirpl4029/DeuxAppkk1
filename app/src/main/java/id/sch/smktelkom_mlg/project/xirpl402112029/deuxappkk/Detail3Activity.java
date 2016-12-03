package id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.model.Sumatera;

public class Detail3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Sumatera sumatera = (Sumatera) getIntent().getSerializableExtra(SumateraActivity.SUMATERA);
        setTitle(sumatera.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto3);
        ivFoto.setImageURI(Uri.parse(sumatera.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.place_detail);
        tvDeskripsi.setText(sumatera.deskripsi + "\n\n" + sumatera.detail);
        TextView tvLokasi = (TextView) findViewById(R.id.place_location);
        tvLokasi.setText(sumatera.lokasi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}
