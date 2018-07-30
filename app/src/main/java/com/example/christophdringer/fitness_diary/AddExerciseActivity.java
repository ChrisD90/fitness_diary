package com.example.christophdringer.fitness_diary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddExerciseActivity extends AppCompatActivity {

    private ImageView imageView;
    File imageFile;
    String currentImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        imageView = findViewById(R.id.imageViewImage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(takePicture.resolveActivity(getPackageManager()) != null) {
                    imageFile = null;
                    try {
                        imageFile = createImageFile();
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                    if(imageFile != null) {
                        Uri imageUri = FileProvider.getUriForFile(getApplicationContext(),
                                "com.example.android.fileProvider",
                                imageFile);
                        takePicture.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                        startActivityForResult(takePicture, 1);
                    }
                }
            }
        });
    }

    public File createImageFile() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timestamp + "_";
        File storageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDirectory
        );

        currentImagePath = image.getAbsolutePath();
        return image;

    }

    public void createExercise(AppDatabase database) {
        TextView textViewName = findViewById(R.id.textViewName);

        Exercise exercise = new Exercise(textViewName.getText().toString());

    }


}
