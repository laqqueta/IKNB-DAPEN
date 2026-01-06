package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.all;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3100PosLbPpiu0000;

public class Lb0000 extends BaseMetadata {

	public Lb0000(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_0000;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 26, null, ER3100PosLbPpiu0000.genFieldSave(), ER3100PosLbPpiu0000.genFieldSave(),
				ER3100PosLbPpiu0000.getRequiredPos());
		res.setUniquePos(ER3100PosLbPpiu0000.getUniquePos());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen10());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen15());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen16());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen100());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen20());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen40());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen5());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen50());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationLen8());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationAlfanumeric());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationDate());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationNpwp());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationNumeric());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationPhone());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationReference1());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationReferenceBentukBadanHukum());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationReferenceJenisKegiatanUsahaSyariahYangDilakukan());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationReferenceLokasiDati2());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationReferenceStatusKepemilikan());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationReferenceStatusKepemilikanGedungUnitUsaha());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genValidationReferenceStatusPerusahaanPembiayaanInfrastruktur());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genRowValidation07());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genRowValidation17());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genRowValidation18());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genRowValidation20A());
		res.addSegmentValidations(ER3100PosLbPpiu0000.genRowValidation20B());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 12, refTable).confReference(EHeaderMetadataLbUus.R3100_LB0000.getObject())
						.confRegex(patternNumeric)));
		fs.add(sf(2, null, "Analisis", sv(M, 1, 200, all)));
		return res;
	}
}
