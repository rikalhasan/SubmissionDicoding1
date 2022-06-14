package com.rikal.dicodingtest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListNameAdapter extends RecyclerView.Adapter<ListNameAdapter.ListNameHolder> {
   private ArrayList<Nama> listNama;

   public ListNameAdapter(ArrayList<Nama> list){
       this.listNama= list;
   }

    @NonNull
    @Override
    public ListNameHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_user, parent, false);
        return new ListNameHolder(view);
    }

    private OnItemClickCallback onItemClickCallback;

       public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
           this.onItemClickCallback = onItemClickCallback;
       }

       public interface OnItemClickCallback {
           void onItemClicked(Nama data);
       }
    @Override
    public void onBindViewHolder(@NonNull ListNameHolder holder, int position) {
        Nama nama = listNama.get(position);
        holder.imgFoto.setImageResource(nama.getFoto());
        holder.tvNama.setText(nama.getNama());
        holder.tvLocation.setText(nama.getLokasi());
        holder.tvCompany.setText(nama.getCompany());

        holder.itemView.setOnClickListener(v -> onItemClickCallback.onItemClicked(listNama.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return listNama.size();
    }

    public class ListNameHolder extends RecyclerView.ViewHolder{
       ImageView imgFoto;
       TextView tvNama, tvLocation, tvCompany;

        public ListNameHolder(View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_item_name);
            tvCompany = itemView.findViewById(R.id.tv_item_company);
            tvLocation = itemView.findViewById(R.id.tv_item_location);
        }
    }


}
