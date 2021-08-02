package estructura.bdgapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ErrorActivity extends AppCompatActivity {
Button bttnError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        getSupportActionBar().hide();
        //TomarFoto();
        bttnError = (Button) findViewById(R.id.bttnError);
        bttnError.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ErrorActivity.this, MainActivity.class);
                startActivity(intent);
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
}
