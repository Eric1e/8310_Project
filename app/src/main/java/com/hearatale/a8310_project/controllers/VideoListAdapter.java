package com.hearatale.a8310_project.controllers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hearatale.a8310_project.R;

import java.util.ArrayList;

import model.FileManager;
import model.Media;

public class VideoListAdapter extends RecyclerView.Adapter<VideoListAdapter.VideoListViewHolder> {

    private String path;
    private ArrayList<Media> mediaList;
    private String pre;
    private String title;

    public VideoListAdapter(String path, ArrayList<Media> mediaList, String pre, String title) {
        this.path = path;
        this.mediaList = mediaList;
        this.pre = pre;
        this.title = title;
    }

    //Setup view holder that will bind to the information
    @NonNull
    @Override
    public VideoListViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.video_list_row, viewGroup, false);
        return new VideoListViewHolder(view, pre);
    }

    //Attach the information to the created view holder
    @Override
    public void onBindViewHolder(@NonNull VideoListViewHolder viewHolder, int i) {
        Media media = mediaList.get(i);
        viewHolder.bind(media);
    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    //Builds upon recycler view to allow the scrolling of the list on screen
    public class VideoListViewHolder extends RecyclerView.ViewHolder {

        private ImageView thumbnail;
        private Media media;


        public VideoListViewHolder(@NonNull final View itemView, final String pre) {
            super(itemView);
            this.thumbnail = itemView.findViewById(R.id.thumbnail_list);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FileManager.getInstance().setSelectedVideo(media.getPath());
                    Intent intent = new Intent(itemView.getContext(), PlayVideoActivity.class);
                    intent.putExtra("category", pre);
                    intent.putExtra("title", title);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public ImageView getThumbnail() {
            return thumbnail;
        }

        public void bind(Media media) {
            this.media = media;
//            Bitmap b = ThumbnailUtils.createVideoThumbnail(media.getPath().toString(), MediaStore.Video.Thumbnails.MINI_KIND);
//            thumbnail.setImageBitmap(b);
        }
    }
}

