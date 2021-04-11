package com.masterbuilder747.apexrandom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity {

    final public static int HIGH = 2;
    final public static int MID = 1;
    final public static int BASIC = 0;

    ArrayList<String> legSelection = new ArrayList<>();
    public ArrayList<String> getLegSelection() {
        return legSelection;
    }

    //map, (loot, location)
    //locations contain the name and the x and y percentages
    //static Map<Integer, HashMap<Integer, Location>> locations = new HashMap<>();

    //name, lootLvl, x, y
    // 0.0 <= x <= 1.0
    // 0.0 <= y <= 1.0
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
            new Location("Cage Crossing", BASIC, 0.601, 0.569),
            new Location("Capacitor Junction", BASIC, 0.765, 0.248),
            new Location("Capacitor Tunnel", BASIC, 0.894, 0.462),
            new Location("Caves", BASIC, 0.504, 0.664),
            new Location("Crossroads", BASIC, 0.194, 0.687),
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
            new Location("Bloodhound's Trials", HIGH, 0.073, 0.13),
            new Location("Countdown", HIGH, 0.167, 0.29),
            new Location("Fragment East", HIGH, 0.686, 0.393),
            new Location("Harvester", HIGH, 0.44, 0.62),
            new Location("Launch Site", HIGH, 0.563, 0.939),
            new Location("Lava City", HIGH, 0.9, 0.847),
            new Location("Lava Fissure", HIGH, 0.029, 0.323),
            new Location("Overlook", HIGH, 1.0, 0.343),
            new Location("Refinery", HIGH, 0.791, 0.08),
            new Location("Staging", HIGH, 0.208, 0.571),
            new Location("Skyhook", HIGH, 0.234, 0.147),
            new Location("Sorting Factory", HIGH, 0.586, 0.754),
            new Location("Survey Camp", HIGH, 0.48, 0.2),
            new Location("Thermal Station", HIGH, 0.158, 0.75),
            new Location("The Dome", HIGH, 0.8, 1.0),
            new Location("The Epicenter", HIGH, 0.686, 0.192),
            new Location("The Geyser", HIGH, 0.847, 0.604),
            new Location("The Tree", HIGH, 0.363, 0.872),
            new Location("The Train Yard", HIGH, 0.299, 0.426),

            new Location("Fragment West", MID, 0.56, 0.333),
            new Location("Spring's End", MID, 0.049, 0.498),

            new Location("Hill Valley", BASIC, 0.299, 0.318),
            new Location("The Bridge", BASIC, 0.276, 0.75),
            new Location("The Mining Pass", BASIC, 0.316, 0.511),
            new Location("The Rain Tunnel", BASIC, 0.478, 0.077)
    };

    static final Location[] map_olympus = {
            new Location("Autumn Estates", HIGH, 0.265, 0.529),
            new Location("Arcadia Supercarrier", HIGH, 0.25, 0.201),
            new Location("Docks", HIGH, 0.343, 0.035),
            new Location("Elysium", HIGH, 0.0, 0.686),
            new Location("Energy Depot", HIGH, 0.653, 0.39),
            new Location("Hydroponics", HIGH, 0.093, 0.772),
            new Location("Orbital Cannon Test Site", HIGH, 0.953, 0.831),
            new Location("Pathfinder's Fight Night", HIGH, 0.366, 0.198),
            new Location("Rift Aftermath", HIGH, 0.686, 0.213),
            new Location("Research Basin", HIGH, 0.504, 0.47),
            new Location("The Reverie Lounge", HIGH, 0.504, 0.973),

            new Location("Bonsai Plaza", MID, 0.57, 0.985),
            new Location("Central Turbine", MID, 0.44, 0.36),
            new Location("Grow Towers", MID, 0.859, 0.582),
            new Location("Golden Gardens", MID, 0.879, 0.396),
            new Location("Hammond Labs", MID, 0.55, 0.559),
            new Location("Primary Power Grid", MID, 0.521, 0.204),
            new Location("Power Station East", MID, 1.0, 0.292),
            new Location("Solar Array", MID, 0.63, 0.736),
            new Location("Velvet Oasis", MID, 0.1, 0.328),

            new Location("Agriculture Entry", BASIC, 0.158, 0.71),
            new Location("Antechamber", BASIC, 0.521, 0.328),
            new Location("Bonsai Hillside", BASIC, 0.54, 0.86),
            new Location("Crossroads", BASIC, 0.686, 0.825),
            new Location("Defense Perimeter", BASIC, 0.815, 0.834),
            new Location("Farmstead", BASIC, 0.046, 0.609),
            new Location("Ivory Pass", BASIC, 0.824, 0.689),
            new Location("Lab Annex", BASIC, 0.392, 0.573),
            new Location("Landing Pier", BASIC, 0.434, 0.0),
            new Location("Maintenance", BASIC, 0.48, 0.431),
            new Location("Oasis Villa", BASIC, 0.265, 0.35),
            new Location("Phase Gateway Central", BASIC, 0.686, 0.582),
            new Location("Phase Gateway West", BASIC, 0.192, 0.636),
            new Location("Secondary Power Grid", BASIC, 0.574, 0.068),
            new Location("Shipyard", BASIC, 0.563, 0.071),
            new Location("Supply Track", BASIC, 0.621, 0.286),
            new Location("Underpass", BASIC, 0.768, 0.352),
            new Location("Welcome Center", BASIC, 1.0, 0.464),
            new Location("Wildflower Meadow", BASIC, 0.346, 0.511),
    };

    //returns a random item from a given array
    public static <T> T random(ArrayList<T> a) {
        return a.get((int)(Math.random() * a.size()));
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

        //the ArrayList legSelection stores all characters by default,
        //this can change now based on the checkbox dialog window
        getLegSelection().add("Bangalore");
        getLegSelection().add("Gibraltar");
        getLegSelection().add("Lifeline");
        getLegSelection().add("Pathfinder");
        getLegSelection().add("Bloodhound");
        getLegSelection().add("Mirage");
        getLegSelection().add("Caustic");
        getLegSelection().add("Octane"); //s1
        getLegSelection().add("Wattson"); //s2
        getLegSelection().add("Crypto"); //s3
        getLegSelection().add("Revenant"); //s4
        getLegSelection().add("Loba"); //s5
        getLegSelection().add("Rampart"); //s6
        getLegSelection().add("Horizon"); //s7
        getLegSelection().add("Fuse"); //s8
        //getLegSelection().add("Valk"); //s9?

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
                character.setText(random(legSelection));
                String leg = character.getText().toString().toLowerCase();
                int id = getResources().getIdentifier(leg, "drawable", getPackageName());
                charImg.setImageResource(id);
            } else {
                //Use Alert dialog windows here
                Toast.makeText(this, "Randomization failed. At least one loot tier must be selected.", Toast.LENGTH_SHORT).show();
            }
        });

        charImg.setOnClickListener(v -> {
            
        });
    }
    public void displayCharacterDialog(View view) {
        //new CharacterSelectionDialog().show(getFragmentManager(), "character_selection_dialog");
    }

    public static Location randomLocation(Location[] a, boolean high, boolean mid, boolean basic) {
        ArrayList<Location> BList = new ArrayList<>();
        for (Location l : a) {
            if (high && l.loot == HIGH || mid && l.loot == MID || basic && l.loot == BASIC) {
                BList.add(l);
            }
        }
        return random(BList);
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