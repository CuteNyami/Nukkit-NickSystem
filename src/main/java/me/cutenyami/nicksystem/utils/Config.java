package me.cutenyami.nicksystem.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.cutenyami.nicksystem.json.JsonFile;
import me.cutenyami.nicksystem.mysql.Profile;

public class Config extends JsonFile {

    private Profile profile = new Profile("127.0.0.1", 3306, "root", "System", "1234");

    public Config() {
        super(new GsonBuilder().setPrettyPrinting().create(), "plugins/NickSystem/mysql.json");

        if (!exists()) {
            create();
            append("profile", profile);
            save();
        }
        load();
        this.profile = get("profile", Profile.class);
    }

    public Profile getProfile() {
        return profile;
    }
}
