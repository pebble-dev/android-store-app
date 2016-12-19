
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
    "collections",
    "applications",
    "custom_banners",
    "category_links",
    "categories"
})
public class ApplicationIndexResult implements Parcelable
{

    @JsonProperty("collections")
    public List<Collection> collections = null;
    @JsonProperty("applications")
    public List<Application> applications = null;
    @JsonProperty("custom_banners")
    public List<Object> customBanners = null;
    @JsonProperty("category_links")
    public List<CategoryLink> categoryLinks = null;
    @JsonProperty("categories")
    public List<Category> categories = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<ApplicationIndexResult> CREATOR = new Creator<ApplicationIndexResult>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ApplicationIndexResult createFromParcel(Parcel in) {
            ApplicationIndexResult instance = new ApplicationIndexResult();
            in.readList(instance.collections, (io.rebble.store.api.model.Collection.class.getClassLoader()));
            in.readList(instance.applications, (Application.class.getClassLoader()));
            in.readList(instance.customBanners, (Object.class.getClassLoader()));
            in.readList(instance.categoryLinks, (io.rebble.store.api.model.CategoryLink.class.getClassLoader()));
            in.readList(instance.categories, (Category.class.getClassLoader()));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public ApplicationIndexResult[] newArray(int size) {
            return (new ApplicationIndexResult[size]);
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
        dest.writeList(collections);
        dest.writeList(applications);
        dest.writeList(customBanners);
        dest.writeList(categoryLinks);
        dest.writeList(categories);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
