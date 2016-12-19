
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
    "name",
    "icon",
    "url"
})
public class AndroidCompanion implements Parcelable
{

    @JsonProperty("id")
    public String id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("icon")
    public String icon;
    @JsonProperty("url")
    public String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<AndroidCompanion> CREATOR = new Creator<AndroidCompanion>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AndroidCompanion createFromParcel(Parcel in) {
            AndroidCompanion instance = new AndroidCompanion();
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.icon = ((String) in.readValue((String.class.getClassLoader())));
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public AndroidCompanion[] newArray(int size) {
            return (new AndroidCompanion[size]);
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
        dest.writeValue(name);
        dest.writeValue(icon);
        dest.writeValue(url);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
