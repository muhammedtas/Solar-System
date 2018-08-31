package bmi.it.sabanci.android_lab4_solarsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlanetDetailActivity extends AppCompatActivity {

    Planet planet;
    ImageView img;
    TextView txtdata;
    TextView txtcat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_detail);
        try {
            this.planet = (Planet)getIntent().getExtras().getSerializable("planet");
        }catch (Exception ex){
            Toast.makeText(PlanetDetailActivity.this, "Could'not get the Planet Details", Toast.LENGTH_SHORT).show();
        }
        try {
            img = findViewById(R.id.imgBigPlanet);
            txtdata = findViewById(R.id.txtData);
            txtcat = findViewById(R.id.txtCategory);

            img.setImageResource(planet.getImg());
            txtdata.setText(planet.getDescription());
            txtcat.setText(planet.getCategory());
        }catch(Exception ex){
            Toast.makeText(PlanetDetailActivity.this, "Could not set some parts in activity", Toast.LENGTH_SHORT).show();
        }
        try {
            getSupportActionBar().setTitle(planet.getName());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.arrow_up_float);
        }catch (Exception ex){
            Toast.makeText(PlanetDetailActivity.this, "Could not set Action bar", Toast.LENGTH_SHORT).show();
        }
    }
}
