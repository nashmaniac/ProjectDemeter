package com.nashvail.projectdemeter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
* Class : MainFragment
* --------------------------------------------
* Holds the views for the main view of the app
 */

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private EditText mAmountView;

    private static final int DECREASE = -1;
    private static final int INCREASE = 1;
    private static final int SMALL_STEP = 5;
    private static final int LARGE_STEP = 10;


    public MainFragment() {
        // Required empty public constructor
        // If you didn't already know the tree traversals are of 3 types
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mAmountView = (EditText) v.findViewById(R.id.text_view_amount);

        mAmountView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getActivity(), "The field will be reset soon", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        new SwipeDetector(mAmountView).setOnSwipeListener(new SwipeDetector.onSwipeEvent(){
            // This becomes an anonymous inner interface in this case
            @Override
            public void SwipeEventDetected(View v, SwipeDetector.SwipeTypeEnum swipeType) {
                if (swipeType == SwipeDetector.SwipeTypeEnum.LEFT_TO_RIGHT) {
                    changeAmountInView(LARGE_STEP, DECREASE);
                } else if (swipeType == SwipeDetector.SwipeTypeEnum.RIGHT_TO_LEFT) {
                    changeAmountInView(LARGE_STEP, INCREASE);
                } else if(swipeType == SwipeDetector.SwipeTypeEnum.BOTTOM_TO_TOP){
                    changeAmountInView(SMALL_STEP, INCREASE);
                }else{
                    changeAmountInView(SMALL_STEP,DECREASE);
                }
            }
        });

        return v;
    }

    /*
    * Function : changeAmountInView(amount to change by, increase or decrease)
    * ------------------------------------------------------------------------
    * Changes the amount visible in the Text View in the app by the difference
    * that is equal to what is supplied as the first argument
    * INCREASE = 1, DECREASE = -1, are initialized as constants
    * In the second argument if INCREASE(1) is supplied then increases the amount in
    * the view by the supplied amount, if DECREASE(-1) is supplied then decreases the amount
    *
    * Avoids going negative.
    */

    private void changeAmountInView(int changeBy, int increaseOrDecrease) {
        int currentAmount = (int) Integer.parseInt(mAmountView.getText().toString());
        // increaseOrDecrease can hold a value of only 1 or -1
        int newAmount = currentAmount + ((changeBy) * increaseOrDecrease);
        if(newAmount < 0) return;

        mAmountView.setText(Integer.toString(newAmount));
    }


}
