// GET
// 
//     /
//     /login
//     /profile
//     /user
//     /user/[id]
//     /dashboard
//     /admin
//     /entity
//     /entity/[id]
//     /entity/[id]/feature
//     /entity/[id]/feature/[key]
//     /entity/feature/[key] 
//     /feature
//     /feature/[key]
//     /search?key=[key]&entity=[id]
// 
// POST, PUT, PATCH, DELETE
// 
//     /user/[id]
// 
//     /entity/[id]
//     /entity/[id]/feature
//     /entity/[id]/feature/[key]
//     /entity/feature/[key]
// 
//     /feature
//     /feature/[id]
// 
//     /search?key=[key]&entity=[id]
// 
// HEAD
//
//
// entity = {
//     id: 0,
//     features: [...]
// }
//
// feature = {
//     id: 0,
//     key: "[key]",
//     data: "[data]",
//     type: "[type]"
// }

// TODO: HAL relations

package com.iloveyou;

public class Mock {

    private static String makeEntity(long id, String... features) {
        String entity;

        entity = "{\n" +
                 "  \"id\": " + id + ",\n" +
                 "  \"features\": [\n";
        
        for(String feature : features) {
            entity += feature + ",\n";
        }
        
        entity += "  ]\n}";

        return entity;
    }

    private static String makeFeature(long id, String key, String data, String type) {
        return "    {\n" +
               "      \"id\": " + id + ",\n" +
               "      \"key\": \"" + key + "\",\n" +
               "      \"type\": \"" + type + "\",\n" +
               "    }";
    }

    // Could return all entities
    // HAL find relation
    // TODO: entity()
    // public static String entity() {}

    public static String entity(long id) {
        return makeEntity(
            id,
            makeFeature(0, "key0", "data0", "text"),
            makeFeature(id * 1, "key1", "0.12345", "number"),
            makeFeature(id * 2, "key2", "true", "boolean"),
            makeFeature(id * 3, "key3", null, "text")
        );
    }

    public static String entityFeature(long id) {
        return makeFeature(id, "key" + id, "data" + id, "text");
    }

    public static String entityFeature(long id, String key) {
        return makeFeature(id, key, "data" + id, "text");
    }

    public static String entityFeature(String key) {
        return "[\n" +
               makeEntity(
                   0,
                   makeFeature(0, "key0", "data0", "text"),
                   makeFeature(1, "key1", "data1", "text"),
                   makeFeature(2, "key2", "data2", "text")
               ) + ",\n" +
               makeEntity(
                1,
                makeFeature(3, "key0", "data0", "text"),
                makeFeature(4, "key3", "data3", "text"),
                makeFeature(5, "key4", "data4", "text"),
                makeFeature(6, "key5", "data5", "text")
            ) + ",\n" + "]";
    }

    // TODO: feature()
    // public static String feature() {}

    // TODO: feature(long id)
    // public static String feature(long id) {}
}

