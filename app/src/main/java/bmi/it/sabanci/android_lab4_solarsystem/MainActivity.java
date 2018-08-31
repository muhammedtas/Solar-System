package bmi.it.sabanci.android_lab4_solarsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    ListView lstPlanets;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            lstPlanets = findViewById(R.id.lstPlanets);

            PlanetsAdapter adp = new PlanetsAdapter(this,Planet.getAllPlanets()); // holder activity nin kenbdisi

            lstPlanets.setAdapter(adp);

        }catch (Exception ex){

            Toast.makeText(MainActivity.this, "Couldn not set PlanetAdapter to planet list", Toast.LENGTH_SHORT).show();


        }


        lstPlanets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try {
                    Intent i = new Intent(MainActivity.this, PlanetDetailActivity.class);
                    Planet planet = Planet.getAllPlanets().get(position);
                    //PlanetsAdapter pa = new PlanetsAdapter(position, view,planet));
                    //i.putExtra("planet",pa.getItem(position));
                    i.putExtra("planet",planet);
                    startActivity(i);
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "Please enter your value to convert...", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
