package artigas.com.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MascotasFavoritas5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas5);

        androidx.appcompat.widget.Toolbar miActionBarmascotaFavorita = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBarmascotaFavorita);
        setSupportActionBar (miActionBarmascotaFavorita);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }
}