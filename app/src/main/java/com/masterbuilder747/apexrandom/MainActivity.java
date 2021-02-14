package com.masterbuilder747.apexrandom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final public static int HIGH = 2;
    final public static int MID = 1;
    final public static int BASIC = 0;

    final public static int KINGS = 1;
    final public static int WORLDS = 2;
    final public static int OLYMPUS = 3;

    static final String[] legends = {
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

    //map, (loot, location)
    //locations contain the name and the x and y percentages
    //static Map<Integer, HashMap<Integer, Location>> locations = new HashMap<>();

    //name, x, y, lootLvl
    static final Location[] map_kings = {
            new Location("Airbase", HIGH), //start high
            new Location("Artillery Battery", HIGH),
            new Location("Bunker Pass", HIGH),
            new Location("Crashed Ship", HIGH),
            new Location("Crash Site", HIGH),
            new Location("Crypto's Map Room", HIGH),
            new Location("High Desert", HIGH),
            new Location("Interstellar Relay", HIGH),
            new Location("Mirage Voyage", HIGH),
            new Location("Offshore Rig", HIGH),
            new Location("Repulsor", HIGH),
            new Location("Runoff", HIGH),
            new Location("Skull Salvage", HIGH),
            new Location("Singh Labs Interior", HIGH),
            new Location("Spotted Lakes", HIGH),
            new Location("Swamps", HIGH),
//            "Terminal Station F-85",
//            "Terminal Station L-19",
//            "Terminal Station O-240",
//            "Terminal Station W-73",
            new Location("The Pit", HIGH),
            new Location("Watchtower North", HIGH),
            new Location("Watchtower South", HIGH),
            new Location("Water Treatment", HIGH),
            new Location("Water Treatment", HIGH), //end high
            new Location("ARES Capacitor", MID), //start mid
            new Location("Broken Coast Overlook", MID),
            new Location("Cage", MID),
            new Location("Capacitor Overlook", MID),
            new Location("Creature Containment", MID),
            new Location("Destroyed Cascades", MID),
            new Location("Hillside Outpost", MID),
            new Location("Lagoon Crossing", MID),
            new Location("Marketplace", MID),
            new Location("Octane's Gauntlet", MID),
            new Location("River Center", MID),
            new Location("Singh Labs", MID),
//            "Slum Lakes",
            new Location("Two Spines", MID),
            new Location("Two Spines Outpost", MID),
            new Location("Verdant Crossing", MID), //end mid
            new Location("Artillery Underpass", BASIC), //start basic
            new Location("Broken Coast", BASIC),
            new Location("Broken Coast South", BASIC),
            new Location("Cage Crossing", BASIC),
            new Location("Capacitor Junction", BASIC),
            new Location("Capacitor Tunnel", BASIC),
            new Location("Caves", BASIC),
            new Location("Crossroads", BASIC),
            new Location("Destroyed Artillery Tunnel", BASIC),
            new Location("Destroyed Bridges", BASIC),
            new Location("East Settlement", BASIC),
            new Location("Golden Sands", BASIC),
            new Location("Hydro Dam", BASIC),
            new Location("Hydro Tunnel", BASIC),
            new Location("Offshore Rig Loading", BASIC),
            new Location("Reclaimed Forest", BASIC),
            new Location("Suspended Skull", BASIC),
            new Location("Uncovered Bones", BASIC) //end basic
//            "Waterfall",
//            "The Farm",
//            "River's End",
    };
    static final Location[] map_worlds = {
            new Location("Bloodhound's Trials", HIGH), //start high
            new Location("Countdown", HIGH),
            new Location("Fragment East", HIGH),
            new Location("Harvester", HIGH),
            new Location("Launch Site", HIGH),
            new Location("Lava City", HIGH),
            new Location("Lava Fissure", HIGH),
            new Location("Overlook", HIGH),
            new Location("Refinery", HIGH),
            new Location("Staging", HIGH),
            new Location("Skyhook", HIGH),
            new Location("Sorting Factory", HIGH),
            new Location("Survey Camp", HIGH),
            new Location("Thermal Station", HIGH),
            new Location("The Dome", HIGH),
            new Location("The Epicenter", HIGH),
            new Location("The Geyser", HIGH),
            new Location("The Tree", HIGH),
            new Location("The Train Yard", HIGH), //end high
            new Location("Fragment West", MID), //mid
            new Location("Spring's End", MID), //mid
            new Location("Hill Valley", BASIC), //basic
            new Location("The Bridge", BASIC), //basic
            new Location("The Mining Pass", BASIC), //basic
            new Location("The Rain Tunnel", BASIC) //basic
    };
    static final Location[] map_olympus = {
            new Location("Autumn Estates", HIGH), //start high
            new Location("Arcadia Supercarrier", HIGH),
            new Location("Docks", HIGH),
            new Location("Elysium", HIGH),
            new Location("Energy Depot", HIGH),
            new Location("Orbital Cannon Test Site", HIGH),
            new Location("Pathfinder's Fight Night", HIGH),
            new Location("Rift Aftermath", HIGH),
            new Location("Research Basin", HIGH),
            new Location("The Reverie Lounge", HIGH), //end high
            new Location("Bonsai Plaza", MID), //start mid
            new Location("Central Turbine", MID),
            new Location("Grow Towers", MID),
            new Location("Golden Gardens", MID),
            new Location("Hammond Labs", MID),
            new Location("Primary Power Grid", MID),
            new Location("Solar Array", MID),
            new Location("Velvet Oasis", MID), //end mid
            new Location("Agriculture Entry", BASIC), //start basic
            new Location("Antechamber", BASIC),
            new Location("Bonsai Hillside", BASIC),
            //"Cargo Hold",
            new Location("Crossroads", BASIC),
            new Location("Defense Perimeter", BASIC),
            new Location("Farmstead", BASIC),
            new Location("Ivory Pass", BASIC),
            new Location("Lab Annex", BASIC),
            new Location("Maintenance", BASIC),
            new Location("Phase Gateway Central", BASIC),
            new Location("Phase Gateway West", BASIC),
            new Location("Secondary Power Grid", BASIC),
            new Location("Shipyard", BASIC),
            new Location("Supply Track", BASIC),
            new Location("Underpass", BASIC),
            new Location("Welcome Center", BASIC),
            new Location("Wildflower Meadow", BASIC), //end basic
            new Location("Hydroponics") //?
    };

    //the final random list once filtering is complete
    static Location[] locations;

    //returns a random item from a given array
    public static <T> T random(T[] a) {
        return a[(int)(Math.random() * a.length)];
    }

    RadioGroup radioGroup; //the group of radioButtons, there is only 1
    RadioButton radioButton; //the selected radio button, 1 out of the possible 3
    TextView character; //text outputs
    TextView location;
    ImageView charImg; //image outputs
    ImageView mapImg;
    ImageView markImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //get resources
        character = findViewById(R.id.characterOutput);
        location = findViewById(R.id.locationOutput);

        charImg = findViewById(R.id.characterImg);
        mapImg = findViewById(R.id.mapImg);
        markImg = findViewById(R.id.markerImg);

        //update the imageViews to show default images
        mapImg.setImageResource(R.drawable.kingscanyonzoom);
        charImg.setImageResource(R.drawable.defaultchoose);
        markImg.setImageResource(R.drawable.marker);

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
                Location k = random(map_kings);
                location.setText(k.name);
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) markImg.getLayoutParams();
                params.horizontalBias = (float)k.x;
                params.verticalBias = (float)k.y;
                markImg.setLayoutParams(params);
            } else if (map.contains("World")) {

            } else {

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