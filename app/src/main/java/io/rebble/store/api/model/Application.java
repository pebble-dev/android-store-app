
package io.rebble.store.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.net.Uri;
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
    "author",
    "capabilities",
    "category",
    "category_color",
    "category_id",
    //"changelog",
    //"companions",
    "compatibility",
    "created_at",
    "description",
    "developer_id",
    "header_images",
    "hearts",
    "icon_image",
    "id",
    "latest_release",
    "links",
    "list_image",
    "published_date",
    "screenshot_hardware",
    "screenshot_images",
    "source",
    "title",
    "type",
    "uuid",
    "website"
})
public class Application implements Parcelable
{

    @JsonProperty("author")
    public String author;
    @JsonProperty("capabilities")
    public List<String> capabilities;
    @JsonProperty("category")
    public String categoryName;
    @JsonProperty("category_color")
    public String categoryColor;
    @JsonProperty("category_id")
    public String categoryId;
    /*
    @JsonProperty("changelog")
    public List<List<String>> changelog;

    @JsonProperty("companions")
    public List<String> companions;
    */
    @JsonProperty("compatibility")
    public Compatibility compatibility;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("description")
    public String description;
    @JsonProperty("developer_id")
    public String developerId;
    @JsonProperty("header_images")
    public List<String> headerImages = null;
    @JsonProperty("hearts")
    public Integer hearts;
    @JsonProperty("icon_image")
    public List<String> iconImage;
    @JsonProperty("id")
    public String id;
    @JsonProperty("latest_release")
    public LatestRelease latestRelease;
    @JsonProperty("links")
    public Links links;
    @JsonProperty("list_image")
    public List<String> listImage;
    @JsonProperty("published_date")
    public String publishedDate;
    @JsonProperty("screenshot_hardware")
    public List<String> screenshotHw;
    @JsonProperty("screenshot_images")
    public List<String> screenshotImages;
    @JsonProperty("source")
    public String source;
    @JsonProperty("title")
    public String title;
    @JsonProperty("type")
    public String type;
    @JsonProperty("uuid")
    public String uuid;
    @JsonProperty("website")
    public String website;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    public final static Creator<Application> CREATOR = new Creator<Application>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Application createFromParcel(Parcel in) {
            Application instance = new Application();
            instance.author = ((String) in.readValue((String.class.getClassLoader())));
            instance.capabilities = ((List<String>) in.readValue((String.class.getClassLoader())));
            instance.categoryName = ((String) in.readValue((String.class.getClassLoader())));
            instance.categoryColor = ((String) in.readValue((String.class.getClassLoader())));
            instance.categoryId = ((String) in.readValue((String.class.getClassLoader())));
            //instance.changelog = (List<List<String>>) in.readValue((String.class.getClassLoader()));
            //instance.companions = ((List<String>) in.readValue((String.class.getClassLoader())));
            instance.compatibility = ((Compatibility) in.readValue((Compatibility.class.getClassLoader())));
            instance.createdAt = ((String) in.readValue((String.class.getClassLoader())));
            instance.description = ((String) in.readValue((String.class.getClassLoader())));
            instance.developerId = ((String) in.readValue((String.class.getClassLoader())));
            instance.headerImages = ((List<String>) in.readValue((String.class.getClassLoader())));
            instance.hearts = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.iconImage = ((List<String>) in.readValue((String.class.getClassLoader())));
            instance.id = ((String) in.readValue((String.class.getClassLoader())));
            instance.latestRelease = ((LatestRelease) in.readValue((LatestRelease.class.getClassLoader())));
            instance.links = ((Links) in.readValue((Links.class.getClassLoader())));
            instance.listImage = ((List<String>) in.readValue((String.class.getClassLoader())));
            instance.publishedDate = ((String) in.readValue((String.class.getClassLoader())));
            instance.screenshotHw = ((List<String>) in.readValue((String.class.getClassLoader())));
            instance.screenshotImages = ((List<String>) in.readValue((String.class.getClassLoader())));
            instance.source = ((String) in.readValue((String.class.getClassLoader())));
            instance.title = ((String) in.readValue((String.class.getClassLoader())));
            instance.type = ((String) in.readValue((String.class.getClassLoader())));
            instance.uuid = ((String) in.readValue((String.class.getClassLoader())));
            instance.website = ((String) in.readValue((String.class.getClassLoader())));

            instance.additionalProperties = ((Map<String, Object> ) in.readValue((Map.class.getClassLoader())));
            return instance;
        }

        public Application[] newArray(int size) {
            return (new Application[size]);
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
        dest.writeValue(author);
        dest.writeList(capabilities);
        dest.writeValue(categoryName);
        dest.writeValue(categoryColor);
        dest.writeValue(categoryId);
        //dest.writeList(changelog);
        //dest.writeList(companions);
        dest.writeValue(compatibility);
        dest.writeValue(createdAt);
        dest.writeValue(description);
        dest.writeValue(developerId);
        dest.writeList(headerImages);
        dest.writeValue(hearts);
        dest.writeList(iconImage);
        dest.writeValue(id);
        dest.writeValue(latestRelease);
        dest.writeValue(links);
        dest.writeList(listImage);
        dest.writeValue(publishedDate);
        dest.writeList(screenshotHw);
        dest.writeList(screenshotImages);
        dest.writeValue(source);
        dest.writeValue(title);
        dest.writeValue(type);
        dest.writeValue(uuid);
        dest.writeValue(website);

        dest.writeValue(additionalProperties);
    }

    public int describeContents() {
        return  0;
    }

}
