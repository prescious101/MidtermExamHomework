package com.alago.bsit.midtermexamhomework.API;

import android.text.TextUtils;
import android.util.Log;

import com.alago.bsit.midtermexamhomework.Entities.Books;
import com.alago.bsit.midtermexamhomework.Utitlities.HttpUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BSIT on 3/5/2016.
 */public class BooksApi {

    public static final String API_URL = "http://joseniandroid.herokuapp.com/api/books";

    private static final String TAG_ID = "_id";
    private static final String TAG_TITLE = "title";
    private static final String TAG_GENRE = "genre";
    private static final String TAG_AUTHOR = "author";
    private static final String TAG_ISREAD = "isRead";

    public static List<Books> getBooks() {
        String json = HttpUtils.GET(API_URL);

        if (TextUtils.isEmpty(json)) {
            return null;
        }

        //Parse the json response and convert it into a Book object
        String id;
        String title;
        String genre;
        String author;
        Boolean isRead;

        JSONArray jsonArray;

        JSONObject jsonObject;

        List<Books> booksList = new ArrayList<>();

        try {
            jsonArray = new JSONArray(json);
            Log.d("Size", "" + jsonArray.length());
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

                id = jsonObject.getString(TAG_ID);
                title = jsonObject.getString(TAG_TITLE);
                genre = jsonObject.getString(TAG_GENRE);
                author = jsonObject.getString(TAG_AUTHOR);
                isRead = jsonObject.getBoolean(TAG_ISREAD);

                booksList.add(new Books(id, title, genre, author, isRead));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return booksList;
    }

}
