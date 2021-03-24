package com.masterbuilder747.apexrandom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final public static int HIGH = 2;
    final public static int MID = 1;
    final public static int BASIC = 0;

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

    //name, lootLvl, x, y
    // 0 <= x <= 1
    // 0 <= y <= 1
    static final Location[] map_kings = {
            new Location("Airbase", HIGH, 0.029, 0.586),
            new Location("Artillery Battery", HIGH, 0.521, 0.095),
            new Location("Bunker Pass", HIGH, 0.351, 0.485),
            new Location("Caustic Treatment", HIGH, 0.586, 1.0),
            new Location("Crashed Ship", HIGH, 0.316, 0.0),
            new Location("Crash Site", HIGH, 0.410, 0.0),
            new Location("Crypto's Map Room", HIGH, 0.847, 0.921),
            new Location("High Desert", HIGH, 0.164, 0.526),
            new Location("Interstellar Relay", HIGH, 0.859, 0.182),
            //new Location("Mirage Voyage", HIGH, 0.272, 0.881),
            new Location("Offshore Rig", HIGH, 1.0, 0.228),
            new Location("Repulsor", HIGH, 0.862, 0.8),
            new Location("Runoff", HIGH, 0.049, 0.39),
            new Location("Skull Salvage", HIGH, 0.363, 0.791),
            new Location("Singh Labs Interior", HIGH, 0.891, 0.468),
            new Location("Swamps", HIGH, 1.0, 0.638),
            new Location("The Pit", HIGH, 0.187, 0.317),
            new Location("Watchtower North", HIGH, 0.457, 0.219),
            new Location("Watchtower South", HIGH, 0.686, 0.841),
//            "Terminal Station F-85",
//            "Terminal Station L-19",
//            "Terminal Station O-240",
//            "Terminal Station W-73",

            new Location("ARES Capacitor", MID, 0.859, 0.378),
            new Location("Broken Coast Overlook", MID, 0.208, 0.696),
            new Location("Cage", MID, 0.697, 0.583),
            new Location("Capacitor Overlook", MID, 0.765, 0.41),
            new Location("Creature Containment", MID, 0.369, 0.28),
            new Location("Destroyed Cascades", MID,  0.29, 0.372),
            new Location("Hillside Outpost", MID, 0.521, 0.404),
            new Location("Lagoon Crossing", MID, 0.434, 0.369),
            new Location("Marketplace", MID, 0.492, 0.734),
            new Location("Octane's Gauntlet", MID, 0.114, 0.763),
            new Location("River Center", MID, 0.392, 0.488),
            new Location("Singh Labs", MID, 0.891, 0.526),
            new Location("Spotted Lake", MID, 0.12, 0.193),
            new Location("Two Spines", MID, 0.686, 0.312),
            new Location("Two Spines Outpost", MID, 0.588, 0.416),
            new Location("Verdant Crossing", MID, 0.565, 0.881),

            new Location("Artillery Underpass", BASIC, 0.51, 0.164),
            new Location("Broken Coast", BASIC, 0.334, 0.69),
            new Location("Broken Coast South", BASIC, 0.492, 0.973),
            new Location("Cage Crossing", BASIC, 0.724, 0.499),
            new Location("Capacitor Junction", BASIC, 0.765, 0.248),
            new Location("Capacitor Tunnel", BASIC, 0.894, 0.462),
            new Location("Caves", BASIC, 0.504, 0.664),
            new Location("Crossroads", BASIC, 0.492, 0.497), //PLEASE CONFIRM, NOT CORRECT LOCATION
            new Location("Destroyed Artillery Tunnel", BASIC, 0.424, 0.101),
            new Location("Destroyed Bridges", BASIC, 0.601, 0.604),
            new Location("East Settlement", BASIC, 0.444, 0.825),
            new Location("Golden Sands", BASIC, 0.299, 0.592),
            new Location("Hydro Dam", BASIC, 0.859, 0.664),
            new Location("Hydro Tunnel", BASIC, 0.768, 0.661),
            new Location("Offshore Rig Loading", BASIC, 1.0, 0.361),
            new Location("Reclaimed Forest", BASIC, 0.953, 0.598),
            new Location("Suspended Skull", BASIC, 0.29, 0.783),
            new Location("Uncovered Bones", BASIC, 0.114, 0.294)
    };

    static final Location[] map_worlds = {
            new Location("Bloodhound's Trials", HIGH),
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
            new Location("The Train Yard", HIGH),

            new Location("Fragment West", MID),
            new Location("Spring's End", MID),

            new Location("Hill Valley", BASIC),
            new Location("The Bridge", BASIC),
            new Location("The Mining Pass", BASIC),
            new Location("The Rain Tunnel", BASIC)
    };

    static final Location[] map_olympus = {
            new Location("Autumn Estates", HIGH),
            new Location("Arcadia Supercarrier", HIGH),
            new Location("Docks", HIGH),
            new Location("Elysium", HIGH),
            new Location("Energy Depot", HIGH),
            new Location("Hydroponics", HIGH),
            new Location("Orbital Cannon Test Site", HIGH),
            new Location("Pathfinder's Fight Night", HIGH),
            new Location("Rift Aftermath", HIGH),
            new Location("Research Basin", HIGH),
            new Location("The Reverie Lounge", HIGH),

            new Location("Bonsai Plaza", MID),
            new Location("Central Turbine", MID),
            new Location("Grow Towers", MID),
            new Location("Golden Gardens", MID),
            new Location("Hammond Labs", MID),
            new Location("Primary Power Grid", MID),
            new Location("Solar Array", MID),
            new Location("Velvet Oasis", MID),

            new Location("Agriculture Entry", BASIC),
            new Location("Antechamber", BASIC),
            new Location("Bonsai Hillside", BASIC),
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
            new Location("Wildflower Meadow", BASIC),
    };

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
    CheckBox highChk; //check boxes
    CheckBox midChk;
    CheckBox basicChk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get resources
        //radio buttons
        radioGroup = findViewById(R.id.chooseMap);
        Button button = findViewById(R.id.newGameButton);
        //text views
        character = findViewById(R.id.characterOutput);
        location = findViewById(R.id.locationOutput);
        //image views
        charImg = findViewById(R.id.characterImg);
        mapImg = findViewById(R.id.mapImg);
        markImg = findViewById(R.id.markerImg);
        //check boxes
        highChk = findViewById(R.id.high_box);
        midChk = findViewById(R.id.mid_box);
        basicChk = findViewById(R.id.basic_box);

        //update the imageViews to show default images
        mapImg.setImageResource(R.drawable.kingscanyonzoom);
        charImg.setImageResource(R.drawable.defaultchoose);
        markImg.setImageResource(R.drawable.marker);

        button.setOnClickListener(v -> {
            //random map location process
            //check the selected radio button, returns an id
            if (!(!highChk.isChecked() && !midChk.isChecked() && !basicChk.isChecked())) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioID);
                String map = radioButton.getText().toString();
                Location k;
                if (map.contains("King")) {
                    //Toast.makeText(this, "King", Toast.LENGTH_SHORT).show();
                    k = randomLocation(map_kings, highChk.isChecked(), midChk.isChecked(), basicChk.isChecked());
                } else if (map.contains("World")) {
                    k = randomLocation(map_worlds, highChk.isChecked(), midChk.isChecked(), basicChk.isChecked());
                } else {
                    k = randomLocation(map_olympus, highChk.isChecked(), midChk.isChecked(), basicChk.isChecked());
                }
                markImg.setVisibility(View.VISIBLE);
                location.setText(k.name);
                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) markImg.getLayoutParams();
                params.horizontalBias = (float) k.x;
                params.verticalBias = (float) k.y;
                markImg.setLayoutParams(params);

                //random character process
                character.setText(random(legends));
                String leg = character.getText().toString().toLowerCase();
                int id = getResources().getIdentifier(leg, "drawable", getPackageName());
                charImg.setImageResource(id);
            } else {
                //Use Alert dialog windows here
                Toast.makeText(this, "Randomization failed. At least one loot tier must be selected.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Location randomLocation(Location[] a, boolean high, boolean mid, boolean basic) {
        Location output;
        Location[] AList;
        ArrayList<Location> BList = new ArrayList<>();
        for (Location l : a) {
            if (high && l.loot == HIGH || mid && l.loot == MID || basic && l.loot == BASIC) {
                BList.add(l);
            }
        }
        AList = new Location[BList.size()];
        AList = BList.toArray(AList);
        output = random(AList);
        return output;
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