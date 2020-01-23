1) MainActivity with layout
2) square retrofit example https://square.github.io/retrofit/?source=post_page-----48437e4e5a23----------------------
3) Create the retrofit singleton builder from sample example
4) create the api service from sample example, (call is from retrofit2)
5) create the model object
6) migrate to android x https://developer.android.com/jetpack/androidx/migrate and open versions page
7) android maven repository https://mvnrepository.com/artifact/com.google.android
8) for eg: appbar, see documentation
9) once activity is created we get handle to the recycler view and set the layout manager, scroll listener and adapter on it
addOnScrollListener(EndlessScrollListener({fetchItems()}, layout))

class EndlessScrollListener(val func: () -> Unit,
                            val layoutManager: LinearLayoutManager) : RecyclerView.OnScrollListener() {
    private val visibleThreshold: Int = 2
    var loading = true
    var previousTotal = 0
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
        if(dy > 0) {
            if(loading) {
                if(layoutManager.itemCount > 0) {
                    loading = false
                    previousTotal = layoutManager.itemCount
                }
            }

            if(!loading && (layoutManager.itemCount - recyclerView.childCount) <=
                (layoutManager.findFirstVisibleItemPosition() + visibleThreshold)) {
                // End has been reached
                Log.d("EndlessScrollListener", "EndlessScrollListener end has reached")
                func()
                loading = true
            }

        }
    }
}
10) All about adapters , have a mainadapter extending RecyclerView.Adapter(ItemsAdapter). override the 3 methods onCreateViewHolder, onBindViewHolder, getItemCount
11) create a interface common for item type delegating adapter ViewTypeDelegateAdapter and implement it for each DelegateAdapter eg: LoadingDelegateAdapter, NewsDelegateAdapter
12) In the main adapter, Have a sparsearraycompat of ViewTypeDelegateAdapter, and a arraylist of items of ViewType. initially we put loadingitem into it.
ViewType is an interface which had getViewItemType() which returns and Int (LOADING or ITEM)
13)
