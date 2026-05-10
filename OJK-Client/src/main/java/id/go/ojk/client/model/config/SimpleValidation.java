package id.go.ojk.client.model.config;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import id.go.ojk.client.model.config.validation.conditional.ConditionalRequired;
import id.go.ojk.client.model.config.validation.conditional.RefConditional;
import id.go.ojk.client.validation.IValidationConverter;
import id.go.ojk.lib.client.exception.SlikException;
import id.go.ojk.lib.client.model.config.DataType;
import id.go.ojk.lib.client.model.config.Regex;
import id.go.ojk.lib.client.model.constant.RequiredCondition;
import id.go.ojk.lib.client.model.reference.ReferenceMetadata;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@XStreamAlias("simpleValidation")
public class SimpleValidation implements Serializable {

    public static Regex patternAll = new Regex("[\\w[ @#$%^&*(){}\\[\\]<=>~\\-\\+`'\".,:;|\\\\\\/?!]]+", "huruf, angka, spasi dan karakter @#$%^&*(){}[]<=>~_-+`'\".,:;\\/?!");
    public static Regex patternAll2 = new Regex("[^\\n]+", "semua karakter kecuali Enter");

    //Start RBB
    public static Regex patternNumeric = new Regex("[\\d]+", "angka tanpa desimal dan tidak boleh negatif (tanpa pemisah ribuan). Contoh: 1000000");
    public static Regex patternNumericNotZero = new Regex("^[1-9]\\d*$", "angka tidak boleh negatif dan 0 (tanpa pemisah ribuan). Contoh: 1000000");
    public static Regex patternNumericNegatif = new Regex("^[\\-]??[0-9]+$", "angka boleh negatif (tanpa pemisah ribuan). Contoh: 1000000");
    public static Regex patternNumericMustNegatif = new Regex("^[\\-][0-9]+$", "angka harus negatif (tanpa pemisah ribuan). Contoh: -1000000");
    public static Regex patternNumericDot = new Regex("[0-9]+([.][0-9]{2})", "angka desimal dengan 2 angka di belakang . (titik) dan tidak boleh negatif. Contoh: 10.00");
    public static Regex patternNumericDotOptTwo = new Regex("^[0-9]\\d{0,9}(\\.\\d{2})?%?$", "angka desimal dengan 2 angka di belakang . (titik) dan tidak boleh negatif. Contoh: 10.00");
    public static Regex patternNumericDotThree = new Regex("[0-9]+([.][0-9]{3})", "angka desimal dengan 3 angka di belakang . (titik) dan tidak boleh negatif. Contoh: 10.00");
    public static Regex patternNumericDotFour = new Regex("[0-9]+([.][0-9]{4})", "angka desimal dengan 4 angka di belakang . (titik) dan tidak boleh negatif. Contoh: 10.00");
    public static Regex patternNumericDotNotZero = new Regex("^(?=.*[1-9])\\d*(?:\\.\\d{2})$", "angka desimal dengan 2 angka di belakang . (titik), tidak boleh negatif dan 0. Contoh: 10.00");
    public static Regex patternNumericDotNegatif = new Regex("^[\\-]?[0-9]+([.][0-9]{2})", "angka desimal dengan 2 angka di belakang . (titik) dan boleh negatif. Contoh: 10.00");
    public static Regex patternNumericDotOpt = new Regex("[0-9]+([.][0-9]{1,2})?", "angka tidak boleh negatif (khusus persentase harus berupa angka desimal dengan 2 angka di belakang . (titik))");
    public static Regex patternNumericDotOptNegatif = new Regex("[\\-]?[0-9]+([.][0-9]{1,2})?", "angka boleh negatif (khusus persentase harus berupa angka desimal dengan 2 angka di belakang . (titik))");
    public static Regex patternWorkPlace = new Regex("[a-zA-Z0-9[ &()\\-'.,]]+", "huruf, angka, spasi dan karakter &-',.()");
    //End RBB

    public static Regex patternUnsignInteger = new Regex("[0]{1}?|^[1-9]+[0-9]*$", "angka tidak boleh negatif");
    public static Regex patternSignInteger = new Regex("[0]{1}?|^(\\-[1-9]+)+[0-9]*$|^[1-9]+[0-9]*$", "angka boleh negatif");
    public static Regex patternDecimal = new Regex("^[0-9]+(,[0-9]+)?$", "angka dan koma");

    public static Regex patternAlfa = new Regex("[a-zA-Z]+", "huruf");
    public static Regex patternAlfaSpace = new Regex("[a-zA-Z[ ]]+", "huruf dan spasi");
    public static Regex patternAlfaNumeric = new Regex("[a-zA-Z0-9]+", "huruf dan angka");
    public static Regex patternAlfaNumericSpace = new Regex("[a-zA-Z0-9[ ]]+", "huruf, angka dan spasi");

    public static Regex patternTax = new Regex("\\d{2}[.]\\d{3}[.]\\d{3}[.]\\d{1}[-]\\d{3}[.]\\d{3}", "npwp");
    public static Regex patternEmail = new Regex("[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", "sesuai format email (mengandung karakter @ dan .)");

    //LBBPRK Custom
    public static Regex patternLJKName = new Regex("[a-zA-Z0-9[ .(),/'\\-&]]+", "huruf, angka, spasi dan karakter .(),/'-&");
    public static Regex patternKecamatan = new Regex("[a-zA-Z0-9[ .(),/'\\-]]+", "huruf, angka, spasi dan karakter .(),/'-");
    public static Regex patternLJKAddress = new Regex("[a-zA-Z0-9[ .,/\\-:()&']]+", "huruf, angka, spasi dan karakter .,/-:()&'");
    public static Regex patternNamePerson2 = new Regex("[a-zA-Z0-9[ .,()]]+", "huruf, angka, spasi dan karakter .,()");
    public static Regex patternSKNumber = new Regex("[a-zA-Z0-9[ ./(),\\-]]+", "huruf, angka, spasi dan karakter ./(),-");
    //	public static Regex patternCoordinate			= new Regex("[a-zA-Z0-9[ .,\"'\\-]]+", 		"huruf, angka, spasi dan karakter .,\"'-");
    public static Regex patternCoordinate = new Regex("[a-zA-Z0-9[ .,\\-\\+]]+", "huruf, angka, spasi dan karakter .,-+");
    public static Regex patternKAP = new Regex("[a-zA-Z[ .,()'&]]+", "huruf, spasi dan karakter .,()'&");
    public static Regex patternPhoneNumber = new Regex("[0-9[ .\\-()]]+", "angka, spasi dan karakter .-()");
    public static Regex patternIdentityNumber = new Regex("[0-9[/]]+", "angka dan karakter /");
    public static Regex patternNPWP = new Regex("[0-9[.\\-]]+", "angka dan karakter .-");
    public static Regex patternDate = new Regex("\\d{8}", "angka tidak boleh negatif dan hanya boleh berupa format tanggal (yyyyMMdd)");

    //Other
    public static Regex patternAlfaDotHypen = new Regex("[a-zA-Z[\\-.]]+", "huruf dan karakter .-");
    public static Regex patternAlfaDotComma = new Regex("[a-zA-Z[,.]]+", "huruf dan karakter .,");
    public static Regex patternAlfaNumericDotComma = new Regex("[a-zA-Z0-9[,.]]+", "huruf, angka dan karakter .,");
    public static Regex patternAlfaNumericDotHypen = new Regex("[a-zA-Z0-9[\\-.]]+", "huruf, angka dan karakter .-");

    public static Regex patternNumericDotOneOrTwo = new Regex("[0-9]+([.][0-9]{1,2})", "angka desimal dengan 1 atau 2 angka di belakang . (titik) dan tidak boleh negatif. Contoh: 10.12 atau 10.1");

    public static Regex patternAccountNumber = new Regex("[a-zA-Z0-9]+", "huruf dan angka ");

    public static Regex patternName = new Regex("[a-zA-Z[ \\-'.]]+", "huruf, spasi dan karakter -'.");
    public static Regex patternAddress = new Regex("[a-zA-Z0-9[ &()\\-'.,/]]+", "huruf, angka, spasi dan karakter &()-'.,/");
    public static Regex patternAddress2 = new Regex("[a-zA-Z0-9[ &()\\-'.,/\"]]+", "huruf, angka, spasi dan karakter &()-'.,/\"");
    public static Regex patternGuarantorAddress = new Regex("[a-zA-Z0-9[ &()\\-'.,/]]+", "huruf, angka, spasi dan karakter &()-'.,/");
    public static Regex patternDistrict = new Regex("[a-zA-Z0-9[ \\-'/.]]+", "huruf, spasi, angka dan karakter -'/.");
    public static Regex patternSubDistrict = new Regex("[a-zA-Z0-9[ \\-'/.]]+", "huruf, spasi, angka dan karakter -'/.");

    public static Regex patternAlfaNumColonPlusMin = new Regex("[a-zA-Z0-9[()\\+\\-]]+", "huruf, angka, dan karakter ()+-");
    public static Regex patternAkadNumber = new Regex("[\\w[ ()\\-'./]]+", "huruf, spasi, angka, dan karakter ()_-'./");

    public static Regex patternBankName = new Regex("[\\w[ ()\\-'./]]+", "huruf, angka, spasi dan karakter ()_-'./");

    public static Regex patternCompanyName = new Regex("[a-zA-Z0-9[ &()\\-'.,/]]+", "huruf, angka, spasi dan karakter &()-'.,/");
    public static Regex patternCompanyAddress = new Regex("[a-zA-Z0-9[ &()\\-'.,/:]]+", "huruf, angka, spasi dan karakter &()-'.,/:");
    public static Regex patternCompanyPlace = new Regex("[a-zA-Z[ \\-'.,]]+", "huruf, spasi dan karakter -'.,");
    public static Regex patternRating = new Regex("[\\w[()\\-/+]]+", "huruf, angka dan karakter ()_-/+");

    public static Regex patternRatingAgency = new Regex("[\\d[&()_'.,]]+", "angka dan karakter &()_'.,");
    public static Regex patternRatingAgency2 = new Regex("[a-zA-Z0-9[ -\\+\\-]]+", "huruf, angka, spasi dan karakter - +");
    public static Regex patternManagementName = new Regex("[a-zA-Z0-9[ &()\\-'.,]]+", "huruf, angka spasi dan karakter &()-'.,");

    public static Regex patternDescription = new Regex("[\\w[ @#$%^&*(){}\\[\\]<>~\\-`'\".,:;/?!]]+", "huruf, angka spasi dan karakter @#$%^&*(){}[]<>~_-`'\".,:;/?!");

    public static Regex patternCollateralRating = new Regex("[\\w[()\\-\\+/]]+", "huruf, angka dan karakter ()_-+/");

    public static Regex patternCollateralAppaiser = new Regex("[a-zA-Z[ \\-'.,]]+", "huruf, spasi dan karakter -'.,");

    public static Regex patternProofOwnership = new Regex("[a-zA-Z0-9[ \\-.,/]]+", "huruf, spasi, angka dan karakter -.,/");

    public static Regex patternNameCollateral = new Regex("[a-zA-Z0-9[ &,()\\-'.]]+", "huruf, angka, spasi dan karakter &,()-'.");

    public static Regex patternDeedIncoporation = new Regex("[\\w[ ()\\-'.,/]]+", "huruf, angka, spasi dan karakter /'-_().,");

    public static Regex patternGroupDebitur = new Regex("[a-zA-Z0-9[ &,()\\-'.,/]]+", "huruf, angka, spasi dan karakter &-',.()/");

    public static Regex patternNameGuaranteed = new Regex("[a-zA-Z0-9[ ()_\\-'./]]+", "huruf, angka spasi dan karakter ( ) _ - ' . /");

    public static Regex patternBirthPlace = new Regex("[a-zA-Z0-9[ \\-]]+", "huruf, angka, spasi dan karakter -");

    public static Regex patternNomorSurat = new Regex("[a-zA-Z0-9[\\-.,/]]+", "huruf, angka dan karakter -.,/");

    public static Regex patternKeterangan = new Regex("[a-zA-Z0-9[ .,]]+", "huruf, angka, spasi dan karakter .,");

    public static final Regex PATTERN_REFERENCE_1 = new Regex("[a-zA-Z0-9[:]]+", "huruf, angka dan karakter :");
    public static final Regex PATTERN_REFERENCE_2 = new Regex("[a-zA-Z0-9[_]]+", "huruf, angka dan karakter _");
    public static final Regex PATTERN_REFERENCE_3 = new Regex("[a-zA-Z[:]]+", "huruf dan karakter :");
    public static final Regex PATTERN_REFERENCE_4 = new Regex("[a-zA-Z0-9[.]]+", "huruf, angka dan karakter .");
    public static final Regex PATTERN_NOMOR_SURAT = new Regex("[\\w[ ().,/]]+", "Huruf Angka Spasi dan karakter .(),/");
    public static final Regex PATTERN_PHONE = new Regex("[0-9[.\\-()]]+", "angka dan karakter ( ) . -");
    public static final Regex PATTERN_ALL_1 = new Regex("[\\w[ @#$%^&*(){}\\[\\]<=>~\\-\\+`'\".,:;\\\\\\/?!]]+", "huruf, angka, spasi dan karakter @#$%^&(){}[]<=>~_-+`'\".,:;\\/?!");
    public static final Regex PATTERN_NAME = new Regex("[a-zA-Z0-9[ ,.]]+", "huruf, angka, spasi dan karakter ,.");
    public static final Regex PATTERN_NAME_1 = new Regex("[a-zA-Z0-9[ (),.]]+", "huruf, angka, spasi dan karakter (),.");
    public static final Regex PATTERN_NAME_2 = new Regex("[a-zA-Z0-9[ .]]+", "huruf, angka, spasi dan karakter .");
    public static final Regex PATTERN_NAME_3 = new Regex("[a-zA-Z0-9[ .(),/'\\-&|]]+", "huruf, angka, spasi dan karakter .(),/'-&|");
    public static final Regex PATTERN_NAME_4 = new Regex("[a-zA-Z[ .,()'\\-]]+", "huruf, spasi dan karakter .,()'-");
    public static final Regex PATTERN_NAME_5 = new Regex("[a-zA-Z0-9[/\\-',.\"()#]]+", "huruf, angka dan karakter /-'.,\"()#");
    public static final Regex PATTERN_NAME_6 = new Regex("[a-zA-Z0-9[ ,.']]+", "huruf, angka, spasi dan karakter ,.'");
    public static final Regex PATTERN_NAME_7 = new Regex("^(?!\\s*$)[^0-9|]+$", "semua karakter kecuali angka, | dan hanya spasi"); // Nama Pengawas, Direksi
    public static final Regex PATTERN_PERIOD = new Regex("[\\d]+:\\d{2}:\\d{2}", "angka, karakter : dan hanya boleh berupa format dd:HH:mm");
    public static final Regex PATTERN_YEAR = new Regex("\\d{4}", "angka tidak boleh negatif dan hanya boleh berupa format tahun (yyyy)");
    public static final Regex PATTERN_YEAR_MONTH = new Regex("\\d{6}", "angka tidak boleh negatif dan hanya boleh berupa format tahun bulan (yyyyMM)");
    public static final Regex PATTERN_WEB_ADDRESS = new Regex("[\\w[/.\\-:]]+", "huruf, angka dan karakter .-:/_");

    public static final Regex FREE_TEXT_PATTERN = new Regex("[\\w[ @#$%^&*(){}\\[\\]<=>~\\-\\+`'\".,:;\\\\\\/?!]]+", "huruf, angka, spasi dan simbol (kecuali karakter | dan enter)");

    // ~ Apolo PM 2025
    public static final Regex PATTERN_NO_SURAT_PM = new Regex("[a-zA-Z0-9[ \\-./]]+", "huruf, angka, spasi dan karakter -./");

    @XStreamAsAttribute
    private RequiredCondition requiredCondition;

    @XStreamAsAttribute
    private int minLength;

    @XStreamAsAttribute
    private int maxLength;

    @XStreamAsAttribute
    private boolean fixLength;

    @XStreamAsAttribute
    private DataType dataType;

    private Regex regex;

    @XStreamAsAttribute
    @Getter
    @Setter
    private List<Integer> referenceTableNumbers;

    private String constant;

    private ConditionalRequired conditionalRequired;

    public SimpleValidation() {
    }

    public SimpleValidation(RequiredCondition requiredCondition, int minLength, int maxLength, DataType dataType) {
        this.requiredCondition = requiredCondition;
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.dataType = dataType;

        this.fixLength = minLength == maxLength;
        initializeDefaultRegex();
    }

    public SimpleValidation confRegex(Regex regex) {
        setRegex(regex);
        return this;
    }

    public SimpleValidation confReference(ReferenceMetadata... referenceMetadatas) {
        List<ReferenceMetadata> tmps = Arrays.asList(referenceMetadatas);
        List<Boolean> perSegments = tmps.stream().map(e -> e.isPerSegment()).distinct().collect(Collectors.toList());
        if (perSegments.size() > 1)
            throw new SlikException("Invalid ref config");

        if (perSegments.get(0)) {
            setDataType(DataType.refTablePerSegment);
        } else {
            setDataType(DataType.refTable);
        }

        setReferenceTableNumbers(tmps.stream().map(e -> e.getNumber()).collect(Collectors.toList()));
        return this;
    }

    public SimpleValidation confConstant(String constant) {
        setConstant(constant);
        return this;
    }

    public SimpleValidation confConditionalRequired(ConditionalRequired conditionalRequired) {
        setConditionalRequired(conditionalRequired);
        return this;
    }

    public SimpleValidation confConditionalRequired(IValidationConverter validation) {
        setConditionalRequired(validation.toFieldConditional());
        return this;
    }

    public SimpleValidation confRefConditionalRequired(int refNumber) {
        setConditionalRequired(new RefConditional("refNumber=" + refNumber));
        return this;
    }

    public void initializeDefaultRegex() {
        if (this.regex == null) {
            switch (this.dataType) {
                case all:
                    this.regex = patternAll.c();
                    break;
                case all2:
                    this.regex = patternAll2.c();
                    break;
                case alfa:
                    this.regex = patternAlfa.c();
                    break;
                case numeric:
                    this.regex = patternNumeric.c();
                    break;
                case numericNegatif:
                    this.regex = patternNumericNegatif.c();
                    break;
                case unsignInt:
                    this.regex = patternUnsignInteger.c();
                    break;
                case signInt:
                    this.regex = patternSignInteger.c();
                    break;
                case decimal:
                    this.regex = patternDecimal.c();
                    break;
                case alfaNumeric:
                    this.regex = patternAlfaNumeric.c();
                    break;
                case alfaSpace:
                    this.regex = patternAlfaSpace.c();
                    break;
                case alfaNumericSpace:
                    this.regex = patternAlfaNumericSpace.c();
                    break;
                case numericDot:
                    this.regex = patternNumericDot.c();
                    break;
                case numericDotNegatif:
                    this.regex = patternNumericDotNegatif.c();
                    break;
                case tax:
                    this.regex = patternTax.c();
                    break;
                case date:
                    this.regex = patternDate.c();
                    break;
                case yearMonth:
                    this.regex = PATTERN_YEAR_MONTH.c();
                    break;
                case year:
                    this.regex = PATTERN_YEAR.c();
                    break;
                case email:
                    this.regex = patternEmail.c();
                    break;
                case phone:
                    this.regex = patternPhoneNumber.c();
                    break;
                case freeText:
                    this.regex = FREE_TEXT_PATTERN.c();
                    break;
                default:
                    break;
            }
        }
    }

    public RequiredCondition getRequiredCondition() {
        return requiredCondition;
    }

    public void setRequiredCondition(RequiredCondition requiredCondition) {
        this.requiredCondition = requiredCondition;
    }

    public int getMinLength() {
        return minLength;
    }

    ;

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    ;

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public boolean isFixLength() {
        return fixLength;
    }

    ;

    public void setFixLength(boolean fixLength) {
        this.fixLength = fixLength;
    }

    public DataType getDataType() {
        return dataType;
    }

    ;

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public Regex getRegex() {
        return regex;
    }

    public void setRegex(Regex regex) {
        this.regex = regex;
    }

    public String getConstant() {
        return constant;
    }

    public void setConstant(String constant) {
        this.constant = constant;
    }

    public ConditionalRequired getConditionalRequired() {
        return conditionalRequired;
    }

    public void setConditionalRequired(ConditionalRequired conditionalRequired) {
        this.conditionalRequired = conditionalRequired;
    }
}