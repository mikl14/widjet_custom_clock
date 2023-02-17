package com.example.widjet_test2;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Color_Picker_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Color_Picker_fragment extends Fragment {

    public static SeekBar Red,Blue,Green;
    String Font;
    TextView TextExample;

    public Color_Picker_fragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Color_Picker_fragment newInstance(String param1, String param2) {
        Color_Picker_fragment fragment = new Color_Picker_fragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onPause()
    {
        super.onPause();
        Save_Text_settings();
    }

    public void Save_Text_settings()
    {
        widjet_setings.Red = Red.getProgress();
        widjet_setings.Blue = Blue.getProgress();
        widjet_setings.Green = Green.getProgress();
        widjet_setings.Font = Font;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.color__picker_fragment, container, false);


        Red = view.findViewById(R.id.seekBar_Red);
        Blue = view.findViewById(R.id.seekBar_Blue);
        Green = view.findViewById(R.id.seekBar_Green);

        TextExample = view.findViewById(R.id.TextExample);
        Spinner dropdown = view.findViewById(R.id.font_pick);
        String[] items = new String[]{"sans-serif", "sans-serif-thin","sans-serif-black","sans-serif-condensed","sans-serif-condensed-light","sans-serif-light","sans-serif-medium","sans-serif-smallcaps","serif-monospace", "casual","cursive","monospace"};
        SpinnerAdapter adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Font = dropdown.getSelectedItem().toString();
                TextExample.setTypeface(Typeface.create(Font,Typeface.NORMAL));
                Save_Text_settings();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //TextExample.setTypeface(Typeface.create("sans-serif-medium",Typeface.NORMAL));
            }
        });

        SeekBar.OnSeekBarChangeListener changeListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextExample.setTextColor(Color.argb(255,Red.getProgress(),Green.getProgress(),Blue.getProgress()));
                Save_Text_settings();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        Font = widjet_setings.Font;
        dropdown.setSelection(Arrays.asList(items).indexOf(Font));
        TextExample.setTextColor(Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
        TextExample.setTypeface(Typeface.create(Font,Typeface.NORMAL));
        Red.setProgress(widjet_setings.Red);
        Green.setProgress(widjet_setings.Green);
        Blue.setProgress(widjet_setings.Blue); // ВАЖНО ПРИСВОИТЬ ДО ЛИСОНЕРА !!!


        Red.setOnSeekBarChangeListener(changeListener);
        Blue.setOnSeekBarChangeListener(changeListener);
        Green.setOnSeekBarChangeListener(changeListener);


        view.findViewById(R.id.BackButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(view).navigate(R.id.action_color_Picker_fragment_to_widjet_setings);

            }
        });


        return view;
    }


}