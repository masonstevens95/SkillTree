package galacticgames.android.skilltree.common.dependencyinjection;

import galacticgames.android.skilltree.common.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit mRetrofit;

//    private Retrofit getRetrofit() {
//        if (mRetrofit == null) {
//            mRetrofit = new Retrofit.Builder()
//                    .baseUrl(Constants.BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build();
//        }
//        return mRetrofit;
//    }
}
