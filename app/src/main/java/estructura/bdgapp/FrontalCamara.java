package estructura.bdgapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FrontalCamara extends AppCompatActivity {
    Button bttnSiguiente;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camara_frontal);
        getSupportActionBar().hide();
        //recibirDato();
        bttnSiguiente=(Button)findViewById(R.id.bttnSiguiente);
        bttnSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                //Pantallas();
                Intent e = new Intent(FrontalCamara.this, ErrorActivity.class);
                startActivity(e);
                return;
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
   /* protected void Pantallas(){
        //boolean x=true;
        String numero = "3000123450111";
        Bundle bundle= getIntent().getExtras();
        String d2=bundle.getString("DPI").toString();
        if (d2.equals(numero)) {
            Intent i = new Intent(FrontalCamara.this, EntrarActivity.class);
            i.putExtra("DPI", text.getText().toString());
            startActivity(i);
            return;
        } else {
            Intent e = new Intent(FrontalCamara.this, ErrorActivity.class);
            startActivity(e);
            return;
        }
    }*/
    private void recibirDato(){

        text = (TextView)findViewById(R.id.text);
        Bundle bundle= getIntent().getExtras();
        String d1=bundle.getString("DPI").toString();
        text.setText(d1);

    }

}
