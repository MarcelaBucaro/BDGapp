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
        recibirDato();
        bttnSiguiente=(Button)findViewById(R.id.bttnSiguiente);
        bttnSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                Intent p1 = new Intent(FrontalCamara.this, PrimeraCamara.class);
                p1.putExtra("DPI", text.getText().toString());
                startActivity(p1);
                return;
            }
        });
    }

    private void recibirDato(){

        text = (TextView)findViewById(R.id.text);
        Bundle bundle= getIntent().getExtras();
        String d1=bundle.getString("DPI").toString();
        text.setText(d1);

    }

}
