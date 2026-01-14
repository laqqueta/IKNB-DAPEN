package id.go.ojk.bptk.client.builder.field.labptkjkk.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLabptkjkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLabptkjkk {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LaDtumJkk(EFormLabptkjkk.DTUM).get(),
      new LaRasJkk(EFormLabptkjkk.RAS).get(),
      new LaLampJkk(EFormLabptkjkk.LAMP).get(),
      new LaSpJkk(EFormLabptkjkk.SP).get()
  );
}
