package artigas.com.petagram;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        //mascotaViewHolder.btnLikeVote.setImageResource(mascota.getBtnLikevote());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvLikeCountCV.setText(""+mascota.getNumeroLikes());
        //mascotaViewHolder.btnLikeCount.setImageResource(mascota.getBtnLikecount());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private ImageButton btnLikeVote;
        private TextView tvNombreCV;
        private TextView tvLikeCountCV;
        private ImageButton btnLikeCount;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            btnLikeVote   = (ImageButton)  itemView.findViewById(R.id.btnLikeVote);
            tvNombreCV    = (TextView)  itemView.findViewById(R.id.tvNombreCV);
            tvLikeCountCV = (TextView)  itemView.findViewById(R.id.tvLikeCountCV);
            btnLikeCount  = (ImageButton)  itemView.findViewById(R.id.btnLikecount);
        }
    }

}
