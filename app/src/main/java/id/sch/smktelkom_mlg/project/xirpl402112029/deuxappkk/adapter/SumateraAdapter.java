package id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.R;
import id.sch.smktelkom_mlg.project.xirpl402112029.deuxappkk.model.Sumatera;

/**
 * Created by SUPER USER on 22/11/2016.
 */

public class SumateraAdapter extends RecyclerView.Adapter<SumateraAdapter.ViewHolder> {

    ArrayList<Sumatera> sumateraList;

    public SumateraAdapter(ArrayList<Sumatera> sumateraList) {

        this.sumateraList = sumateraList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list3, parent, false);
        SumateraAdapter.ViewHolder vh = new SumateraAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Sumatera sumatera = sumateraList.get(position);
        holder.tvJudul.setText(sumatera.judul);
        holder.tvDeskripsi.setText(sumatera.deskripsi);
        holder.ivFoto.setImageDrawable(sumatera.foto);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
        }
    }
}
