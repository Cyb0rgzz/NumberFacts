package systems.cyberdyne.com.timefacts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tab1Fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab1, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("INFO", "ON FRAGMENT1 ATTACHEDDD->>>>>>>>>>>");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisible()){
            if(isVisibleToUser){
                Log.d("MyTag","My Fragment1 is visible");
            }else{
                Log.d("MyTag","My Fragment1 is not visible");
            }
        }
    }
}
