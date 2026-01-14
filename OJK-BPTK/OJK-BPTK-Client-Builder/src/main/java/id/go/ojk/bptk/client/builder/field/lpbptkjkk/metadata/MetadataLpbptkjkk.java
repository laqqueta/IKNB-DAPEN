package id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLpbptkjkk {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LpRkpstJkk(EFormLpbptkjkk.RKPST).get(),
      new LpRpiuJkk(EFormLpbptkjkk.RPIU).get(),
      new LpRpmfJkk(EFormLpbptkjkk.RPMF).get(),
      new LpRkpiuJkk(EFormLpbptkjkk.RKPIU).get(),
      new LpRkpmfJkk(EFormLpbptkjkk.RKPMF).get(),
      new LpInfJkk(EFormLpbptkjkk.INF).get(),
      new LpSpJkk(EFormLpbptkjkk.SP).get()
  );
}
