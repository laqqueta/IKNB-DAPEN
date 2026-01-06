package id.go.ojk.reask.client.builder.field.lb.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.client.model.config.validation.segmen.SegmentValidation;
import id.go.ojk.conf.client.UtilMetadata;
import id.go.ojk.conf.client.UtilSegmentValidation;
import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER3048PosLbReask212 implements IObject<KeyValueString> {
	R_6101000000 ("6101000000", "Pertanian, kehutanan dan perikanan"),
	R_6102000000 ("6102000000", "Pertambangan dan penggalian"),
	R_6103000000 ("6103000000", "Industri pengolahan"),
	R_6104000000 ("6104000000", "Pengadaan listrik, gas, uap/air panas dan udara dingin"),
	R_6105000000 ("6105000000", "Pengadaan air, pengelolaan sampah dan daur ulang, pembuangan dan pembersihan limbah dan sampah"),
	R_6106000000 ("6106000000", "Konstruksi"),
	R_6107000000 ("6107000000", "Perdagangan besar dan eceran; reparasi dan perawatan mobil dan sepeda motor"),
	R_6108000000 ("6108000000", "Transportasi dan pergudangan"),
	R_6109000000 ("6109000000", "Penyediaan akomodasi dan penyediaan makan minum"),
	R_6110000000 ("6110000000", "Informasi dan komunikasi"),
	R_6111000000 ("6111000000", "Jasa keuangan dan asuransi"),
	R_6112000000 ("6112000000", "Real Estat"),
	R_6113000000 ("6113000000", "Jasa profesional, ilmiah dan teknis"),
	R_6114000000 ("6114000000", "Jasa persewaan dan sewa guna usaha tanpa hak opsi, ketenagakerjaan, agen perjalanan dan penunjang usaha lainnya"),
	R_6115000000 ("6115000000", "Administrasi pemerintahan, pertahanan dan jaminan sosial wajib"),
	R_6116000000 ("6116000000", "Jasa pendidikan"),
	R_6117000000 ("6117000000", "Jasa kesehatan dan kegiatan sosial"),
	R_6118000000 ("6118000000", "Kesenian, hiburan dan rekreasi"),
	R_6119000000 ("6119000000", "Kegiatan jasa lainnya"),
	R_6120000000 ("6120000000", "Jasa perorangan yang melayani rumah tangga; kegiatan yang menghasilkan barang dan jasa oleh rumah tangga yang digunakan sendiri untuk memenuhi kebutuhan"),
	R_6121000000 ("6121000000", "Kegiatan badan internasional dan badan ekstra internasional lainnya"),
	R_6122000000 ("6122000000", "Rumah tangga"),
	R_6123000000 ("6123000000", "Bukan Lapangan Usaha Lainnya"),
	R_6100000000 ("6100000000", "Total"),
//	R_6100000001 ("6100000001", "*Data premi dan klaim merupakan data gabungan tradisional dan PAYDI"),
	;

	private String key;
	private String value;

	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER3048PosLbReask212 eEnum : ER3048PosLbReask212.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getRequiredPos() {
		return UtilMetadata.genPipeRow(getObjects());
	}
	
	public static String genFieldSave() {
		return UtilMetadata.genFieldSave(UtilMetadata.genPipeColumn(2, 5), getObjects());
	}
	
	public static SegmentValidation genValidationTotal() {
		return UtilSegmentValidation.genEqualsFormula(UtilMetadata.genPipeColumn(2, 5), R_6100000000.key, 
				UtilMetadata.genPlusRow(getObjects(), 0, 22), "Total|Penjumlahan detail");
	}
}
