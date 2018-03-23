package io.honeymon.gradle.i18nmsggenerator.dsl;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.gradle.api.Project;

import static io.honeymon.gradle.i18nmsggenerator.dsl.MessageType.valueOf;

@Data
@ToString(of = {"spreadSheetId", "cellRange", "type", "destinationPath"})
public class I18nMsgGeneratorExtension {
    private final Project project;
    private String spreadSheetId;
    private String cellRange;
    private MessageType type;
    private String destinationPath;
    private boolean printSheetInfo;

    /**
     * Decorate 처리용도
     * TODO 나중에 어떻게 사용되는지 확인하기
     *
     * @param project
     */
    public I18nMsgGeneratorExtension(Project project) {
        this.project = project;
    }

    public void setType(String type) {
        this.type = MessageType.of(type);
    }
}
