import org.apache.commons.cli.*;

public class Cli {
    private String[] args = null;
    private Options options = new Options();
    private CommandLine parsedObj = null;

    public Cli(String[] args) {

        this.args = args;

        options.addOption("h", "help", false, "Show help");
        options.addOption("c", "char", false, "Show Character count");
        options.addOption("l", "char", false, "Show Line count");
        options.addOption("w", "char", false, "Show Word count");
        options.addOption("a", "char", false, "Show all");
    }

    private void parse() throws ParseException {
        CommandLineParser parser = new BasicParser();
        this.parsedObj = parser.parse(options, args);
    }

    public String getOptions() throws ParseException{
        this.parse();
        String result = "";
        Option[] options = parsedObj.getOptions();
        for (int i = 0; i < options.length; i++) {
            result = result.concat(options[i].getOpt());
        }
        return  result;
    }

    public String[] getFiles() throws ParseException{
        this.parse();
        return this.parsedObj.getArgs();
    }

    public boolean hasOption(String a) throws ParseException{
        this.parse();
        return this.parsedObj.hasOption(a);
    }

//    public boolean hasOption(char a) throws ParseException{
//        String temp = new String(a);
//        return this.hasOption(temp);
//    }

    public void help() {
        // This prints out some help
        HelpFormatter formater = new HelpFormatter();
        formater.printHelp("Wc", options);
        options.getOptions().toArray();
    }
}
