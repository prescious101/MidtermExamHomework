package com.alago.bsit.midtermexamhomework.Fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alago.bsit.midtermexamhomework.API.BooksApi;
import com.alago.bsit.midtermexamhomework.Adapters.BookAdapter;
import com.alago.bsit.midtermexamhomework.Entities.Books;
import com.alago.bsit.midtermexamhomework.R;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by BSIT on 3/5/2016.
 */
public class ListviewFragment  extends Fragment implements AdapterView.OnItemClickListener  {

    private ListView mListView;
    private TextView mTvGetBooks;
    private ProgressBar mProgBar;

    private List<Books> Books = new ArrayList<>();
    private BookAdapter bookAdapter ;

    public static ListviewFragment newInstance() {
        return new ListviewFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        GetBook getBooks= new GetBook();
        getBooks.execute();

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState){
        return inflater.inflate(R.layout.listview_fragment, container, false);
    }

    @Override
    public void onViewCreated (View view,  Bundle savedInstanceState){
        // find all the views
        mListView = (ListView) view.findViewById(R.id.list_item);
        mTvGetBooks = (TextView) view.findViewById(R.id.tvProgressGettingBooks);
        mProgBar = (ProgressBar) view.findViewById(R.id.progressBarLoadingBooks);

        // create a new instance of adapter
        bookAdapter = new BookAdapter(getActivity(), R.layout.list_item, Books);

        // set the adapter
        mListView.setAdapter(bookAdapter);


        // set item click listener
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }



    public class GetBook extends AsyncTask<String, Void, List<Books>> {
        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected List<Books> doInBackground(String... params) {

            return BooksApi.getBooks();
        }

        @Override
        protected void onPostExecute(List<Books> books) {
            super.onPostExecute(books);
            mTvGetBooks.setVisibility(View.GONE);
            mProgBar.setVisibility(View.GONE);
            bookAdapter.addAll(books);
        }
    }

}
