package com.soosalu_simsel.elunautleja_app.utils;

import android.content.Context;
import android.util.Log;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.soosalu_simsel.elunautleja_app.model.JsonActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Utils {
    private List<JsonActivity> activities;

    public final List getToDosFromJsonFile(Context context, String fileName) {
        if(context != null) {
            try {
                InputStream jsonStream = context.getAssets().open(fileName);
                Reader reader = (Reader) (new InputStreamReader(jsonStream, StandardCharsets.UTF_8));
                activities = new Gson().fromJson(reader, new TypeToken<List<JsonActivity>>(){}.getType());
                reader.close();
            } catch (IOException ex) {
                Log.e("Utils.class: Stream error - ", ex.toString());
            }
        }
        return activities;
    }
}
