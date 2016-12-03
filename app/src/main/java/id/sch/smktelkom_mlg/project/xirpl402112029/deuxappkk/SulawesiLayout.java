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

import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.adapter.SulawesiAdapter;
import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.model.Sulawesi;

/**
 * Created by AS X550Z on 22/11/2016.
 * Class button Sulawesi
 */

public class SulawesiLayout extends AppCompatActivity implements SulawesiAdapter.ISulawesiAdapter {
    public static final String SULAWESI = "sulawesi";
    ArrayList<Sulawesi> mList = new ArrayList<>();
    SulawesiAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalimantan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Kalimantan");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new SulawesiAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();

    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.tempat2);
        String[] arDeskripsi = resources.getStringArray(R.array.tempat2_desc);
        String[] arDetail = resources.getStringArray(R.array.tempat2_details);
        String[] arLokasi = resources.getStringArray(R.array.tempat2_locations);
        TypedArray a = resources.obtainTypedArray(R.array.tempat2_picture);
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
            mList.add(new Sulawesi(arJudul[i], arDeskripsi[i], arFoto[i], arDetail[i], arLokasi[i]));
        }
        mAdapter.notifyDataSetChanged();
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
        Intent intent = new Intent(this, Detail2Activity.class);
        intent.putExtra(SULAWESI, mList.get(pos));
        startActivity(intent);
    }
}

