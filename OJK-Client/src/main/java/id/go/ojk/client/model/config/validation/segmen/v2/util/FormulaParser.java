package id.go.ojk.client.model.config.validation.segmen.v2.util;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// this made using AI, don't expect this to always work for every case
// [TESTED] work with this case :: (ROW[1+2+3]+ROW[1-2-3]-ROW[1*2*3]) * (ROW[1+2+3]+ROW[1-2-3]-ROW[1*2*3])
// use UtilMetadata.genFormulaFormatter(....) to format the formula
// Example usage on E7017Ras1ValidationsConfig.java :: OJK-METADATA package
public class FormulaParser {

    /*
    * Penggunaan pada validasi RAS1 Dapen 2026
    *
    * SUM'(ROW[1+2+3...] + ROW[1+2+3...]) + SUM'(ROW[1+2+3...] + ROW[1+2+3...]) - SUM'(ROW[1+2+3...] + ROW[1+2+3...])
    * SUM'(ROW[1+2+3...] + ROW[1+2+3...]) - SUM'(ROW[1+2+3...] + ROW[1+2+3...])
    * ROW[1+2+3...] + ROW[1+2+3...]
    * */

    @Getter
    public static class Operand {
        private final String operator;
        private final String field;

        Operand(String operator, String field) {
            this.operator = operator;
            this.field = field;
        }
    }

    @Getter
    public static class RowToken {
        private final String operator;
        private final String rowCode;
        private final String raw;
        private final List<Operand> operands;

        RowToken(String operator, String rowCode, String raw, List<Operand> operands) {
            this.operator = operator;
            this.rowCode = rowCode;
            this.raw = raw;
            this.operands = operands;
        }
    }

    @Getter
    public static class Group {
        private final int index;
        private final String operator; // operator BEFORE this group, e.g. "*"
        private final String raw;
        private final List<RowToken> tokens;

        Group(int index, String operator, String raw, List<RowToken> tokens) {
            this.index = index;
            this.operator = operator;
            this.raw = raw;
            this.tokens = tokens;
        }
    }

    @Getter
    public static class ParsedFormula {
        private final List<Group> groups;

        ParsedFormula(List<Group> groups) {
            this.groups = groups;
        }
    }

    private static final Pattern P_GROUP =
            Pattern.compile("([+\\-*]?)\\s*\\(([^)]+)\\)");

    private static final Pattern P_ROW_TOKEN =
            Pattern.compile("([+\\-*]?)\\s*(([\\w]+)\\[([^]]+)])");

    private static final Pattern P_OPERAND =
            Pattern.compile("([+\\-*]?)\\s*(\\w+)");

    public static List<Operand> parseInner(String inner) {
        List<Operand> result = new ArrayList<>();
        Matcher m = P_OPERAND.matcher(inner);
        while (m.find()) {
            result.add(new Operand(m.group(1), m.group(2)));
        }
        return result;
    }

    public static List<RowToken> parseGroup(String groupContent) {
        List<RowToken> result = new ArrayList<>();
        Matcher m = P_ROW_TOKEN.matcher(groupContent);
        while (m.find()) {
            String op = m.group(1);
            String raw = m.group(2);
            String rowName = m.group(3);
            String inner = m.group(4);
            result.add(new RowToken(op, rowName, raw, parseInner(inner)));
        }
        return result;
    }

    public static ParsedFormula parse(String formula) {
        List<Group> groups = new ArrayList<Group>();
        Matcher m = P_GROUP.matcher(formula);
        int idx = 1;
        while (m.find()) {
            String op = m.group(1); // "*", "+", "-", or "" for the first group
            String content = m.group(2);
            groups.add(new Group(idx++, op, content, parseGroup(content)));
        }
        return new ParsedFormula(groups);
    }

    public static void main(String[] args) {
        String formula =
                "(ROW#ROWXXX000001[1])";

        System.out.println("Formula: " + formula);
        System.out.println();

        ParsedFormula parsed = parse(formula);

        for (Group g : parsed.getGroups()) {
            System.out.printf("══ Group %d  op=%-4s ══════════════════════%n",
                    g.getIndex(), "\"" + g.getOperator() + "\"");
            System.out.println("  Raw: " + g.getRaw());
            System.out.println();

            for (RowToken t : g.getTokens()) {
                System.out.printf("  ├─ op=%-4s  rowName=%-12s  raw=%s%n",
                        "\"" + t.getOperator() + "\"", t.getRowCode(), t.getRaw());

                for (Operand o : t.getOperands()) {
                    System.out.printf("  │    ├─ op=%-4s  field=%s%n",
                            "\"" + o.getOperator() + "\"", o.getField());
                }
                System.out.println("  │");
            }
            System.out.println();
        }

        List<String> a = Arrays.asList("1", "2", "3");
        System.out.println(a.toString().replace(", ", "+"));
    }
}

