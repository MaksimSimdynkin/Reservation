package ru.myproject.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import ru.myproject.enums.StatusRoom;

@Builder
public record RequestRoom(
        @Min(value = 1, message = "Номер комнаты должен быть больше 0" )
        @Max(value = 2000, message = "Номер комнаты не может быть больше 2000")
        int number,

        @Min(value = 1, message = "Этаж должен быть больше 0")
        @Max(value = 50, message = "Этаж не может быть больше 50")
        int floor,

        @Min(value = 1, message = "Количество комнат должно быть больше 0")
        @Max(value = 5, message = "Количество комнат не может быть больше 5")
        int countRooms,

        @Min(value = 1, message = "Стоимость комнаты не может быть отрицательной")
        int count,

        @NotNull(message = "Статус комнаты обязателен")
        StatusRoom statusRoom
) {
}
