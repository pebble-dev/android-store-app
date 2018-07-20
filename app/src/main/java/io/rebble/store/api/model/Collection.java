
package io.rebble.store.api.model;

import java.util.ArrayList;
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
    "featured",
    "applications"
})
public class Collection implements Parcelable
{

    @JsonProperty("links")
    public String href;
    @JsonProperty("name")
    public String name;
    @JsonProperty("slug")
    public String slug;
    @JsonProperty("application_ids")
    public List<String> applications = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Collection> CREATOR = new Creator<Collection>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Collection createFromParcel(Parcel in) {
            Collection instance = new Collection();
            instance.href = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.applications = new ArrayList<>();
            in.readList(instance.applications, (String.class.getClassLoader()));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Collection[] newArray(int size) {
            return (new Collection[size]);
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
        dest.writeValue(href);
        dest.writeValue(name);
        dest.writeList(applications);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
