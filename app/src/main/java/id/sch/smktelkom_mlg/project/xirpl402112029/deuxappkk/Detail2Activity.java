package id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.model.Sulawesi;

public class Detail2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Sulawesi sulawesi = (Sulawesi) getIntent().getSerializableExtra(SulawesiLayout.SULAWESI);
        setTitle(sulawesi.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto2);
        ivFoto.setImageURI(Uri.parse(sulawesi.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.place_detail);
        tvDeskripsi.setText(sulawesi.deskripsi + "\n\n" + sulawesi.detail);
        TextView tvLokasi = (TextView) findViewById(R.id.place_location);
        tvLokasi.setText(sulawesi.lokasi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}
