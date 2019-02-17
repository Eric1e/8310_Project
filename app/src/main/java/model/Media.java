package model;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;

import com.hearatale.a8310_project.R;

import java.util.ArrayList;

public class Media {

    private String title;
    private Uri path;
    private Bitmap thumbnail;
    private ArrayList<String> quizPaths;

    public Media(String path) {
        this.path = Uri.parse("android.resource://com.hearatale.a8310_project/" + path);
        this.thumbnail = ThumbnailUtils.createVideoThumbnail(path, MediaStore.Video.Thumbnails.MINI_KIND);
    }

    public String getTitle() {
        return title;
    }

    public Uri getPath() {
        return path;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public ArrayList<String> getQuizPaths() {
        return quizPaths;
    }
}
