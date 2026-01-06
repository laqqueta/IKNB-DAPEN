package id.go.ojk.asruk.client.builder.field.lb.metadata;

import static id.go.ojk.lib.client.model.config.DataType.alfaNumeric;
import static id.go.ojk.lib.client.model.config.DataType.numericNegatif;
import static id.go.ojk.lib.client.model.config.DataType.refTable;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.C;
import static id.go.ojk.lib.client.model.constant.RequiredCondition.M;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.asruk.client.builder.field.EFormLaporanBulanan;
import id.go.ojk.asruk.client.builder.field.lb.reference.EHeaderMetadataLb;
import id.go.ojk.asruk.client.builder.field.lb.reference.ER3046PosLbAsruk211;
import id.go.ojk.asruk.client.builder.field.reference.EHeaderMetadataShared;
import id.go.ojk.client.model.config.SubmissionField;
import id.go.ojk.client.model.config.SubmissionFormat;
import id.go.ojk.conf.client.BaseMetadata;

public class Lb211 extends BaseMetadata {

	public Lb211(String reportCode) {
		super(reportCode, ".txt");
	}

	@Override
	public SubmissionFormat get() {
		EFormLaporanBulanan eEnum = EFormLaporanBulanan.LB_211;
		SubmissionFormat res = new SubmissionFormat(eEnum.getCode(), eEnum.getName(), reportCode,
				new ArrayList<>(), extension, 1, null, ER3046PosLbAsruk211.genFieldSave(), null,
				ER3046PosLbAsruk211.getRequiredPos());
		res.addSegmentValidations(ER3046PosLbAsruk211.genValidationTotal());
		List<SubmissionField> fs = res.getFields();
		fs.add(sf(0, null, "Flag Detail", sv(M, 3, 3, alfaNumeric).confConstant("D01")));
		fs.add(sf(1, null, "Kode Komponen / Baris",
				sv(M, 10, 10, refTable).confReference(EHeaderMetadataLb.R3046_LB211.getObject())));
		fs.add(sf(2, null, "Kode Propinsi (DATI I)",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R015.getObject())
						.confConditionalRequired(ER3046PosLbAsruk211.genConditionField2())));
		fs.add(sf(3, null, "Kode Kota/Kabupaten (DATI II)",
				sv(C, 1, 6, refTable).confReference(EHeaderMetadataShared.R016.getObject())
						.confConditionalRequired(ER3046PosLbAsruk211.genConditionField3()))
								.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation3()));
		fs.add(sf(4, null, "Harta Benda (Property) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(5, null, "Harta Benda (Property) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(6, null, "Harta Benda (Property) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(7, null, "Harta Benda (Property) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(8, null,
				"Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(9, null,
				"Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(10, null,
				"Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(11, null,
				"Kendaraan Bermotor (Own Damage, Third Party Liability, dan Personal Accident) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(12, null, "Pengangkutan (Marine Cargo) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(13, null, "Pengangkutan (Marine Cargo) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(14, null, "Pengangkutan (Marine Cargo) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(15, null, "Pengangkutan (Marine Cargo) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(16, null, "Rangka Kapal (Marine Hull) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(17, null, "Rangka Kapal (Marine Hull) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(18, null, "Rangka Kapal (Marine Hull) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(19, null, "Rangka Kapal (Marine Hull) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(20, null, "Rangka Pesawat (Aviation Hull) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(21, null, "Rangka Pesawat (Aviation Hull) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(22, null, "Rangka Pesawat (Aviation Hull) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(23, null, "Rangka Pesawat (Aviation Hull) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(24, null, "Satelit - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(25, null, "Satelit - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(26, null, "Satelit - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(27, null, "Satelit - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(28, null, "Energi Onshore (Oil and Gas) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(29, null, "Energi Onshore (Oil and Gas) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(30, null, "Energi Onshore (Oil and Gas) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(31, null, "Energi Onshore (Oil and Gas) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(32, null, "Energi Offshore (Oil and Gas) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(33, null, "Energi Offshore (Oil and Gas) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(34, null, "Energi Offshore (Oil and Gas) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(35, null, "Energi Offshore (Oil and Gas) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(36, null, "Rekayasa (Engineering) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(37, null, "Rekayasa (Engineering) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(38, null, "Rekayasa (Engineering) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(39, null, "Rekayasa (Engineering) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(40, null, "Tanggung Gugat (Liability) - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(41, null, "Tanggung Gugat (Liability) - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(42, null, "Tanggung Gugat (Liability) - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(43, null, "Tanggung Gugat (Liability) - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(44, null, "Kecelakaan Diri & Kesehatan - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(45, null, "Kecelakaan Diri & Kesehatan - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(46, null, "Kecelakaan Diri & Kesehatan - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(47, null, "Kecelakaan Diri & Kesehatan - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(48, null, "Kredit (Credit)  - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(49, null, "Kredit (Credit)  - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(50, null, "Kredit (Credit)  - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(51, null, "Kredit (Credit)  - Jumlah Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(52, null, "Suretyship - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(53, null, "Suretyship - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(54, null, "Suretyship - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(55, null, "Suretyship - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(56, null, "Aneka - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(57, null, "Aneka - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(58, null, "Aneka - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(59, null, "Aneka - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(60, null, "Total Tradisional - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation60()));
		fs.add(sf(61, null, "Total Tradisional - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation61()));
		fs.add(sf(62, null, "Total Tradisional - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation62()));
		fs.add(sf(63, null, "Total Tradisional - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation63()));
		fs.add(sf(64, null, "PAYDI - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(65, null, "PAYDI - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(66, null, "PAYDI - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(67, null, "PAYDI - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField())));
		fs.add(sf(68, null, "Total Gabungan - Jumlah (Juta Rupiah)",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation68()));
		fs.add(sf(69, null, "Total Gabungan - Jumlah Polis",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation69()));
		fs.add(sf(70, null, "Total Gabungan - Jumlah Peserta/Objek Asuransi",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation70()));
		fs.add(sf(71, null, "Total Gabungan - Jumlah Uang Pertanggungan",
				sv(C, 1, 16, numericNegatif).confConditionalRequired(ER3046PosLbAsruk211.genConditionField()))
						.addFieldValidations(ER3046PosLbAsruk211.genFieldValidation71()));
		return res;
	}
}
