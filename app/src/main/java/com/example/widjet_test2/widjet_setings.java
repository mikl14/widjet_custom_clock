package com.example.widjet_test2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link widjet_setings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class widjet_setings extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static int Red = 0,Blue =0,Green = 0;
    public static String Font ="sans-serif";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public widjet_setings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment widjet_setings.
     */
    // TODO: Rename and change types and number of parameters
    public static widjet_setings newInstance(String param1, String param2) {
        widjet_setings fragment = new widjet_setings();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onPause()
    {
        super.onPause();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_widjet_setings, container, false);
        view.findViewById(R.id.buttonColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_widjet_setings_to_color_Picker_fragment);
            }
        });
        TextView clock = view.findViewById(R.id.Clock_example);
        clock.setTextColor(Color.argb(255,Red,Green,Blue));
        clock.setTypeface(Typeface.create(Font,Typeface.NORMAL));
        ImageView image = view.findViewById(R.id.imageView);
        image.setImageBitmap(widjetConfigureActivity.picture);
        return view;
    }
}