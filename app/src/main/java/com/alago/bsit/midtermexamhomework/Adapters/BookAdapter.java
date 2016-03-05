package com.alago.bsit.midtermexamhomework.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.alago.bsit.midtermexamhomework.Entities.Books;
import com.alago.bsit.midtermexamhomework.R;

import java.util.List;

/**
 * Created by BSIT on 3/5/2016.
 */
public class BookAdapter extends ArrayAdapter<Books> {

    private Context mContext;
    private int mLayoutId;
    private List<Books> mBooks;

    public BookAdapter(Context context, int resource, List<Books> mBooks) {
        super(context, resource, mBooks);
        this.mContext = context;
        this.mLayoutId = resource;
        this.mBooks = mBooks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            // Inflate the layout
            convertView = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false);

            // create the view holder
            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvBookTitle);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Set the book data
        Books book = mBooks.get(position);

        if (book != null) {
            if (viewHolder.tvTitle != null) {
                viewHolder.tvTitle.setText(book.getmTitle());

                if (book.getmIsRead()) {
                    viewHolder.tvTitle.setPaintFlags(viewHolder.tvTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    viewHolder.tvTitle.setTextColor(Color.parseColor("#B0171F"));
                }
            }
        }
        return convertView;
    }

    private static class ViewHolder {
        public TextView tvTitle;
    }

}
