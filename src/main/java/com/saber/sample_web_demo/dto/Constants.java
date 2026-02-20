package com.saber.sample_web_demo.dto;

import lombok.Getter;

public class Constants {
    @Getter
    public enum EducationEnum {
        DIPLOMA("diploma","دیپلم")
        ,BS("bs","کارشناسی")
        ,MSC("msc","کارشناسی ارشد")
        ,PHD("phd","دکترا")
        ;
        private final String value;
        private final String title;

        EducationEnum(String value, String title) {
            this.value = value;
            this.title = title;
        }
    }
}
