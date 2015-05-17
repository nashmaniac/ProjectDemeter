package com.nashvail.projectdemeter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/*
* Class : MainFragment
* --------------------------------------------
* Holds the views for the main view of the app
 */

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
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

        new SwipeDetector(mAmountView).setOnSwipeListener(new SwipeDetector.onSwipeEvent(){
            @Override
            public void SwipeEventDetected(View v, SwipeDetector.SwipeTypeEnum swipeType) {
                if(swipeType == SwipeDetector.SwipeTypeEnum.LEFT_TO_RIGHT)
                    Toast.makeText(getActivity(), "The number will be increased", Toast.LENGTH_SHORT).show();
                else if(swipeType == SwipeDetector.SwipeTypeEnum.RIGHT_TO_LEFT)
                    Toast.makeText(getActivity(), "The number will be decreased", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }


}
