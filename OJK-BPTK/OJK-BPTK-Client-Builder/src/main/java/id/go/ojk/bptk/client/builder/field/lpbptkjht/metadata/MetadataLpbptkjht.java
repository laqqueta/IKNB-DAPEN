package id.go.ojk.bptk.client.builder.field.lpbptkjht.metadata;

import java.util.Arrays;
import java.util.List;

import id.go.ojk.bptk.client.builder.field.EFormLpbptkjht;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpInfJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRkpstJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpRpiuJkk;
import id.go.ojk.bptk.client.builder.field.lpbptkjkk.metadata.LpSpJkk;
import id.go.ojk.client.model.config.SubmissionFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MetadataLpbptkjht {
  @Getter
  private static final List<SubmissionFormat> metadata = Arrays.asList(
      new LpRkpstJkk(EFormLpbptkjht.RKPST).get(),
      new LpRpiuJkk(EFormLpbptkjht.RPIU).get(),
      new LpRdjht(EFormLpbptkjht.RDJHT).get(),
      new LpRpmfJht(EFormLpbptkjht.RPMF).get(),
      new LpRkpiuJht(EFormLpbptkjht.RKPIU).get(),
      new LpRkpmfJht(EFormLpbptkjht.RKPMF).get(),
      new LpInfJkk(EFormLpbptkjht.INF).get(),
      new LpSpJkk(EFormLpbptkjht.SP).get()
  );
}
