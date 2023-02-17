package com.example.widjet_test2;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import android.os.Bundle;

import com.example.widjet_test2.databinding.WidjetConfigureBinding;

import java.io.IOException;

/**
 * The configuration screen for the {@link widjet widjet} AppWidget.
 */
public class widjetConfigureActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "com.example.widjet_test2.widjet";
    private static final String PREF_PREFIX_KEY = "appwidget_";
    int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;

    EditText mAppWidgetText;
    public static Uri background_picture_path ;
    public static Bitmap picture;
    boolean ss;


    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            final Context context = widjetConfigureActivity.this;

            // When the button is clicked, store the string locally
            String widgetText ;
           // saveTitlePref(context, mAppWidgetId, widgetText);

            saveTitlePref(context, mAppWidgetId, "color"); //цвет сохранить

            // It is the responsibility of the configuration activity to update the app widget
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
            widjet.updateAppWidget(context, appWidgetManager, mAppWidgetId);

            // Make sure we pass back the original appWidgetId
            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, mAppWidgetId);
            setResult(RESULT_OK, resultValue);
            finish();
        }
    };
    private WidjetConfigureBinding binding;

    public widjetConfigureActivity() {
        super();
    }

    // Write the prefix to the SharedPreferences object for this widget
    static void saveTitlePref(Context context, int appWidgetId, String text) {

        SharedPreferences.Editor prefs = context.getSharedPreferences(PREFS_NAME, 0).edit();
        prefs.putString(PREF_PREFIX_KEY + appWidgetId, text);
        prefs.apply();
    }

    // Read the prefix from the SharedPreferences object for this widget.
    // If there is no preference saved, get the default from a resource
    static String loadTitlePref(Context context, int appWidgetId) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, 0);
        String titleValue = prefs.getString(PREF_PREFIX_KEY + appWidgetId, null);
        if (titleValue != null) {
            return titleValue;
        } else {
            return "meme";
        }
    }

    static void deleteTitlePref(Context context, int appWidgetId) {
        SharedPreferences.Editor prefs = context.getSharedPreferences(PREFS_NAME, 0).edit();
        prefs.remove(PREF_PREFIX_KEY + appWidgetId);
        prefs.apply();
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // Set the result to CANCELED.  This will cause the widget host to cancel
        // out of the widget placement if the user presses the back button.
        setResult(RESULT_CANCELED);

        binding = WidjetConfigureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       // mAppWidgetText = binding.appwidgetText;


        // Find the widget id from the intent.
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            mAppWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        }

        // If this activity was started with an intent without an app widget ID, finish with an error.
        if (mAppWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
            finish();
            return;
        }

        //mAppWidgetText.setText(loadTitlePref(widjetConfigureActivity.this, mAppWidgetId));
    }
    @Override
    public void onResume() {
        super.onResume();
        onFragmentLoad();

    }
    @Override
    public void onPause() {
        super.onPause();


    }
    @Override
    public void onStop() {
        super.onStop();

    }
    @Override
    public void onRestart() {
        super.onRestart();

    }


    int requestcode = 1;


    public void onActivityResult(int requestcode,int resultCode,Intent data)
    {
        super.onActivityResult(requestcode,resultCode,data);

        Context context = getApplicationContext();
        if(requestcode == requestcode && resultCode == Activity.RESULT_OK)
        {
            if(data == null)
            {
                return;
            }
            Uri uri = data.getData();
            background_picture_path = uri;
            load_prev_pic();

        }

    }



    public void onFragmentLoad()
    {
       // System.out.println("click");
        findViewById(R.id.add_button).setOnClickListener(mOnClickListener);
    }
    public void load_prev_pic()
    {
        ImageView ss = findViewById(R.id.imageView);
        //ss.setImageURI(background_picture_path);

        Bitmap bits = null;
        try {bits = MediaStore.Images.Media.getBitmap(this.getContentResolver(), background_picture_path);} catch (IOException e) {e.printStackTrace();};
        ss.setImageBitmap(getRoundedCornerBitmap(bits,50));
        picture = getRoundedCornerBitmap(bits,50);
        Toast.makeText(getApplicationContext(),background_picture_path.getPath(),Toast.LENGTH_SHORT).show();
    }
    public void openfilechooser(View view)
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");

        startActivityForResult(intent,requestcode);

      //  Intent cropIntent = new Intent("com.android.camera.action.CROP");

    }



    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

}