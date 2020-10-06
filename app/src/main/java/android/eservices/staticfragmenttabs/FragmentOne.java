package android.eservices.staticfragmenttabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class FragmentOne extends Fragment {
    OnButtonPlusClickListener callback;
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


    public interface OnButtonPlusClickListener {
        public void onButtonPlusClicked(int increment);
    }

    public void setOnButtonPlusClickListener(OnButtonPlusClickListener callback) {
        this.callback = callback;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button) getView().findViewById(R.id.button_increment);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callback.onButtonPlusClicked(1);
            }
        });
        //getActivity().setTitle(TAB_NAME);
    }

}
