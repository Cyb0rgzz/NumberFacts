package systems.cyberdyne.com.timefacts;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.TextUtils;
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

public class Tab2Fragment extends Fragment {

    static NumbersModal numbersModal;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.tab2, container, false);
        textView = rootView.findViewById(R.id.textView_tab2);
        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("INFO", "ON FRAGMENT2 ATTACHEDDD->>>>>>>>>>>");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisible()){
            if(isVisibleToUser){
                Log.d("MyTag","My Fragment2 is visible");
                ServicesInterface servicesInterface = RetrofitClient.getClient().create(ServicesInterface.class);

                Call<NumbersModal> call = servicesInterface.getNumberTriviaRandomFacts();
                call.enqueue(new Callback<NumbersModal>() {

                    @Override
                    public void onResponse(Call<NumbersModal> call, Response<NumbersModal> response) {
                        System.out.println("Response Body: " + response.body());
                        Log.i("My Fragment2 Response",response.body().getText());
                        numbersModal = response.body();
                        TabLayout tabLayout = getActivity().findViewById(R.id.main_tab_layout);
                        setText(numbersModal.getNumber(), numbersModal.getText());
                    }

                    private void setText(String text, String content) {
                        //text = text.split(" ")[0];
                        SpannableString ss1=  new SpannableString(text);
                        ss1.setSpan(new RelativeSizeSpan(3.75f), 0, text.length(), 0); // set size
                        ss1.setSpan(new ForegroundColorSpan(Color.RED), 0, text.length(), 0);// set color

                        SpannableString ss2=  new SpannableString(content);
                        ss2.setSpan(new RelativeSizeSpan(1.5f), 0, content.length(), 0); // set size

                        textView.setText(TextUtils.concat(ss1,"\n",ss2));
                        //textView.setText(ss1);
                    }

                    @Override
                    public void onFailure(Call<NumbersModal> call, Throwable t) {
                        System.out.println(" MyFragment3 EXCEPTION ::: " + t.getMessage());
                    }
                });
            }else{
                Log.d("MyTag","My Fragment2 is not visible");
            }
        }
    }


}
