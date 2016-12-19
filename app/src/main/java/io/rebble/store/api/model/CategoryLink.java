
package io.rebble.store.api.model;

import java.util.HashMap;
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
    "icon_url",
    "color",
    "apps_count"
})
public class CategoryLink implements Parcelable
{

    @JsonProperty("id")
    public String id;
    @JsonProperty("href")
    public String href;
    @JsonProperty("name")
    public String name;
    @JsonProperty("icon_url")
    public String iconUrl;
    @JsonProperty("color")
    public String color;
    @JsonProperty("apps_count")
    public Integer appsCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<CategoryLink> CREATOR = new Creator<CategoryLink>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CategoryLink createFromParcel(Parcel in) {
            CategoryLink instance = new CategoryLink();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.iconUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.color = ((String) in.readValue((String.class.getClassLoader())));
            instance.appsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public CategoryLink[] newArray(int size) {
            return (new CategoryLink[size]);
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
        dest.writeValue(iconUrl);
        dest.writeValue(color);
        dest.writeValue(appsCount);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
