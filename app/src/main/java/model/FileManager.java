package model;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;

import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private static FileManager instance;
    private Uri selectedVideo;

    private FileManager() {

    }

    public Uri getSelectedVideo() {
        return selectedVideo;
    }

    public void setSelectedVideo(Uri selectedVideo) {
        this.selectedVideo = selectedVideo;
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }


}
