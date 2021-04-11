package com.masterbuilder747.apexrandom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CharacterSelectionDialog extends DialogFragment {
    private List<String> legSelection;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        legSelection = new ArrayList<>();  // Where we track the selected items
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Set the dialog title
        builder.setTitle("Character Toggle")
            // Specify the list array, the items to be selected by default (null for none),
            // and the listener through which to receive callbacks when items are selected
            .setMultiChoiceItems(R.array.Legends, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        String[] items = getActivity().getResources().getStringArray(R.array.Legends);
                        if (isChecked) {
                            // If the user checked the item, add it to the selected items
                            legSelection.add(items[which]);
                        } else if (legSelection.contains(items[which])) {
                            // Else, if the item is already in the array, remove it
                            legSelection.remove(items[which]);
                        }
                    }
                })
            // Set the action buttons
            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog

                    //saves the selection of characters

                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    //discards the selection of characters

                }
            });
        return builder.create();
        //return super.onCreateDialog(savedInstanceState);
    }
}
