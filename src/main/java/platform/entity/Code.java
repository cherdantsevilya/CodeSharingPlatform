package platform.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@Entity
public class Code {

    private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @JsonIgnore
    private String id;

    @NonNull
    private String code;

    @NonNull
    private String date;

    private Long time;

    private Long views;

    @JsonIgnore
    private Boolean timeRestriction;

    @JsonIgnore
    private Boolean viewsRestriction;

    @JsonIgnore
    private LocalDateTime localDateTime;

    public void setDate(LocalDateTime localDateTime) {
        this.date = localDateTime.format(formatter);
        this.localDateTime = localDateTime;
    }
}
