package systems.cyberdyne.com.timefacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import networkutils.APIInterface.ServicesInterface;
import networkutils.Modal.NumbersModal;
import networkutils.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Tab3Fragment extends Fragment {

    private static NumbersModal numbersModal;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.tab3, container, false);
        textView = rootView.findViewById(R.id.textView_tab3);
        return rootView;
    }
    @Override
    public void onResume() {

        super.onResume();
        ServicesInterface servicesInterface = RetrofitClient.getClient().create(ServicesInterface.class);
        Log.i("INFO", "ON FRAGMENT3 ATTACHEDDD->>>>>>>>>>>");
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {

        super.setUserVisibleHint(isVisibleToUser);
        if(isVisible()){
            if(isVisibleToUser){
                Log.i("MyTag","My Fragment3 is visible");
                ServicesInterface servicesInterface = RetrofitClient.getClient().create(ServicesInterface.class);

                Call<NumbersModal> call = servicesInterface.getNumberMathFacts("6");
                call.enqueue(new Callback<NumbersModal>() {

                    @Override
                    public void onResponse(Call<NumbersModal> call, Response<NumbersModal> response) {
                        System.out.println("Response Body: " + response.body());
                        Log.i("My Fragment3 Response",response.body().getText());
                        numbersModal = response.body();
                        TabLayout tabLayout = getActivity().findViewById(R.id.main_tab_layout);
                        setText(numbersModal.getText());
                    }

                    private void setText(String text) {
                        //text = text.replaceAll(" ","\n");
                        SpannableString ss1=  new SpannableString(text);
                        ss1.setSpan(new RelativeSizeSpan(3f), 0,1, 0); // set size
                        ss1.setSpan(new ForegroundColorSpan(Color.RED), 0, 1, 0);// set color
                        textView.setText(ss1);
                    }

                    @Override
                    public void onFailure(Call<NumbersModal> call, Throwable t) {
                        System.out.println(" MyFragment3 EXCEPTION ::: " + t.getMessage());
                    }
                });



            }else{
                Log.i("MyTag","cis not visible");
            }
        }
    }
}
