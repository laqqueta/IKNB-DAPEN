package id.go.ojk.bptk.client.builder.field.lpbptkjkm.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpInfJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRkpiuJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRkpstJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRpiuJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLpbptkjkm {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LpRkpstJkk(EFormLpbptkjk.RKPST).get(),
      new LpRpiuJkk(EFormLpbptkjk.RPIU).get(),
      new LpRpmfJkm(EFormLpbptkjk.RPMF).get(),
      new LpRkpiuJkk(EFormLpbptkjk.RKPIU).get(),
      new LpRkpmfJkm(EFormLpbptkjk.RKPMF).get(),
      new LpInfJkk(EFormLpbptkjk.INF).get(),
      new LpSpJkk(EFormLpbptkjk.SP).get()
  );
}
