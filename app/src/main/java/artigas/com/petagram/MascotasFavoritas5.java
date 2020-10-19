package artigas.com.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MascotasFavoritas5 extends AppCompatActivity {

    ArrayList<Mascota> mascotasFavoritasList;


    private RecyclerView mRecyclerViewFavorita;
    private RecyclerView.Adapter mAdapterFavorita;
    private RecyclerView.LayoutManager mLayoutManagerFavorita;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas5);

        androidx.appcompat.widget.Toolbar miActionBarmascotaFavorita = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBarmascotaFavorita);
        setSupportActionBar (miActionBarmascotaFavorita);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mascotasFavoritasList = getIntent().getParcelableArrayListExtra("MascotasFavoritas");

        buildRecyclerViewFavoritas();

    }

    public void buildRecyclerViewFavoritas(){

        mRecyclerViewFavorita = (RecyclerView) findViewById(R.id.rvMascotasFavoritas);
        mRecyclerViewFavorita.setHasFixedSize(true);

        mLayoutManagerFavorita = new LinearLayoutManager(this);
        ((LinearLayoutManager) mLayoutManagerFavorita).setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewFavorita.setLayoutManager(mLayoutManagerFavorita);

        mAdapterFavorita = new MascotaAdaptador(mascotasFavoritasList);
        mRecyclerViewFavorita.setAdapter(mAdapterFavorita);

    }


}