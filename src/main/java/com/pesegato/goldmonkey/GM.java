
package com.pesegato.goldmonkey;

import com.google.gson.Gson;
import com.jme3.math.ColorRGBA;
import model.builders.definitions.BuilderManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class GM {

    public static Logger log = LoggerFactory.getLogger(GM.class);

    private static HashMap<String, ColorRGBA> colorRGBAs;

    public static ColorRGBA getColor(String id) {
        if (colorRGBAs == null) {
            try {
                colorRGBAs = new HashMap<>();
                GoldColorRGBA[] data = new Gson().fromJson(new FileReader("assets/GoldMonkey/ColorRGBA.json"), GoldColorRGBA[].class);
                for (GoldColorRGBA c : data) {
                    colorRGBAs.put(c.id, c.getColorRGBA());
                }
            } catch (FileNotFoundException ex) {
                log.error(null, ex);
            }
        }
        return colorRGBAs.get(id);
    }

    private static HashMap<String, String> strings;

    public static String getStringG(String id) {
        if (strings == null) {
            try {
                strings = new HashMap<>();
                GoldString[] data = new Gson().fromJson(new FileReader("assets/GoldMonkey/String.json"), GoldString[].class);
                for (GoldString c : data) {
                    strings.put(c.id, c.string);
                }
            } catch (FileNotFoundException ex) {
                log.error(null, ex);
            }
        }
        return strings.get(id);
    }

    public static ColorRGBA getColorRGBA(String id){
        return ((ColorBuilder)BuilderManager.getBuilder("com.pesegato.goldmonkey.ColorBuilder",id, ColorBuilder.class)).buildColorRGBA();
    }
    public static boolean existsData(String id) {
        try {
            DataBuilder d = ((DataBuilder) BuilderManager.getBuilder("com.pesegato.goldmonkey.DataBuilder", id, DataBuilder.class));
            return true;
        } catch (java.lang.IllegalArgumentException e) {
            return false;
        }
    }
    public static boolean getBool(String id){
        return ((DataBuilder)BuilderManager.getBuilder("com.pesegato.goldmonkey.DataBuilder",id, DataBuilder.class)).buildBoolean();
    }
    public static int getInt(String id){
        return ((DataBuilder)BuilderManager.getBuilder("com.pesegato.goldmonkey.DataBuilder",id, DataBuilder.class)).buildInt();
    }
    public static float getFloat(String id){
        return ((DataBuilder)BuilderManager.getBuilder("com.pesegato.goldmonkey.DataBuilder",id, DataBuilder.class)).buildFloat();
    }
    public static double getDouble(String id){
        return ((DataBuilder)BuilderManager.getBuilder("com.pesegato.goldmonkey.DataBuilder",id, DataBuilder.class)).buildDouble();
    }
    public static String getString(String id){
        return ((DataBuilder)BuilderManager.getBuilder("com.pesegato.goldmonkey.DataBuilder",id, DataBuilder.class)).buildString();
    }
}
