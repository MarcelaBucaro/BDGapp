package estructura.bdgapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.widget.Toast.makeText;

public class EntrarActivity extends AppCompatActivity {

    TextView txtDpiEnter;
    TextView txtNameEnter;
    ProgressDialog dialog;
    private ImageView img;
  //  Button bttnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        TomarFoto();
        getSupportActionBar().hide();
        dialog=new ProgressDialog(EntrarActivity.this);
        dialog.show();
        dialog.setContentView(R.layout.progress_dialog);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.darker_gray
        );
        Thread timer=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3500);
                    dialog.dismiss();
                    super.run();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        timer.start();
        img=(ImageView)findViewById(R.id.imageView2);
        if (ContextCompat.checkSelfPermission(EntrarActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(EntrarActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(EntrarActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }
        txtDpiEnter = (TextView)findViewById(R.id.txtDpiEnter);
        txtNameEnter = (TextView)findViewById(R.id.txtNombreEnter);
        String nameEx="Rosa Ramirez";
        txtNameEnter.setText(nameEx);

        final int dpi = getIntent().getIntExtra("DPI", 0);
        Intent intent = getIntent();
        String dpiEx = "";
        // Validar que este llegando
        if (intent != null && intent.hasExtra("DPI")) {
            //  get del parametro
            dpiEx = intent.getStringExtra("DPI");
        }
        //Mensaje a mostrar
        txtDpiEnter.setText(dpiEx);

        //Boton cerrar
       /* bttnContinuar = (Button) findViewById(R.id.bttnContinuar);
        bttnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });*/

    }

    //Metodo para nombre de fotografia
    String currentPhotoPath;
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onBackPressed() {
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    private void TomarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);

    }

    static final int REQUEST_IMAGE_CAPTURE=1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            img.setImageBitmap(imageBitmap);
        }
    }

}
