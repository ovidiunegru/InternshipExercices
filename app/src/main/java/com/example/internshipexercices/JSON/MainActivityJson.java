package com.example.internshipexercices.JSON;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.internshipexercices.JSON.DownloadImageUtils.DownloaderUtil;
import com.example.internshipexercices.JSON.model.Post;
import com.example.internshipexercices.JSON.server.ServerProvider;
import com.example.internshipexercices.R;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityJson extends AppCompatActivity {
    private static final String TAG = "MainActivity2";
    private ImageView imageView;
    private Runnable downloadImage = new DownloadRunnable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_json);
        imageView= findViewById(R.id.imageViewJson);

        //getImageUsingThread();
//        getImageUsingExecutor();
        getPostAsynchronously();
    }


    class DownloadRunnable implements Runnable{
        @Override
        public void run() {
            Bitmap bitmap = DownloaderUtil.INSTANCE.downloadImage();
            runOnUiThread(()->imageView.setImageBitmap(bitmap));
        }
    }

    private void getImageUsingExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(downloadImage);
    }

    private void getImageUsingThread(){
        Thread thread= new Thread(downloadImage);
        thread.start();
    }

    private void getPostAsynchronously() {
        ServerProvider.createPostService().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                if(posts!=null)
                    Log.d(TAG, "there are " + posts.size());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e(TAG, "error trying to get posts");

            }
        });
    }

    private void getPostSynchronously() {
        try {
            Response<List<Post>> response = ServerProvider.createPostService().getPosts().execute();
            List<Post> posts= response.body(); //if null check needed
            if(posts!=null)
                Log.d(TAG, "there are " + posts.size());
        } catch (IOException e) {
            Log.e(TAG, "error trying to get posts");
        }
    }

}