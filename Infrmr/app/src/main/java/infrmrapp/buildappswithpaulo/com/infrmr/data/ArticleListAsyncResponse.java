package infrmrapp.buildappswithpaulo.com.infrmr.data;

import java.util.ArrayList;

/**
 * Created by paulodichone on 10/16/17.
 */

public interface ArticleListAsyncResponse {
    void processFinish(ArrayList<Article> articles);
}
