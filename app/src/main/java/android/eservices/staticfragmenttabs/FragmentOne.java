package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentOne extends Fragment {
    OnButtonClickListener callback;
    public static final String TAB_NAME = "ADD TO COUNTER";

    public FragmentOne() {
    }

    //Pattern factory pour la création de ce fragment
    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        return v;
    }

    public void setOnButtonClickListener(OnButtonClickListener callback) {
        this.callback = callback;
    }

    public interface OnButtonClickListener {
        public void onButtonClicked(int increment);
    }



    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button) getView().findViewById(R.id.button_increment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callback.onButtonClicked(1);
            }
        });
    }


    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}
