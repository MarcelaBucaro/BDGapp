package estructura.bdgapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import static android.widget.Toast.makeText;

public class EntrarActivity extends AppCompatActivity {

    TextView txtDpiEnter;
    Button bttnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        TomarFoto();
        txtDpiEnter = (TextView)findViewById(R.id.txtDpiEnter);

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
        bttnContinuar = (Button) findViewById(R.id.bttnContinuar);
        bttnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
    static final int REQUEST_TAKE_PHOTO = 1;

    private void TomarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);

    }

}
