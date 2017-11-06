package wss.com.mystudysolutions.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chiranjit Jana on 04/11/2017.
 */

public class BlogHeaderList {

    @SerializedName("blogs_header")
    @Expose
    private List<BlogsHeader> headerList = new ArrayList<>();

    public List<BlogsHeader> getHeaderList() {
        return headerList;
    }

    public void setHeaderList(List<BlogsHeader> headerList) {
        this.headerList = headerList;
    }
}
