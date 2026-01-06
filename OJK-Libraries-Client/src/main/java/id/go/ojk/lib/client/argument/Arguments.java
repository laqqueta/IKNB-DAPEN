package id.go.ojk.lib.client.argument;

import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Arguments {
	private final Options options = new Options();
	private CommandLine commandLine;
	private String appName;

	public Arguments(String appName, String[] args, List<DtoArgument> arguments) {
		this.appName = appName;
		initOption(arguments);
		initCommandLine(args);
	}

	public void help() {
		HelpFormatter formater = new HelpFormatter();
		formater.printHelp(appName, options);
		System.exit(0);
	}

	public String getOptionValue(String option, String defaultValue) {
		String res = "";
		boolean hasOption = commandLine.hasOption(option);
		if (hasOption) {
			res = commandLine.getOptionValue(option);
//		} else {
//			help();
		}
		return StringUtils.isNotEmpty(res) ? res : defaultValue;
	}

	private void initCommandLine(String[] args) {
		try {
			CommandLineParser parser = new DefaultParser();
			commandLine = parser.parse(options, args);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	private void initOption(List<DtoArgument> arguments) {
		for (int i = 0; i < arguments.size(); i++) {
			DtoArgument dto = arguments.get(i);
			options.addOption(genOption(dto.getId(), dto.getCountArg(), dto.getDesc()));
		}
	}

	private Option genOption(String opt, int countArg, String desc) {
		Option res = new Option(opt, countArg > 0, desc);
		if (countArg > 1) {
			res.setArgs(countArg);
		}
		return res;
	}
}
