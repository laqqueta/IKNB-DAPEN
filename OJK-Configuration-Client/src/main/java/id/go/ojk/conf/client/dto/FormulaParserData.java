package id.go.ojk.conf.client.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class FormulaParserData {

    @Getter
    @Setter
    private String formula;

    @Getter
    @Setter
    private String errMessage;

}
