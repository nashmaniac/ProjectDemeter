package com.nashvail.projectdemeter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
* Class : MainFragment
* --------------------------------------------
* Holds the views for the main view of the app
 */

public class MainFragment extends Fragment {

    private TextView mAmountView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mAmountView = (TextView) v.findViewById(R.id.text_view_amount);

        // we will have to detect the swipes and taps on this view right here

        return v;
    }


}
