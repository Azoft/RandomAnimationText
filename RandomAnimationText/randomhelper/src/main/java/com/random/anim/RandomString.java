package com.random.anim;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Date: 08.06.16
 * Time: 10:11
 *
 * @author Artem Zalevskiy
 */
public class RandomString {

    private final int mLength;
    private final TypeRandomEnum mTypeRandomEnum;

    public RandomString(final int length, final TypeRandomEnum typeRandomEnum) {
        mLength = length;
        mTypeRandomEnum = typeRandomEnum;
    }

    public int getLength() {
        return mLength;
    }

    public TypeRandomEnum getTypeRandomEnum() {
        return mTypeRandomEnum;
    }

    @Nullable
    public static TypeRandomEnum getTypeRandomEnum(final String s) {
        if (TextUtils.isEmpty(s)) {
            return null;
        }
        for (final TypeRandomEnum randomEnum : TypeRandomEnum.values()) {
            if (s.startsWith(randomEnum.value)) {
                return randomEnum;
            }
        }
        return null;
    }

    public static Collection<RandomString> parseParams(final String rules) {
        if (TextUtils.isEmpty(rules)) {
            return Collections.emptyList();
        }
        final String[] params = StringUtils.split(rules, ':');
        final Collection<RandomString> list = new ArrayList<>();

        int value = 1;
        for (final String s : params) {
            final TypeRandomEnum typeRandomEnum = getTypeRandomEnum(s);
            if (null == typeRandomEnum) {
                continue;
            }

            final int index = s.indexOf(typeRandomEnum.value);
            String size = StringUtils.substring(s, index + 1);
            if (2 < size.length()) {
                size = size.substring(0, 2);
            }
            if (StringUtils.isNumeric(size)) {
                value = Integer.parseInt(size);
            }
            list.add(new RandomString(value, typeRandomEnum));
        }

        return list;
    }

    public enum TypeRandomEnum {
        ALPHA("a"), NUMERIC("n"), ALPHA_NUMERIC("A");

        public final String value;

        TypeRandomEnum(final String a) {
            value = a;
        }
    }
}
