package networkutils.APIInterface;

import networkutils.Modal.NumbersModal;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ServicesInterface {

    @Headers({
            "Content-Type: application/json",
    })
    @GET("{number}/math")
    Call<NumbersModal> getNumberMathFacts(@Path("number") String number);


    @Headers({
            "Content-Type: application/json",
    })
    @GET("{number}")
    Call<NumbersModal> getNumberTriviaFacts(@Path("number") String number);


    @Headers({
            "Content-Type: application/json",
    })
    @GET("random/trivia")
    Call<NumbersModal> getNumberTriviaRandomFacts();

    @Headers({
            "Content-Type: application/json",
    })
    @GET("random/date")
    Call<NumbersModal> getNumberDateRandomFacts();
}
