
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
    "add",
    "remove",
    "remove_heart",
    "add_heart",
    "add_flag",
    "remove_flag",
    "share"
})
public class Links implements Parcelable
{

    @JsonProperty("add")
    public String add;
    @JsonProperty("remove")
    public String remove;
    @JsonProperty("remove_heart")
    public String removeHeart;
    @JsonProperty("add_heart")
    public String addHeart;
    @JsonProperty("add_flag")
    public String addFlag;
    @JsonProperty("remove_flag")
    public String removeFlag;
    @JsonProperty("share")
    public String share;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Links> CREATOR = new Creator<Links>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links createFromParcel(Parcel in) {
            Links instance = new Links();
            instance.add = ((String) in.readValue((String.class.getClassLoader())));
            instance.remove = ((String) in.readValue((String.class.getClassLoader())));
            instance.removeHeart = ((String) in.readValue((String.class.getClassLoader())));
            instance.addHeart = ((String) in.readValue((String.class.getClassLoader())));
            instance.addFlag = ((String) in.readValue((String.class.getClassLoader())));
            instance.removeFlag = ((String) in.readValue((String.class.getClassLoader())));
            instance.share = ((String) in.readValue((String.class.getClassLoader())));
            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
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
        dest.writeValue(add);
        dest.writeValue(remove);
        dest.writeValue(removeHeart);
        dest.writeValue(addHeart);
        dest.writeValue(addFlag);
        dest.writeValue(removeFlag);
        dest.writeValue(share);
        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
