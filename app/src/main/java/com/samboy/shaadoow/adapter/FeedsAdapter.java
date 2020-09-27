package com.samboy.shaadoow.adapter;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.util.Log;
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
import com.samboy.shaadoow.model.Feed;
import com.samboy.shaadoow.utils.Utils;

import java.util.List;

import okhttp3.internal.Util;

public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.FeedHolder> {

    private List<Feed> mList;

    public FeedsAdapter(List<Feed> mList) {
        this.mList = mList;
    }

    public void updateData(List<Feed> mList){
        this.mList = mList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ada_feed,parent,false);
        return new FeedHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedHolder holder, int position) {
        holder.onBind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class FeedHolder extends RecyclerView.ViewHolder {
        private ImageView imgProfile;
        private ImageView imgVip;
        private ImageView imgContent;
        private ImageView imgLike;

        private TextView txtName;
        private TextView txtTime;
        private TextView txtDesc;
        private TextView txtLike;
        private TextView txtComment;

        public FeedHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.adaFeedProfileImg);
            imgVip = itemView.findViewById(R.id.adaFeedVip);
            imgContent = itemView.findViewById(R.id.adaFeedImage);
            imgLike = itemView.findViewById(R.id.adaFeedThumb);

            txtName = itemView.findViewById(R.id.adaFeedProfileName);
            txtTime = itemView.findViewById(R.id.adaFeedTime);
            txtDesc = itemView.findViewById(R.id.adaFeedContent);
            txtLike = itemView.findViewById(R.id.adaFeedLikes);
            txtComment = itemView.findViewById(R.id.adaFeedComment);
        }

        private void onBind(Feed feed){
            Glide.with(itemView.getContext()).load(SC.ASSET_URL+feed.createdBy.getProfileImage()).circleCrop().into(imgProfile);
            Glide.with(itemView.getContext()).load(SC.ASSET_URL+feed.recordingDetails.getCoverImage()).into(imgContent);
            imgVip.setVisibility(feed.createdBy.isVip()?View.VISIBLE:View.GONE);
            imgLike.setImageDrawable(feed.is_liked?getImage(R.drawable.ic_thumb_up):getImage(R.drawable.ic_outline_thumb));

            txtName.setText(feed.createdBy.getName());
            txtTime.setText(Utils.covertTimeToText(feed.createdAt));
            txtDesc.setText(feed.recordingDetails.getDescription());
            txtLike.setText(String.valueOf(feed.getInteractionCounter().likes)+" Likes");
            txtComment.setText(String.valueOf(feed.getInteractionCounter().comments)+" Comments");


        }

        @SuppressLint("UseCompatLoadingForDrawables")
        private Drawable getImage(int resId){
            return itemView.getContext().getResources().getDrawable(resId,null);
        }
    }
}
