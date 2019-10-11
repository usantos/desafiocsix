package br.com.desafiocsix.response

import br.com.desafiocsix.request.GitRepository
import com.google.gson.annotations.SerializedName

class GitRepositoryListResponse {

    @SerializedName("total_count")
    var totalCount: Int = 0

    @SerializedName("items")
    var items: List<GitRepository>? = null

    @SerializedName("incomplete_results")
    var incompleteResults: Boolean = false

    @SerializedName("total_pages")
    var totalPages: Int = 0
}
