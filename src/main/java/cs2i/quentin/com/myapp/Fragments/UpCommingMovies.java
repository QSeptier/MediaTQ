package cs2i.quentin.com.myapp.Fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cs2i.quentin.com.myapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpCommingMovies extends Fragment {


    public UpCommingMovies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_up_comming_movies, container, false);
    }

}
