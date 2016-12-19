
package io.rebble.store.api.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "href",
    "name",
    "collections",
    "custom_banners",
    "featured_applications",
    "top_recent_applications",
    "top_hearted_applications",
    "category_links"
})
public class Category implements Parcelable
{

    @JsonProperty("id")
    public String id;
    @JsonProperty("href")
    public String href;
    @JsonProperty("name")
    public String name;
    @JsonProperty("collections")
    public List<String> collections = null;
    @JsonProperty("custom_banners")
    public List<Object> customBanners = null;
    @JsonProperty("featured_applications")
    public List<String> featuredApplications = null;
    @JsonProperty("top_recent_applications")
    public List<String> topRecentApplications = null;
    @JsonProperty("top_hearted_applications")
    public List<String> topHeartedApplications = null;
    @JsonProperty("category_links")
    public List<String> categoryLinks = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Category> CREATOR = new Creator<Category>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Category createFromParcel(Parcel in) {
            Category instance = new Category();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.collections, (String.class.getClassLoader()));
            in.readList(instance.customBanners, (Object.class.getClassLoader()));
            in.readList(instance.featuredApplications, (String.class.getClassLoader()));
            in.readList(instance.topRecentApplications, (String.class.getClassLoader()));
            in.readList(instance.topHeartedApplications, (String.class.getClassLoader()));
            in.readList(instance.categoryLinks, (String.class.getClassLoader()));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Category[] newArray(int size) {
            return (new Category[size]);
        }

    }
    ;

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(href);
        dest.writeValue(name);
        dest.writeList(collections);
        dest.writeList(customBanners);
        dest.writeList(featuredApplications);
        dest.writeList(topRecentApplications);
        dest.writeList(topHeartedApplications);
        dest.writeList(categoryLinks);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
