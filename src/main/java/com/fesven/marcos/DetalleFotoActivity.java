package com.fesven.marcos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class DetalleFotoActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView imageViewFoto;
    private Button btnCompartir;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_foto);

        bindUI();
    }

    private void bindUI(){
        imageViewFoto = findViewById(R.id.imageViewFoto);
        btnCompartir = findViewById(R.id.btnCompartir);
        btnCompartir.setOnClickListener(this);
        loadData();
    }

    public void loadData(){
        bitmap = FotoSingleton.getInstance().getBitmap();
        imageViewFoto.setImageBitmap(bitmap);
    }

    @Override
    public void onClick(View view) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(),
                bitmap, "Title", null);
        Uri imageUri =  Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(share, "Select"));
    }

}
