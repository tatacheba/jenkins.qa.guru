package pages.components;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public UserProfile profile;
    public List<String> points;
    public Lines lines;

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public User(@JsonProperty("proFile") UserProfile profile, @JsonProperty("points") List<String> points, @JsonProperty("line") Lines lines) {
        this.profile = profile;
        this.points = points;
        this.lines = lines;
    }
}

