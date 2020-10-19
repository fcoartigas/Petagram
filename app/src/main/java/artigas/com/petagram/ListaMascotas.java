package artigas.com.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;



public class ListaMascotas extends AppCompatActivity {

    ArrayList<Mascota> mascotasList;

    private RecyclerView mRecyclerView;
    private MascotaAdaptador mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TASK_LIST = "taskList";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        androidx.appcompat.widget.Toolbar miActionBarlistaMascota = (androidx.appcompat.widget.Toolbar) findViewById(R.id.miActionBarlistaMascota);
        setSupportActionBar (miActionBarlistaMascota);

        loadData();
        buildRecyclerView();

    }

    private void saveData(){
        SharedPreferences mSharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        Gson gson = new Gson();
        String mJson = gson.toJson(mascotasList);
        mEditor.putString(TASK_LIST,mJson);
        mEditor.apply();
    }

    private void loadData(){
        SharedPreferences mSharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        Gson gson = new Gson();
        String mJson = mSharedPreferences.getString(TASK_LIST,null);
        Type mType = new TypeToken<ArrayList<Mascota>>() {}.getType();
        mascotasList = gson.fromJson(mJson,mType);

        if (mascotasList == null) {
            mascotasList = new ArrayList<Mascota>();
            mascotasList.add(new Mascota(R.drawable.pet1, R.mipmap.bone_like,"Catty",0, R.mipmap.bone_count));
            mascotasList.add(new Mascota(R.drawable.pet2, R.mipmap.bone_like, "Ronny",0, R.mipmap.bone_count));
            mascotasList.add(new Mascota(R.drawable.pet3, R.mipmap.bone_like, "Stark",0, R.mipmap.bone_count));
            mascotasList.add(new Mascota(R.drawable.pet4, R.mipmap.bone_like, "Jack",0, R.mipmap.bone_count));
            mascotasList.add(new Mascota(R.drawable.pet5, R.mipmap.bone_like, "Spartacus",0, R.mipmap.bone_count));
            mascotasList.add(new Mascota(R.drawable.pet6, R.mipmap.bone_like, "Romeo",0, R.mipmap.bone_count));
            mascotasList.add(new Mascota(R.drawable.pet7, R.mipmap.bone_like, "Conan",0, R.mipmap.bone_count));
        }
     }

    public void irMascotasFavoritas5(View v) {
        saveData();
        Intent intent = new Intent(this,MascotasFavoritas5.class);
        intent.putParcelableArrayListExtra("MascotasFavoritas", mascotasList);
        startActivityForResult(intent,1);
    }


    public void updateLikecount(int position){
        mascotasList.get(position).updatebtncount();
        mAdapter.notifyItemChanged(position);
    }


    public void buildRecyclerView(){

        mRecyclerView = (RecyclerView) findViewById(R.id.rvMascotas);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MascotaAdaptador(mascotasList);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MascotaAdaptador.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                updateLikecount(position);
            }
        });

    }

}