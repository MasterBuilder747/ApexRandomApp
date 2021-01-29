package com.masterbuilder747.apexrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //from java implementation
    String[] legends = {
            "Wraith",
            "Bangalore",
            "Gibraltar",
            "Lifeline",
            "Pathfinder",
            "Bloodhound",
            "Mirage",
            "Caustic",
            "Octane", //s1
            "Wattson", //s2
            "Crypto", //s3
            "Revenant", //s4
            "Loba", //s5
            "Rampart", //s6
            "Horizon" //s7
    };

    //high tier loot unless stated
    String[] map_kings = {
            "Airbase", //start high
            "Artillery Battery",
            "Bunker Pass",
            "Crypto's Map Room",
            "Destroyed Cascades",
            "Interstellar Relay",
            "Mirage Voyage",
            "Offshore Rig",
            "Repulsor",
            "Runoff",
            "Skull Salvage",
            "Singh Labs Interior",
            "Swamps",
            "Terminal Station F-85",
            "Terminal Station L-19",
            "Terminal Station O-240",
            "Terminal Station W-73",
            "The Pit",
            "Watchtower North",
            "Watchtower South",
            "Water Treatment", //end high
            "ARES Capacitor", //mid
            "Artillery Underpass",
            "Artillery Tunnel",
            "Broken Coast",
            "Broken Coast Overlook", //mid
            "Broken Coast South",
            "Cage", //mid
            "Capacitor Junction",
            "Capacitor Overlook", //mid
            "Capacitor Tunnel",
            "Caves",
            "Creature Containment", //mid
            "Crossroads",
            "Destroyed Bridges",
            "East Settlement",
            "The Farm", //mid
            "Golden Sands",
            "High Desert", //mid
            "Hillside Outpost", //mid
            "Hydro Dam",
            "Hydro Tunnel",
            "Hydro Tunnel",
            "Marketplace", //mid
            "Octane's Gauntlet", //mid
            "Offshore Rig Loading",
            "Reclaimed Forest",
            "River's End", //mid
            "River Center", //mid
            "Singh Labs", //mid
            "Suspended Skull",
            "Slum Lakes", //mid //will be removed in s8
            "Two Spines", //mid
            "Two Spines Outpost",
            "Waterfall" //mid
    };
    String[] map_worlds = {
            "Bloodhound's Trials", //high
            "Countdown", //high
            "Fragment East", //high
            "Harvester", //high
            "Launch Site", //high
            "Lava City", //high
            "Lava Fissure", //high
            "Overlook", //high
            "Refinery", //high
            "Staging", //high
            "Skyhook", //high
            "Sorting Factory", //high
            "Survey Camp", //high
            "Thermal Station", //high
            "The Dome", //high
            "The Epicenter", //high
            "The Geyser", //high
            "The Tree", //high
            "The Train Yard", //high
            "Fragment West", //mid
            "Spring's End", //mid
            "Hill Valley", //low
            "The Mining Pass", //low
            "The Rain Tunnel", //low
            "The Bridge" //low
    };
    String[] map_olympus = {
            "Autumn Estates",
            "Arcadia Supercarrier",
            "Docks",
            "Elysium",
            "Energy Depot",
            "Orbital Cannon Test Site",
            "Pathfinder's Fight Night",
            "Rift Aftermath",
            "Research Basin",
            "Central Turbine", //mid
            "Bonsai Plaza", //mid
            "Solar Array", //mid
            "The Reverie Lounge",
            "Velvet Oasis", //mid
            "Grow Towers", //mid
            "Golden Gardens", //mid
            "Hammond Labs", //mid
            "Primary Power Grid", //mid
            "Crossroads", //low
            "Defense Perimeter", //low
            "Farmstead", //low
            "Ivory Pass", //low
            "Lab Annex", //low
            "Maintenance", //low
            "Phase Gateway Central", //low
            "Phase Gateway West", //low
            "Secondary Power Grid", //low
            "Shipyard", //low
            "Supply Track", //low
            "Underpass", //low
            "Welcome Center", //low
            "Agriculture Entry", //low
            "Antechamber", //low
            "Wildflower Meadow", //low
            "Bonsai Hillside", //low
            //"Cargo Hold", //low //removed
            "Hydroponics" //?
    };

    //returns a random item from a given array
    public static String random(String[] a) {
        return a[(int)(Math.random() * a.length)];
    }

    RadioGroup radioGroup;
    RadioButton radioButton; //the selected radio button
    TextView character;
    TextView location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        character = findViewById(R.id.characterOutput);
        location = findViewById(R.id.locationOutput);

        radioGroup = findViewById(R.id.chooseMap);
        Button button = findViewById(R.id.newGameButton);
        button.setOnClickListener(v -> {
            //check the selected radio button, returns an id
            int radioID = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioID);

            //given the map selection, display the random location on text/image here
            String map = radioButton.getText().toString();
            if (map.contains("King")) {
                //Toast.makeText(this, "King", Toast.LENGTH_SHORT).show();
                character.setText(random(legends));
                location.setText(random(map_kings));
            } else if (map.contains("World")) {
                //Toast.makeText(this, "World", Toast.LENGTH_SHORT).show();
                character.setText(random(legends));
                location.setText(random(map_worlds));
            } else {
                //Toast.makeText(this, "Olympus", Toast.LENGTH_SHORT).show();
                character.setText(random(legends));
                location.setText(random(map_olympus));
            }
        });
    }

    public void checkButton(View v) {
        //only used for changing the radio button, on the radio button press
    }
}