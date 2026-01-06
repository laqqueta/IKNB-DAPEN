package id.go.ojk.conf.client.field.reference;

import java.util.ArrayList;
import java.util.List;

import id.go.ojk.lib.client.IObject;
import id.go.ojk.lib.client.model.KeyValueString;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ER1082Tagihan implements IObject<KeyValueString> {
	R_2601 ("2601", "Tagihan Kontribusi"),
	R_2602 ("2602", "Tagihan Kontribusi-Peserta-Harta Benda "),
	R_2603 ("2603", "Tagihan Kontribusi-Peserta-Kendaraan Bermotor "),
	R_2604 ("2604", "Tagihan Kontribusi-Peserta-Pengangkutan "),
	R_2605 ("2605", "Tagihan Kontribusi-Peserta-Rangka kapal "),
	R_2606 ("2606", "Tagihan Kontribusi-Peserta-Rangka pesawat "),
	R_2607 ("2607", "Tagihan Kontribusi-Peserta-Satelit"),
	R_2608 ("2608", "Tagihan Kontribusi-Peserta-Energi  Onshore "),
	R_2609 ("2609", "Tagihan Kontribusi-Peserta-Energi  Offshore "),
	R_2610 ("2610", "Tagihan Kontribusi-Peserta-Rekayasa "),
	R_2611 ("2611", "Tagihan Kontribusi-Peserta-Tanggung-gugat "),
	R_2612 ("2612", "Tagihan Kontribusi-Peserta-Kecelakaan diri dan kesehatan"),
	R_2613 ("2613", "Tagihan Kontribusi-Peserta-Surety Ship"),
	R_2614 ("2614", "Tagihan Kontribusi-Peserta-Aneka"),
	R_2615 ("2615", "Tagihan kontribusi-peserta-kematian berjangka"),
	R_2616 ("2616", "Tagihan kontribusi-peserta-kematian ekawarsa"),
	R_2617 ("2617", "Tagihan kontribusi-peserta-kematian kecelakaan diri"),
	R_2618 ("2618", "Tagihan kontribusi-peserta-kesehatan"),
	R_2619 ("2619", "Tagihan Kontribusi - Pialang Asuransi"),
	R_2620 ("2620", "Tagihan Reasuransi - Dalam Negeri"),
	R_2621 ("2621", "Tagihan Reasuransi - Luar Negeri"),
	R_2622 ("2622", "Tagihan klaim reasuransi"),
	R_2623 ("2623", "Tagihan Investasi - Deposito"),
	R_2624 ("2624", "Tagihan Investasi - Sertifikat Deposito"),
	R_2625 ("2625", "Tagihan Investasi - Saham Syariah"),
	R_2626 ("2626", "Tagihan Investasi - Sukuk atau Obligasi Syariah"),
	R_2627 ("2627", "Tagihan Investasi - MTN Syariah"),
	R_2628 ("2628", "Tagihan Investasi - Surat Berharga Syariah Negara"),
	R_2629 ("2629", "Tagihan Investasi - Surat Berharga Syariah yang diterbitkan oleh Bank Indonesia"),
	R_2630 ("2630", "Tagihan Investasi - Surat Berharga Syariah Yang Diterbitkan oleh selain negara Republik Indonesia"),
	R_2631 ("2631", "Tagihan Investasi - Surat Berharga Syariah Yang Diterbitkan oleh Lembaga Multinasional"),
	R_2632 ("2632", "Tagihan Investasi - Reksa Dana Syariah"),
	R_2633 ("2633", "Tagihan Investasi - Efek Beragun Aset Syariah"),
	R_2634 ("2634", "Tagihan Investasi - Dana Investasi Real Estate Syariah"),
	R_2635 ("2635", "Tagihan Investasi - REPO"),
	R_2636 ("2636", "Tagihan Investasi - Pembiayaan Melalui Kerjasama dengan Pihak Lain "),
	R_2637 ("2637", "Tagihan Investasi - Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_2638 ("2638", "Tagihan Investasi - Properti Investasi"),
	R_2639 ("2639", "Tagihan Hasil Investasi - Deposito"),
	R_2640 ("2640", "Tagihan Hasil Investasi - Sertifikat Deposito"),
	R_2641 ("2641", "Tagihan Hasil Investasi - Saham Syariah"),
	R_2642 ("2642", "Tagihan Hasil Investasi - Sukuk atau Obligasi Syariah"),
	R_2643 ("2643", "Tagihan Hasil Investasi - MTN Syariah"),
	R_2644 ("2644", "Tagihan Hasil Investasi - Surat Berharga Syariah Negara"),
	R_2645 ("2645", "Tagihan Hasil Investasi - Surat Berharga Syariah yang diterbitkan oleh Bank Indonesia"),
	R_2646 ("2646", "Tagihan Hasil Investasi - Surat Berharga Syariah Yang Diterbitkan oleh selain negara Republik Indonesia"),
	R_2647 ("2647", "Tagihan Hasil Investasi - Surat Berharga Syariah Yang Diterbitkan oleh Lembaga Multinasional"),
	R_2648 ("2648", "Tagihan Hasil Investasi - Reksa Dana Syariah"),
	R_2649 ("2649", "Tagihan Hasil Investasi - Efek Beragun Aset Syariah"),
	R_2650 ("2650", "Tagihan Hasil Investasi - Dana Investasi Real Estate Syariah"),
	R_2651 ("2651", "Tagihan Hasil Investasi - REPO"),
	R_2652 ("2652", "Tagihan Hasil Investasi - Pembiayaan Melalui Kerjasama dengan Pihak Lain "),
	R_2653 ("2653", "Tagihan Hasil Investasi - Pembiayaan Syariah Dengan Hak Tanggungan"),
	R_2654 ("2654", "Tagihan Hasil Investasi - Properti Investasi"),
	R_2655 ("2655", "Tagihan Ujrah Kepada Peserta"),
	;

	private String key;
	private String value;
	
	public KeyValueString getObject() {
		return new KeyValueString(key, value, new String[] {});
	}

	public static List<KeyValueString> getObjects() {
		List<KeyValueString> res = new ArrayList<>();
		for (ER1082Tagihan eEnum : ER1082Tagihan.values()) {
			res.add(eEnum.getObject());
		}
		return res;
	}
	
	public static String getName() {
		return ER1082Tagihan.class.getSimpleName().substring(6);
	}
	
	public static int getRefNumber() {
		return Integer.parseInt(ER1082Tagihan.class.getSimpleName().substring(2, 6));
	}
}
