package id.go.ojk.pnjk.client.builder.field.lb.uus.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.pnjk.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.pnjk.client.builder.field.lb.uus.reference.ER3137PosLbPnju7100;

public class Lb7100 extends BaseMetadata {

	public Lb7100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_7100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 3, 3, ER3137PosLbPnju7100.genFieldSave(), ER3137PosLbPnju7100.genFieldSave(),
				ER3137PosLbPnju7100.getRequiredPos());
		res.addSegmentValidations(ER3137PosLbPnju7100.genValidationNumeric());
        res.addSegmentValidations(ER3137PosLbPnju7100.genValidationNumeric2());
		res.addSegmentValidations(ER3137PosLbPnju7100.genValidationNumericDot());
		res.addSegmentValidations(ER3137PosLbPnju7100.genValidation4());
        res.addSegmentValidations(ER3137PosLbPnju7100.genValidation5());
        res.addSegmentValidations(ER3137PosLbPnju7100.genValidation6());

		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLbUus.R3137_LB7100.getObject())).confUnique(U));
		fs.add(sf(2, null, "Usaha Produktif", sv(C, 1, 16, all)
                .confConditionalRequired(ER3137PosLbPnju7100.genValidationMustEmpty1())));
		fs.add(sf(3, null, "Usaha Non-Produktif", sv(C, 1, 16, all)
                .confConditionalRequired(ER3137PosLbPnju7100.genValidationMustEmpty2())));
		fs.add(sf(4, null, "Jumlah", sv(M, 1, 16, all)).addFieldValidations(ER3137PosLbPnju7100.genFieldValidation4()));
		return res;
	}
}
