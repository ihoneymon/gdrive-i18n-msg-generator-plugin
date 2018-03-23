package io.honeymon.gradle.i18nmsggenerator.dsl;

import org.gradle.api.Project;

import static io.honeymon.gradle.i18nmsggenerator.dsl.MessageType.valueOf;

public class I18nMsgGeneratorExtension {
    private String spreadSheetId;
    private String cellRange;
    private MessageType type;
    private String destinationPath;

    public String getSpreadSheetId() {
        return spreadSheetId;
    }

    public String getCellRange() {
        return cellRange;
    }

    public MessageType getType() {
        return type;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public void setSpreadSheetId(String spreadSheetId) {
        this.spreadSheetId = spreadSheetId;
    }

    public void setCellRange(String cellRange) {
        this.cellRange = cellRange;
    }

    public void setType(String type) {
        this.type = MessageType.of(type);
    }
}
