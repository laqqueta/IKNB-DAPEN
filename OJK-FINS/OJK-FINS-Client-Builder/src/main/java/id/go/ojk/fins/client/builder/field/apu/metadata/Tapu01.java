package id.go.ojk.fins.client.builder.field.apu.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numeric;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.fins.client.builder.field.EFormApuPenilaian;
import id.go.ojk.fins.client.builder.field.apu.reference.EHeaderMetadataPenilaian;
import id.go.ojk.fins.client.builder.field.apu.reference.ER5000PosApuFins01;

public class Tapu01 extends BaseMetadata {

	public Tapu01(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormApuPenilaian eEnum = EFormApuPenilaian.APU_01;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 135, 135, ER5000PosApuFins01.genFieldSave(), null, ER5000PosApuFins01.getRequiredPos());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation002());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation003());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation006());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation009());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation012());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation016());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation017());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation020());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation023());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation026());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation029());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation032());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation035());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation036());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation039());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation042());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation045());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation046());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation050());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation051());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation054());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation057());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation058());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation061());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation064());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation065());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation068());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation071());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation074());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation075());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation078());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation081());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation084());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation087());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation088());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation091());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation094());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation097());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation098());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation101());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation102());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation105());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation108());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation109());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation112());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation115());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation116());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation119());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation122());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation123());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation127());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation131());
		res.addSegmentValidations(ER5000PosApuFins01.genRowValidation134());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 16, 16, refTable).confReference(EHeaderMetadataPenilaian.R000.getObject())).confUnique(U));
		fs.add(sf(2, null, "Jumlah Pengguna", sv(M, 1, 16, numeric)));
		fs.add(sf(3, null, "Jumlah Nominal Nilai Pembiayaan", sv(M, 1, 16, numeric)));
		return res;
	}
}
