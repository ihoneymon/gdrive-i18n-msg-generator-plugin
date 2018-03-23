package io.honeymon.gradle.i18nmsggenerator.dsl;

public enum MessageType {
    MESSAGES("properties", "messages", "message", ".properties", "Generate for Spring Application(`messages/message-{local}.properties`)"),
    ANDROID("android", "values", "strings", ".xml", "Generatoe for Android(`values-{local}/strings.xml`)"),
    IOS("ios", ".lproj", "Localizable", ".strings", "Generate for IOS(`{local}.lproj/Localizable.strings`");

    private String type;
    private String path;
    private String fileNamePrefix;
    private String fileExtension;
    private String descr;

    MessageType(String type, String path, String fileNamePrefix, String fileExtension, String descr) {
        this.type = type;
        this.path = path;
        this.fileNamePrefix = fileNamePrefix;
        this.fileExtension = fileExtension;
        this.descr = descr;
    }

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getFileNamePrefix() {
        return fileNamePrefix;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getDescr() {
        return descr;
    }

    public static MessageType of(String type) {
        for (MessageType el : values()) {
            if (el.getType().equals(type)) {
                return el;
            }
        }

        throw new IllegalArgumentException("Not found type: " + type);
    }
}
