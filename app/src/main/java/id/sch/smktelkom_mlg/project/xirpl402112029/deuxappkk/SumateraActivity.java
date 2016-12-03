package id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.adapter.SumateraAdapter;
import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.model.Sumatera;

public class SumateraActivity extends AppCompatActivity implements SumateraAdapter.ISumateraAdapter {
    public static final String SUMATERA = "sumatera";
    ArrayList<Sumatera> mSumatera = new ArrayList<>();
    SumateraAdapter mSumada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumatera);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mSumada = new SumateraAdapter(this, mSumatera);
        setTitle("Sumatera");
        recyclerView.setAdapter(mSumada);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.tempat1);
        String[] arDeskripsi = resources.getStringArray(R.array.tempat1_desc);
        String[] arDetail = resources.getStringArray(R.array.tempat1_details);
        String[] arLokasi = resources.getStringArray(R.array.tempat1_locations);
        TypedArray a = resources.obtainTypedArray(R.array.tempat1_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + "/"
                    + resources.getResourceTypeName(id) + "/"
                    + resources.getResourceEntryName(id)
            ;
        }
        a.recycle();
        for (int i = 0; i < arJudul.length; i++) {
            mSumatera.add(new Sumatera(arJudul[i], arDeskripsi[i], arFoto[i], arDetail[i], arLokasi[i]));
        }
        mSumada.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, Detail3Activity.class);
        intent.putExtra(SUMATERA, mSumatera.get(pos));
        startActivity(intent);
    }
}
