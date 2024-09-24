package com.nextroom.nextRoomServer.dto;

import com.nextroom.nextRoomServer.domain.Theme;
import com.nextroom.nextRoomServer.util.Timestamped;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class ThemeDto {

    @Getter
    @Builder
    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    public static class AddThemeRequest {
        @NotBlank(message = "테마 이름을 입력해 주세요.")
        private final String title;
        private final Integer timeLimit;
        private final Integer hintLimit;
    }

    @Getter
    public static class AddThemeResponse {
        private final Long id;

        public AddThemeResponse(Long id) {
            this.id = id;
        }
    }

    @Getter
    public static class ThemeListResponse {
        private final Long id;
        private final String title;
        private final Integer timeLimit;
        private final Integer hintLimit;
        private final String createdAt;
        private final String modifiedAt;

        public ThemeListResponse(Theme theme) {
            this.id = theme.getId();
            this.title = theme.getTitle();
            this.timeLimit = theme.getTimeLimit();
            this.hintLimit = theme.getHintLimit();
            this.createdAt = Timestamped.dateTimeFormatter(theme.getCreatedAt());
            this.modifiedAt = Timestamped.dateTimeFormatter(theme.getModifiedAt());
        }
    }

    @Getter
    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    public static class EditThemeRequest {
        @Positive(message = "THEME ID를 입력해 주세요.")
        private final Long id;
        @NotBlank(message = "테마 이름을 입력해 주세요.")
        private final String title;
        private final Integer timeLimit;
        private final Integer hintLimit;
    }

    @Getter
    @NoArgsConstructor
    public static class RemoveThemeRequest {
        @Positive(message = "THEME ID를 입력해 주세요.")
        private Long id;
    }
}
