package com.russellitneng.rite;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class EmaiDialog extends DialogFragment implements View.OnClickListener {

    ImageButton yes;
    ImageButton no;
    Comunicator comunicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        comunicator = (Comunicator) activity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.email_dialog_layout, null);

        yes = (ImageButton) view.findViewById(R.id.button_yes);
        no = (ImageButton) view.findViewById(R.id.button_no);

        yes.setOnClickListener(this);
        no.setOnClickListener(this);

        setCancelable(true);
        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_yes){
            String uri = "mailto:a15shaafi.209@gmail.com";

            Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
            sendIntent.setType("message/plain");
            sendIntent.setData(Uri.parse(uri));
            startActivity(sendIntent);

            //comunicator.onClickEvent(this.getString(R.string.mail_yes));
            dismiss();
        }
        else if (v.getId() == R.id.button_no){
            comunicator.onClickEvent("Cancel Sending...");
            dismiss();
        }
    }

    interface Comunicator{
        public void onClickEvent(String massage);
    }
}
