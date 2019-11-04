import android.content.Context
import com.example.mvvmbaseproject.api.ApiInterface
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


object RestClient {
    private var retrofitApi: Retrofit? = null
    val BASE_URL = "https://gist.githubusercontent.com/"

    fun getApiInterface(context: Context): ApiInterface {
        if (retrofitApi == null) {
            try {
                val gson = GsonBuilder()
                    .setLenient().setPrettyPrinting()
                    .create()
                val logging = HttpLoggingInterceptor()
// set your desired log level
                logging.level = HttpLoggingInterceptor.Level.BODY
                val httpClient = OkHttpClient.Builder()
                retrofitApi = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(httpClient.build())
                    .build()
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        return retrofitApi!!.create(ApiInterface::class.java)
    }


}