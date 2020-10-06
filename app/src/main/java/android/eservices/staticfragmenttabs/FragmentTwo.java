package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

//TODO : fix this fragment so it works :)
//Once it's done, then create a second fragment with the other layout
public class FragmentTwo extends Fragment {
    FragmentTwo.OnButtonLessClickListener callback;
    public static final String TAB_NAME = "ADD TO COUNTER";

    public FragmentTwo() {
    }

    //Pattern factory pour la création de ce fragment
    public static FragmentTwo newInstance() {
        return new FragmentTwo();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_two, container, false);
        return v;
    }

    public interface OnButtonLessClickListener {
        public void onButtonLessClicked(int increment);
    }

    public void setOnButtonLessClickListener(FragmentTwo.OnButtonLessClickListener callback) {
        this.callback = callback;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button) getView().findViewById(R.id.button_decrement);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callback.onButtonLessClicked(1);
            }
        });
    }


    //TODO add listener to button and transmit the information to parent Activity
    //TODO read the Android doc, as suggested, to do it the right way
}
