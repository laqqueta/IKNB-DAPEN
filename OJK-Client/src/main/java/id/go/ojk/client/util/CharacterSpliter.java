package id.go.ojk.client.util;

import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public enum CharacterSpliter {

    PIPE(Pattern.compile("[|]"))

    ;

    private final Pattern pattern;

    CharacterSpliter(Pattern pattern) {
        this.pattern = pattern;
    }

}
