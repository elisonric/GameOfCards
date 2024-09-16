package br.com.challenge.gameofcards.enums;

import java.util.Objects;

public enum CardEnum {

    ACE("ACE", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("JACK", 11),
    QUEEN("QUEEN", 12),
    KING("KING", 13);


    private final String code;
    private final Integer value;

    CardEnum(String code, Integer value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public Integer getValue() {
        return value;
    }

    public static Integer fromCode(String code) {
        for (CardEnum cards : CardEnum.values()) {
            if (Objects.equals(cards.getCode(), code)) {
                return cards.getValue();
            }
        }
        throw new IllegalArgumentException("Codigo invalido: " + code);
    }
}
