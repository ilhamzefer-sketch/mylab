package az.mylab.exception;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


//Standart error response  qoyuruq ki front  eyni  formatda exception gorsun
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)  //Null olan fieldleri  front gormesin
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private  int status;
    private String error;
    private String message;
    private String path;
    private String code;

    //Sadece  Valid xetasi verende  dolacaq
    private Map<String, List<String>> validationErrors;


}
