package com.russellitneng.rite;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class EmaiDialog extends DialogFragment  {

    ImageButton yes;
    ImageButton no;
    View view;

    /*TODO building a custom alert dialog*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Log.d("oncratedialog","oncrate");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.email_dialog_layout, null);

        builder.setTitle("Confirm");
        builder.setView(view);
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String uri = "mailto:russellitnengineering@gmail.com";
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
                sendIntent.setType("message/plain");
                sendIntent.setData(Uri.parse(uri));
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "feedback");
                startActivity(sendIntent);
            }
        });

        return builder.create();

    }
}
