package id.go.ojk.bptk.client.builder.field.labptkjht.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjht;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaDtumJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaLampJkk;
import id.go.ojk.bptk.client.builder.field.labptkjkk.metadata.LaSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLabptkjht {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LaDtumJkk(EFormLabptkjht.DTUM).get(),
      new LaRasJht(EFormLabptkjht.RAS).get(),
      new LaLampJkk(EFormLabptkjht.LAMP).get(),
      new LaSpJkk(EFormLabptkjht.SP).get()
  );
}
