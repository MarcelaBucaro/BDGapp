package estructura.bdgapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CodigoCamara extends AppCompatActivity {
    Button bttnSiguiente2;
    TextView textView2;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara_codigo);
        getSupportActionBar().hide();
        TomarFoto();
        dialog=new ProgressDialog(CodigoCamara.this);
        dialog.show();
        dialog.setContentView(R.layout.progress_dialog);
        dialog.getWindow().setBackgroundDrawableResource(
                android.R.color.darker_gray
        );
        Thread timer=new Thread(){
            @Override
            public void run() {
                try {
                    sleep(8000);
                    dialog.dismiss();
                    super.run();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };
        timer.start();
        bttnSiguiente2=(Button)findViewById(R.id.bttnSiguiente2);
        bttnSiguiente2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog=new ProgressDialog(CodigoCamara.this);
                Pantallas();
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

    protected void Pantallas(){
        Intent e = new Intent(CodigoCamara.this, FrontalCamara.class);
        startActivity(e);
        return;

    }
    //Metodo para cambiar acceso
    /*protected void Pantallas(){
        //boolean x=true;
        String numero = "3000123450101";
        Bundle bundle= getIntent().getExtras();
        String d2=bundle.getString("DPI").toString();
        if (d2.equals(numero)) {
            Intent i = new Intent(CodigoCamara.this, EntrarActivity.class);
            i.putExtra("DPI", textView2.getText().toString());
            startActivity(i);
            return;
        } else {
            Intent e = new Intent(CodigoCamara.this, ErrorActivity.class);
            startActivity(e);
            return;
        }
    }
    private void recibirDato(){

        textView2 = (TextView)findViewById(R.id.textView2);
        Bundle bundle= getIntent().getExtras();
        String d2=bundle.getString("DPI").toString();
        textView2.setText(d2);

    }*/
}
