package artigas.com.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ListaMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        androidx.appcompat.widget.Toolbar miActionBarlistaMascota = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBarlistaMascota);
        setSupportActionBar (miActionBarlistaMascota);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void irMascotasFavoritas5(View v) {
        Intent intent = new Intent(this,MascotasFavoritas5.class);
        startActivity(intent);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.pet1, R.mipmap.bone_like,"Catty",0, R.mipmap.bone_count));
        mascotas.add(new Mascota(R.drawable.pet2, R.mipmap.bone_like, "Ronny",0, R.mipmap.bone_count));
        mascotas.add(new Mascota(R.drawable.pet3, R.mipmap.bone_like, "Stark",0, R.mipmap.bone_count));
        mascotas.add(new Mascota(R.drawable.pet4, R.mipmap.bone_like, "Jack",0, R.mipmap.bone_count));
        mascotas.add(new Mascota(R.drawable.pet5, R.mipmap.bone_like, "Spartacus",0, R.mipmap.bone_count));
        mascotas.add(new Mascota(R.drawable.pet6, R.mipmap.bone_like, "Romeo",0, R.mipmap.bone_count));
        mascotas.add(new Mascota(R.drawable.pet7, R.mipmap.bone_like, "Conan",0, R.mipmap.bone_count));
    }

}