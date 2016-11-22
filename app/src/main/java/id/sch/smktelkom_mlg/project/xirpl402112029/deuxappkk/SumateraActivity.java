package id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.adapter.SumateraAdapter;
import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.model.Sumatera;

public class SumateraActivity extends AppCompatActivity {
    ArrayList<Sumatera> mSumatera = new ArrayList<>();
    SumateraAdapter mSumada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumatera);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mSumada = new SumateraAdapter(mSumatera);
        recyclerView.setAdapter(mSumada);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.tempat1);
        String[] arDeskripsi = resources.getStringArray(R.array.tempat1_desc);
        TypedArray a = resources.obtainTypedArray(R.array.tempat1_details);
        Drawable[] arFoto = new Drawable[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            BitmapDrawable bd = (BitmapDrawable) a.getDrawable(i);
            RoundedBitmapDrawable rbd = RoundedBitmapDrawableFactory.create(getResources(), bd.getBitmap());
            rbd.setCircular(true);
            arFoto[i] = rbd;
        }
        a.recycle();
        for (int i = 0; i < arJudul.length; i++) {
            mSumatera.add(new Sumatera(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mSumada.notifyDataSetChanged();
    }
}
