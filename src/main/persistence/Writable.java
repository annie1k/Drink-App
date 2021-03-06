package persistence;

import org.json.JSONObject;
//refer to JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
