package br.com.desafiocsix.response

import br.com.desafiocsix.request.GitRepository
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitRepositoryListResponse {

    @SerializedName("total_count")
    @Expose
    var totalCount: Int = 0

    @SerializedName("items")
    @Expose
    var items: List<GitRepository>? = null

    @SerializedName("incomplete_results")
    @Expose
    var incompleteResults: Boolean = false

    @SerializedName("total_pages")
    @Expose
    var totalPages: Int = 0
}
