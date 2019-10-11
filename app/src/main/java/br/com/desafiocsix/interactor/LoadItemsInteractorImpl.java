

package br.com.desafiocsix.interactor;

import android.util.Log;
import br.com.desafiocsix.interactor.interfaces.LoadItemsInteractor;
import br.com.desafiocsix.network.ApiInterface;
import br.com.desafiocsix.request.GitRepository;
import br.com.desafiocsix.response.GitRepositoryListResponse;
import br.com.desafiocsix.network.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class LoadItemsInteractorImpl implements LoadItemsInteractor {

    private final String TAG = "LoadItemsInteractorImpl";

    @Override
    public void getRepositoryList(final OnFinishedListener onFinishedListener, int pageNo) {
        ApiInterface apiService = ApiClient.INSTANCE.getResults().create(ApiInterface.class);

        Call<GitRepositoryListResponse> call = apiService.getEventList(pageNo);
        call.enqueue(new Callback<GitRepositoryListResponse>() {
            @Override
            public void onResponse(Call<GitRepositoryListResponse> call, Response<GitRepositoryListResponse> response) {
                List<GitRepository> events = response.body() != null ? response.body().getItems() : null;
                Log.d(TAG, "Number of repository: " + events.size());
                onFinishedListener.onFinished(events);
            }

            @Override
            public void onFailure(Call<GitRepositoryListResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
