package estructura.bdgapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaCamara extends AppCompatActivity {
    Button bttnSiguiente2;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara_segunda);
        TomarFoto();
        recibirDato();
        bttnSiguiente2=(Button)findViewById(R.id.bttnSiguiente2);
        bttnSiguiente2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Pantallas();
                return;
            }
        });
    }
    static final int REQUEST_TAKE_PHOTO = 1;

    private void TomarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_TAKE_PHOTO);
    }
    protected void Pantallas(){
        boolean x=false;
        if (x==true) {
            Intent i = new Intent(SegundaCamara.this, EntrarActivity.class);
            i.putExtra("DPI", textView2.getText().toString());
            startActivity(i);
            return;
        } if (x==false) {
            Intent e = new Intent(SegundaCamara.this, ErrorActivity.class);
            startActivity(e);
            return;
        }
    }
    private void recibirDato(){

        textView2 = (TextView)findViewById(R.id.textView2);
        Bundle bundle= getIntent().getExtras();
        String d2=bundle.getString("DPI").toString();
        textView2.setText(d2);

    }
}
