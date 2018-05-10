package enums;

import lombok.Getter;

/**
 * Created by yong on 2018-05-10.
 *
 * @author yong
 */
public enum AsciiTypeEnum {
    NUMBER("NUMBER"),
    LOWER("LOWER"),
    UPPER("UPPER");

    @Getter
    private String name;

    private AsciiTypeEnum(final String name){
        this.name = name;
    }
}
