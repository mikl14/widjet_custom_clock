package com.example.widjet_test2;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link widjetConfigureActivity widjetConfigureActivity}
 */
public class widjet extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        String widgetText = widjetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widjet);
        //views.setTextColor(R.id.appwidget_clock,Parce.Color widgetText);


        System.out.println(widgetText);
        if(widgetText != "meme")
        {
            views.setImageViewBitmap(R.id.imageView2,widjetConfigureActivity.picture);
            views.setTextColor(R.id.appwidget_clock,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_sans_serif_thin,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_sans_serif_black,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_sans_serif_condensed,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_sans_serif_condensed_light,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_sans_serif_light,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_sans_serif_medium,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_sans_serif_smallcaps,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_serif_monospace,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_casual,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_cursive,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));
            views.setTextColor(R.id.appwidget_clock_monospace,Color.argb(255,widjet_setings.Red,widjet_setings.Green,widjet_setings.Blue));

            if(widjet_setings.Font != "sans-serif") {views.setViewVisibility(R.id.appwidget_clock, View.GONE);}
            if(widjet_setings.Font != "sans-serif-thin") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_thin, View.GONE);}
            if(widjet_setings.Font != "sans-serif-black") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_black, View.GONE);}
            if(widjet_setings.Font != "sans-serif-condensed") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_condensed, View.GONE);}
            if(widjet_setings.Font != "sans-serif-condensed-light") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_condensed_light, View.GONE);}
            if(widjet_setings.Font != "sans-serif-light") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_light, View.GONE);}
            if(widjet_setings.Font != "sans-serif-medium") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_medium, View.GONE);}
            if(widjet_setings.Font != "sans-serif-smallcaps") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_smallcaps, View.GONE);}
            if(widjet_setings.Font != "serif-monospace") {views.setViewVisibility(R.id.appwidget_clock_serif_monospace, View.GONE);}
            if(widjet_setings.Font != "casual") {views.setViewVisibility(R.id.appwidget_clock_casual, View.GONE);}
            if(widjet_setings.Font != "cursive") {views.setViewVisibility(R.id.appwidget_clock_cursive, View.GONE);}
            if(widjet_setings.Font != "monospace") {views.setViewVisibility(R.id.appwidget_clock_monospace, View.GONE);}

            if(widjet_setings.Font == "sans-serif") {views.setViewVisibility(R.id.appwidget_clock, View.VISIBLE);}
            if(widjet_setings.Font == "sans-serif-thin") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_thin, View.VISIBLE);}
            if(widjet_setings.Font == "sans-serif-black") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_black, View.VISIBLE);}
            if(widjet_setings.Font == "sans-serif-condensed") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_condensed, View.VISIBLE);}
            if(widjet_setings.Font == "sans-serif-condensed-light") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_condensed_light, View.VISIBLE);}
            if(widjet_setings.Font == "sans-serif-light") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_light, View.VISIBLE);}
            if(widjet_setings.Font == "sans-serif-medium") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_medium, View.VISIBLE);}
            if(widjet_setings.Font == "sans-serif-smallcaps") {views.setViewVisibility(R.id.appwidget_clock_sans_serif_smallcaps,View.VISIBLE);}
            if(widjet_setings.Font == "serif-monospace") {views.setViewVisibility(R.id.appwidget_clock_serif_monospace, View.VISIBLE);}
            if(widjet_setings.Font == "casual") {views.setViewVisibility(R.id.appwidget_clock_casual, View.VISIBLE);}
            if(widjet_setings.Font == "cursive") {views.setViewVisibility(R.id.appwidget_clock_cursive, View.VISIBLE);}
            if(widjet_setings.Font == "monospace") {views.setViewVisibility(R.id.appwidget_clock_monospace, View.VISIBLE);}
            //views.setInt(R.id.background,"setBackgroundResource", R.drawable.test1);  //замена картинки
        }
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            widjetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}