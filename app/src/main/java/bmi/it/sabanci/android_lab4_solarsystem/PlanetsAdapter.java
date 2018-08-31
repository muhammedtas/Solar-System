package bmi.it.sabanci.android_lab4_solarsystem;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class PlanetsAdapter extends ArrayAdapter<Planet> {
    public PlanetsAdapter(@NonNull Context context, @NonNull List<Planet> objects) {  // int resource layout  id si veriyordu. Kaldırıyoruz.
        super(context, android.R.layout.simple_expandable_list_item_1, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {   // partial layout larımızı yüklediğimiz method budur. layoutları smooth bir şekilde yükleyeceğiz.
        // Holder pattern ile layoutları cache leyerek ekrana yüklüyoruz.
        // Bu pattern ile tag içerisinde cache liyoruz ekranlarımızı.
        View row = convertView; // row null sa layouttan çağırıyoruz. Doluysa
        PlanetViewHolder viewHolder = null;
        if (row==null){
            // Activity nin inflator ü var. Oradan çağıracağız.
            // Activity has a planetadapter, one to one ilişki var aralaraında.
            LayoutInflater inflator =((Activity)getContext()).getLayoutInflater();
            row =inflator.inflate(R.layout.planet_row_layout,parent,false); // bunu row a almalıyım
            viewHolder = new PlanetViewHolder(row);
            row.setTag(viewHolder); // Tag le holder ı koyduk row un içine. daha sonra getTag ile alacağız.
        }
        else{
                viewHolder = (PlanetViewHolder)row.getTag(); // Eğer varsa da get tag ile al row u ve viewHolder a ata.
        }
        viewHolder.getImgPlanet().setImageResource((getItem(position).getImg())); // Kaçıncı satırı çizdirmekle arraylist in içindeki data aynı. setImage i o yüzden hangi row u çiziyorsa unun
        // position unu veririz. // Bu resources planet in içerisindekiler.
        viewHolder.getTxtPlanetName().setText(getItem(position).getName());
        viewHolder.getTxtPlanetCat().setText(getItem(position).getCategory()); // Sonra o item in category bilgisini text ine atıyoruz.
        return row; // işte bir adet viewholder pattern i kullanan adaptör yazmış bulunduk.
    } // şimdi gidip ana activity e bu view dan instance alıp ekleyeceğiz oraya.


    class PlanetViewHolder{
        // Bunun ile main activity içerisinde itemlerimizi satır satır göstereceğiz.
        View base;
        // şimdi önce bir layout xml olulşturalım bunun için sonra dolduralım.
        ImageView imgPlanet;
        TextView txtPlanetName;
        TextView txtPlanetCat;

        public PlanetViewHolder(View base){
            this.base = base;
        }

        public ImageView getImgPlanet() {
            if (imgPlanet == null){
            imgPlanet = base.findViewById(R.id.imgplanet);
            }

            return imgPlanet;
        }

        public TextView getTxtPlanetCat() {

            if (txtPlanetCat == null){
                txtPlanetCat = base.findViewById(R.id.txtPlanetCat);

            }

            return txtPlanetCat;
        }

        public TextView getTxtPlanetName() {

            if (txtPlanetName == null){

                txtPlanetName = base.findViewById(R.id.txtPlanetName);
            }
            return txtPlanetName;
        }
    }
}
