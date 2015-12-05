package com.russellitneng.rite;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class EmaiDialog extends DialogFragment  {

    ImageButton yes;
    ImageButton no;
    View view;

    /*TODO building a custom dialog fragment.. and using it*/

    //Comunicator comunicator;

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        comunicator = (Comunicator) activity;
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.email_dialog_layout, null);
//
//        yes = (ImageButton) view.findViewById(R.id.button_yes);
//        no = (ImageButton) view.findViewById(R.id.button_no);
//
//        yes.setOnClickListener(this);
//        no.setOnClickListener(this);
//
//        setCancelable(true);
//        return view;
//    }
//
//    @Override
//    public void onClick(View v) {
//        if(v.getId() == R.id.button_yes){
//            String uri = "mailto:a15shaafi.209@gmail.com";
//
//            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
//            sendIntent.setType("message/plain");
//            sendIntent.setData(Uri.parse(uri));
//            startActivity(sendIntent);
//
//            //comunicator.onClickEvent(this.getString(R.string.mail_yes));
//            dismiss();
//        }
//        else if (v.getId() == R.id.button_no){
//            comunicator.onClickEvent("Cancel Sending...");
//            dismiss();
//        }
//    }
//
//    interface Comunicator{
//        public void onClickEvent(String massage);
//    }


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
                Toast.makeText(getActivity(), "Cancel sending..", Toast.LENGTH_SHORT).show();
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
