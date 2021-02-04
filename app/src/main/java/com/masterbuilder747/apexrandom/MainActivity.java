package com.masterbuilder747.apexrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
            "Horizon", //s7
            "Fuse" //s8
    };

    //high tier loot unless stated
    String[] map_kings = {
            "Airbase", //start high
            "Artillery Battery",
            "Bunker Pass",
            "Crashed Ship",
            "Crash Site",
            "Crypto's Map Room",
            "High Desert",
            "Interstellar Relay",
            "Mirage Voyage",
            "Offshore Rig",
            "Repulsor",
            "Runoff",
            "Skull Salvage",
            "Singh Labs Interior",
            "Spotted Lakes",
            "Swamps",
//            "Terminal Station F-85",
//            "Terminal Station L-19",
//            "Terminal Station O-240",
//            "Terminal Station W-73",
            "The Pit",
            "Watchtower North",
            "Watchtower South",
            "Water Treatment", //end high
            "ARES Capacitor", //start mid
            "Broken Coast Overlook",
            "Cage",
            "Capacitor Overlook",
            "Creature Containment",
            "Destroyed Cascades",
            "Hillside Outpost",
            "Lagoon Crossing",
            "Marketplace",
            "Octane's Gauntlet",
            "River Center",
            "Singh Labs",
//            "Slum Lakes",
            "Two Spines",
            "Two Spines Outpost",
            "Verdant Crossing", //end mid
            "Artillery Underpass", //start basic
            "Broken Coast",
            "Broken Coast South",
            "Cage Crossing",
            "Capacitor Junction",
            "Capacitor Tunnel",
            "Caves",
            "Crossroads",
            "Destroyed Artillery Tunnel",
            "Destroyed Bridges",
            "East Settlement",
            "Golden Sands",
            "Hydro Dam",
            "Hydro Tunnel",
            "Offshore Rig Loading",
            "Reclaimed Forest",
            "Suspended Skull",
            "Uncovered Bones" //end basic
//            "Waterfall",
//            "The Farm",
//            "River's End",
    };
    String[] map_worlds = {
            "Bloodhound's Trials", //start high
            "Countdown",
            "Fragment East",
            "Harvester",
            "Launch Site",
            "Lava City",
            "Lava Fissure",
            "Overlook",
            "Refinery",
            "Staging",
            "Skyhook",
            "Sorting Factory",
            "Survey Camp",
            "Thermal Station",
            "The Dome",
            "The Epicenter",
            "The Geyser",
            "The Tree",
            "The Train Yard", //end high
            "Fragment West", //mid
            "Spring's End", //mid
            "Hill Valley", //basic
            "The Bridge", //basic
            "The Mining Pass", //basic
            "The Rain Tunnel" //basic
    };
    String[] map_olympus = {
            "Autumn Estates", //start high
            "Arcadia Supercarrier",
            "Docks",
            "Elysium",
            "Energy Depot",
            "Orbital Cannon Test Site",
            "Pathfinder's Fight Night",
            "Rift Aftermath",
            "Research Basin",
            "The Reverie Lounge", //end high
            "Bonsai Plaza", //start mid
            "Central Turbine",
            "Grow Towers",
            "Golden Gardens",
            "Hammond Labs",
            "Primary Power Grid",
            "Solar Array",
            "Velvet Oasis", //end mid
            "Agriculture Entry", //start basic
            "Antechamber",
            "Bonsai Hillside",
            //"Cargo Hold",
            "Crossroads",
            "Defense Perimeter",
            "Farmstead",
            "Ivory Pass",
            "Lab Annex",
            "Maintenance",
            "Phase Gateway Central",
            "Phase Gateway West",
            "Secondary Power Grid",
            "Shipyard",
            "Supply Track",
            "Underpass",
            "Welcome Center",
            "Wildflower Meadow", //end basic
            "Hydroponics" //?
    };

    //returns a random item from a given array
    public static String random(String[] a) {
        return a[(int)(Math.random() * a.length)];
    }

    RadioGroup radioGroup; //the group of radioButtons, there is only 1
    RadioButton radioButton; //the selected radio button, 1 out of the possible 3
    TextView character; //text outputs
    TextView location;
    ImageView charImg; //image outputs
    ImageView mapImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get resources
        character = findViewById(R.id.characterOutput);
        location = findViewById(R.id.locationOutput);

        charImg = findViewById(R.id.characterImg);
        mapImg = findViewById(R.id.mapImg);

        //update the imageViews to show default images
        mapImg.setImageResource(R.drawable.kingscanyonzoom);
        charImg.setImageResource(R.drawable.defaultchoose);

        //button action
        radioGroup = findViewById(R.id.chooseMap);
        Button button = findViewById(R.id.newGameButton);
        button.setOnClickListener(v -> {

            //random map location process
            //check the selected radio button, returns an id
            int radioID = radioGroup.getCheckedRadioButtonId();
            radioButton = findViewById(radioID);
            String map = radioButton.getText().toString();
            if (map.contains("King")) {
                //Toast.makeText(this, "King", Toast.LENGTH_SHORT).show();
                location.setText(random(map_kings));
            } else if (map.contains("World")) {
                //Toast.makeText(this, "World", Toast.LENGTH_SHORT).show();
                location.setText(random(map_worlds));
            } else {
                //Toast.makeText(this, "Olympus", Toast.LENGTH_SHORT).show();
                location.setText(random(map_olympus));
            }

            //random character process
            character.setText(random(legends));
            String leg = character.getText().toString().toLowerCase();
            int id = getResources().getIdentifier(leg, "drawable", getPackageName());
            charImg.setImageResource(id);

        });
    }

    public void checkButton(View v) {
        //only used for changing the radio button, on the radio button press
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        String map = radioButton.getText().toString();
        if (map.contains("King")) {
            mapImg.setImageResource(R.drawable.kingscanyonzoom);
        } else if (map.contains("World")) {
            mapImg.setImageResource(R.drawable.worldsedgezoom);
        } else {
            mapImg.setImageResource(R.drawable.olympuszoom);
        }
    }
}