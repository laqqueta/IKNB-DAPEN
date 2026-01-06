package id.go.ojk.ppik.client.builder.field.lb.uus.metadata;

import static id.go.ojk.client.model.config.SimpleValidation.patternNumeric;
import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.config.UniqueType.U;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;
import id.go.ojk.ppik.client.builder.field.EFormLaporanBulananUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.EHeaderMetadataLbUus;
import id.go.ojk.ppik.client.builder.field.lb.uus.reference.ER3108PosLbPpiu1100;

public class Lb1100 extends BaseMetadata {

	public Lb1100(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulananUus eEnum = EFormLaporanBulananUus.LB_1100;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode, new ArrayList<>(),
				extension, 120, 120, ER3108PosLbPpiu1100.genFieldSave(), ER3108PosLbPpiu1100.genFieldSave(),
				ER3108PosLbPpiu1100.getRequiredPos());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation002());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation004());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation007());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation011A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation011B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation013A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation013B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation013C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation013D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation014A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation014B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation014C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation014D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation015A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation015B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation015C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation025A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation025B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation025C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation025D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation025E());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation026A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation026B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation026C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation026D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation027A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation027B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation027C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation032A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation032B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation033A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation033B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation033C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation033D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation034A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation034B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation036A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation036B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation036C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation036D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation037A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation037B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation037C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation037D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation038A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation038B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation040A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation040B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation041A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation041B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation041C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation041D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation042A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation042B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation044A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation044B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation045A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation045D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation045E());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation045F());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation049A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation049B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation049C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation052());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation054A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation054B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation056());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation059());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation063A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation063B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation064A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation064B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation064C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation064D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation064E());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation065());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation073A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation073B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation073C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation073D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation074());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation075A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation075B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation076A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation076B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation077A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation077B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation078A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation078B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation079());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation080A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation080B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation081A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation081B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation082());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation083A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation083B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation084A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation084B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation085A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation085B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation085C());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation085D());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation085E());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation088());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation089A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation089B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation090A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation090B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation091A());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation091B());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation092());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation096());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation097());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation100());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation108());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation113());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation115());
		res.addSegmentValidations(ER3108PosLbPpiu1100.genRowValidation121());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 14, 14, refTable).confReference(EHeaderMetadataLbUus.R3109_LB1100.getObject())
						.confRegex(patternNumeric)).confUnique(U));
		fs.add(sf(2, null, "Indonesian Rupiah", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(3, null, "Mata Uang Asing", sv(M, 1, 16, numericNegatif)));
		fs.add(sf(4, null, "Total", sv(M, 1, 16, numericNegatif))
				.addFieldValidations(ER3108PosLbPpiu1100.genFieldValidation4()));
		return res;
	}
}
