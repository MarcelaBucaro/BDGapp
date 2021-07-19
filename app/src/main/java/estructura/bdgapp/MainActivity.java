package estructura.bdgapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity{

    Button buttonEntrar;
    EditText cajaDpi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        buttonEntrar = (Button) findViewById(R.id.buttonEntrar);
        cajaDpi = (EditText) findViewById(R.id.txtDpi);
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String DPI = cajaDpi.getText().toString();
                if (DPI.length() < 13) {
                    makeText(MainActivity.this, "Ingrese su DPI", Toast.LENGTH_LONG).show();
                } else {
                    Intent p = new Intent(MainActivity.this, FrontalCamara.class);
                    p.putExtra("DPI", cajaDpi.getText().toString());
                    startActivity(p);
                    return;
                    }
                }
            });
        }


    protected void Pantallas(){
        boolean x=true;
        if (x==true) {
            Intent i = new Intent(MainActivity.this, EntrarActivity.class);
            i.putExtra("DPI", cajaDpi.getText().toString());
            startActivity(i);
            return;
        } if (x==false) {
            Intent e = new Intent(MainActivity.this, ErrorActivity.class);
            startActivity(e);
            return;
        }
    }
}