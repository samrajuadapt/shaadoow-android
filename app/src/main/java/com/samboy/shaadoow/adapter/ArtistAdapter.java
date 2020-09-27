package com.samboy.shaadoow.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.samboy.shaadoow.R;
import com.samboy.shaadoow.consts.SC;
import com.samboy.shaadoow.model.Artist;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistHolder> {
    private List<Artist> mList;

    public ArtistAdapter(List<Artist> mList) {
        this.mList = mList;
    }

    public void updateData(List<Artist> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArtistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ada_artist,parent,false);
        return new ArtistHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistHolder holder, int position) {
        holder.onBind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ArtistHolder extends RecyclerView.ViewHolder {
        private ImageView imgProfile;
        private TextView txtName;
        private TextView txtFollowers;
        public ArtistHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.adaArtistImage);
            txtName=itemView.findViewById(R.id.adaArtistName);
            txtFollowers=itemView.findViewById(R.id.adaArtistFollow);
        }

        private void onBind(Artist artist){
            Glide.with(itemView.getContext()).load(SC.ASSET_URL+artist.getProfileImage()).circleCrop().into(imgProfile);
            txtName.setText(artist.getName());
            txtFollowers.setText(String.valueOf(artist.getFollowers()));
        }
    }
}
