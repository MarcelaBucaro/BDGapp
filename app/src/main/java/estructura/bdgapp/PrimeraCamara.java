package estructura.bdgapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrimeraCamara extends AppCompatActivity {
    Button bttnSiguiente1;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara_primera);
        getSupportActionBar().hide();
        TomarFoto();
        recibirDato();
        bttnSiguiente1=(Button)findViewById(R.id.bttnSiguiente);
        bttnSiguiente1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                Intent p1 = new Intent(PrimeraCamara.this, CodigoCamara.class);
                p1.putExtra("DPI", text.getText().toString());
                startActivity(p1);
                return;
            }
            });
    }

    @Override
    public void onBackPressed() {
    }

    static final int REQUEST_TAKE_PHOTO = 1;

    private void TomarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
    }
    private void recibirDato(){

        text = (TextView)findViewById(R.id.text);
        Bundle bundle= getIntent().getExtras();
        String d1=bundle.getString("DPI").toString();
        text.setText(d1);

    }
}
